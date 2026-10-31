package com.alvaroru.tiendainvierno.gui;

import Util.Util;
import com.alvaroru.tiendainvierno.base.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

public class ProductosControlador implements ActionListener, ListSelectionListener, WindowListener {
    private Vista vista;   //Llamar a vista desde la clase, pero no hacer un new que te ejecuta otra ventana
    private ProductosModelo modelo;
    private File ultimaRutaExportada;

    public ProductosControlador(Vista vista, ProductosModelo modelo) {  //Creamos el constructor y CREAMOS NUEVOS METODOS
        this.vista = vista;
        this.modelo = modelo;

        addActionListener(this);        //CREO LOS METODOS, NO SE IMPLEMENTAN
        addListSelectionListener(this);
        addWindowListener(this);
        categoriaComboBox();
    }

    private void addActionListener(ActionListener actionListener) {     //Cuando se pulse un boton
        vista.Anadir.addActionListener(actionListener);    //Pilla el actionListener (que es lo que recibe el metodo)
        vista.eliminarButton.addActionListener(actionListener);
        vista.verCestaButton.addActionListener(actionListener);
        vista.CategoriaProducto.addActionListener(actionListener);  //También ponemos el ComboBox, porque aunque muestre una lista, se detecta como boton
        vista.importar.addActionListener(actionListener);
        vista.exportar.addActionListener(actionListener);
    }

    private void addListSelectionListener(ListSelectionListener listener) {     //Para mostrar listas o tablas
        vista.VerCesta.addListSelectionListener(listener);  //PONER AQUI LAS LISTAS como JLIST o JTABLE
    }

    private void addWindowListener(WindowListener listener) {  // Detecta cambios en el estado de la ventana
        vista.frame.addWindowListener(listener);    //Si ocurre algo en la ventana, este lo recibira
    }

    private void categoriaComboBox(){
        vista.dcbm.addElement("Guantes");
        vista.dcbm.addElement("Casco");
        vista.dcbm.addElement("CamisetaTermica");
        vista.dcbm.addElement("Botas");
        vista.dcbm.addElement("Anorak");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion){
            case "Añadir":
                if (vista.dcbm.equals("Guantes")){
                    modelo.altaGuantes(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                            vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.tactilesRadioButton.isSelected());
                }

                if (vista.dcbm.equals("Casco")){
                    modelo.altaCasco(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                            vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.homologacionTallaNumPieDescuento.getText());
                }

                if (vista.dcbm.equals("CamisetaTermica")){
                    modelo.altaCamisetaTermica(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                            vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.homologacionTallaNumPieDescuento.getText());
                }

                if (vista.dcbm.equals("Botas")){
                    modelo.altaBotas(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                            vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), Integer.parseInt(vista.homologacionTallaNumPieDescuento.getText()));
                }

                if (vista.dcbm.equals("Anorak")){
                    modelo.altaAnorak(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                            vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.homologacionTallaNumPieDescuento.getText());
                }

                break;

            case "Eliminar":

                break;

            case "Ver Cesta":

                break;
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {  //Cuando la ventana se vaya a cerrar
        int opcion = Util.MensajeConfirmacion("¿Desea cerrar la ventana?", "Confirmacion para cerrar");

        if (opcion == JOptionPane.OK_OPTION){   //Si la opcion es el okey
            System.exit(0);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

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
