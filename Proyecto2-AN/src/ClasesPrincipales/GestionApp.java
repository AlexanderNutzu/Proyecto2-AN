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
 * Clase que gestiona la aplicación , proporcionando métodos para   
 * interactuar con una tabla hash de personas y un árbol genealógico.  
 * Permite realizar búsquedas de personas y mostrar resultados de forma estructurada.  
 *   
 * @author alexa  
 */  
public class GestionApp {  
    HashTable tablaPersonas;  // Tabla hash que contiene personas  
    Arbol arbolGenealogico;   // Árbol genealógico de la aplicación  
    private String nombreFamilia; // Nombre de la familia  

    /**  
     * Constructor de la clase GestionApp. Inicializa la tabla de personas,  
     * el árbol genealógico y el nombre de la familia como nulos.  
     */  
    public GestionApp() {  
        this.tablaPersonas = null;  
        this.arbolGenealogico = null;  
        this.nombreFamilia = null;  
    }  

    /**  
     * Retorna la tabla de personas.  
     *   
     * @return la tabla hash que contiene personas.  
     */  
    public HashTable getTablaPersonas() {  
        return tablaPersonas;  
    }  

    /**  
     * Establece la tabla de personas.  
     *   
     * @param tablaPersonas la tabla hash a establecer.  
     */  
    public void setTablaPersonas(HashTable tablaPersonas) {  
        this.tablaPersonas = tablaPersonas;  
    }  

    /**  
     * Retorna el árbol genealógico.  
     *   
     * @return el árbol genealógico de la aplicación.  
     */  
    public Arbol getArbolGenealogico() {  
        return arbolGenealogico;  
    }  

    /**  
     * Establece el árbol genealógico de la aplicación.  
     *   
     * @param arbolGenealogico el árbol a establecer.  
     */  
    public void setArbolGenealogico(Arbol arbolGenealogico) {  
        this.arbolGenealogico = arbolGenealogico;  
    }  

    /**  
     * Retorna el nombre de la familia.  
     *   
     * @return el nombre de la familia.  
     */  
    public String getNombreFamilia() {  
        return nombreFamilia;  
    }  

    /**  
     * Establece el nombre de la familia.  
     *   
     * @param nombreFamilia el nombre de la familia a establecer.  
     */  
    public void setNombreFamilia(String nombreFamilia) {  
        this.nombreFamilia = nombreFamilia;  
    }  

    /**  
     * Muestra los resultados de una búsqueda de nombres únicos.  
     *   
     * @param resultados la lista de resultados a mostrar.  
     * @return un string con los resultados formateados,  
     *         o un mensaje indicando que no hay resultados.  
     */  
    public String mostrarBusquedaNombreUnico(Lista resultados) {  
        String resultadoStr = "";  
        if (!resultados.isEmpty()) {  
            for (int i = 0; i < resultados.getSize(); i++) {  
                resultadoStr += resultados.getValor(i).toString() + "\n";  
            }  
            return resultadoStr;  
        } else {  
            return "No hay resultados";  
        }  
    }  

    /**  
     * Busca una persona en la lista de resultados por su índice.  
     *   
     * @param resultados la lista de resultados donde buscar.  
     * @param index el índice de búsqueda.  
     * @return la persona correspondiente al índice, o null si no se encuentra.  
     */  
    public Persona buscarIndex(Lista resultados, int index) {  
        if (!resultados.isEmpty()) {  
            for (int i = 0; i < resultados.getSize(); i++) {  
                ResultadoBusq resultadoActual = (ResultadoBusq) resultados.getValor(i);  
                if (resultadoActual.getIndexHash() == index) {  
                    return resultadoActual.getPersona();  
                }  
            }  
        }  
        return null;  
    }  

    /**  
     * Busca personas en la tabla de hash por título.  
     *  
     * @param titulo el título por el que se busca.  
     * @return un arreglo de personas que tienen el título dado, o null si no hay resultados.  
     */  
    public Persona[] buscarTitulo(String titulo) {  
        Lista resultados = this.tablaPersonas.buscarTitulo(titulo);  
        if (!resultados.isEmpty()) {  
            Persona[] resultadoBusq = new Persona[resultados.getSize()];  
            for (int i = 0; i < resultados.getSize(); i++) {  
                resultadoBusq[i] = (Persona) resultados.getValor(i);  
            }  
            return resultadoBusq;  
        }  
        return null;  
    }  

    /**  
     * Muestra los resultados de búsqueda de títulos formateados.  
     *   
     * @param resultados el arreglo de personas a mostrar.  
     * @return un string con los resultados formateados.  
     */  
    public String mostrarBusqTitulo(Persona[] resultados) {  
        String resultadosStr = "";  
        for (int i = 0; i < resultados.length; i++) {  
            int index = i;  
            resultadosStr += "Indice: " + index + "\nNombre Unico: " + resultados[i].getNombreUnico() + "\nTitulo: " + resultados[i].getTitulo() + "\n\n";  
        }  
        return resultadosStr;  
    }  

    /**  
     * Crea una lista de generaciones en el árbol genealógico.  
     *   
     * @return una lista de los niveles de generaciones.  
     */  
    public Lista listaGen() {  
        Lista generaciones = new Lista();  
        int maxGen = this.getArbolGenealogico().maximoNivel();  
        for (int i = 0; i < maxGen; i++) {  
            generaciones.insertarFinal(i + 1);  
        }  
        return generaciones;  
    }  

    /**  
     * Busca personas en una generación específica del árbol genealógico.  
     *   
     * @param numGen el número de la generación a buscar.  
     * @return un arreglo de personas en la generación especificada, o null si no hay resultados.  
     */  
    public Persona[] buscarGeneracion(int numGen) {  
        Lista generacion = this.getArbolGenealogico().listaNivel(numGen);  
        if (!generacion.isEmpty()) {  
            Persona[] resultadoBusq = new Persona[generacion.getSize()];  
            for (int i = 0; i < generacion.getSize(); i++) {  
                resultadoBusq[i] = (Persona) generacion.getValor(i);  
            }  
            return resultadoBusq;  
        }  
        return null;  
    }  

    /**  
     * Muestra los resultados de la búsqueda de una generación formateados.  
     *   
     * @param resultados el arreglo de personas a mostrar.  
     * @return un string con los resultados formateados.  
     */  
    public String mostrarGeneracion(Persona[] resultados) {  
        String resultadosStr = "";  
        for (int i = 0; i < resultados.length; i++) {  
            int index = i;  
            resultadosStr += "Indice: " + index + "\nNombre Unico: " + resultados[i].getNombreUnico() + "\n\n";  
        }  
        return resultadosStr;  
    }  
}  
