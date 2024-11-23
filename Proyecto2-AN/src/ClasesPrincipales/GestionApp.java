/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

import EDD.Arbol;
import EDD.HashTable;

/**
 *
 * @author alexa
 */
public class GestionApp {
    HashTable tablaPersonas;
    Arbol arbolGenealogico;
    private String nombreFamilia;

    public GestionApp() {
        this.tablaPersonas = null;
        this.arbolGenealogico = null;
        this.nombreFamilia = null;
    }

    public HashTable getTablaPersonas() {
        return tablaPersonas;
    }

    public void setTablaPersonas(HashTable tablaPersonas) {
        this.tablaPersonas = tablaPersonas;
    }

    public Arbol getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(Arbol arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }
}
