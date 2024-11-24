/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

import javax.swing.JOptionPane;  

/**  
 * Clase que representa una lista enlazada simple.  
 * La lista puede almacenar objetos y proporciona métodos para manipular y acceder a ellos.  
 *   
 * @autor alexa  
 */  
public class Lista {  
    private Nodo pFirst; // Primer nodo de la lista  
    private int size;    // Tamaño actual de la lista  

    /**  
     * Constructor que inicializa una nueva lista vacía.  
     */  
    public Lista() {  
        this.pFirst = null;  
        this.size = 0;  
    }  

    public Nodo getpFirst() {  
        return pFirst;  
    }  

    public void setpFirst(Nodo pFirst) {  
        this.pFirst = pFirst;  
    }  

    public int getSize() {  
        return size;  
    }  

    public void setSize(int size) {  
        this.size = size;  
    }  

    /**  
     * Verifica si la lista está vacía.  
     *   
     * @return true si la lista está vacía, false en caso contrario.  
     */  
    public boolean isEmpty() {  
        return this.pFirst == null;  
    }  

    /**  
     * Elimina todos los elementos de la lista.  
     */  
    public void eliminar() {  
        pFirst = null;  
        size = 0;  
    }  

    /**  
     * Inserta un nuevo dato al final de la lista.  
     *   
     * @param dato el objeto a insertar en la lista.  
     */  
    public void insertarFinal(Object dato) {  
        Nodo pNew = new Nodo(dato);  
        if (isEmpty()) {  
            pFirst = pNew;  
        } else {  
            Nodo aux = pFirst;  
            while (aux.getPnext() != null) {  
                aux = aux.getPnext();  
            }  
            aux.setPnext(pNew);  
        }  
        size++;  
    }  

    /**  
     * Muestra todos los elementos de la lista en un cuadro de diálogo.  
     */  
    public void mostrar() {  
        if (!isEmpty()) {  
            Nodo aux = pFirst;  
            StringBuilder expresion = new StringBuilder();  
            while (aux != null) {  
                expresion.append(aux.getDato().toString()).append("\n");  
                aux = aux.getPnext();  
            }  
            JOptionPane.showMessageDialog(null, expresion.toString());  
        } else {  
            JOptionPane.showMessageDialog(null, "La lista está vacía");  
        }  
    }  

    /**  
     * Elimina el último elemento de la lista.  
     */  
    public void eliminarFinal() {  
        if (!isEmpty()) {  
            if (getSize() == 1) {  
                eliminar();  
            } else {  
                Nodo pointer = getpFirst();  
                while (pointer.getPnext() != null && pointer.getPnext().getPnext() != null) {  
                    pointer = pointer.getPnext();  
                }  
                pointer.setPnext(null);  
            }  
            size--;  
        }  
    }  

    /**  
     * Busca un objeto en la lista.  
     *   
     * @param referencia el objeto a buscar.  
     * @return true si se encuentra el objeto, false en caso contrario.  
     */  
    public boolean buscar(Object referencia) {  
        Nodo aux = pFirst;  
        while (aux != null) {  
            if (referencia.equals(aux.getDato())) { // Comparar usando equals  
                return true;  
            }  
            aux = aux.getPnext();  
        }  
        return false;  
    }  

    /**  
     * Obtiene el valor en la posición especificada.  
     *   
     * @param posicion la índice del valor a obtener.  
     * @return el objeto en la posición especificada, o null si la posición es inválida.  
     */  
    public Object getValor(int posicion) {  
        if (posicion >= 0 && posicion < size) {  
            Nodo aux = pFirst;  
            for (int i = 0; i < posicion; i++) {  
                aux = aux.getPnext();  
            }  
            return aux.getDato();  
        }  
        return null; // Devuelve null si la posición es inválida  
    }  

    /**  
     * Transforma la lista en una representación en cadena de sus elementos.  
     *   
     * @return una cadena que representa todos los datos en la lista, o "Lista vacía" si no hay elementos.  
     */  
    public String transformar() {  
        if (!isEmpty()) {  
            Nodo aux = pFirst;  
            StringBuilder expresion = new StringBuilder();  
            for (int i = 0; i < size; i++) {  
                expresion.append(aux.getDato().toString()).append("\n");  
                aux = aux.getPnext();  
            }  
            return expresion.toString();  
        }  
        return "Lista vacía";  
    }  
}  
