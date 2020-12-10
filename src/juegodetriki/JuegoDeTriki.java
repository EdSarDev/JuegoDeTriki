/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodetriki;

import java.util.Scanner;
/**
 *
 * @author EdSar
 */
public class JuegoDeTriki {

    // Función para escribir (en pantalla) una matriz de caracteres
    public static void escribirArregloMatrizString(String[][] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[0].length; j++){
                System.out.print(x[i][j] + "  ");
            }
            System.out.println("");
        } 
    }
    
    public static void main(String[] args) {
        
        System.out.println("============================");
        System.out.println("=====  Juego de Triki  =====");
        System.out.println("============================");
        System.out.println("");
        System.out.println("Reglas: ");
        System.out.println("1. El jugador 1 escoge si juega con \"X\" ó con \"O\".");
        System.out.println("2. Cada jugador juega un turno cada vez.");
        System.out.println("3. En cada turno, el jugador debe escribir la posición donde quiere poner su símbolo:");
        System.out.println("_7_|_8_|_9_");
        System.out.println("_4_|_5_|_6_");
        System.out.println("_1_|_2_|_3_");
        System.out.println("");
        System.out.println("¡Jugadores!");
        
        // Ejecución de juego
        Scanner sc = new Scanner(System.in);
        System.out.println("El jugador 1 escoge \"X\" ó \"O\" (Escribir 1 para \"X\" ó 2 para \"O\"): ");

        int jugador1 = Integer.parseInt(sc.nextLine());

        String car_jugador1;
        String car_jugador2;
        if (jugador1 == 1){
            car_jugador1 = "X";
            car_jugador2 = "O";
        } else {
            car_jugador1 = "O";
            car_jugador2 = "X";
        }
        
        System.out.println("");
        System.out.println("¡Empieza el juego!");
        System.out.println("");

        Triki nuevo_juego = new Triki();

        int i = 0; // Inicia variable contadora para turnos de jugador
        int jugador = 0; // Inicia variable que contiene el número del jugador
        int num_casilla = 0; // Inicia la variable que contiene el número de la casilla de la jugada actual
        int numero_jugadas = 0;
        escribirArregloMatrizString(nuevo_juego.matriz);
        
        while (nuevo_juego.verificarGanador().equals("Siguiente turno") && numero_jugadas != 9){
            jugador = (i % 2)+1;
            if (jugador == 1){
                System.out.print("Turno jugador " + jugador + " (" + car_jugador1 + "). Marca casilla --> ");
            } else {
                System.out.print("Turno jugador " + jugador + " (" + car_jugador2 + "). Marca casilla --> ");
            }
            
            num_casilla = Integer.parseInt(sc.nextLine());
            if(jugador == 1){
               nuevo_juego.marcarCasilla(num_casilla, car_jugador1); 
            } else {
               nuevo_juego.marcarCasilla(num_casilla, car_jugador2);
            }
            i += 1;
            numero_jugadas +=1;
            System.out.println("");
            escribirArregloMatrizString(nuevo_juego.matriz);
        }
        
        System.out.println("");
        if (numero_jugadas == 9 && nuevo_juego.verificarGanador().equals("Siguiente turno")){
            System.out.println("No hay más jugadas posibles. Ningún jugador ha ganado.");
        } else {System.out.println("¡Ha ganado el jugador " + jugador + "!");
        }
        
        
    }
    
}
