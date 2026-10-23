package com.alvaroru.tiendainvierno.base;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cesta {
    private LocalDate fechaLlegada;

    public Cesta(ArrayList<Productos> listaProductos, LocalDate fechaLlegada) {
    this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
