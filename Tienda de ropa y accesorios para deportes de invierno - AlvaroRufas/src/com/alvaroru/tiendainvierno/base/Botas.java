package com.alvaroru.tiendainvierno.base;

public class Botas extends Productos {
    private int numPie;

    public Botas(String nombre, float precio, int numPie) {
        super(nombre, precio);
        this.numPie = numPie;
    }

    public int getNumPie() {
        return numPie;
    }

    public void setNumPie(int numPie) {
        this.numPie = numPie;
    }
}
