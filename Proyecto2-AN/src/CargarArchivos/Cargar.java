/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CargarArchivos;  

import ClasesPrincipales.Persona;  
import EDD.Arbol;  
import EDD.HashTable;  
import com.google.gson.Gson;  
import com.google.gson.JsonArray;  
import com.google.gson.JsonElement;  
import com.google.gson.JsonObject;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  

/**  
 * Clase que maneja la carga de datos desde un archivo JSON en estructuras de árbol y tabla hash.  
 * Permite almacenar información sobre personas y sus relaciones familiares.  
 *   
 * @author alexa  
 */  
public class Cargar {  

    private Arbol estructuraArbol;  
    private HashTable tablaHash;  
    private String nombreFamilia;  
    private boolean padresInexistentes;  
    private boolean duplicadosDetectados;  

    /**  
     * Constructor que inicializa la clase Cargar y sus estructuras de datos.  
     */  
    public Cargar() {  
        this.estructuraArbol = new Arbol();  
        this.tablaHash = new HashTable(100);  
        this.nombreFamilia = null;  
        this.duplicadosDetectados = false;  
        this.padresInexistentes = false;  
    }  

    /**  
     * Obtiene la estructura del árbol.  
     *  
     * @return la estructura del árbol.  
     */  
    public Arbol getEstructuraArbol() {  
        return estructuraArbol;  
    }  

    /**  
     * Establece la estructura del árbol.  
     *  
     * @param estructuraArbol la nueva estructura del árbol.  
     */  
    public void setEstructuraArbol(Arbol estructuraArbol) {  
        this.estructuraArbol = estructuraArbol;  
    }  

    /**  
     * Obtiene la tabla hash.  
     *  
     * @return la tabla hash.  
     */  
    public HashTable getTablaHash() {  
        return tablaHash;  
    }  

    /**  
     * Establece la tabla hash.  
     *  
     * @param tablaHash la nueva tabla hash.  
     */  
    public void setTablaHash(HashTable tablaHash) {  
        this.tablaHash = tablaHash;  
    }  

    /**  
     * Obtiene el nombre de la familia.  
     *  
     * @return el nombre de la familia.  
     */  
    public String getNombreFamilia() {  
        return nombreFamilia;  
    }  

    /**  
     * Establece el nombre de la familia.  
     *  
     * @param nombreFamilia el nuevo nombre de la familia.  
     */  
    public void setNombreFamilia(String nombreFamilia) {  
        this.nombreFamilia = nombreFamilia;  
    }  

    /**  
     * Verifica si hay padres inexistentes en los registros.  
     *  
     * @return true si hay padres inexistentes; false en caso contrario.  
     */  
    public boolean isPadresInexistentes() {  
        return padresInexistentes;  
    }  

    /**  
     * Establece el estado de existencia de padres.  
     *  
     * @param padresInexistentes el nuevo estado de existencia de padres.  
     */  
    public void setPadresInexistentes(boolean padresInexistentes) {  
        this.padresInexistentes = padresInexistentes;  
    }  

    /**  
     * Verifica si se han detectado duplicados.  
     *  
     * @return true si se han detectado duplicados; false en caso contrario.  
     */  
    public boolean isDuplicadosDetectados() {  
        return duplicadosDetectados;  
    }  

    /**  
     * Establece el estado de detección de duplicados.  
     *  
     * @param duplicadosDetectados el nuevo estado de detección de duplicados.  
     */  
    public void setDuplicadosDetectados(boolean duplicadosDetectados) {  
        this.duplicadosDetectados = duplicadosDetectados;  
    }  

    /**  
     * Carga un archivo JSON y almacena sus datos en las estructuras de árbol y tabla hash.  
     *  
     * @param rutaArchivo la ruta del archivo JSON a cargar.  
     * @throws FileNotFoundException si no se encuentra el archivo en la ruta especificada.  
     */  
    public void cargarArchivo(String rutaArchivo) throws FileNotFoundException {  
        FileReader lector = new FileReader(rutaArchivo);  
        Gson gson = new Gson();  
        JsonObject datosJson = gson.fromJson(lector, JsonObject.class);  

        for (String linaje : datosJson.keySet()) {  
            nombreFamilia = linaje;  
            JsonArray integrantes = datosJson.getAsJsonArray(nombreFamilia);  
            for (JsonElement integrante : integrantes) {  
                JsonObject registro = integrante.getAsJsonObject();  
                agregarATablaHash(registro);  
            }  
        }  

        for (String linaje : datosJson.keySet()) {  
            JsonArray integrantes = datosJson.getAsJsonArray(nombreFamilia);  
            for (JsonElement integrante : integrantes) {  
                JsonObject registro = integrante.getAsJsonObject();  
                insertarEnArbol(registro);  
            }  
        }  
    }  

