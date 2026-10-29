package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Anorak extends Productos{
    private String descuento;

    public Anorak(String nombre, float precio, LocalDate fechaLlegada, String descuento, int id) {
        super(nombre, precio, fechaLlegada, id);
        this.descuento = descuento;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
