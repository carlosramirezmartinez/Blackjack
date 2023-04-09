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
        
        System.out.println("Quieres jugar de nuevo? (Si o Yes(S/s o Y/y) o No(n/n))");
        String decision = sc.nextLine().toUpperCase();
        if(decision.equals("Y") || decision.equals("S")) {
            continue;
        } else {
            break;
        }
    }
    sc.close();
	}
}

//Funciones abajo