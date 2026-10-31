package Util;

import javax.swing.*;

public class Util {
    public static void MensajeError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, titulo, mensaje, JOptionPane.ERROR_MESSAGE);
    }

    public static int MensajeConfirmacion(String mensaje, String titulo){  //Tiene que devolver int
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }
}
