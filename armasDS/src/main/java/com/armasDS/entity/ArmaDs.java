package com.armasDS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class ArmaDs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String titulo;
    @Transient
    @JsonIgnore
    private MultipartFile imagen;
    @JsonProperty("image")
    private String rutaImagen;
    private String imageUrl;
    @NotBlank
    private String obtencion;
    @NotNull
    private CategoriaDs categoria;
    @NotNull
    @Min(0)
    private double peso ;
    @NotNull
    @Min(0)
    private int durabilidad=100;
    @NotNull
    @Min(0)
    @JsonProperty("atkPhys")
    private int aFisico;
    @NotNull
    @Min(0)
    @JsonProperty("defPhys")
    private int dFisico=40;
    @NotNull
    @Min(0)
    @JsonProperty("atkMagic")
    private int aMagico;
    @NotNull
    @Min(0)
    @JsonProperty("defMagic")
    private int dMagico=10;
    @NotNull
    @Min(0)
    @JsonProperty("atkFire")
    private int aFuego;
    @NotNull
    @Min(0)
    @JsonProperty("defFire")
    private int dFuego=30;
    @NotNull
    @Min(0)
    @JsonProperty("atkLightning")
    private int aElectricidad;
    @NotNull
    @Min(0)
    @JsonProperty("defLightning")
    private int dElectricidad=30;
    @NotNull
    @Min(0)
    private int critico=100;
    @NotNull
    @Min(0)
    private int estabilidad;
    @NotNull
    @Min(0)
    @JsonProperty("reqStr")
    private int nFuerza;
    @NotNull
    @Min(0)
    @JsonProperty("reqDex")
    private int nDestreza;
    @NotNull
    @Min(0)
    @JsonProperty("reqInt")
    private int nInteligencia;
    @NotNull
    @Min(0)
    @JsonProperty("reqFe")
    private int nFe;
    @NotNull
    @JsonProperty("escaldoStr")
    private Escalado escaladoFuerza;
    @NotNull
    @JsonProperty("escaldoDex")
    private Escalado escaladoDestreza;
    @NotNull
    @JsonProperty("escaldoInt")
    private Escalado escaladoInteligencia;
    @NotNull
    @JsonProperty("escaldoFe")
    private Escalado escaladoFe;
    @NotNull
    @Min(0)
    private int hemorragia;
    @NotNull
    @Min(0)
    private int veneno;
    @NotNull
    @Min(0)
    private int divino;
    @NotNull
    @Min(0)
    private int oculto;
    @NotNull
    @Min(0)
    private int toxico;

    //Get Y Set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public @NotBlank String getObtencion() {
        return obtencion;
    }

    public void setObtencion(@NotBlank String obtencion) {
        this.obtencion = obtencion;
    }

    public @NotNull CategoriaDs getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull CategoriaDs categoria) {
        this.categoria = categoria;
    }

    @NotNull
    @Min(0)
    public double getPeso() {
        return peso;
    }

    public void setPeso(@NotNull @Min(0) double peso) {
        this.peso = peso;
    }

    @NotNull
    @Min(0)
    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(@NotNull @Min(0) int durabilidad) {
        this.durabilidad = durabilidad;
    }

    @NotNull
    @Min(0)
    public int getaFisico() {
        return aFisico;
    }

    public void setaFisico(@NotNull @Min(0) int aFisico) {
        this.aFisico = aFisico;
    }

    @NotNull
    @Min(0)
    public int getdFisico() {
        return dFisico;
    }

    public void setdFisico(@NotNull @Min(0) int dFisico) {
        this.dFisico = dFisico;
    }

    @NotNull
    @Min(0)
    public int getaMagico() {
        return aMagico;
    }

    public void setaMagico(@NotNull @Min(0) int aMagico) {
        this.aMagico = aMagico;
    }

    @NotNull
    @Min(0)
    public int getdMagico() {
        return dMagico;
    }

    public void setdMagico(@NotNull @Min(0) int dMagico) {
        this.dMagico = dMagico;
    }

    @NotNull
    @Min(0)
    public int getaFuego() {
        return aFuego;
    }

    public void setaFuego(@NotNull @Min(0) int aFuego) {
        this.aFuego = aFuego;
    }

    @NotNull
    @Min(0)
    public int getdFuego() {
        return dFuego;
    }

    public void setdFuego(@NotNull @Min(0) int dFuego) {
        this.dFuego = dFuego;
    }

    @NotNull
    @Min(0)
    public int getaElectricidad() {
        return aElectricidad;
    }

    public void setaElectricidad(@NotNull @Min(0) int aElectricidad) {
        this.aElectricidad = aElectricidad;
    }

    @NotNull
    @Min(0)
    public int getdElectricidad() {
        return dElectricidad;
    }

    public void setdElectricidad(@NotNull @Min(0) int dElectricidad) {
        this.dElectricidad = dElectricidad;
    }

    @NotNull
    @Min(0)
    public int getCritico() {
        return critico;
    }

    public void setCritico(@NotNull @Min(0) int critico) {
        this.critico = critico;
    }

    @NotNull
    @Min(0)
    public int getEstabilidad() {
        return estabilidad;
    }

    public void setEstabilidad(@NotNull @Min(0) int estabilidad) {
        this.estabilidad = estabilidad;
    }

    @NotNull
    @Min(0)
    public int getnFuerza() {
        return nFuerza;
    }

    public void setnFuerza(@NotNull @Min(0) int nFuerza) {
        this.nFuerza = nFuerza;
    }

    @NotNull
    @Min(0)
    public int getnDestreza() {
        return nDestreza;
    }

    public void setnDestreza(@NotNull @Min(0) int nDestreza) {
        this.nDestreza = nDestreza;
    }

    @NotNull
    @Min(0)
    public int getnInteligencia() {
        return nInteligencia;
    }

    public void setnInteligencia(@NotNull @Min(0) int nInteligencia) {
        this.nInteligencia = nInteligencia;
    }

    @NotNull
    @Min(0)
    public int getnFe() {
        return nFe;
    }

    public void setnFe(@NotNull @Min(0) int nFe) {
        this.nFe = nFe;
    }

    public @NotNull Escalado getEscaladoFuerza() {
        return escaladoFuerza;
    }

    public void setEscaladoFuerza(@NotNull Escalado escaladoFuerza) {
        this.escaladoFuerza = escaladoFuerza;
    }

    public @NotNull Escalado getEscaladoDestreza() {
        return escaladoDestreza;
    }

    public void setEscaladoDestreza(@NotNull Escalado escaladoDestreza) {
        this.escaladoDestreza = escaladoDestreza;
    }

    public @NotNull Escalado getEscaladoInteligencia() {
        return escaladoInteligencia;
    }

    public void setEscaladoInteligencia(@NotNull Escalado escaladoInteligencia) {
        this.escaladoInteligencia = escaladoInteligencia;
    }

    public @NotNull Escalado getEscaladoFe() {
        return escaladoFe;
    }

    public void setEscaladoFe(@NotNull Escalado escaladoFe) {
        this.escaladoFe = escaladoFe;
    }

    @NotNull
    @Min(0)
    public int getHemorragia() {
        return hemorragia;
    }

    public void setHemorragia(@NotNull @Min(0) int hemorragia) {
        this.hemorragia = hemorragia;
    }

    @NotNull
    @Min(0)
    public int getVeneno() {
        return veneno;
    }

    public void setVeneno(@NotNull @Min(0) int veneno) {
        this.veneno = veneno;
    }

    @NotNull
    @Min(0)
    public int getDivino() {
        return divino;
    }

    public void setDivino(@NotNull @Min(0) int divino) {
        this.divino = divino;
    }

    @NotNull
    @Min(0)
    public int getOculto() {
        return oculto;
    }

    public void setOculto(@NotNull @Min(0) int oculto) {
        this.oculto = oculto;
    }

    @NotNull
    @Min(0)
    public int getToxico() {
        return toxico;
    }

    public void setToxico(@NotNull @Min(0) int toxico) {
        this.toxico = toxico;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    //CONSTRUCTOR


    public ArmaDs() {
    }

    public ArmaDs(String titulo, MultipartFile imagen, String rutaImagen, String obtencion, CategoriaDs categoria, double peso, int durabilidad, int aFisico, int dFisico, int aMagico, int dMagico, int aFuego, int dFuego, int aElectricidad, int dElectricidad, int critico, int estabilidad, int nFuerza, int nDestreza, int nInteligencia, int nFe, Escalado escaladoFuerza, Escalado escaladoDestreza, Escalado escaladoInteligencia, Escalado escaladoFe, int hemorragia, int veneno, int divino, int oculto, int toxico) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.rutaImagen = rutaImagen;
        this.obtencion = obtencion;
        this.categoria = categoria;
        this.peso = peso;
        this.durabilidad = durabilidad;
        this.aFisico = aFisico;
        this.dFisico = dFisico;
        this.aMagico = aMagico;
        this.dMagico = dMagico;
        this.aFuego = aFuego;
        this.dFuego = dFuego;
        this.aElectricidad = aElectricidad;
        this.dElectricidad = dElectricidad;
        this.critico = critico;
        this.estabilidad = estabilidad;
        this.nFuerza = nFuerza;
        this.nDestreza = nDestreza;
        this.nInteligencia = nInteligencia;
        this.nFe = nFe;
        this.escaladoFuerza = escaladoFuerza;
        this.escaladoDestreza = escaladoDestreza;
        this.escaladoInteligencia = escaladoInteligencia;
        this.escaladoFe = escaladoFe;
        this.hemorragia = hemorragia;
        this.veneno = veneno;
        this.divino = divino;
        this.oculto = oculto;
        this.toxico = toxico;
    }
}
