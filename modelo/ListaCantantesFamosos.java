/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaCantantesFamosos {
    private ArrayList<CantanteFamoso> listaCantantesFamosos;

    public ListaCantantesFamosos() {
        listaCantantesFamosos = new ArrayList<>();
    }

    // Método para obtener la lista (agregado)
    public List<CantanteFamoso> obtenerLista() {
        return new ArrayList<>(listaCantantesFamosos);
    }

    public void agregarCantante(CantanteFamoso cantante) {
        listaCantantesFamosos.add(cantante);
    }

    public boolean eliminarCantante(String nombre) {
        boolean eliminado = false;
        for (int i = 0; i < listaCantantesFamosos.size(); i++) {
            if (listaCantantesFamosos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                listaCantantesFamosos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public boolean modificarNombreCantante(String nombreAntiguo, String nombreNuevo) {
        boolean modificado = false;
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            if (cantante.getNombre().equalsIgnoreCase(nombreAntiguo)) {
                cantante.setNombre(nombreNuevo);
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public boolean modificarDiscoCantante(String nombre, String nuevoDisco) {
        boolean modificado = false;
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            if (cantante.getNombre().equalsIgnoreCase(nombre)) {
                cantante.setDiscoConMasVentas(nuevoDisco);
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public boolean modificarVentasCantante(String nombre, int nuevasVentas) {
        boolean modificado = false;
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            if (cantante.getNombre().equalsIgnoreCase(nombre)) {
                cantante.setVentasTotales(nuevasVentas);
                modificado = true;
                break;
            }
        }
        return modificado;
    }

    public void ordenarPorVentas() {
        Collections.sort(listaCantantesFamosos, 
            (c1, c2) -> Integer.compare(c2.getVentasTotales(), c1.getVentasTotales()));
    }
}
