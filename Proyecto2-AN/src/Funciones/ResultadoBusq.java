/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import ClasesPrincipales.Persona;

/**
 *
 * @author alexa
 */
public class ResultadoBusq {
    private Persona persona;
    private int indexHash;

    public ResultadoBusq(Persona persona, int indexHash) {
        this.persona = persona;
        this.indexHash = indexHash;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIndexHash() {
        return indexHash;
    }

    public void setIndexHash(int indexHash) {
        this.indexHash = indexHash;
    }

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
