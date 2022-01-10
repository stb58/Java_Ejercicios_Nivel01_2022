/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosnivel01;

import java.util.Arrays;

/**
 *
 * @author sergi
 */
public class EjerciciosNivel01 {
    public int [] maximos(int[] lista){
        int[] arrayMaximos = {lista[0],lista[0]};
        for (int i=0; i<lista.length; i++){
            if (lista[i] > arrayMaximos[0]){
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            }
            else if (lista[i] > arrayMaximos[1]){
                arrayMaximos[1] = lista[i];
            }
        }
        
        return arrayMaximos;
    }
    //SEGUNDO EJERCICIO : PALÍNDROMO 
    //PARA HACER ESTE EJERCICIO NECESITO HACER PRIMERO UNA FUNCION QUE
    //LIMPIE EL STRING PARA QUITARLE LOS ACENTOS Y LOS ESPACIOS EN BLANCO
    
    private String limpiaFrase(String frase) {
        frase = frase.toLowerCase(); //paso la frase a minuscula
        frase = frase.replace('á', 'a');
        frase = frase.replace('é', 'e');
        frase = frase.replace('í', 'i');
        frase = frase.replace('ó', 'o');
        frase = frase.replace('ú', 'u');
        //quito también los espacios en blanco
        frase = frase.replace(" ", "");
        
        return frase;
    }
    
    public boolean esPalindromo(String frase){
        frase = limpiaFrase(frase); //quita acentos y espacios en blanco
        
        int indiceIzquierdo = 0;
        int indiceDerecho = frase.length() - 1;
        
        while (frase.charAt(indiceIzquierdo) == frase.charAt(indiceDerecho) && indiceIzquierdo <= indiceDerecho){
            indiceIzquierdo++; //Voy ajustando los caracteres para que los vaya comparando
            indiceDerecho--;
        }
        if (indiceIzquierdo>indiceDerecho){ //Si ocurre esto es que ha salido del while y que es un palindromo
            return true;
        } else {
            return false;
        }
        
    }

    public static void main(String[] args) {
       int[] numeros = {99,37,7,54,13}; 
       int[] numeros2 = {-1,9,17,54,3}; 
       
       EjerciciosNivel01 e = new EjerciciosNivel01();
       //System.out.print(Arrays.toString(e.maximos(numeros2)));
       
       System.out.print(e.esPalindromo("Acaso hubo buhos acá"));
    }
    
}
