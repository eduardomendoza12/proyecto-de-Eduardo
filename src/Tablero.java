public class Tablero {
    private char[][] tablero;
    private int tamano;

    public Tablero(int tamano) {
        this.tamano = tamano;
        tablero = new char[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("  ");
        for (int j = 0; j < tamano; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < tamano; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tamano; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int fila, int columna) {
        return fila >= 0 && fila < tamano && columna >= 0 && columna < tamano && tablero[fila][columna] == '_';
    }

    public void colocarSimbolo(int fila, int columna, char simbolo) {
        tablero[fila][columna] = simbolo;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (tablero[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hayGanador(char simbolo) {
        for (int i = 0; i < tamano; i++) {
            boolean filaGana = true;
            for (int j = 0; j < tamano; j++) {
                if (tablero[i][j] != simbolo) {
                    filaGana = false;
                    break;
                }
            }
            if (filaGana) return true;
        }

        for (int j = 0; j < tamano; j++) {
            boolean colGana = true;
            for (int i = 0; i < tamano; i++) {
                if (tablero[i][j] != simbolo) {
                    colGana = false;
                    break;
                }
            }
            if (colGana) return true;
        }
        boolean diag1 = true;
        for (int i = 0; i < tamano; i++) {
            if (tablero[i][i] != simbolo) {
                diag1 = false;
                break;
            }
        }
        boolean diag2 = true;
        for (int i = 0; i < tamano; i++) {
            if (tablero[i][tamano - 1 - i] != simbolo) {
                diag2 = false;
                break;
            }
        }

        return diag1 || diag2;
    }
}
