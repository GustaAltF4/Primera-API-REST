package com.armasDS.controller;

import com.armasDS.entity.ArmaDs;
import com.armasDS.entity.CategoriaDs;
import com.armasDS.entity.Escalado;
import com.armasDS.services.AlmacenajeServiceImpl;
import com.armasDS.services.ArmaDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private ArmaDsService armaService;
    @Autowired
    private AlmacenajeServiceImpl almacenajeService;

    @GetMapping
    public ModelAndView verInicioAdmin(@PageableDefault(size = 16) Pageable pageable){


        Page<ArmaDs> armas= armaService.findAll(pageable);
        return new ModelAndView("index")
                .addObject("armas", armas)
                .addObject("category", CategoriaDs.values())
                .addObject("escalados", Escalado.values());

    }
    @GetMapping("/arma/agregar")
    public ModelAndView verFormularioDeAgregar(){

        return new ModelAndView("nueva-arma")
                .addObject("arma", new ArmaDs())
                .addObject("category", CategoriaDs.values())
                .addObject("escalados", Escalado.values());
    }

    @PostMapping("/arma/agregar")
    public ModelAndView agregarArma(@ModelAttribute("arma") @Validated ArmaDs arma , BindingResult result){

        if (result.hasErrors() || arma.getImagen().isEmpty()){
            if (arma.getImagen()==null || arma.getImagen().isEmpty()){
                result.rejectValue("rutaImagen", "error.arma" , "La imagen es obligatoria");
            }
            return new ModelAndView("nueva-arma")
                    .addObject("arma",arma)
                    .addObject("category", CategoriaDs.values());
        }
        String rutaImagen = almacenajeService.almacenarArchivo(arma.getImagen());
        arma.setRutaImagen(rutaImagen);

        armaService.addArma(arma);

        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/arma/{id}/editar")
    public ModelAndView verFormularioDeEditar(@PathVariable Integer id){

        ArmaDs arma = armaService.getArmaById(id);
        return new ModelAndView("nueva-arma")
                .addObject("arma",arma)
                .addObject("category", CategoriaDs.values())
                .addObject("escalados", Escalado.values());
    }


    @PostMapping("/arma/{id}/editar")
    public ModelAndView editarArma(@PathVariable Integer id, @ModelAttribute("arma") @Validated ArmaDs arma , BindingResult result){

        if (result.hasErrors()){
            return new ModelAndView("editar-arma")
                    .addObject("arma",arma)
                    .addObject("category", CategoriaDs.values())
                    .addObject("escalados", Escalado.values());
        }
        ArmaDs armaDsEditar = armaService.getArmaById(id);

        armaDsEditar.setTitulo(arma.getTitulo());
        armaDsEditar.setObtencion(arma.getObtencion());
        armaDsEditar.setCategoria(arma.getCategoria());
        armaDsEditar.setPeso(arma.getPeso());
        armaDsEditar.setDurabilidad(arma.getDurabilidad());
        armaDsEditar.setCritico(arma.getCritico());
        armaDsEditar.setEstabilidad(arma.getEstabilidad());
        armaDsEditar.setHemorragia(arma.getHemorragia());
        armaDsEditar.setVeneno(arma.getVeneno());
        armaDsEditar.setDivino(arma.getDivino());
        armaDsEditar.setOculto(arma.getOculto());
        armaDsEditar.setToxico(arma.getToxico());
        armaDsEditar.setaFisico(arma.getaFisico());
        armaDsEditar.setaMagico(arma.getaMagico());
        armaDsEditar.setaFuego(arma.getaFuego());
        armaDsEditar.setaElectricidad(arma.getaElectricidad());
        armaDsEditar.setdFisico(arma.getdFisico());
        armaDsEditar.setdMagico(arma.getdMagico());
        armaDsEditar.setdFuego(arma.getdFuego());
        armaDsEditar.setdElectricidad(arma.getdElectricidad());
        armaDsEditar.setnFuerza(arma.getnFuerza());
        armaDsEditar.setnDestreza(arma.getnDestreza());
        armaDsEditar.setnInteligencia(arma.getnInteligencia());
        armaDsEditar.setnFe(arma.getnFe());
        armaDsEditar.setEscaladoFuerza(arma.getEscaladoFuerza());
        armaDsEditar.setEscaladoDestreza(arma.getEscaladoDestreza());
        armaDsEditar.setEscaladoInteligencia(arma.getEscaladoInteligencia());
        armaDsEditar.setEscaladoFe(arma.getEscaladoFe());

        if (!arma.getImagen().isEmpty()){
            almacenajeService.borrarArchivo(armaDsEditar.getRutaImagen());
            String rutaImagen = almacenajeService.almacenarArchivo(arma.getImagen());
            armaDsEditar.setRutaImagen(rutaImagen);
        }

        armaService.addArma(armaDsEditar);

        return new ModelAndView("redirect:/admin");

    }

    @PostMapping("/arma/{id}/borrar")
    public String borrarArma(@PathVariable Integer id){


        ArmaDs armaDs = armaService.getArmaById(id);
        armaService.deleteArma(armaDs.getId());
        almacenajeService.borrarArchivo(armaDs.getRutaImagen());

        return "redirect:/admin";

    }



}
