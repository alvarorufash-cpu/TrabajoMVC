package com.alvaroru.tiendainvierno.base;

public class Guantes extends Productos {
    private boolean EsTermico;

    public Guantes(String nombre, float precio, boolean esTermico) {
        super(nombre, precio);
        EsTermico = esTermico;
    }

    public boolean isEsTermico() {
        return EsTermico;
    }

    public void setEsTermico(boolean esTermico) {
        EsTermico = esTermico;
    }
}
