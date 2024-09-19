package com.armasDS.entity;

public class ArmaDSSummaryDto {

    private Integer id;
    private String titulo;
    private String obtencion;
    private String categoria;
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObtencion() {
        return obtencion;
    }

    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
