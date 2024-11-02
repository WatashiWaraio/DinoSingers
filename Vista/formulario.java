/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author qwerty2
 */

public class formulario extends JFrame {
    private JTextField txtNombre, txtDisco, txtVentas;
    private JButton btnAgregar, btnEliminar, btnModificar, btnOrdenar, btnSalir;
    private JTable tablaCantantes;
    public DefaultTableModel modeloTabla;

    public formulario() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Cantantes Famosos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));
        panelEntrada.setBorder(new EmptyBorder(10, 10, 10, 10)); // Espaciado
        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Disco más vendido:"));
        txtDisco = new JTextField(20);
        panelEntrada.add(txtDisco);
        panelEntrada.add(new JLabel("Ventas totales:"));
        txtVentas = new JTextField(20);
        panelEntrada.add(txtVentas);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnModificar = new JButton("Modificar");
        btnOrdenar = new JButton("Ordenar");
        btnSalir = new JButton("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnOrdenar);
        panelBotones.add(btnSalir);

        // Tabla
        String[] columnNames = {"Nombre", "Disco más vendido", "Ventas totales"};
        modeloTabla = new DefaultTableModel(columnNames, 0);
        tablaCantantes = new JTable(modeloTabla);
        tablaCantantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tablaCantantes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Cantantes")); // Borde para la tabla

        // Agregar componentes al frame
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Métodos para acceder a los componentes
    public String getNombreInput() { return txtNombre.getText(); }
    public String getDiscoInput() { return txtDisco.getText(); }
    public String getVentasInput() { return txtVentas.getText(); }
    public void limpiarCampos() {
        txtNombre.setText("");
        txtDisco.setText("");
        txtVentas.setText("");
    }

    // Métodos para manipular la tabla
    public void agregarCantante(String nombre, String disco, String ventas) {
        modeloTabla.addRow(new Object[]{nombre, disco, ventas});
    }

    public void eliminarCantante(int fila) {
        if (fila >= 0) {
            modeloTabla.removeRow(fila);
        }
    }

    public void modificarCantante(int fila, String nombre, String disco, String ventas) {
        if (fila >= 0) {
            modeloTabla.setValueAt(nombre, fila, 0);
            modeloTabla.setValueAt(disco, fila, 1);
            modeloTabla.setValueAt(ventas, fila, 2);
        }
    }

    public int obtenerFilaSeleccionada() {
        return tablaCantantes.getSelectedRow();
    }

    // Métodos para registrar los listeners
    public void setAgregarListener(ActionListener listener) { btnAgregar.addActionListener(listener); }
    public void setEliminarListener(ActionListener listener) { btnEliminar.addActionListener(listener); }
    public void setModificarListener(ActionListener listener) { btnModificar.addActionListener(listener); }
    public void setOrdenarListener(ActionListener listener) { btnOrdenar.addActionListener(listener); }
    public void setSalirListener(ActionListener listener) { btnSalir.addActionListener(listener); }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String pedirNuevoNombre() {
        return JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:");
    }
}
