package Util;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Util {
    public static void MensajeError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static int MensajeConfirmacion(String mensaje, String titulo){  //Tiene que devolver int
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }

    public static JFileChooser SelectorFichero(File ruta, String tipoArchivo, String extension){
        JFileChooser selector = new JFileChooser();

        if (ruta != null){
            selector.setCurrentDirectory(ruta);
        }

        if (extension!=null){
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(tipoArchivo, extension);
            selector.setFileFilter(filtro); //El archivo sera un XML
        }

        return selector;
    }
}
