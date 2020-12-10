/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodetriki;

/**
 *
 * @author EdSar
 */
public class Triki {
    
    // Atributos
    public String[][] matriz; 
    
    
    // Constructor
    public Triki(){
        String c = "-";
        // String[][] matriz_aux = {{"7", "8", "9"}, {"4", "5", "6"}, {"1", "2", "3"}};
        String[][] matriz_aux = {{c, c, c}, {c, c, c}, {c, c, c}};
        this.matriz = matriz_aux;
    }
    
    
    // Métodos
    public void marcarCasilla(int casilla, String simbolo){
        int fila = 0;
        int columna = 0;
        if(casilla == 7){
            fila = 0;
            columna = 0;
        } else if (casilla == 8) {
            fila = 0;
            columna = 1;
        } else if (casilla == 9) {
            fila = 0;
            columna = 2;
        } else if (casilla == 4) {
            fila = 1;
            columna = 0;
        } else if (casilla == 5) {
            fila = 1;
            columna = 1;
        } else if (casilla == 6) {
            fila = 1;
            columna = 2;
        } else if (casilla == 1) {
            fila = 2;
            columna = 0;
        } else if (casilla == 2) {
            fila = 2;
            columna = 1;
        } else if (casilla == 3){
            fila = 2;
            columna = 2;
        }
        
        this.matriz[fila][columna] = simbolo;
    }
    
    public String verificarCasilla(int fila, int columna){
        String caracter = this.matriz[fila][columna];
        return caracter;
    }
    
    public String verificarGanador(){
        String valor = "Siguiente turno";
        String[][] matriz_aux = this.matriz;
        for(int i = 0; i < this.matriz.length; i++){
            
            // Comprobación horizontales
            if (verificarCasilla(i, 0) != "-" && verificarCasilla(i, 0).equals(verificarCasilla(i, 1)) && verificarCasilla(i, 0).equals(verificarCasilla(i, 2))){
                valor = verificarCasilla(i, 0);
                
            // Comprobación verticales
            } else if (verificarCasilla(0, i) != "-" && verificarCasilla(0, i).equals(verificarCasilla(1, i)) && verificarCasilla(0, i).equals(verificarCasilla(2, i))){
                valor = verificarCasilla(0, i);
            } 
        }
        
        // Comprobación de posibilidades para ganar (Diagonales)
        if (verificarCasilla(0, 0) != "-" && verificarCasilla(0, 0).equals(verificarCasilla(1, 1)) && verificarCasilla(0, 0).equals(verificarCasilla(2, 2))){
            valor = verificarCasilla(0, 0); 
        } else if (verificarCasilla(0, 2) != "-" && verificarCasilla(0, 2).equals(verificarCasilla(1, 1)) && verificarCasilla(0, 2).equals(verificarCasilla(2, 0))){
            valor = verificarCasilla(0, 2); 
        }   
        
        return valor;
    }
}