package com.armasDS.services;

import com.armasDS.entity.ArmaDs;
import com.armasDS.entity.ArmaDSSummaryDto;
import com.armasDS.entity.CategoriaDs;
import com.armasDS.exceptions.FileNotFoundException;
import com.armasDS.repository.ArmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmaDsService {

    @Autowired
    private ArmaRepository armaRepository;

    public List<ArmaDs> listarTodasLasArmas(){
        return armaRepository.findAll();
    }

    public ArmaDs getArmaById(Integer id){
        return armaRepository.findById(id).orElseThrow(()-> new FileNotFoundException("Arma no encontrada"));
    }
    public ArmaDs getArmaByTitulo(String titulo){
        if (armaRepository.findByTitulo(titulo) == null) {
            throw new FileNotFoundException("Arma no encontrada");
        }else {
            return armaRepository.findByTitulo(titulo);
        }
    }
    public List<ArmaDs> listarArmasPorCategoria(CategoriaDs categoria){
        return armaRepository.findByCategoria(categoria);
    }

    public ArmaDs addArma(ArmaDs arma){
        return armaRepository.save(arma);
    }

    public String deleteArma(Integer id){
        if (armaRepository.existsById(id)) {
            armaRepository.deleteById(id);
            return "Arma eliminada";
        }else {
            return "Arma no encontrada";
        }
    }

    public String deleteArmaByTitulo(String titulo){
        ArmaDs arma = getArmaByTitulo(titulo);
        if (arma != null) {
            armaRepository.delete(arma);
            return "Arma eliminada";
        }else {
            return "Arma no encontrada";
        }
    }

    //summary Dto

    public ArmaDSSummaryDto getSummaryDtoById(Integer id){

        ArmaDs arma = getArmaById(id);
        if (arma == null){ return null; }

        ArmaDSSummaryDto dto = new ArmaDSSummaryDto();
        dto.setId(arma.getId());
        dto.setTitulo(arma.getTitulo());
        dto.setCategoria(arma.getCategoria().toString());
        dto.setObtencion(arma.getObtencion());

        return dto;

    }

    public ArmaDSSummaryDto getSummaryDtoByTitulo(String titulo){

        ArmaDs arma = getArmaByTitulo(titulo);
        if (arma == null){return null;}

        ArmaDSSummaryDto dto = new ArmaDSSummaryDto();
        dto.setId(arma.getId());
        dto.setTitulo(arma.getTitulo());
        dto.setCategoria(arma.getCategoria().toString());
        dto.setObtencion(arma.getObtencion());

        return dto;
    }


    public Page<ArmaDs> findAll(Pageable pageable) {

        return armaRepository.findAll(pageable);
    }
}
