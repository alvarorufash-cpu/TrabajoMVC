package com.alvaroru.tiendainvierno.base;

public class Anorak extends Productos{
    private String descuento;

    public Anorak(String nombre, float precio, String descuento) {
        super(nombre, precio);
        this.descuento = descuento;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
