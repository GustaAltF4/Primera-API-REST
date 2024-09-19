package com.armasDS.services;

import com.armasDS.exceptions.AlmancenajeException;
import com.armasDS.exceptions.FileNotFoundException;
import com.armasDS.repository.ArmaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AlmacenajeServiceImpl implements AlmacenajeServicio{

    @Autowired
    private ArmaRepository armaRepositorio;
    @Value("${storage.location}")
    private String storageLocation;


    @Override
    @PostConstruct
    public void inicializarAlmacenaje() {
        try{
            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException e){
            throw new AlmancenajeException("Error al iniciar el almacenaje");
        }
    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo =archivo.getOriginalFilename();
        if (archivo.isEmpty()){
            throw new AlmancenajeException("No se puede subir un archivo vació");
        }
        try{
            InputStream inputStream =archivo.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new AlmancenajeException("Error al subir el archivo"+ nombreArchivo);
        }

        return nombreArchivo;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        // Imprime el nombre del archivo para depuración
        System.out.println("Nombre del archivo: " + nombreArchivo);

        // Imprime el storageLocation para depuración
        System.out.println("storageLocation: " + storageLocation);

        nombreArchivo = nombreArchivo.replaceAll("^assets[/\\\\]", "");

        // Construye la ruta y la imprime
        Path archivo = Paths.get(storageLocation).resolve(nombreArchivo);
        System.out.println("Ruta del Archivo: " + archivo.toAbsolutePath());
        return archivo;

    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) {
        try{
            Path archivo =cargarArchivo(nombreArchivo);
            Resource resource =new UrlResource(archivo.toUri());
            if (resource.exists()||resource.isReadable()){
                return resource;
            }else {
                throw new FileNotFoundException("No se pudo encontrar el archivo: "+ nombreArchivo);
            }
        }catch (MalformedURLException e){
            throw new FileNotFoundException("No se pudo encontrar el archivo: "+ nombreArchivo);
        }
    }

    @Override
    public void borrarArchivo(String nombreArchivo) {
        Path archivo =cargarArchivo(nombreArchivo);
        try{
            FileSystemUtils.deleteRecursively(archivo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
