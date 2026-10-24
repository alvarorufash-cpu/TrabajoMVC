package com.alvaroru.tiendainvierno;

import com.alvaroru.tiendainvierno.gui.ProductosControlador;
import com.alvaroru.tiendainvierno.gui.ProductosModelo;
import com.alvaroru.tiendainvierno.gui.Vista;

public class Principal {
    public static void main(String[] args) {
        Vista vista = new Vista();
        ProductosModelo modelo = new ProductosModelo();
        ProductosControlador controlador = new ProductosControlador(vista, modelo);
    }
}
