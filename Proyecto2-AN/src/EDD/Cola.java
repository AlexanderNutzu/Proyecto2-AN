/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

/**  
 * Clase que representa una cola (estructura de datos tipo FIFO).  
 * Permite el manejo de elementos en un orden de primero en entrar, primero en salir.  
 *  
 * @autor alexa  
 */  
public class Cola {  
    private Nodo cabeza; // Primer nodo de la cola  
    private Nodo cola;   // Último nodo de la cola  
    private int size;    // Tamaño actual de la cola  

    /**  
     * Constructor de la clase Cola.  
     * Inicializa una cola vacía.  
     */  
    public Cola() {  
        this.cabeza = null;  
        this.cola = null;  
        this.size = 0;  
    }  

    // Métodos de acceso (getters y setters)  

    public Nodo getCabeza() {  
        return cabeza;  
    }  

    public void setCabeza(Nodo cabeza) {  
        this.cabeza = cabeza;  
    }  

    public Nodo getCola() {  
        return cola;  
    }  

    public void setCola(Nodo cola) {  
        this.cola = cola;  
    }  

    public int getSize() {  
        return size;  
    }  

    public void setSize(int size) {  
        this.size = size;  
    }  

    /**  
     * Verifica si la cola está vacía.  
     *   
     * @return true si la cola no tiene elementos, false en caso contrario.  
     */  
    public boolean colaVacia() {  
        return this.cabeza == null;  
    }  

    /**  
     * Añade un nuevo elemento al final de la cola.  
     *   
     * @param dato el dato a añadir a la cola.  
     */  
    public void enColar(Object dato) {  
        Nodo pNew = new Nodo(dato);  
        if (this.colaVacia()) {  
            this.setCabeza(pNew);  
            this.setCola(pNew);  
        } else {  
            this.cola.setPnext(pNew);  
            this.setCola(pNew);  
        }  
        size++;  
    }  

    /**  
     * Elimina y devuelve el primer elemento de la cola.  
     *   
     * @return el dato del primer elemento de la cola o null si la cola está vacía.  
     * @throws IllegalStateException si se intenta desEncolar de una cola vacía.  
     */  
    public Object desEnColar() {  
        if (this.colaVacia()) {  
            throw new IllegalStateException("No se puede desEncolar de una cola vacía");  
        }  
        
        Object quitar = this.cabeza.getDato();  
        this.setCabeza(this.cabeza.getPnext());  
        size--;  

        // Si la cola queda vacía, también se debe actualizar el nodo de cola.  
        if (this.cabeza == null) {  
            this.setCola(null);  
        }  

        return quitar;  
    }  

    /**  
     * Destruye la cola, eliminando todos los elementos y liberando recursos.  
     */  
    public void destruir() {  
        cabeza = null;  
        cola = null;  
        size = 0;  
    }  

    /**  
     * Imprime en la consola todos los elementos de la cola.  
     */  
    public void listar() {  
        Nodo aux = cabeza;  
        StringBuilder colaStr = new StringBuilder("COLA:\n");  
        
        while (aux != null) {  
            colaStr.append(aux.getDato()).append("\n");  
            aux = aux.getPnext();  
        }  

        System.out.println(colaStr);  
    }    
} 
