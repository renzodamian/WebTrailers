package com.rdjaramillo.trailers.trailers.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.nio.file.Path;

public interface AlmacenServicio {

    public void iniciarAlmacenDeArchivo();

    public String almacenarArchivo(MultipartFile archivo);

    public Path cargarArchivo(String nombreArchivo);

    public Resource cargarComoRecurso(String nombreArchivo) throws FileNotFoundException;

    public void eliminarArchivo(String nombreArchivo);


}
