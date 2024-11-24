/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

/**  
 * Clase que representa un nodo en una lista enlazada.  
 * Cada nodo contiene un dato y una referencia al siguiente nodo en la lista.  
 *   
 * @autor alexa  
 */  
public class Nodo {  
    private Object dato; // Dato almacenado en el nodo  
    private Nodo pnext;  // Referencia al siguiente nodo  
    
    /**  
     * Constructor vacío que inicializa un nodo con datos nulos.  
     */  
    public Nodo() {  
        this.dato = null;  
        this.pnext = null;  
    }  
    
    /**  
     * Constructor que inicializa un nodo con un dato específico.  
     *   
     * @param dato el dato a almacenar en el nodo.  
     */  
    public Nodo(Object dato) {  
        this.dato = dato;  
        this.pnext = null;  
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
     * Obtiene la referencia al siguiente nodo.  
     *   
     * @return el siguiente nodo.  
     */  
    public Nodo getPnext() {  
        return pnext;  
    }  

    /**  
     * Establece el siguiente nodo en la lista.  
     *   
     * @param pnext el nodo que se establecerá como siguiente.  
     */  
    public void setPnext(Nodo pnext) {  
        this.pnext = pnext;  
    }  
}  
