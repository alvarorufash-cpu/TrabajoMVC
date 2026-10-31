package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class CamisetaTermica extends Productos{
    private String Talla;

    public CamisetaTermica(){
        super();
    }

    public CamisetaTermica(int id, String nombre, float precio, String descipcion, LocalDate fechaLlegada, String talla) {
        super(nombre, precio, descipcion, fechaLlegada, id);
        Talla = talla;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }
}
