package Util;

import javax.swing.*;

public class Util {
    public static void MensajeError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, titulo, mensaje, JOptionPane.ERROR_MESSAGE);
    }
}
