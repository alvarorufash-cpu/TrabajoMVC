package com.alvaroru.tiendainvierno.base;

public class Casco extends Productos{
    private String homologacion;

    public Casco(String nombre, float precio, String homologacion) {
        super(nombre, precio);
        this.homologacion = homologacion;
    }

    public String getHomologacion() {
        return homologacion;
    }

    public void setHomologacion(String homologacion) {
        this.homologacion = homologacion;
    }
}
