package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Guantes extends Productos {
    private boolean EsTactil;

    public Guantes(String nombre, float precio, LocalDate fechaLlegada, boolean esTermico) {
        super(nombre, precio, fechaLlegada);
        EsTactil = esTermico;
    }

    public boolean isEsTermico() {
        return EsTactil;
    }

    public void setEsTermico(boolean esTermico) {
        EsTactil = esTermico;
    }
}
