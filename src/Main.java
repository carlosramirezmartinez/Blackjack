/*
Para coger una carta se debera pulsar Si o Yes(S/s o Y/y) o No(n/n)


Tenemos que hacer un bucle para cada partida hasta que el jugador diga que no
Despues se mostrara un historico de partidas
*/


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
        System.out.println("Quieres jugar de nuevo? (Si o Yes(S/s o Y/y) o No(n/n o cualquier tecla distinta a Si o Yes))");
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

private static void FinJuego() {
    System.out.println("Partidas jugada/s: " + PartidasJugadas);
    System.out.println("Victoria/s: " + Victorias);
    System.out.println("Empate/s: " + Empates);
    System.out.println("Derrota/s: " + Derrotas);
	}
}