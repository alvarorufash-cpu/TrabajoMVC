package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;

public class Botas extends Productos {
    private int numPie;

    public Botas(){
        super();
    }

    public Botas(String nombre, float precio, String descipcion, LocalDate fechaLlegada, int numPie, int id) {
        super(nombre, precio, descipcion, fechaLlegada, id);
        this.numPie = numPie;
    }

    public int getNumPie() {
        return numPie;
    }

    public void setNumPie(int numPie) {
        this.numPie = numPie;
    }
}
