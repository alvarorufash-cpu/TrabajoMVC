package com.alvaroru.tiendainvierno.gui;

import Util.Util;
import com.alvaroru.tiendainvierno.base.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ProductosControlador implements ActionListener, ListSelectionListener, WindowListener {
    private Vista vista;   //Llamar a vista desde la clase, pero no hacer un new que te ejecuta otra ventana
    private ProductosModelo modelo;
    private File ultimaRutaExportada;

    public ProductosControlador(Vista vista, ProductosModelo modelo) {  //Creamos el constructor y CREAMOS NUEVOS METODOS
        this.vista = vista;
        this.modelo = modelo;

        try {
            cargarDatosConfiguracion();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addActionListener(this);        //CREO LOS METODOS, NO SE IMPLEMENTAN
        addListSelectionListener(this);
        addWindowListener(this);
        categoriaComboBox();
    }

    //AHORA VAMOS CON LOS TRES DATOS CONFIGURACION

    private void actualizarDatosConfiguracion(){
        this.ultimaRutaExportada = ultimaRutaExportada;
    }

    private void guardarDatosConfiguracion() throws IOException {
        Properties configuracion = new Properties();
        configuracion.setProperty("ultimaRutaExportada", ultimaRutaExportada.getAbsolutePath());
        configuracion.store(new PrintWriter("Productos.conf"), "Datos configuracion de Productos");
    }

    private void cargarDatosConfiguracion() throws IOException {
        Properties configuracion = new Properties();
        configuracion.load(new FileReader("Productos.conf"));
        ultimaRutaExportada = new File(configuracion.getProperty("ultimaRutaExportada"));
    }

    private void addActionListener(ActionListener actionListener) {     //Cuando se pulse un boton
        vista.Anadir.addActionListener(actionListener);    //Pilla el actionListener (que es lo que recibe el metodo)
        vista.eliminarButton.addActionListener(actionListener);
        vista.CategoriaProducto.addActionListener(actionListener);  //También ponemos el ComboBox, porque aunque muestre una lista, se detecta como boton
        vista.Importar.addActionListener(actionListener);
        vista.Exportar.addActionListener(actionListener);
    }

    private void addListSelectionListener(ListSelectionListener listener) {     //Para mostrar listas o tablas
        vista.VerCesta.addListSelectionListener(listener);  //PONER AQUI LAS LISTAS como JLIST o JTABLE
    }

    private void addWindowListener(WindowListener listener) {  // Detecta cambios en el estado de la ventana
        vista.frame.addWindowListener(listener);    //Si ocurre algo en la ventana, este lo recibira
    }

    private boolean SinCampos(){
        if (vista.txtID.getText().isEmpty() || vista.txtNombreProducto.getText().isEmpty() ||
            vista.txtPrecio.getText().isEmpty() || vista.txtDescripcion.getText().isEmpty() || vista.fechaLlegada.getDate().equals("")){
            return true;
        }
        return false;
    }

    private void limpiarCampos(){
        vista.txtID.setText(null);
        vista.txtNombreProducto.setText(null);
        vista.txtPrecio.setText(null);
        vista.txthomologacionTallaNumPieDescuento.setText(null);
        vista.txtDescripcion.setText(null);
        vista.fechaLlegada.setDate(null);
    }

    private void refresccar(){
        vista.dlmProductos.clear();
        for (Productos producto: modelo.obtenerLista()) {
            vista.dlmProductos.addElement(producto);
        }
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
                if (vista.dcbm.getSelectedItem().equals("Guantes")){
                    if (SinCampos() && (!vista.tactilesRadioButton.isSelected() || !vista.noTactilesRadioButton.isSelected())){
                        Util.MensajeError("ERROR", "Hay campos sin seleccionar");
                    }else {
                        modelo.altaGuantes(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                                vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.tactilesRadioButton.isSelected());
                    }
                }

                if (vista.dcbm.getSelectedItem().equals("Casco")){
                    if (SinCampos() && (vista.txthomologacionTallaNumPieDescuento.getText().isEmpty())){
                        Util.MensajeError("ERROR", "Hay campos sin seleccionar");
                    } else {
                        modelo.altaCasco(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                                vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.txthomologacionTallaNumPieDescuento.getText());
                    }

                }

                if (vista.dcbm.getSelectedItem().equals("CamisetaTermica")){
                    if (SinCampos() && (vista.txthomologacionTallaNumPieDescuento.getText().isEmpty())){
                        Util.MensajeError("ERROR", "Hay campos sin seleccionar");
                    } else {
                        modelo.altaCamisetaTermica(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                                vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.txthomologacionTallaNumPieDescuento.getText());

                    }
                }

                if (vista.dcbm.getSelectedItem().equals("Botas")){
                    if (SinCampos() && (vista.txthomologacionTallaNumPieDescuento.getText().isEmpty())){
                        Util.MensajeError("ERROR", "Hay campos sin seleccionar");
                    } else {
                        modelo.altaBotas(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                                vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), Integer.parseInt(vista.txthomologacionTallaNumPieDescuento.getText()));

                    }
                }

                if (vista.dcbm.getSelectedItem().equals("Anorak")){
                    if (SinCampos() && (vista.txthomologacionTallaNumPieDescuento.getText().isEmpty())){
                        Util.MensajeError("ERROR", "Hay campos sin seleccionar");
                    } else {
                        modelo.altaAnorak(Integer.parseInt(vista.txtID.getText()), vista.txtNombreProducto.getText(), Float.parseFloat(vista.txtPrecio.getText()),
                                vista.txtDescripcion.getText(),vista.fechaLlegada.getDate(), vista.txthomologacionTallaNumPieDescuento.getText());

                    }
                }
                refresccar();
                limpiarCampos();
                break;

                case "Eliminar":
                Productos productoSeleccionado = (Productos) vista.VerCesta.getSelectedValue(); //Creamos una variable que guardara de la lista el seleccionado
                modelo.eliminarProducto(productoSeleccionado, productoSeleccionado.getId());
                refresccar();
                break;

            case "Importar":
                JFileChooser selectorFichero = Util.SelectorFichero(ultimaRutaExportada, "Archivo XML", "xml");

                int opt = selectorFichero.showOpenDialog(null);
                if (opt == JFileChooser.APPROVE_OPTION){
                    try {
                        modelo.importarXML(selectorFichero.getSelectedFile()); //Importara del selector el fichero seleccionado
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (SAXException ex) {
                        ex.printStackTrace();
                    }
                    refresccar();
                }

                break;

            case "Exportar":
                JFileChooser selectorFichero2 = Util.SelectorFichero(ultimaRutaExportada, "Archivo XML", "xml");
                int opt2 = selectorFichero2.showOpenDialog(null);
                if (opt2 == JFileChooser.APPROVE_OPTION){
                    try {
                        modelo.exportarXML(selectorFichero2.getSelectedFile());
                        actualizarDatosConfiguracion();
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (TransformerException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
        }

        if (vista.CategoriaProducto.getSelectedItem().equals("Guantes")){
            vista.GuantesTactiles.setEnabled(true);
            vista.tactilesRadioButton.setEnabled(true);
            vista.noTactilesRadioButton.setEnabled(true);

            vista.homologacionTallaNumPieDescuento.setEnabled(false);
            vista.txthomologacionTallaNumPieDescuento.setEnabled(false);

        }
        else if (vista.CategoriaProducto.getSelectedItem().equals("Casco")){
            vista.GuantesTactiles.setEnabled(false);
            vista.tactilesRadioButton.setEnabled(false);
            vista.noTactilesRadioButton.setEnabled(false);

            vista.homologacionTallaNumPieDescuento.setEnabled(true);
            vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
            vista.homologacionTallaNumPieDescuento.setText("Homologacion");
        }
        else if (vista.CategoriaProducto.getSelectedItem().equals("CamisetaTermica")){
            vista.GuantesTactiles.setEnabled(false);
            vista.tactilesRadioButton.setEnabled(false);
            vista.noTactilesRadioButton.setEnabled(false);

            vista.homologacionTallaNumPieDescuento.setEnabled(true);
            vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
            vista.homologacionTallaNumPieDescuento.setText("Talla");
        }
        else if (vista.CategoriaProducto.getSelectedItem().equals("Botas")){
            vista.GuantesTactiles.setEnabled(false);
            vista.tactilesRadioButton.setEnabled(false);
            vista.noTactilesRadioButton.setEnabled(false);

            vista.homologacionTallaNumPieDescuento.setEnabled(true);
            vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
            vista.homologacionTallaNumPieDescuento.setText("Numero de Pie");
        }
        else if (vista.CategoriaProducto.getSelectedItem().equals("Anorak")){
            vista.GuantesTactiles.setEnabled(false);
            vista.tactilesRadioButton.setEnabled(false);
            vista.noTactilesRadioButton.setEnabled(false);

            vista.homologacionTallaNumPieDescuento.setEnabled(true);
            vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
            vista.homologacionTallaNumPieDescuento.setText("Descuento");
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {  //Cuando la ventana se vaya a cerrar
        int opcion = Util.MensajeConfirmacion("¿Desea cerrar la ventana?", "Confirmacion para cerrar");

        if (opcion == JOptionPane.OK_OPTION){   //Si la opcion es el okey
            try {
                guardarDatosConfiguracion();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()){
            Productos productoSeleccionado = (Productos) vista.VerCesta.getSelectedValue();
            vista.txtID.setText(String.valueOf(productoSeleccionado.getId()));
            vista.txtNombreProducto.setText(productoSeleccionado.getNombre());
            vista.txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
            vista.txtDescripcion.setText(productoSeleccionado.getDescripcion());
            vista.fechaLlegada.setDate(productoSeleccionado.getFechaLlegada());
            if (productoSeleccionado instanceof Guantes && ((Guantes) productoSeleccionado).getEsTactil() == true){
                vista.GuantesTactiles.setEnabled(true);
                vista.tactilesRadioButton.setEnabled(true);
                vista.noTactilesRadioButton.setEnabled(true);
                vista.tactilesRadioButton.doClick();
            } else {
                vista.GuantesTactiles.setEnabled(true);
                vista.tactilesRadioButton.setEnabled(true);
                vista.noTactilesRadioButton.setEnabled(true);
                vista.noTactilesRadioButton.doClick();
            }
            if (productoSeleccionado instanceof Casco){
                vista.GuantesTactiles.setEnabled(false);
                vista.tactilesRadioButton.setEnabled(false);
                vista.homologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setText(((Casco) productoSeleccionado).getHomologacion());
            }
            if (productoSeleccionado instanceof CamisetaTermica){
                vista.GuantesTactiles.setEnabled(false);
                vista.tactilesRadioButton.setEnabled(false);
                vista.homologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setText(((CamisetaTermica) productoSeleccionado).getTalla());
            }
            if (productoSeleccionado instanceof Botas){
                vista.GuantesTactiles.setEnabled(false);
                vista.tactilesRadioButton.setEnabled(false);
                vista.homologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setEnabled(true);
                vista.txthomologacionTallaNumPieDescuento.setText(String.valueOf(((Botas) productoSeleccionado).getNumPie()));
            }
            if (productoSeleccionado instanceof Anorak){
                vista.homologacionTallaNumPieDescuento.setEnabled(false);
                vista.txthomologacionTallaNumPieDescuento.setEnabled(false);
                vista.txthomologacionTallaNumPieDescuento.setText(((Anorak) productoSeleccionado).getDescuento());
            }
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
}
