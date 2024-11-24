/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPrincipales;  

/**  
 * Clase que representa a una persona en la genealogía.  
 * Contiene información básica como nombre, padres, mote, título,  
 * y otros atributos relacionados con la vida y muerte de la persona.  
 *   
 * @autor alexa  
 */  
public class Persona {  
    private String nombre;         // Nombre de la persona  
    private String numeral;        // Identificador numérico de la persona  
    private String padre;          // Nombre del padre  
    private String madre;          // Nombre de la madre  
    private String mote;           // Apodo de la persona  
    private String titulo;         // Título profesional o honorífico  
    private String esposa;         // Nombre de la esposa  
    private String colorOjos;      // Color de los ojos  
    private String colorCabello;   // Color del cabello  
    private String comentVida;     // Comentarios sobre su vida  
    private String comentMuerte;   // Comentarios sobre su muerte  

    /**  
     * Constructor de la clase Persona.  
     *   
     * @param nombre el nombre de la persona.  
     */  
    public Persona(String nombre) {  
        this.nombre = nombre;  
        this.numeral = null;  
        this.padre = null;  
        this.madre = null;  
        this.mote = null;  
        this.titulo = null;  
        this.esposa = null;  
        this.colorOjos = null;  
        this.colorCabello = null;  
        this.comentVida = null;  
        this.comentMuerte = null;  
    }  

    // Métodos de acceso (getters)  

    public String getNombre() {  
        return nombre;  
    }  

    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  

    public String getNumeral() {  
        return numeral;  
    }  

    public void setNumeral(String numeral) {  
        this.numeral = numeral;  
    }  

    public String getPadre() {  
        return padre;  
    }  

    public void setPadre(String padre) {  
        this.padre = padre;  
    }  

    public String getMadre() {  
        return madre;  
    }  

    public void setMadre(String madre) {  
        this.madre = madre;  
    }  

    public String getMote() {  
        return mote;  
    }  

    public void setMote(String mote) {  
        this.mote = mote;  
    }  

    public String getTitulo() {  
        return titulo;  
    }  

    public void setTitulo(String titulo) {  
        this.titulo = titulo;  
    }  

    public String getEsposa() {  
        return esposa;  
    }  

    public void setEsposa(String esposa) {  
        this.esposa = esposa;  
    }  

    public String getColorOjos() {  
        return colorOjos;  
    }  

    public void setColorOjos(String colorOjos) {  
        this.colorOjos = colorOjos;  
    }  

    public String getColorCabello() {  
        return colorCabello;  
    }  

    public void setColorCabello(String colorCabello) {  
        this.colorCabello = colorCabello;  
    }  

    public String getComentVida() {  
        return comentVida;  
    }  

    public void setComentVida(String comentVida) {  
        this.comentVida = comentVida;  
    }  

    public String getComentMuerte() {  
        return comentMuerte;  
    }  

    public void setComentMuerte(String comentMuerte) {  
        this.comentMuerte = comentMuerte;  
    }  

    /**  
     * Obtiene el nombre único de la persona.  
     * Si no tiene mote, se devuelve el nombre seguido de su numeral.  
     *   
     * @return el mote si existe, de lo contrario el nombre con el numeral.  
     */  
    public String getNombreUnico() {  
        if (this.mote == null) {  
            return this.getNombreNumeral();  
        }  
        return this.mote;  
    }  

    /**  
     * Obtiene el nombre de la persona concatenado con su numeral.  
     *   
     * @return el nombre y numeral de la persona.  
     */  
    public String getNombreNumeral() {  
        return this.getNombre() + " " + this.getNumeral();   
    }  

    /**  
     * Representa la información de la persona como un String.  
     *   
     * @return la representación completa de la persona con sus atributos.  
     */  
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("\nNombre: ").append(nombre);  
        sb.append("\nNumeral: ").append(numeral);  
        sb.append("\nPadre: ").append(padre);  
        sb.append("\nMadre: ").append(madre);  
        sb.append("\nMote: ").append(mote);  
        sb.append("\nTitulo: ").append(titulo);  
        sb.append("\nEsposa: ").append(esposa);  
        sb.append("\nColor de Ojos: ").append(colorOjos);  
        sb.append("\nColor de Cabello: ").append(colorCabello);  
        sb.append("\nComentarios de su Vida: ").append(comentVida);  
        sb.append("\nComentarios de su Muerte: ").append(comentMuerte);  
        return sb.toString();  
    }     
}  
