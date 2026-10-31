package com.alvaroru.tiendainvierno.gui;

import Util.Util;
import com.alvaroru.tiendainvierno.base.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductosModelo {

    public ArrayList<Productos> listaProductos;

    public ProductosModelo() {  //CONSTRUCTOR
       this.listaProductos = new ArrayList<>();
    }

    public ArrayList<Productos> obtenerLista(){
        return listaProductos;
    }


    //ALTA DE PRODUCTOS
    public void altaGuantes(int id, String nombre, float precio, String descipcion, LocalDate fechaLlegada, boolean EsTactil){
        if (existeID(id)){
            Util.MensajeError("Error", "Ese ID ya existe");
        } else {
            Guantes guantes = new Guantes(nombre, precio, descipcion, fechaLlegada, id, EsTactil);
            listaProductos.add(guantes);
        }
    }

    public void altaCasco(int id, String nombre, float precio, String descripcion, LocalDate fechaLlegada, String homologacion){
        if (existeID(id)){
            Util.MensajeError("Error", "Ese ID ya existe");
        } else {
            Casco casco = new Casco(id, nombre, precio, descripcion, fechaLlegada, homologacion);
            listaProductos.add(casco);
        }
    }

    public void altaCamisetaTermica(int id, String nombre, float precio, String descripcion, LocalDate fechaLlegada, String Talla){
        if (existeID(id)){
            Util.MensajeError("Error", "Ese ID ya existe");
        } else {
            CamisetaTermica camisetaTermica = new CamisetaTermica(id, nombre, precio, descripcion, fechaLlegada, Talla);
            listaProductos.add(camisetaTermica);
        }
    }

    public void altaBotas(int id, String nombre, float precio, String descripcion, LocalDate fechaLlegada, int numPies){
        if (existeID(id)){
            Util.MensajeError("Error", "Ese ID ya existe");
        } else {
            Botas botas = new Botas(nombre, precio, descripcion, fechaLlegada, numPies, id);
            listaProductos.add(botas);
        }
    }

    public void altaAnorak(int id, String nombre, float precio, String descripcion, LocalDate fechaLlegada, String descuento){
        if (existeID(id)){
            Util.MensajeError("Error", "Ese ID ya existe");
        } else {
            Anorak anorak = new Anorak(nombre, precio, descripcion, fechaLlegada,  descuento, id);
            listaProductos.add(anorak);
        }
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
    public void ExportarXML(File fichero) throws ParserConfigurationException, TransformerException {     //Recibe el fichero
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
            if (producto instanceof Guantes){
                nodoProductos = documento.createElement("Guantes");
            } else if (producto instanceof Casco){
                nodoProductos = documento.createElement("Casco");
            } else if (producto instanceof CamisetaTermica){
                nodoProductos = documento.createElement("CamisetaTermica");
            } else if (producto instanceof Botas){
                nodoProductos = documento.createElement("Botas");
            } else if(producto instanceof Anorak){
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
                texto = documento.createTextNode(String.valueOf(((Guantes) producto).getEsTactil()));
                nodoDatos.appendChild(texto);

            } else if (producto instanceof Casco){
                nodoDatos =  documento.createElement("Homologacion");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(((Casco) producto).getHomologacion());
                nodoDatos.appendChild(texto);

            } else if (producto instanceof CamisetaTermica){
                nodoDatos = documento.createElement("Talla");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(((CamisetaTermica) producto).getTalla());
                nodoDatos.appendChild(texto);

            } else if (producto instanceof Botas){
                nodoDatos = documento.createElement("Num Pie");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(((Botas) producto).getNumPie()));
                nodoDatos.appendChild(texto);

            } else if (producto instanceof Anorak){
                nodoDatos = documento.createElement("Descuento");
                nodoProductos.appendChild(nodoDatos);
                texto = documento.createTextNode(((Anorak) producto).getDescuento());
                nodoDatos.appendChild(texto);
            }
        }

        Source source = new DOMSource(documento);   //Define el origen y que va a coger el documento de xml
        Result resultado = new StreamResult(fichero);   //Define el destino

        Transformer transformer = TransformerFactory.newInstance().newTransformer();    //Crea el objeto y la instancia de Transformer
        transformer.transform(source, resultado);   //Toma los datos definidos y los escribe en resultado
    }

    //IMPORTAR XML
    public void importarXML(File fichero) throws ParserConfigurationException, IOException, SAXException {
        listaProductos = new ArrayList<Productos>();    //Creamos una nueva lista de productos y con este los herederos
        Guantes guantes = null;
        Casco casco = null;
        CamisetaTermica camisetaTermica = null;
        Botas botas = null;
        Anorak anorak = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse(fichero);    //El documento sera la construcción (builder) del fichero seleccionado
        NodeList listaElementos = documento.getElementsByTagName("*");  //Hace una lista de elementos del fichero que acabamos de coger y lo ordena por todo (*)

        for (int i=0; i<listaElementos.getLength(); i++){
            Element nodoProducto = (Element) listaElementos.item(i);    //Extrae el elemento que esta en la posicion i

            if (nodoProducto.getTagName().equals("Guantes")){
                Guantes nuevoGuante = new Guantes();
                nuevoGuante.setId(Integer.parseInt(nodoProducto.getChildNodes().item(0).getTextContent()));
                nuevoGuante.setNombre(nodoProducto.getChildNodes().item(1).getTextContent());
                nuevoGuante.setPrecio(Float.parseFloat(nodoProducto.getChildNodes().item(2).getTextContent()));
                nuevoGuante.setFechaLlegada(LocalDate.parse(nodoProducto.getChildNodes().item(3).getTextContent()));
                nuevoGuante.setEsTactil(Boolean.parseBoolean(nodoProducto.getChildNodes().item(4).getTextContent()));
                listaProductos.add(nuevoGuante);
            }
            if (nodoProducto.getTagName().equals("Casco")){
                Casco nuevoCasco = new Casco();
                nuevoCasco.setId(Integer.parseInt(nodoProducto.getChildNodes().item(0).getTextContent()));
                nuevoCasco.setNombre(nodoProducto.getChildNodes().item(1).getTextContent());
                nuevoCasco.setPrecio(Float.parseFloat(nodoProducto.getChildNodes().item(2).getTextContent()));
                nuevoCasco.setFechaLlegada(LocalDate.parse(nodoProducto.getChildNodes().item(3).getTextContent()));
                nuevoCasco.setHomologacion(nodoProducto.getChildNodes().item(4).getTextContent());
                listaProductos.add(nuevoCasco);
            }
            if (nodoProducto.getTagName().equals("CamisetaTermica")){
                CamisetaTermica nuevaCamisetaTermica = new CamisetaTermica();
                nuevaCamisetaTermica.setId(Integer.parseInt(nodoProducto.getChildNodes().item(0).getTextContent()));
                nuevaCamisetaTermica.setNombre(nodoProducto.getChildNodes().item(1).getTextContent());
                nuevaCamisetaTermica.setPrecio(Float.parseFloat(nodoProducto.getChildNodes().item(2).getTextContent()));
                nuevaCamisetaTermica.setFechaLlegada(LocalDate.parse(nodoProducto.getChildNodes().item(3).getTextContent()));
                nuevaCamisetaTermica.setTalla(nodoProducto.getChildNodes().item(4).getTextContent());
                listaProductos.add(nuevaCamisetaTermica);
            }
            if (nodoProducto.getTagName().equals("Botas")){
                Botas nuevasBotas = new Botas();
                nuevasBotas.setId(Integer.parseInt(nodoProducto.getChildNodes().item(0).getTextContent()));
                nuevasBotas.setNombre(nodoProducto.getChildNodes().item(1).getTextContent());
                nuevasBotas.setPrecio(Float.parseFloat(nodoProducto.getChildNodes().item(2).getTextContent()));
                nuevasBotas.setFechaLlegada(LocalDate.parse(nodoProducto.getChildNodes().item(3).getTextContent()));
                nuevasBotas.setNumPie(Integer.parseInt(nodoProducto.getChildNodes().item(4).getTextContent()));
                listaProductos.add(nuevasBotas);
            }
            if (nodoProducto.getTagName().equals("Anorak")){
                Anorak nuevoAnorak = new Anorak();
                nuevoAnorak.setId(Integer.parseInt(nodoProducto.getChildNodes().item(0).getTextContent()));
                nuevoAnorak.setNombre(nodoProducto.getChildNodes().item(1).getTextContent());
                nuevoAnorak.setPrecio(Float.parseFloat(nodoProducto.getChildNodes().item(2).getTextContent()));
                nuevoAnorak.setFechaLlegada(LocalDate.parse(nodoProducto.getChildNodes().item(3).getTextContent()));
                nuevoAnorak.setDescuento(nodoProducto.getChildNodes().item(4).getTextContent());
                listaProductos.add(nuevoAnorak);
            }

        }

    }

}
