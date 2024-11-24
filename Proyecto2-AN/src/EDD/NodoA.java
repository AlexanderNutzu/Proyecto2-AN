/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

import ClasesPrincipales.Persona;  

/**  
 * Clase que representa un nodo en una estructura de árbol.  
 * Cada nodo puede tener un padre y una lista de nodos hijos.  
 *   
 * @autor alexa  
 */  
public class NodoA {  
    private Object dato;    // Dato almacenado en el nodo  
    private NodoA padre;    // Referencia al nodo padre  
    private Lista hijos;     // Lista de nodos hijos  

    /**  
     * Constructor que inicializa el nodo con un dato específico.  
     *   
     * @param dato el dato a almacenar en el nodo.  
     */  
    public NodoA(Object dato) {  
        this.dato = dato;  
        this.padre = null;  
        this.hijos = new Lista();  
    }  

    /**  
     * Obtiene el dato almacenado en el nodo.  
     *   
     * @return el dato del nodo.  
     */  
    public Object getDato() {  
        return dato;  
    }  

    /**  
     * Establece el dato del nodo.  
     *   
     * @param dato el nuevo dato a almacenar en el nodo.  
     */  
    public void setDato(Object dato) {  
        this.dato = dato;  
    }  

    /**  
     * Obtiene la referencia al nodo padre.  
     *   
     * @return el nodo padre.  
     */  
    public NodoA getPadre() {  
        return padre;  
    }  

    /**  
     * Establece el nodo padre.  
     *   
     * @param padre el nodo que se establecerá como padre.  
     */  
    public void setPadre(NodoA padre) {  
        this.padre = padre;  
    }  

    /**  
     * Obtiene la lista de nodos hijos.  
     *   
     * @return la lista de nodos hijos.  
     */  
    public Lista getHijos() {  
        return hijos;  
    }  

    /**  
     * Establece la lista de nodos hijos.  
     *   
     * @param hijos la nueva lista de nodos hijos.  
     */  
    public void setHijos(Lista hijos) {  
        this.hijos = hijos;  
    }  

    /**  
     * Agrega un hijo al nodo si no existe ya en la lista de hijos.  
     *   
     * @param hijo el nodo hijo a agregar.  
     */  
    public void aggHijo(NodoA hijo) {  
        if (!this.buscarHijo(hijo)) {  
            this.hijos.insertarFinal(hijo);  
            hijo.setPadre(this); // Establece este nodo como padre del nuevo hijo  
        }  
    }  

    /**  
     * Busca un hijo específico en la lista de hijos.  
     *   
     * @param hijo el nodo hijo a buscar.  
     * @return true si el hijo ya existe, false en caso contrario.  
     */  
    public boolean buscarHijo(NodoA hijo) {  
        if (!this.esHoja()) {  
            Persona personaNueva = (Persona) hijo.getDato();  
            for (int i = 0; i < this.hijos.getSize(); i++) {  
                NodoA hijoActual = (NodoA) this.hijos.getValor(i);  
                Persona personaActual = (Persona) hijoActual.getDato();  
                if (personaActual.getNombreUnico().equalsIgnoreCase(personaNueva.getNombreUnico())) {  
                    return true; // El hijo ya existe  
                }  
            }  
        }  
        return false; // Si es hoja o no se encontró el hijo  
    }  

    /**  
     * Verifica si el nodo es una hoja (sin hijos).  
     *   
     * @return true si el nodo es una hoja, false en caso contrario.  
     */  
    public boolean esHoja() {  
        return this.hijos.isEmpty();  
    }  
}
