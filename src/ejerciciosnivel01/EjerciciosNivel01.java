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
        /**
     * 
     * @param anagrama comprobamos si es un anagrama comparando las letras y borrandolas
     * una vez que hemos visto que si coinciden
     * @return 
     */
    public boolean esAnagrama (String palabra1, String palabra2){
         palabra1 = limpiaFrase(palabra1);
         palabra2 = limpiaFrase(palabra2);
         palabra1 = palabra1.toUpperCase();
         palabra2 = palabra2.toUpperCase();
         if (palabra1.length() == palabra2.length()){ //Para que sean anagramas tienen que tener la misma longitud
         for(int i=0; i< palabra1.length(); i++){
         for(int j=0; j< palabra2.length(); j++){
            if (palabra1.charAt(i) == palabra2.charAt(j)){
                palabra2 = palabra2.substring(0, j) + palabra2.substring(j + 1,palabra2.length());  //Para borrar las letras, creo 2 substrings y luego los junto
                if(palabra2.equals("")){ //Si se han comprobado y borrado todas las letras el string tiene que ser ""
                    return true;
                }
               }
            }
         }
         }
         return false;
    }
    public void imprimeMes(int numX){
        int contador = 0; //Para saber que dia de la semana estoy imprimiendo
        //primera fase: Imprime las XX
        for (int i=0;i<numX; i++){
            System.out.print("XX ");
            contador++;
        }
        //Segunda fase: imprime los numeros desde el 1 al 31
        for (int i=1; i<=31;i++){
            if(i<10){
            System.out.print("0" + i + " ");
            } else {
            System.out.print(i+ " ");
            }
            contador++;
            if (contador % 7 == 0){
                System.out.println("");
            }
        }
        //Tercera fase: Poner las XX
        while (!(contador % 7 == 0)) {
            System.out.print("XX ");
            contador++;
        }
        
    }

    public static void main(String[] args) {
       int[] numeros = {99,37,7,54,13}; 
       int[] numeros2 = {-1,9,17,54,3}; 
       
       EjerciciosNivel01 e = new EjerciciosNivel01();
       //System.out.print(Arrays.toString(e.maximos(numeros2)));
       
       // palindromo System.out.print(e.esPalindromo("Acaso hubo buhos acá")); 
       //es Isograma System.out.println(e.esIsograma("pajaro"));
       //es Acronimo System.out.println("acronimo de alta velocidad española: " + e.esAcronimo("Alta Velocidad Española"));
       //es Anagrama System.out.println(e.esAnagrama("amor","roma"));
       e.imprimeMes(1);
    }
    
}
