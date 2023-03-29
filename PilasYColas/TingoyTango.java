package PilasYColas;

import static PilasYColas.TingoyTango.Conteo.calcularEliminado;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class TingoyTango {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el numero de jugadores: ");

        int numeroJugadores = scanner.nextInt();
        System.out.println("Empezando el juego de Tingo tingo tango...");
        calcularEliminado(numeroJugadores);

    }
    public class Conteo {

        public static void calcularEliminado(Integer numeroJugadores ) {
            int numeroDeRondas = numeroJugadores;
            Queue<Integer> queue = new LinkedList<>();

            // Añadir jugadores a la cola
            for (int i = 1; i <= numeroJugadores; i++) {
                queue.add(i);
            }

            // Empezar a pasar el tango
            while (queue.size() > 1) {
                for (int i = 0; i < numeroDeRondas; i++) {
                    queue.add(queue.remove());
                }
                int jugadorEliminado = queue.remove();
                System.out.println("El jugador " + jugadorEliminado + " ha sido eliminado :c");
            }
            int ganador = queue.remove();
            System.out.println("El jugador " + ganador + " ha ganado!!!!");


        }

    }

}