package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Guantes extends Productos {
    private boolean EsTactil;

    public Guantes(){
        super();
    }

    public Guantes(String nombre, float precio, String descripcion, LocalDate fechaLlegada, int id, boolean esTactil) {
        super(nombre, precio, descripcion, fechaLlegada, id);
        EsTactil = esTactil;
    }

    public boolean getEsTactil() {
        return EsTactil;
    }

    public void setEsTactil(boolean esTactil) {
        EsTactil = esTactil;
    }
}
