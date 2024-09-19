package com.armasDS.controller;

import com.armasDS.services.AlmacenajeServiceImpl;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private AlmacenajeServiceImpl almacenajeService;


    @GetMapping("/{filename:.+}")
    @Hidden
    public Resource obtenerComoRecurso(@PathVariable("filename") String filename) {
        return almacenajeService.cargarComoRecurso(filename);
    }
}
