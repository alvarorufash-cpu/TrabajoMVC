package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Botas extends Productos {
    private int numPie;

    public Botas(String nombre, float precio, LocalDate fechaLlegada, int numPie) {
        super(nombre, precio, fechaLlegada);
        this.numPie = numPie;
    }

    public int getNumPie() {
        return numPie;
    }

    public void setNumPie(int numPie) {
        this.numPie = numPie;
    }
}