    /**  
     * Inserta un registro JSON en la estructura de árbol.  
     *  
     * @param registroJson el objeto JSON que representa el registro a insertar.  
     */  
    private void insertarEnArbol(JsonObject registroJson) {  
        String nombreCompleto = registroJson.keySet().iterator().next();  
        JsonArray detalles = registroJson.getAsJsonArray(nombreCompleto);  

        Persona persona = new Persona(nombreCompleto);  
        asignarDetalles(persona, detalles);  

        if (this.estructuraArbol.buscarNombreUnico(persona.getNombreUnico()) == null) {  
            if (estructuraArbol.isEmpty()) {  
                estructuraArbol.iniciarlizarRaiz(persona);  
            } else {  
                if (persona.getPadre().contains(" of his name")) {  
                    String nombrePadre = persona.getPadre().replace(" of his name", "").replaceAll(",", "").trim();  
                    persona.setPadre(nombrePadre);  

                    if (estructuraArbol.buscarNombreUnico(nombrePadre) != null) {  
                        estructuraArbol.insertar(estructuraArbol.buscarNombreUnico(nombrePadre), persona);  
                    } else {  
                        this.setPadresInexistentes(true);  
                    }  
                } else {  
                    if (estructuraArbol.buscarNombreUnico(persona.getPadre()) != null) {  
                        estructuraArbol.insertar(estructuraArbol.buscarNombreUnico(persona.getPadre()), persona);  
                    } else {  
                        this.setPadresInexistentes(true);  
                    }  
                }  
            }  
        } else {  
            this.setDuplicadosDetectados(true);  
        }  
    }  

    /**  
     * Agrega un registro JSON a la tabla hash.  
     *  
     * @param registroJson el objeto JSON que representa el registro a agregar.  
     */  
    private void agregarATablaHash(JsonObject registroJson) {  
        String nombreCompleto = registroJson.keySet().iterator().next();  
        JsonArray detalles = registroJson.getAsJsonArray(nombreCompleto);  

        Persona persona = new Persona(nombreCompleto);  
        asignarDetalles(persona, detalles);  
        this.tablaHash.insertar(persona.getNombreUnico(), persona);  
    }  

    /**  
     * Asigna los detalles de una persona a partir de un arreglo JSON.  
     *  
     * @param persona  la persona a la que se le asignarán los detalles.  
     * @param detalles el arreglo JSON con los detalles de la persona.  
     */  
    private void asignarDetalles(Persona persona, JsonArray detalles) {
        for (JsonElement elemento : detalles) {
            JsonObject atributo = elemento.getAsJsonObject();
            if (atributo.has("Of his name")) {
                persona.setNumeral(atributo.get("Of his name").getAsString());
            } else if (atributo.has("Born to")) {
                if (persona.getPadre() == null) {
                    persona.setPadre(atributo.get("Born to").getAsString());
                } else {
                    persona.setMadre(atributo.get("Born to").getAsString());
                }
            } else if (atributo.has("Known throughout as")) {
                persona.setMote(atributo.get("Known throughout as").getAsString());
            } else if (atributo.has("Held title")) {
                persona.setTitulo(atributo.get("Held title").getAsString());
            } else if (atributo.has("Wed to")) {
                persona.setEsposa(atributo.get("Wed to").getAsString());
            } else if (atributo.has("Of eyes")) {
                persona.setColorOjos(atributo.get("Of eyes").getAsString());
            } else if (atributo.has("Of hair")) {
                persona.setColorCabello(atributo.get("Of hair").getAsString());
            } else if (atributo.has("Notes")) {
                persona.setComentVida(atributo.get("Notes").getAsString());
            } else if (atributo.has("Fate")) {
                persona.setComentMuerte(atributo.get("Fate").getAsString());
            }
        }
    }
}
