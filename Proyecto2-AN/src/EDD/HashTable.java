/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;
import Funciones.ResultadoBusq;

/**
 *
 * @author alexa
 */
public class HashTable {
    private Lista[] tabla;
    private int max;

    public HashTable(int max) {
        this.max = max;
        this.tabla = new Lista[max];
        for (int i = 0; i < max; i++) {
            tabla[i] = new Lista();
        }
    }

    public Lista[] getTabla() {
        return tabla;
    }

    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIndex(Object key) {
        return Math.abs(key.hashCode()) % max;
    }

    public void insertar(Object key, Object value) {
        int index = this.getIndex(key);
        Lista listaIndex = tabla[index];

        if (this.buscar(key) == null) {
            listaIndex.insertarFinal(value);
        }
    }

    public Object buscar(Object clave) {
        int index = this.getIndex(clave);
        Lista listaIndex = tabla[index];
        if (!listaIndex.isEmpty()) {
            for (int i = 0; i < listaIndex.getSize(); i++) {
                Persona personaActual = (Persona) listaIndex.getValor(i);
                String claveStr = (String) clave;
                if (personaActual.getNombreUnico().equalsIgnoreCase(claveStr)) {
                    return personaActual;
                }
            }
        }
        return null;
    }

     public Lista buscarNombreUnico(String nombre) {
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getMote() != null) {
                        if (personaActual.getMote().toLowerCase().contains(nombre.toLowerCase())) {
                            ResultadoBusq resultadoPersona = new ResultadoBusq(personaActual, i);
                            resultado.insertarFinal(resultadoPersona);
                        } else if (personaActual.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                            ResultadoBusq resultadoPersona = new ResultadoBusq(personaActual, i);
                            resultado.insertarFinal(resultadoPersona);
                        }
                    } else {
                        ResultadoBusq resultadoPersona = new ResultadoBusq(personaActual, i);
                        if (personaActual.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.insertarFinal(resultadoPersona);
                        }
                    }
                }
            }
        }

        return resultado;
    }
    

    public Lista buscarTitulo(String titulo) {
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getTitulo() != null) {
                        if (personaActual.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                            resultado.insertarFinal(personaActual);
                        }
                    }
                }
            }
        }

        return resultado;
    }

    public void destruir() {
        for (int i = 0; i < max; i++) {
            tabla[i] = new Lista();
        }
    }

    public void mostrarTabla() {
        String tablaStr = "HashTable:\n";
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                tablaStr += "Indice " + i + ": ";
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona persona = (Persona) tabla[i].getValor(j);
                    tablaStr += persona.getNombreUnico()+ "-> ";
                }

                tablaStr += """
                            null
                            """;
            }
        }

        System.out.println(tablaStr);
    }
}
