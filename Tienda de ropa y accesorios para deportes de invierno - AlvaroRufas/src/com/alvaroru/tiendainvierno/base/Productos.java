package com.alvaroru.tiendainvierno.base;


import java.time.LocalDate;

public class Productos {
    private int id;
    private String nombre;
    private float precio;
    private LocalDate fechaLlegada;

    public Productos(){     //Crea dos constructores, uno lleno y otro vacio

    }

    public Productos(String nombre, float precio, LocalDate fechaLlegada, int id) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaLlegada = fechaLlegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
