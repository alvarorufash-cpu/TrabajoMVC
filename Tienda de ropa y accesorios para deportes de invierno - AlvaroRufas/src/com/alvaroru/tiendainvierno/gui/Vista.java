package com.alvaroru.tiendainvierno.gui;

import com.alvaroru.tiendainvierno.base.Productos;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;

public class Vista {
    private JPanel panel1;
    public JComboBox CategoriaProducto;
    public JTextField NombreProducto;
    public JTextField textField1;
    public JTextPane textPane1;
    public JButton Añadir;
    public JButton eliminarButton;
    public JButton verCestaButton;
    public JRadioButton tactilesRadioButton;
    public JRadioButton noTactilesRadioButton;
    public JLabel GuantesTermicos;
    public JList VerCesta;
    public DatePicker fechaLlegada;

    public JFrame frame;
    public DefaultListModel<Productos>dlmProductos;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item;

    JMenuItem importar;
    JMenuItem exportar;

    public Vista() {
        frame = new JFrame("Vista");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        ProductosModelo.crearMenu(importar, exportar);
        frame.setVisible(true);
    }

    public void inicializar(JMenuItem importar, JMenuItem exportar){
        frame = new JFrame();
        VerCesta.setModel(dlmProductos);    //Indicamos donde se va a pintar la lista en la parte grafica
    }



}
