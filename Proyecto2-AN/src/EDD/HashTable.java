/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

import ClasesPrincipales.Persona;  
import Funciones.ResultadoBusq;  

/**  
 * Clase que representa una tabla hash para almacenar objetos basados en claves.  
 
 *  
 * @autor alexa  
 */  
public class HashTable {  
    private Lista[] tabla; // Arreglo de listas 
    private int max;       // Tamaño máximo de la tabla hash  

    /**  
     * Constructor para inicializar una nueva tabla hash con el tamaño especificado.  
     *   
     * @param max el número máximo de entradas en la tabla hash.  
     */  
    public HashTable(int max) {  
        this.max = max;  
        this.tabla = new Lista[max];  
        for (int i = 0; i < max; i++) {  
            tabla[i] = new Lista();  
        }  
    }  

    // Métodos de acceso (getters y setters)  

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

    /**  
     * Calcula el índice para una clave dada utilizando su código hash.  
     *  
     * @param key la clave cuyo índice se desea obtener.  
     * @return el índice calculado en la tabla hash.  
     */  
    public int getIndex(Object key) {  
        return Math.abs(key.hashCode()) % max;  
    }  

    /**  
     * Inserta un nuevo valor en la tabla hash asociado a una clave dada.  
     * No insertará si ya existe un elemento con la misma clave.  
     *   
     * @param key la clave bajo la cual se almacenará el valor.  
     * @param value el valor a almacenar en la tabla.  
     */  
    public void insertar(Object key, Object value) {  
        int index = this.getIndex(key);  
        Lista listaIndex = tabla[index];  

        if (this.buscar(key) == null) {  
            listaIndex.insertarFinal(value);  
        }  
    }  

    /**  
     * Busca y devuelve el objeto asociado a la clave proporcionada.  
     *   
     * @param clave la clave del objeto que se desea buscar.  
     * @return el objeto encontrado asociado a la clave, o null si no se encuentra.  
     */  
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

    /**  
     * Busca y devuelve una lista de personas cuyos nombres o apodos contienen la cadena proporcionada.  
     *   
     * @param nombre la cadena de caracteres a buscar en nombres y apodos.  
     * @return una lista de resultados que contienen las personas que coinciden.  
     */  
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
    
    /**  
     * Busca y devuelve una lista de personas cuyos títulos contienen la cadena proporcionada.  
     *   
     * @param titulo la cadena de caracteres a buscar en los títulos.  
     * @return una lista de personas cuyos títulos coinciden.  
     */  
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

    /**  
     * Destruye la tabla hash, eliminando todos los elementos.  
     */  
    public void destruir() {  
        for (int i = 0; i < max; i++) {  
            tabla[i] = new Lista();  
        }  
    }  

    /**  
     * Imprime en la consola el contenido de la tabla hash para facilitar la visualización.  
     */  
    public void mostrarTabla() {  
        StringBuilder tablaStr = new StringBuilder("HashTable:\n");  
        for (int i = 0; i < max; i++) {  
            if (!tabla[i].isEmpty()) {  
                tablaStr.append("Indice ").append(i).append(": ");  
                for (int j = 0; j < tabla[i].getSize(); j++) {  
                    Persona persona = (Persona) tabla[i].getValor(j);  
                    tablaStr.append(persona.getNombreUnico()).append(" -> ");  
                }  
                tablaStr.append("null\n");  
            }  
        }  
        System.out.println(tablaStr);  
    }  
}  
