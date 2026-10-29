package com.alvaroru.tiendainvierno.gui;

import Util.Util;
import com.alvaroru.tiendainvierno.base.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductosModelo {
    private Vista vista;

    public ArrayList<Productos> listaProductos;

    public ProductosModelo() {  //CONSTRUCTOR
       this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Productos> obtenerLista(){
        return listaProductos;
    }


    //ALTA DE PRODUCTOS
    public void altaGuantes(int id, String nombre, float precio, LocalDate fechaLlegada, boolean EsTactil){
        Guantes guantes = new Guantes(id, nombre, precio, fechaLlegada, EsTactil);
        listaProductos.add(guantes);
    }

    public void altaCasco(int id, String nombre, float precio, LocalDate fechaLlegada, String homologacion){
        Casco casco = new Casco(id, nombre, precio, fechaLlegada, homologacion);
        listaProductos.add(casco);
    }

    public void altaCamisetaTermica(int id, String nombre, float precio, LocalDate fechaLlegada, String Talla){
        CamisetaTermica camisetaTermica = new CamisetaTermica(id, nombre, precio, fechaLlegada, Talla);
        listaProductos.add(camisetaTermica);
    }

    public void altaBotas(int id, String nombre, float precio, LocalDate fechaLlegada, int numPies){
        Botas botas = new Botas(nombre, precio, fechaLlegada, numPies, id);
        listaProductos.add(botas);
    }

    public void altaAnorak(int id, String nombre, float precio, LocalDate fechaLlegada, String descuento){
        Anorak anorak = new Anorak(nombre, precio, fechaLlegada,  descuento, id);
        listaProductos.add(anorak);
    }

    public boolean existeID(int productosid){
        boolean existe;
        for (Productos productos: listaProductos) {
            if (productos.equals(productosid)) {
                return true;
            }
        }
        return false;
    }

    //ELIMINAR PRODUCTO POR ID
    public void eliminarGuantes(Productos producto, int id){
        if (existeID(id) == true){
            listaProductos.remove(producto);
        }else {
            Util.MensajeError("Error", "El ID no existe");
        }
    }


    //EXPORTAR XML
    public void ExportarXML() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //NO PONER NEW
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation dom = builder.getDOMImplementation();
        Document documento = dom.createDocument(null, "xml", null);

        Element raiz = documento.createElement("Productos");    //Crear la raiz
        documento.getDocumentElement().appendChild(raiz);   //Aplicarla al documento

        Element nodoProductos = null;
        Element nodoDatos = null;
        Text texto = null;

        //Recorreremos la lista de Productos y si es de una categoria, crearemos un nodo para esa categoria
        for (Productos producto: listaProductos) {  //Por esto hemos creado el ArrayList de productos al principio, recorrera todos los productos
            if (nodoProductos instanceof Guantes){
                nodoProductos = documento.createElement("Guantes");
            } else if (nodoProductos instanceof Casco){
                nodoProductos = documento.createElement("Casco");
            } else if (nodoProductos instanceof CamisetaTermica){
                nodoProductos = documento.createElement("CamisetaTermica");
            } else if (nodoProductos instanceof Botas){
                nodoProductos = documento.createElement("Botas");
            } else if(nodoProductos instanceof Anorak){
                nodoProductos = documento.createElement("Anorak");
            }

            raiz.appendChild(nodoProductos);

            //Una vez creadas las etiquetas para cada categoria de ropa, crearemos un Elemento para cada atributo del Producto

            nodoDatos = documento.createElement("id");
            nodoProductos.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(producto.getId()));
            nodoDatos.appendChild(texto);   //Nodo datos tiene metido a texto

            nodoDatos = documento.createElement("nombre");
            nodoProductos.appendChild(nodoDatos);
            texto = documento.createTextNode(producto.getNombre());
            nodoDatos.appendChild(texto);

            nodoDatos = documento.createElement("precio");
            nodoProductos.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
            nodoDatos.appendChild(texto);

            nodoDatos = documento.createElement("fecha_llegada");
            nodoProductos.appendChild(nodoDatos);
            texto = documento.createTextNode(producto.getFechaLlegada().toString());
            nodoDatos.appendChild(texto);

            if (producto instanceof Guantes){
                nodoDatos = documento.createElement("Es Tactil");
                nodoProductos.appendChild(nodoDatos);

            } else if (producto instanceof Casco){
                nodoDatos =  documento.createElement("Homologacion");

            } else if (producto instanceof CamisetaTermica){
                nodoDatos = documento.createElement("Talla");

            } else if (producto instanceof Botas){
                nodoDatos = documento.createElement("Num Pie");

            } else if (producto instanceof Anorak){
                nodoDatos = documento.createElement("Descuento");

            }

        }
    }

    //IMPORTAR XML
    public void ImportarXML(){

    }
}
