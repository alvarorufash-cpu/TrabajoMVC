package com.alvaroru.tiendainvierno.base;


import java.time.LocalDate;

public class Productos {
    private String nombre;
    private float precio;
    private LocalDate fechaLlegada;

    public Productos(String nombre, float precio, LocalDate fechaLlegada) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaLlegada = fechaLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) { this.precio = precio; }

    public LocalDate getFechaLlegada(){return fechaLlegada;}

    public void setFechaLlegada(LocalDate fechaLlegada){this.fechaLlegada = fechaLlegada;}
}
