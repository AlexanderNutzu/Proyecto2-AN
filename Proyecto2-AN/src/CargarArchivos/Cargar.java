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
 *
 * @author alexa
 */
public class Cargar {
    private Arbol estructuraArbol;
    private HashTable tablaHash;
    private String nombreFamilia;
    private boolean padresInexistentes;
    private boolean duplicadosDetectados;

    public Cargar() {
        this.estructuraArbol = new Arbol();
        this.tablaHash = new HashTable(100);
        this.nombreFamilia = null;
        this.duplicadosDetectados = false;
        this.padresInexistentes = false;
    }

    public Arbol getEstructuraArbol() {
        return estructuraArbol;
    }

    public void setEstructuraArbol(Arbol estructuraArbol) {
        this.estructuraArbol = estructuraArbol;
    }

    public HashTable getTablaHash() {
        return tablaHash;
    }

    public void setTablaHash(HashTable tablaHash) {
        this.tablaHash = tablaHash;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public boolean isPadresInexistentes() {
        return padresInexistentes;
    }

    public void setPadresInexistentes(boolean padresInexistentes) {
        this.padresInexistentes = padresInexistentes;
    }

    public boolean isDuplicadosDetectados() {
        return duplicadosDetectados;
    }

    public void setDuplicadosDetectados(boolean duplicadosDetectados) {
        this.duplicadosDetectados = duplicadosDetectados;
    }

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

    private void agregarATablaHash(JsonObject registroJson) {
        String nombreCompleto = registroJson.keySet().iterator().next();
        JsonArray detalles = registroJson.getAsJsonArray(nombreCompleto);

        Persona persona = new Persona(nombreCompleto);
        asignarDetalles(persona, detalles);
        this.tablaHash.insertar(persona.getNombreUnico(), persona);
    }

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
