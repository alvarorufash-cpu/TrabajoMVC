package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Casco extends Productos{
    private String homologacion;

    public Casco(int id, String nombre, float precio, LocalDate fechaLlegada, String homologacion) {
        super(nombre, precio, fechaLlegada, id);
        this.homologacion = homologacion;
    }

    public String getHomologacion() {
        return homologacion;
    }

    public void setHomologacion(String homologacion) {
        this.homologacion = homologacion;
    }
}
