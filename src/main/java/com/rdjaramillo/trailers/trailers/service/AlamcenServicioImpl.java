package com.rdjaramillo.trailers.trailers.service;

import com.rdjaramillo.trailers.trailers.excepciones.AlmacenException;
import com.rdjaramillo.trailers.trailers.excepciones.FileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AlamcenServicioImpl implements AlmacenServicio{
    @Value("${storage.location}")
    private String storageLocation;

    @PostConstruct
    @Override
    public void iniciarAlmacenDeArchivo() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException e) {
            throw  new AlmacenException("Error al inicial la ubicacion en el servicio");
        }
    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if (archivo.isEmpty()){
            throw new AlmacenException("No se puede almacenar un archivo vacio");

        }try{
            InputStream inStream = archivo.getInputStream();
            Files.copy(inStream, Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e) {
            throw new AlmacenException("Error al almacenar el archivo"+nombreArchivo,e);
        }
        return nombreArchivo;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return  Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo)  {
       try {
           Path archivo = cargarArchivo(nombreArchivo);
           Resource recurso = new UrlResource(archivo.toUri());
           if (recurso.exists() || recurso.isReadable()) {
               return  recurso;
           } else{
               throw new FileNotFoundException("No se pudo encontrar el archivo"+nombreArchivo);
           }
       }catch (MalformedURLException e) {
           throw new FileNotFoundException("No se pudo encontrar el archivo"+nombreArchivo,e);
       }
    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {

        Path archivo = cargarArchivo(nombreArchivo);
        try {
            FileSystemUtils.deleteRecursively(archivo);

        }catch (IOException e) {
            System.out.println(e);
        }

    }
}
