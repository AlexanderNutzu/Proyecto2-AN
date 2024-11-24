/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;  

import ClasesPrincipales.Persona;  

/**  
 * Clase que representa un árbol genealógico que permite la organización  
 * y búsqueda de personas (nodos) en base a sus relaciones familiares.  
 *   
 * @autor alexa  
 */  
public class Arbol {  
    private NodoA root; // Raíz del árbol  

    /**  
     * Constructor de la clase Arbol.  
     * Inicializa el árbol con una raíz nula.  
     */  
    public Arbol() {  
        this.root = null;  
    }  

    // Métodos de acceso (getters y setters)  

    public NodoA getRoot() {  
        return root;  
    }  

    public void setRoot(NodoA root) {  
        this.root = root;  
    }  

    /**  
     * Verifica si el árbol está vacío.  
     *   
     * @return true si el árbol no tiene nodos, false en caso contrario.  
     */  
    public boolean isEmpty() {  
        return root == null;  
    }  

    /**  
     * Inicializa la raíz del árbol con un nuevo nodo dado.  
     *   
     * @param dato el dato a almacenar en el nodo raíz.  
     */  
    public void iniciarlizarRaiz(Object dato) {  
        NodoA rootNueva = new NodoA(dato);  
        this.setRoot(rootNueva);  
    }  

    /**  
     * Inserta un nuevo nodo como hijo de un nodo padre existente.  
     *   
     * @param padre el nodo padre al que se le añadirá el hijo.  
     * @param dato el dato a almacenar en el nuevo nodo hijo.  
     */  
    public void insertar(NodoA padre, Object dato) {  
        NodoA hijo = new NodoA(dato);  
        hijo.setPadre(padre);  
        padre.aggHijo(hijo);  
    }  

    /**  
     * Busca un nodo en el árbol por el nombre único (mote o nombre con numeral) de una persona.  
     *  
     * @param nombreUnico el mote o nombre con numeral de la persona a buscar.  
     * @return el nodo que contiene la persona, o null si no se encuentra.  
     */  
    public NodoA buscarNombreUnico(String nombreUnico) {  
        if (!this.isEmpty()) {  
            Cola cola = new Cola();  
            cola.enColar(this.root);  

            while (!cola.colaVacia()) {  
                NodoA nodoActual = (NodoA) cola.desEnColar();  
                Persona personaActual = (Persona) nodoActual.getDato();  

                // Verifica si el mote coincide  
                if (personaActual.getMote() != null && personaActual.getMote().equalsIgnoreCase(nombreUnico)) {  
                    return nodoActual;  
                }  

                // Verifica si el nombre y numeral coinciden  
                if (personaActual.getNombreNumeral().equalsIgnoreCase(nombreUnico)) {  
                    return nodoActual;  
                }  

                // Agrega hijos a la cola para la búsqueda en niveles  
                Nodo temp = nodoActual.getHijos().getpFirst();  
                while (temp != null) {  
                    NodoA nodoHijoActual = (NodoA) temp.getDato();  
                    cola.enColar(nodoHijoActual);  
                    temp = temp.getPnext();  
                }  
            }  
        }  
        return null;  
    }  

    /**  
     * Muestra el árbol por niveles en la consola.  
     */  
    public void mostrarPorNiveles() {  
        if (!this.isEmpty()) {  
            String arbolStr = "Arbol General Por Niveles:\n";  
            Cola cola = new Cola();  
            cola.enColar(this.root);  

            while (!cola.colaVacia()) {  
                NodoA nodoActual = (NodoA) cola.desEnColar();  
                Persona personaActual = (Persona) nodoActual.getDato();  

                arbolStr += personaActual.toString() + "\n";  

                Nodo temp = nodoActual.getHijos().getpFirst();  
                while (temp != null) {  
                    NodoA nodoHijoActual = (NodoA) temp.getDato();  
                    cola.enColar(nodoHijoActual);  
                    temp = temp.getPnext();  
                }  
            }  

            System.out.println(arbolStr);  
        }  
    }  

    /**  
     * Calcula el máximo nivel profundidad del árbol.  
     *   
     * @return el nivel máximo del árbol.  
     */  
    public int maximoNivel() {  
        if (this.isEmpty()) {  
            return 0;  
        }  
        int max = 0;  
        Cola cola = new Cola();  
        cola.enColar(this.root);  

        Cola colaNiveles = new Cola();  
        colaNiveles.enColar(1);  

        while (!cola.colaVacia()) {  
            NodoA nodoActual = (NodoA) cola.desEnColar();  
            int nivelActual = (int) colaNiveles.desEnColar();  

            max = Math.max(max, nivelActual);  

            Nodo temp = nodoActual.getHijos().getpFirst();  
            while (temp != null) {  
                NodoA nodoHijoActual = (NodoA) temp.getDato();  
                cola.enColar(nodoHijoActual);  
                colaNiveles.enColar(nivelActual + 1);  
                temp = temp.getPnext();  
            }  
        }  

        return max;  
    }  

    /**  
     * Devuelve una lista de personas que se encuentran en un nivel específico.  
     *   
     * @param nivel el nivel cuyas personas se desean obtener.  
     * @return una lista de personas en el nivel especificado o null si el árbol está vacío.  
     */  
    public Lista listaNivel(int nivel) {  
        Lista personasNivel = new Lista();  
        if (this.isEmpty()) {  
            return null;  
        }  

        Cola cola = new Cola();  
        cola.enColar(this.root);  

        Cola colaNiveles = new Cola();  
        colaNiveles.enColar(1);  

        while (!cola.colaVacia()) {  
            NodoA nodoActual = (NodoA) cola.desEnColar();  
            int nivelActual = (int) colaNiveles.desEnColar();  

            if (nivelActual == nivel) {  
                Persona personaActual = (Persona) nodoActual.getDato();  
                personasNivel.insertarFinal(personaActual);  
            }  

            Nodo temp = nodoActual.getHijos().getpFirst();  
            while (temp != null) {  
                NodoA nodoHijoActual = (NodoA) temp.getDato();  
                cola.enColar(nodoHijoActual);  
                colaNiveles.enColar(nivelActual + 1);  
                temp = temp.getPnext();  
            }  
        }  

        return personasNivel;  
    }  

    /**  
     * Busca y devuelve una lista de antepasados de un nodo dado.  
     *   
     * @param nodo el nodo a partir del cual se buscarán los antepasados.  
     * @return una lista de personas que son ancestros del nodo dado, o null si el nodo es nulo.  
     */  
    public Lista buscarAntepasados(NodoA nodo) {  
        if (nodo == null) {  
            return null;  
        }  

        Lista ancestros = new Lista();  
        NodoA actual = nodo.getPadre();  

        while (actual != null) {  
            Persona personaActual = (Persona) actual.getDato();  
            ancestros.insertarFinal(personaActual);  
            actual = actual.getPadre();  
        }  

        return ancestros;  
    }  
}  
