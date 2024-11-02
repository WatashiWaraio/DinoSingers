/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ListaCantantesFamosos;
import modelo.CantanteFamoso;
import java.util.List;

public class controlador {
    private ListaCantantesFamosos modelo;
    private Vista.formulario vista;

    public controlador(ListaCantantesFamosos modelo, Vista.formulario vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        inicializarDatos();
        inicializarVista();
    }

    private void inicializarDatos() {
        modelo.agregarCantante(new CantanteFamoso("Michael Jackson", "Thriller", 70000000));
        modelo.agregarCantante(new CantanteFamoso("Elvis Presley", "Blue Hawaii", 65000000));
    }

    private void inicializarVista() {
        vista.setAgregarListener(e -> agregarCantante());
        vista.setEliminarListener(e -> eliminarCantante());
        vista.setModificarListener(e -> modificarCantante());
        vista.setOrdenarListener(e -> ordenarPorVentas());
        vista.setSalirListener(e -> System.exit(0));
        actualizarVista();
    }

    private void agregarCantante() {
        try {
            String nombre = vista.getNombreInput();
            String disco = vista.getDiscoInput();
            int ventas = Integer.parseInt(vista.getVentasInput());
            
            if (!nombre.isEmpty() && !disco.isEmpty()) {
                modelo.agregarCantante(new CantanteFamoso(nombre, disco, ventas));
                actualizarVista();
                vista.limpiarCampos();
            } else {
                vista.mostrarError("Por favor, complete todos los campos");
            }
        } catch (NumberFormatException ex) {
            vista.mostrarError("Por favor, ingrese un número válido para las ventas");
        }
    }

    private void eliminarCantante() {
        int filaSeleccionada = vista.obtenerFilaSeleccionada();
        if (filaSeleccionada >= 0) {
            String nombre = (String) vista.modeloTabla.getValueAt(filaSeleccionada, 0);
            modelo.eliminarCantante(nombre); 
            actualizarVista();
            vista.limpiarCampos();
        } else {
            vista.mostrarError("Por favor, seleccione un cantante para eliminar");
        }
    }

    private void modificarCantante() {
        int filaSeleccionada = vista.obtenerFilaSeleccionada();
        if (filaSeleccionada >= 0) {
            String nombreAntiguo = (String) vista.modeloTabla.getValueAt(filaSeleccionada, 0); 
            String nuevoNombre = vista.pedirNuevoNombre();
            String nuevoDisco = vista.getDiscoInput();
            String ventasInput = vista.getVentasInput();

            try {
                int nuevasVentas = Integer.parseInt(ventasInput);
                if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                    modelo.modificarNombreCantante(nombreAntiguo, nuevoNombre);
                    modelo.modificarDiscoCantante(nombreAntiguo, nuevoDisco);
                    modelo.modificarVentasCantante(nombreAntiguo, nuevasVentas);
                    actualizarVista();
                    vista.limpiarCampos();
                } else {
                    vista.mostrarError("Por favor, ingrese un nuevo nombre válido");
                }
            } catch (NumberFormatException ex) {
                vista.mostrarError("Por favor, ingrese un número válido para las ventas");
            }
        } else {
            vista.mostrarError("Por favor, seleccione un cantante para modificar");
        }
    }

    private void ordenarPorVentas() {
        modelo.ordenarPorVentas();
        actualizarVista();
    }

    private void actualizarVista() {
        vista.modeloTabla.setRowCount(0); 
        List<CantanteFamoso> lista = modelo.obtenerLista(); 
        for (CantanteFamoso cantante : lista) {
            vista.modeloTabla.addRow(new Object[]{
                cantante.getNombre(),
                cantante.getDiscoConMasVentas(),
                cantante.getVentasTotales()
            });
        }
    }
}
