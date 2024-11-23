/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;

import EDD.Arbol;
import EDD.HashTable;
import EDD.Lista;
import Funciones.ResultadoBusq;

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
    
    public String mostrarBusquedaNombreUnico(Lista resultados){
        
        String resultadoStr = "";
        if(!resultados.isEmpty()){
            for (int i = 0; i < resultados.getSize(); i++) {
                resultadoStr += resultados.getValor(i).toString() + "\n";
            }
            
            return resultadoStr;
        }else{
            return "No hay resultados";
        }
    }
    
    public Persona buscarIndex(Lista resultados, int index){
        if(!resultados.isEmpty()){
            for (int i = 0; i < resultados.getSize(); i++) {
                ResultadoBusq resultadoActual = (ResultadoBusq) resultados.getValor(i);
                if(resultadoActual.getIndexHash() == index){
                    return resultadoActual.getPersona();
                }
            }
        }
        return null;
    }
    
    
    public Persona[] buscarTitulo(String titulo){
        Lista resultados = this.tablaPersonas.buscarTitulo(titulo);
        
        if(!resultados.isEmpty()){
            Persona[] resultadoBusq = new Persona[resultados.getSize()];
            for (int i = 0; i < resultados.getSize(); i++) {
                resultadoBusq[i] = (Persona) resultados.getValor(i);
            }
            
            return resultadoBusq;
        }
        
        return null;
    }
    
    public String mostrarBusqTitulo(Persona[] resultados){
        String resultadosStr = "";
        for (int i = 0; i < resultados.length; i++) {
            int index = i;
            resultadosStr += "Indice: " + index + "\nNombre Unico: " + resultados[i].getNombreUnico() + "\nTitulo: " + resultados[i].getTitulo()+"\n\n";
        }
        
        return resultadosStr;
    }
}
