package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Anorak extends Productos{
    private String descuento;

    public Anorak(){
        super();
    }

    public Anorak(String nombre, float precio, String descripcion, LocalDate fechaLlegada, String descuento, int id) {
        super(nombre, precio, descripcion, fechaLlegada, id);
        this.descuento = descuento;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
