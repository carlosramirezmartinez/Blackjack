/*
Para coger una carta se debera pulsar Si o Yes(S/s o Y/y) o No(n/n)


Tenemos que hacer un bucle para cada partida hasta que el jugador diga que no
Despues se mostrara un historico de partidas
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    private static int PartidasJugadas = 0;
    private static int Victorias = 0;
    private static int Empates = 0;
    private static int Derrotas = 0;

 
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
    	empezarJuego();
        System.out.println("Quieres jugar de nuevo? (Si o Yes(S/s o Y/y) o No(N/n o cualquier tecla distinta a Si o Yes))");
        String decision = sc.nextLine().toUpperCase();
        if(decision.equals("Y") || decision.equals("S")) {
            continue;
        } else {
            break;
        }
    }
    FinJuego();
    sc.close();
}




//Funciones abajo

private static void empezarJuego() {
    ArrayList<Integer> jugador = new ArrayList<>();
    ArrayList<Integer> cpu = new ArrayList<>();
    ArrayList<Integer> cartas = new ArrayList<>();
    
    //Juego 1 carta
    for(int i = 0; i < 2; i++) {
        for(int j = 2; j < 12; j++) {
            cartas.add(j);
        }
    }
    
    Collections.shuffle(cartas, new Random());
    
    //Partida con 2 cartas
    jugador.add(cartas.get(cartas.size() - 1));
    cartas.remove(cartas.size() - 1);
    cpu.add(cartas.get(cartas.size() - 1));
    cartas.remove(cartas.size() - 1);
    
    
    /*Ver como comparar cartas de usuario y cpu para acabar*/
}


private static void FinJuego() {
    System.out.println("Partidas jugada/s: " + PartidasJugadas);
    System.out.println("Victoria/s: " + Victorias);
    System.out.println("Empate/s: " + Empates);
    System.out.println("Derrota/s: " + Derrotas);
	}
}