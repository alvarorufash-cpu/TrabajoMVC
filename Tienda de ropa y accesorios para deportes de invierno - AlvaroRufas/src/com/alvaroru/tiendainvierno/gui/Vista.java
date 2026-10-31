package com.alvaroru.tiendainvierno.gui;

import com.alvaroru.tiendainvierno.base.Productos;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;

public class Vista {
    private JPanel panel1;
    public JComboBox CategoriaProducto;
    public JTextField txtNombreProducto;
    public JTextField txtPrecio;
    public JTextPane txtDescripcion;
    public JButton Anadir;
    public JButton eliminarButton;
    public JButton verCestaButton;
    public JRadioButton tactilesRadioButton;
    public JRadioButton noTactilesRadioButton;
    public JLabel GuantesTermicos;
    public JList VerCesta;
    public DatePicker fechaLlegada;
    public JTextField txtID;
    public JTextField txthomologacionTallaNumPieDescuento;
    public JLabel homologacionTallaNumPieDescuento;

    public JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item;

    public JMenuItem importar;
    public JMenuItem exportar;

    public DefaultListModel<Productos>dlmProductos; //ListaModel
    public DefaultComboBoxModel<String> dcbm;    //El comboBox sera de tipo Texto, porque le pondremos al comboBox texto

    public Vista() {
        frame = new JFrame("Vista");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        inicializar();
        crearMenu();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void crearMenu(){   //En vista crear el menu
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Archivo");

        importar = new JMenuItem("importar");   //INICIALIZAR
        exportar = new JMenuItem("exportar");

        importar.setActionCommand("importar");  //Decir que funcion tiene
        importar.setActionCommand("exportar");

        menu.add("importar");
        menu.add("exportar");

        barra.add(menu);

        frame.setJMenuBar(barra);   //Poner la barra en el frame
    }

    public void inicializar(){
        //INICIALIZAR LA LISTA
        dlmProductos = new DefaultListModel<>();
        VerCesta.setModel(dlmProductos);

        //INICIALIZAR EL COMBOBOX
        dcbm = new DefaultComboBoxModel<>();
        CategoriaProducto.setModel(dcbm);
    }
}
