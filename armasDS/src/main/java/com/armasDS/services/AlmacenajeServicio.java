package com.armasDS.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface AlmacenajeServicio {

    public void inicializarAlmacenaje();
    public String almacenarArchivo(MultipartFile archivo);
    public Path cargarArchivo(String nombreArchivo);
    public Resource cargarComoRecurso(String nombreArchivo);
    public void borrarArchivo(String nombreArchivo);


}
