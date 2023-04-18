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
    
    //Logica para las jugadas
    boolean jugadorCogeCarta = true;
    boolean cpuCogeCarta = true;
    while(true) {
    	
        if(jugadorCogeCarta) {
            jugadorCogeCarta = jugadaUsuario(jugador);
        }
        
        if(cpuCogeCarta) {
            cpuCogeCarta = jugadaCPU(cpu);
        }
        
        if(jugadorCogeCarta) {
            jugador.add(cartas.get(cartas.size() - 1));
            cartas.remove(cartas.size() - 1);
        }
        
        if(cpuCogeCarta) {
            cpu.add(cartas.get(cartas.size() - 1));
            cartas.remove(cartas.size() - 1);
        }
        
        if(!jugadorCogeCarta && !cpuCogeCarta) { //Al acabar compara
            comparaCartas(jugador, cpu);
            break;
        }
    }
    //Juegos
	}
    /*Ver como comparar cartas de usuario y cpu para acabar*/
        
	 private static void comparaCartas(ArrayList<Integer> user, ArrayList<Integer> cpu) {
	        
	        int jugadorSum = user.stream().mapToInt(Integer::intValue).sum();
	        int cpuSum = cpu.stream().mapToInt(Integer::intValue).sum();
	        System.out.println("Jugador: " + user + ". sumas = " + jugadorSum);
	        System.out.println("CPU: " + cpu + ". sumas = " + cpuSum);
	        if(jugadorSum == 22 && user.size() == 2) {
	            jugadorSum--;
	        }
	        if(cpuSum == 22 && cpu.size() == 2) {
	            cpuSum--;
	        }
	        if(jugadorSum == cpuSum || (jugadorSum > 21 && cpuSum > 21)) {
	            System.out.println("Empate!");
	            Empates++;
	        } else if(jugadorSum > cpuSum) {
	            System.out.println("Victoria!");
	            Victorias++;
	        } else {
	            System.out.println("Derrota!");
	            Derrotas++;
	        }
	    }
	    
        private static boolean jugadaUsuario(ArrayList<Integer> user) {
        	int sum = user.stream().mapToInt(Integer::intValue).sum();
			System.out.println("Las Cartas: " + user + ". Suman = " + sum);
            Scanner sc = new Scanner(System.in);
            System.out.println("Quieres jugar de nuevo? (Si o Yes(S/s o Y/y) o No(N/n o cualquier tecla distinta a Si o Yes))");
            while(true) {
                String decision = sc.nextLine().toUpperCase();
                if(decision.equals("Y") || decision.equals("S") ){
                    return true;
                } else {
                    return false; 
                }
            }
        }


        private static boolean jugadaCPU(ArrayList<Integer> cpu) {
            int sum = cpu.stream().mapToInt(Integer::intValue).sum();
            if((21 - sum) > 2) {
                return true;
            } else {
                return false;
            }
        }
        
		private static void FinJuego() {
		    System.out.println("Partidas jugada/s: " + PartidasJugadas);
		    System.out.println("Victoria/s: " + Victorias);
		    System.out.println("Empate/s: " + Empates);
		    System.out.println("Derrota/s: " + Derrotas);
		}
		
		
		
	}