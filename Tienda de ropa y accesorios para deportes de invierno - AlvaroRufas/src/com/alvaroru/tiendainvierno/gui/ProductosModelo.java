package com.alvaroru.tiendainvierno.gui;

import com.alvaroru.tiendainvierno.base.*;

import java.util.ArrayList;

public class ProductosModelo {
    private ArrayList<Productos> listaProductos;

    public ProductosModelo() {  //CONSTRUCTOR
       this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Productos> obtenerLista(){
        return listaProductos;
    }

    public void altaGuantes(String nombre, float precio, boolean EsTermico){
        Guantes guantes = new Guantes(nombre, precio, EsTermico);
        listaProductos.add(guantes);
    }

    public void altaCasco(String nombre, float precio, String homologacion){
        Casco casco = new Casco(nombre, precio, homologacion);
        listaProductos.add(casco);
    }

    public void altaCamisetaTermica(String nombre, float precio, String Talla){
        CamisetaTermica camisetaTermica = new CamisetaTermica(nombre, precio, Talla);
        listaProductos.add(camisetaTermica);
    }

    public void altaBotas(String nombre, float precio, int numPies){
        Botas botas = new Botas(nombre, precio, numPies);
        listaProductos.add(botas);
    }

    public void altaAnorak(String nombre, float precio, String descuento){
        Anorak anorak = new Anorak(nombre, precio, descuento);
        listaProductos.add(anorak);
    }

}
