package com.armasDS.controller;

import com.armasDS.entity.ArmaDSSummaryDto;
import com.armasDS.entity.ArmaDs;
import com.armasDS.entity.CategoriaDs;
import com.armasDS.services.AlmacenajeServiceImpl;
import com.armasDS.services.ArmaDsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/weaponsDS")
public class ArmaController {

    @Autowired
    private ArmaDsService armaService;
    @Autowired
    private AlmacenajeServiceImpl almacenajeService;

    @GetMapping("/all")
    @Order(1)
    @Tag(name = "Obtener Grupos de Armas")
    public ResponseEntity<List<ArmaDs>> getAllWeapons(){
        List<ArmaDs> armas = armaService.listarTodasLasArmas();
        if (armas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (ArmaDs arma : armas){
            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/id/")
                    .path(String.valueOf(arma.getId()))
                    .toUriString();
            arma.setImageUrl(imageUrl);
        }

        return ResponseEntity.ok(armas);
    }

    @GetMapping("/category/{category}")
    @Order(2)
    @Tag(name = "Obtener Grupos de Armas")
    public ResponseEntity<List<ArmaDs>> getWeaponsByCategory(@PathVariable String category){
        CategoriaDs catergoriaEnum= CategoriaDs.valueOf(category);
        List<ArmaDs> armas = armaService.listarArmasPorCategoria(catergoriaEnum);
        if (armas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (ArmaDs arma : armas){
            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/id/")
                    .path(String.valueOf(arma.getId()))
                    .toUriString();
            arma.setImageUrl(imageUrl);
        }

        return ResponseEntity.ok(armas);
    }

    @GetMapping
    @Order(1)
    @Tag(name = "Arma Aleatoria")
    public ResponseEntity<ArmaDs> getRandomWeapon(){
        List<ArmaDs> armas = armaService.listarTodasLasArmas();
        if (armas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        int numRandom = (int) (Math.random() * armas.size());
        ArmaDs armaAlAzar = armas.get(numRandom);
        if (armaAlAzar != null){
            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/id/")
                    .path(String.valueOf(armaAlAzar.getId()))
                    .toUriString();
            armaAlAzar.setImageUrl(imageUrl);
        }
        return ResponseEntity.ok(armaAlAzar);
    }
    @GetMapping("/imagen")
    @Order(2)
    @Tag(name = "Arma Aleatoria")
    public ResponseEntity<Resource> getRandomWeaponImage(){
        List<ArmaDs> armas = armaService.listarTodasLasArmas();
        if (armas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        int numRandom = (int) (Math.random() * armas.size());
        ArmaDs armaAlAzar = armas.get(numRandom);

        //--------------------------------

        try{
            ArmaDs arma = armaService.getArmaById(armaAlAzar.getId());
            if (arma == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            String rutaImagen = arma.getRutaImagen();
            if(rutaImagen.isEmpty()|| rutaImagen== null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Path filePath = almacenajeService.cargarArchivo(rutaImagen);
            Resource resource = almacenajeService.cargarComoRecurso(String.valueOf(filePath));

            if (resource.exists() || resource.isReadable()){
                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf("image/webp"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/id/{id}")
    @Order(1)
    @Tag(name = "Obtener Arma Especifica")
    public ResponseEntity<ArmaDs> getWeaponById(@PathVariable Integer id){
        ArmaDs arma = armaService.getArmaById(id);
        if (arma != null){

            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/id/")
                    .path(String.valueOf(id))
                    .toUriString();
            arma.setImageUrl(imageUrl);

            return ResponseEntity.ok(arma);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nombre/{nombreArma}")
    @Order(2)
    @Tag(name = "Obtener Arma Especifica")
    public ResponseEntity<ArmaDs> getWeaponByTitle(@PathVariable String nombreArma){
        String nombreArmaTransformado = nombreArma.replace("_", " ");
        ArmaDs arma = armaService.getArmaByTitulo(nombreArmaTransformado);
        if (arma != null){

            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/nombre/")
                    .path(nombreArmaTransformado)
                    .toUriString();
            arma.setImageUrl(imageUrl);

            return ResponseEntity.ok(arma);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //dto
    @GetMapping("/id/{id}/summary")
    @Order(1)
    @Tag(name = "Obtener Arma Especifica Resumida")
    public ResponseEntity<ArmaDSSummaryDto> getArmaSummaryById(@PathVariable Integer id){
        ArmaDSSummaryDto resumen= armaService.getSummaryDtoById(id);
        if (resumen != null){
            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/id/")
                    .path(String.valueOf(id))
                    .toUriString();
            resumen.setImageUrl(imageUrl);

            return ResponseEntity.ok(resumen);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nombre/{nombreArma}/summary")
    @Order(2)
    @Tag(name = "Obtener Arma Especifica Resumida")
    public ResponseEntity<ArmaDSSummaryDto> getArmaSummaryByTitle(@PathVariable String nombreArma){
        String nombreArmaTransformado = nombreArma.replace("_", " ");
        ArmaDSSummaryDto resumen= armaService.getSummaryDtoByTitulo(nombreArmaTransformado);
        if (resumen != null){

            String imageUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/weaponsDS/imagen/nombre/")
                    .path(nombreArmaTransformado)
                    .toUriString();
            resumen.setImageUrl(imageUrl);

            return ResponseEntity.ok(resumen);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/imagen/nombre/{nombreArma}")
    @Order(4)
    @Tag(name = "Obtener Arma Especifica")
    public ResponseEntity<Resource> getWeaponImage(@PathVariable String nombreArma){
        try{
            String nombreArmaTransformado = nombreArma.replace("_", " ");
            ArmaDs arma = armaService.getArmaByTitulo(nombreArmaTransformado);
            if (arma == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            String rutaImagen = arma.getRutaImagen();
            if(rutaImagen.isEmpty()|| rutaImagen== null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Path filePath = almacenajeService.cargarArchivo(rutaImagen);
            Resource resource = almacenajeService.cargarComoRecurso(rutaImagen);
            if (resource.exists() || resource.isReadable()){
                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf("image/webp"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/imagen/id/{id}")
    @Order(3)
    @Tag(name = "Obtener Arma Especifica")
    public ResponseEntity<Resource> getWeaponImageById(@PathVariable Integer id){
        try{
            ArmaDs arma = armaService.getArmaById(id);
            if (arma == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            String rutaImagen = arma.getRutaImagen();
            if(rutaImagen.isEmpty()|| rutaImagen== null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Path filePath = almacenajeService.cargarArchivo(rutaImagen);
            Resource resource = almacenajeService.cargarComoRecurso(String.valueOf(filePath));

            if (resource.exists() || resource.isReadable()){
                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf("image/webp"))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping
    @Order(1)
    @Tag(name = "Acciones de Modificación")
    public ArmaDs addWeapon(@RequestBody ArmaDs arma){
        return armaService.addArma(arma);
    }

    @DeleteMapping("/id/{id}")
    @Order(2)
    @Tag(name = "Acciones de Modificación")
    public String deleteWeapon(@PathVariable Integer id){
        return armaService.deleteArma(id);
    }
    @DeleteMapping("/nombre/{title}")
    @Order(3)
    @Tag(name = "Acciones de Modificación")
    public String deleteWeaponByTitle(@PathVariable String nombreArma){
        String nombreArmaTransformado = nombreArma.replace("_", " ");
        return armaService.deleteArmaByTitulo(nombreArmaTransformado);
    }

}
