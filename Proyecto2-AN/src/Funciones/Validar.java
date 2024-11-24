/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;  

import EDD.Lista;  

/**  
 * Clase que proporciona métodos para validar números, convertir cadenas a enteros  
 * y comprobar índices válidos en una lista de resultados.  
 *   
 * @author alexa  
 */  
public class Validar {  
    
    /**  
     * Verifica si la cadena proporcionada consiste únicamente en dígitos.  
     *   
     * @param num la cadena a validar.  
     * @return true si la cadena representa un número, false en caso contrario.  
     */  
    private boolean validarNumeros(String num){  
        return num.matches("[0-9]*");  
    }  
    
    /**  
     * Convierte una cadena a un número entero si la cadena es válida.  
     *   
     * @param numero la cadena que representa el número.  
     * @return el número entero si la conversión es exitosa, -1 si la cadena no es válida.  
     */  
    public int convertirNumero(String numero){  
        if(validarNumeros(numero)){  
            return Integer.parseInt(numero);  
        } else {  
            return -1; // Indicador de error  
        }  
    }  
    
    /**  
     * Verifica si el índice proporcionado es válido dentro de la lista de resultados.  
     *   
     * @param resultados la lista de resultados a validar.  
     * @param index el índice que se va a verificar.  
     * @return true si el índice es válido, false en caso contrario.  
     */  
    public boolean indexResultadoValido(Lista resultados, int index){  
        if(!resultados.isEmpty()){  
            for (int i = 0; i < resultados.getSize(); i++) {  
                ResultadoBusq resultadoActual = (ResultadoBusq) resultados.getValor(i);  
                if(resultadoActual.getIndexHash() == index){  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
    
    /**  
     * Valida si el índice está dentro del rango permitido.  
     *   
     * @param max el valor máximo permitido para el índice.  
     * @param indice el índice a validar.  
     * @return true si el índice es válido, false en caso contrario.  
     */  
    public boolean validarIndice(int max, int indice){  
        return (indice >= 0 && indice < max);  
    }  
}  
