package com.example.veterinaria.model;

import jakarta.persistence.*;

public class Mascota {

    private String nombre;

    private String especie;// Perro ,Gato ,Aves

    private String raza;

    private Integer edad;

    //Constructor vacio
    public Mascota(){

    }

    //Constrcutor con parametros
    public Mascota(String nombre, String especie, String raza, Integer edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
