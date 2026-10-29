package com.alvaroru.tiendainvierno.gui;

import Util.Util;
import com.alvaroru.tiendainvierno.base.Productos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ProductosControlador implements ActionListener, ListSelectionListener, WindowListener {
    private Vista vista;   //Llamar a vista desde la clase, pero no hacer un new que te ejecuta otra ventana
    private ProductosModelo modelo;
    private File ultimaRutaExportada;

    public ProductosControlador(Vista vista, ProductosModelo modelo) {  //Creamos el constructor y creamos nuevos metodos
        this.vista = vista;
        this.modelo = modelo;

        addActionListener(this);        //CREO LOS METODOS, NO SE IMPLEMENTAN
        addListSelectionListener(this);
        addWindowListener(this);
    }

    private void addActionListener(ActionListener actionListener) {
    }

    private void addListSelectionListener(ListSelectionListener listener) {
    }

    private void addWindowListener(WindowListener listener) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
