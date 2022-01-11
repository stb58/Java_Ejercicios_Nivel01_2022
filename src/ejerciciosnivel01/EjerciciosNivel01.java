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
        frase = frase.replace(" ", "");  //Ponemos comillas simples para indicar que el espacio es un charAt
        
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
    
    public boolean esIsograma(String palabra){
        palabra = limpiaFrase(palabra);
        
        for (int i=0; i < palabra.length(); i++) {
            for(int j=i + 1; j< palabra.length(); j++){
                if (palabra.charAt(i) == palabra.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * @param frase la frase a convertir en acronimo, el acronimo en mayusculas
     * @return 
     */
    
    public String esAcronimo(String frase){
        //Suponemos que por lo menos hay una letra en la frase
       frase = frase.toUpperCase();
       String palabras[] = frase.split(" "); //Dividimos la frase en palabras
       String resultado = ""; //Ponemos comillas para que java lo convierta en string
       
       for (int i=0; i<palabras.length;i++){
            if (!(palabras[i].equals("Y") || palabras[i].equals("E") || palabras[i].equals("DE") || palabras[i].equals("LA") || palabras[i].equals("LAS"))){
            resultado = resultado + palabras[i].charAt(0);
            }
         }
       return resultado;
    }

    public static void main(String[] args) {
       int[] numeros = {99,37,7,54,13}; 
       int[] numeros2 = {-1,9,17,54,3}; 
       
       EjerciciosNivel01 e = new EjerciciosNivel01();
       //System.out.print(Arrays.toString(e.maximos(numeros2)));
       
       // palindromo System.out.print(e.esPalindromo("Acaso hubo buhos acá")); 
       //es Isograma System.out.println(e.esIsograma("pajaro"));
       //es Acronimo System.out.println("acronimo de alta velocidad española: " + e.esAcronimo("Alta Velocidad Española"));
       
       
    }
    
}
