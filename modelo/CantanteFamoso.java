/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author qwerty2
 */
public class CantanteFamoso {
    private String nombre;
    private String discoConMasVentas;
    private int ventasTotales; 

    public CantanteFamoso(String nombre, String discoConMasVentas, int ventasTotales) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
        this.ventasTotales = ventasTotales;
    }

   
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDiscoConMasVentas() { return discoConMasVentas; }
    public void setDiscoConMasVentas(String disco) { this.discoConMasVentas = disco; }
    public int getVentasTotales() { return ventasTotales; }
    public void setVentasTotales(int ventas) { this.ventasTotales = ventas; }
}