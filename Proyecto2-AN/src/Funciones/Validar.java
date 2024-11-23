/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Lista;

/**
 *
 * @author alexa
 */
public class Validar {
    private boolean validarnumeros(String num){
        return num.matches("[0-9]*");
    }
    
    public int convertirNumero(String numero){
        if(validarnumeros(numero)== true){
            int num = Integer.parseInt(numero);
            return num;
        }else{
            return -1;
        }
      }
    
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
    
    public boolean validarIndice(int max, int indice){
        return max > indice && indice>=0;
    }
    
    }
