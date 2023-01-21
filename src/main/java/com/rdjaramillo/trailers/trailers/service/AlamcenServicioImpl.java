package com.rdjaramillo.trailers.trailers.service;

import com.rdjaramillo.trailers.trailers.excepciones.AlmacenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        return null;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return null;
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) {
        return null;
    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {

    }
}
