package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Guantes extends Productos {
    private boolean EsTactil;

    public Guantes(int id, String nombre, float precio, LocalDate fechaLlegada, boolean esTermico) {
        super(nombre, precio, fechaLlegada, id);
        EsTactil = esTermico;
    }

    public boolean isEsTactil() {
        return EsTactil;
    }

    public void setEsTactil(boolean esTactil) {
        EsTactil = esTactil;
    }

    public boolean isEsTermico() {
        return EsTactil;
    }

}
