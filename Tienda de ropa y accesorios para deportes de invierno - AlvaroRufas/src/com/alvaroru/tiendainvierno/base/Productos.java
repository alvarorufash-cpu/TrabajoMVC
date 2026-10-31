package com.alvaroru.tiendainvierno.base;


import java.time.LocalDate;

public class Productos {
    private int id;
    private String nombre;
    private float precio;
    private String descripcion;
    private LocalDate fechaLlegada;

    public Productos(){     //Crea dos constructores, uno lleno y otro vacio

    }

    public Productos(String nombre, float precio, String descripcion, LocalDate fechaLlegada, int id) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaLlegada = fechaLlegada;
    }

    public Productos(String nombre, String precio, LocalDate fechaLlegada, String id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
