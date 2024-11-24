/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;  

import ClasesPrincipales.Persona;  

/**  
 * Clase que representa el resultado de una búsqueda de una persona,  
 * incluyendo el objeto persona y el índice hash asociado.  
 *   
 * @author alexa  
 */  
public class ResultadoBusq {  
    private Persona persona;   // Objeto persona que se ha encontrado  
    private int indexHash;     // Índice hash correspondiente a la persona  

    /**  
     * Constructor que inicializa el resultado de búsqueda con  
     * un objeto Persona y un índice hash.  
     *   
     * @param persona el objeto Persona encontrado.  
     * @param indexHash el índice hash correspondiente a la búsqueda.  
     */  
    public ResultadoBusq(Persona persona, int indexHash) {  
        this.persona = persona;  
        this.indexHash = indexHash;  
    }  

    /**  
     * Obtiene el objeto Persona asociado al resultado de búsqueda.  
     *   
     * @return el objeto Persona.  
     */  
    public Persona getPersona() {  
        return persona;  
    }  

    /**  
     * Establece el objeto Persona asociado al resultado de búsqueda.  
     *   
     * @param persona el nuevo objeto Persona.  
     */  
    public void setPersona(Persona persona) {  
        this.persona = persona;  
    }  

    /**  
     * Obtiene el índice hash asociado al resultado de búsqueda.  
     *   
     * @return el índice hash.  
     */  
    public int getIndexHash() {  
        return indexHash;  
    }  

    /**  
     * Establece un nuevo índice hash para el resultado de búsqueda.  
     *   
     * @param indexHash el nuevo índice hash.  
     */  
    public void setIndexHash(int indexHash) {  
        this.indexHash = indexHash;  
    }  

    /**  
     * Devuelve una representación en forma de cadena del resultado  
     * de búsqueda, incluyendo el índice hash y los detalles de la persona.  
     *   
     * @return una cadena que representa el resultado de búsqueda.  
     */  
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("Indice en Hash: ").append(indexHash);  
        sb.append("\nNombre: ").append(persona.getNombreNumeral());  
        if (persona.getMote() != null) {  
            sb.append("\nMote: ").append(persona.getMote());  
        }  
        return sb.toString();  
    }  
}