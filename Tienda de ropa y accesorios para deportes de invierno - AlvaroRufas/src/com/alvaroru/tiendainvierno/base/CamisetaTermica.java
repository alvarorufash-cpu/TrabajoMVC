package com.alvaroru.tiendainvierno.base;

public class CamisetaTermica extends Productos{
    private String Talla;

    public CamisetaTermica(String nombre, float precio, String talla) {
        super(nombre, precio);
        Talla = talla;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }
}
