/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;

/**
 *
 * @author alexa
 */
public class Arbol {
    private NodoA root;

    public Arbol() {
        this.root = null;
    }

    public NodoA getRoot() {
        return root;
    }

    public void setRoot(NodoA root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void iniciarlizarRaiz(Object dato) {
        NodoA rootNueva = new NodoA(dato);
        this.setRoot(rootNueva);
    }

    public void insertar(NodoA padre, Object dato) {
        NodoA hijo = new NodoA(dato);
        hijo.setPadre(padre);
        padre.aggHijo(hijo);
    }

    public NodoA buscarNombreUnico(String nombreUnico) {
        if (!this.isEmpty()) {
            Cola cola = new Cola();

            cola.enColar(this.root);

            while (!cola.colaVacia()) {
                NodoA nodoActual = (NodoA) cola.desEnColar();
                Persona personaActual = (Persona) nodoActual.getDato();

                if(personaActual.getMote() != null){
                    if(personaActual.getMote().equalsIgnoreCase(nombreUnico))  {
                        return nodoActual;
                    }
                }
                
                if (personaActual.getNombreNumeral().equalsIgnoreCase(nombreUnico)){
                    return nodoActual;
                }
                
                

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

            if(nivelActual == nivel){
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
    
    public Lista buscarAntepasados(NodoA nodo){
        if(nodo == null){
            return null;
        }
        
        Lista ancestros = new Lista();
        NodoA actual = nodo.getPadre();
        
        while(actual != null){
            Persona personaActual = (Persona) actual.getDato();
            ancestros.insertarFinal(personaActual);
            actual = actual.getPadre();
        }
        
        return ancestros;
    }
}
