package com.armasDS.entity;

public enum CategoriaDs {

    ALABARDA("Alabarda"),
    ARCO("Arco"),
    ARMADEJEFES("Arma de jefes"),
    ARMADLC("Arma DLC"),
    BALLESTA("Ballesta"),
    CATALIZADOR("Catalizador"),
    DAGA("Daga"),
    ESCUDODLC("Escudo DLC"),
    ESCUDOGRANDE("Escudo grande"),
    ESCUDOMEDIANO("Escudo mediano"),
    ESCUDOPEQUENIO("Escudo pequeño"),
    ESPADACURVA("Espada curva"),
    ESPADAESTOCADA("Espada estocada"),
    ESPADARECTA("Espada recta"),
    ESPADON("Espadón"),
    ESPADONCURVO("Espadón curvo"),
    FAROL("Farol"),
    GUANTELETE("Guantelete"),
    HACHA("Hacha"),
    HACHAGRANDE("Hacha grande"),
    KATANA("Katana"),
    LANZA("Lanza"),
    LANZALARGA("Lanza larga"),
    LATIGO("Latigo"),
    LLAMAPIROMANCIA("Llama piromancia"),
    MARTILLO("Martillo"),
    MARTILLOGRANDE("Martillo grande"),
    TALISMAN("Talisman"),
    ULTRAESPANDON("Ultra espadón"),;

    private final String titulo;

    CategoriaDs(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

}
