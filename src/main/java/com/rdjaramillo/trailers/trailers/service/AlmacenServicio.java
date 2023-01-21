package com.rdjaramillo.trailers.trailers.service;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Path;

public interface AlmacenServicio {

    public void iniciarAlmacenDeArchivo();

    public String almacenarArchivo(MultipartFile archivo);

    public Path cargarArchivo(String nombreArchivo);

    public Resource cargarComoRecurso(String nombreArchivo);

    public void eliminarArchivo(String nombreArchivo);


}
