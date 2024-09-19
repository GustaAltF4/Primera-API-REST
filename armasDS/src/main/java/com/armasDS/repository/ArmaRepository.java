package com.armasDS.repository;

import com.armasDS.entity.ArmaDs;
import com.armasDS.entity.CategoriaDs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArmaRepository extends JpaRepository<ArmaDs, Integer> {
    ArmaDs findByTitulo(String titulo);

    List<ArmaDs> findByCategoria(CategoriaDs categoria);
}
