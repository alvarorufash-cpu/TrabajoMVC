package com.alvaroru.tiendainvierno.gui;

import com.alvaroru.tiendainvierno.base.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductosModelo {
    private ArrayList<Productos> listaProductos;

    public ProductosModelo() {  //CONSTRUCTOR
       this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Productos> obtenerLista(){
        return listaProductos;
    }

    public static void crearMenu(JMenuItem importar, JMenuItem exportar){
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Archivo");

        importar = new JMenuItem("importar");   //INICIALIZAR
        exportar = new JMenuItem("exportar");

        importar.setActionCommand("importar");  //Decir que funcion tiene
        importar.setActionCommand("exportar");

        menu.add("importar");
        menu.add("exportar");

        barra.add(menu);

    }

    public void altaGuantes(String nombre, float precio, LocalDate fechaLlegada, boolean EsTactil){
        Guantes guantes = new Guantes(nombre, precio, fechaLlegada, EsTactil);
        listaProductos.add(guantes);
    }

    public void altaCasco(String nombre, float precio, LocalDate fechaLlegada, String homologacion){
        Casco casco = new Casco(nombre, precio, fechaLlegada, homologacion);
        listaProductos.add(casco);
    }

    public void altaCamisetaTermica(String nombre, float precio, LocalDate fechaLlegada, String Talla){
        CamisetaTermica camisetaTermica = new CamisetaTermica(nombre, precio, fechaLlegada, Talla);
        listaProductos.add(camisetaTermica);
    }

    public void altaBotas(String nombre, float precio, LocalDate fechaLlegada, int numPies){
        Botas botas = new Botas(nombre, precio, fechaLlegada, numPies);
        listaProductos.add(botas);
    }

    public void altaAnorak(String nombre, float precio, LocalDate fechaLlegada, String descuento){
        Anorak anorak = new Anorak(nombre, precio, fechaLlegada,  descuento);
        listaProductos.add(anorak);
    }

}
