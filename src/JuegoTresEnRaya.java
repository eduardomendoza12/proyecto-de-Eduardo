import java.util.Scanner;

public class JuegoTresEnRaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== TRES EN RAYA - 2 JUGADORES ====");

        System.out.print("Ingrese el tamaño del tablero (mínimo 3): ");
        int tam = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (tam < 3) {
            System.out.println("El tamaño debe ser 3 o más.");
            return;
        }

        Tablero tablero = new Tablero(tam);
        Jugador jugador1 = new Jugador('X');
        Jugador jugador2 = new Jugador('O');

        boolean turnoJugador1 = true;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            Jugador jugadorActual = turnoJugador1 ? jugador1 : jugador2;
            System.out.println("Turno de Jugador " + (turnoJugador1 ? "1" : "2") + " (" + jugadorActual.getSimbolo() + ")");

            String posicion;
            int fila, columna;
            while (true) {
                System.out.print("Ingrese la posición (ej: A1): ");
                posicion = scanner.nextLine().toUpperCase();

                if (posicion.length() < 2) {
                    System.out.println("Formato inválido. Intente de nuevo.");
                    continue;
                }

                fila = posicion.charAt(0) - 'A';
                try {
                    columna = Integer.parseInt(posicion.substring(1)) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Intente de nuevo.");
                    continue;
                }

                if (tablero.movimientoValido(fila, columna)) {
                    tablero.colocarSimbolo(fila, columna, jugadorActual.getSimbolo());
                    break;
                } else {
                    System.out.println("Movimiento inválido. Intente otra posición.");
                }
            }

            if (tablero.hayGanador(jugadorActual.getSimbolo())) {
                tablero.mostrarTablero();
                System.out.println("¡Jugador " + (turnoJugador1 ? "1" : "2") + " gana!");
                juegoTerminado = true;
            } else if (tablero.tableroLleno()) {
                tablero.mostrarTablero();
                System.out.println("¡Empate!");
                juegoTerminado = true;
            } else {
                turnoJugador1 = !turnoJugador1;
            }
        }
    }
}
