/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.controlador;
import javax.swing.SwingUtilities;
import modelo.ListaCantantesFamosos;

/**
 *
 * @author qwerty2
 */
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaCantantesFamosos modelo = new ListaCantantesFamosos();
            Vista.formulario vista = new  Vista.formulario();
            controlador controlador = new controlador(modelo, vista);
            vista.setVisible(true);
        });
    }
}