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
public class NodoA {
    private Object dato;
    private NodoA padre;
    private Lista hijos;

    public NodoA(Object dato) {
        this.dato = dato;
        this.padre = null;
        this.hijos = new Lista();
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoA getPadre() {
        return padre;
    }

    public void setPadre(NodoA padre) {
        this.padre = padre;
    }

    public Lista getHijos() {
        return hijos;
    }

    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }
    
    public void aggHijo(NodoA hijo){
        if(!this.buscarHijo(hijo)){
            this.hijos.insertarFinal(hijo);
        }
    }

    public boolean buscarHijo(NodoA hijo) {
        if (!this.esHoja()) {
            Persona personaNueva = (Persona) hijo.getDato();
            for (int i = 0; i < this.hijos.getSize(); i++) {
                NodoA hijoActual = (NodoA) this.hijos.getValor(i);
                Persona personaActual = (Persona) hijoActual.getDato();
                if (personaActual.getNombreUnico().equalsIgnoreCase(personaNueva.getNombreUnico())) {
                    return true;
                }
            }

            return false;
        }
        
        return false;
    }

    public boolean esHoja() {
        return this.hijos.isEmpty();
    }
}
