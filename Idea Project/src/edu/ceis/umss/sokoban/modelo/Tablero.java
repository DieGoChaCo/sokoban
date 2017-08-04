package edu.ceis.umss.sokoban.modelo;

public class Tablero {
    private Celda[][] celdas;
    private Jugador jugador;
    private int filas;
    private int columnas;

    public Tablero(char[][] tablero, Jugador jugador1){
        jugador = jugador1;
        filas = tablero.length;
        columnas = tablero[0].length;
        celdas = new Celda[filas][columnas];
        iniciarTablero(tablero);
    }

//    public Tablero(char[][] tablero){
//        filas = tablero.length;
//        columnas = tablero[0].length;
//        celdas = new Celda[filas][columnas];
//        iniciarTablero(tablero);
//    }

    private void iniciarTablero(char [][]tablero){
        for (int i = 0; i <filas ; i++) {
            for (int j = 0; j <columnas ; j++) {
                celdas[i][j] = new Celda(i,j);
                switch (tablero[i][j]){
                    case 'o':
                        celdas[i][j].setEstado(Estado.OBSTACULO);
                        break;
                    case 'n':
                        celdas[i][j].setEstado(Estado.NADA);
                        break;
                    case 'v':
                        celdas[i][j].setEstado(Estado.VACIO);
                        break;
                    case 'j':
                        celdas[i][j].setJugador(jugador);
                        celdas[i][j].getJugador().setTablero(this);
                        celdas[i][j].setEstado();
                        jugador.setCelda(celdas[i][j]);
                        break;
                    case 'c':
                        celdas[i][j].setCaja(new Caja());
                        celdas[i][j].getCaja().setTablero(this);
                        celdas[i][j].setEstado();
                        celdas[i][j].getCaja().setCelda(celdas[i][j]);
                        break;
                    case 'f':
                        celdas[i][j].setMeta(new Meta());
                        celdas[i][j].setEstado();
                        celdas[i][j].getMeta().setCelda(celdas[i][j]);
                        break;
                        default:
                            break;
                }
            }
        }
    }

    public void mostrar(){
        String letra = "";
        for (int i = 0; i <filas ; i++) {
            for (int j = 0; j <columnas ; j++) {
                switch (celdas[i][j].getEstado()){
                    case OBSTACULO:
                        letra = "O";
                        break;
                    case CAJA:
                        letra = "C";
                        break;
                    case VACIO:
                        letra = "-";
                        break;
                    case JUGADOR:
                        letra = "J";
                        break;
                    case META:
                        letra = "X";
                        break;
                    case NADA:
                        letra = " ";
                        break;
                        default:
                }
                System.out.printf("%3s",letra);
            }
            System.out.println();
        }
    }

    public Celda getCelda(int fila, int columna){
        return celdas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void limpiarCelda(Celda celda){
        celda.agregarObject(null);
        celda.setEstado();
    }

    public boolean termine(){
        for (int i = 0; i <filas ; i++) {
            for (int j = 0; j <columnas ; j++) {
                if(celdas[i][j].getMeta()!=null){
                    celdas[i][j].getMeta().verificarCaja();
                    if(!celdas[i][j].getMeta().getTengoCaja()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
