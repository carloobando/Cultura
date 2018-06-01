package com.example.sistemas.cultura.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bibliotecas {

    @SerializedName("barrio")
    @Expose
    private String barrio;
    @SerializedName("c_digo_dane")
    @Expose
    private String cDigoDane;
    @SerializedName("centro_poblado")
    @Expose
    private String centroPoblado;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("direcci_n_de_la_biblioteca")
    @Expose
    private String direcciNDeLaBiblioteca;
    @SerializedName("estado_de_la_biblioteca")
    @Expose
    private String estadoDeLaBiblioteca;
    @SerializedName("georeferencia")
    @Expose
    private String georeferencia;
    @SerializedName("municipio")
    @Expose
    private String municipio;
    @SerializedName("naturaleza_de_la_biblioteca")
    @Expose
    private String naturalezaDeLaBiblioteca;
    @SerializedName("nombre_de_la_biblioteca")
    @Expose
    private String nombreDeLaBiblioteca;
    @SerializedName("tel_fonos_de_contacto")
    @Expose
    private String telFonosDeContacto;
    @SerializedName("tipo_de_biblioteca")
    @Expose
    private String tipoDeBiblioteca;

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCDigoDane() {
        return cDigoDane;
    }

    public void setCDigoDane(String cDigoDane) {
        this.cDigoDane = cDigoDane;
    }

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDirecciNDeLaBiblioteca() {
        return direcciNDeLaBiblioteca;
    }

    public void setDirecciNDeLaBiblioteca(String direcciNDeLaBiblioteca) {
        this.direcciNDeLaBiblioteca = direcciNDeLaBiblioteca;
    }

    public String getEstadoDeLaBiblioteca() {
        return estadoDeLaBiblioteca;
    }

    public void setEstadoDeLaBiblioteca(String estadoDeLaBiblioteca) {
        this.estadoDeLaBiblioteca = estadoDeLaBiblioteca;
    }

    public String getGeoreferencia() {
        return georeferencia;
    }

    public void setGeoreferencia(String georeferencia) {
        this.georeferencia = georeferencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNaturalezaDeLaBiblioteca() {
        return naturalezaDeLaBiblioteca;
    }

    public void setNaturalezaDeLaBiblioteca(String naturalezaDeLaBiblioteca) {
        this.naturalezaDeLaBiblioteca = naturalezaDeLaBiblioteca;
    }

    public String getNombreDeLaBiblioteca() {
        return nombreDeLaBiblioteca;
    }

    public void setNombreDeLaBiblioteca(String nombreDeLaBiblioteca) {
        this.nombreDeLaBiblioteca = nombreDeLaBiblioteca;
    }

    public String getTelFonosDeContacto() {
        return telFonosDeContacto;
    }

    public void setTelFonosDeContacto(String telFonosDeContacto) {
        this.telFonosDeContacto = telFonosDeContacto;
    }

    public String getTipoDeBiblioteca() {
        return tipoDeBiblioteca;
    }

    public void setTipoDeBiblioteca(String tipoDeBiblioteca) {
        this.tipoDeBiblioteca = tipoDeBiblioteca;
    }

}