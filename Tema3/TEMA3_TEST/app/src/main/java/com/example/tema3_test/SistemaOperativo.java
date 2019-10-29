package com.example.tema3_test;

public class SistemaOperativo {
    String nombre,year;
    int logo;

    public SistemaOperativo(String nombre, String year, int logo) {
        this.nombre = nombre;
        this.year = year;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
