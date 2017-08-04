package edu.ceis.umss.sokoban.modelo;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private Celda celda;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void mover(Direccion direccion){
        switch (direccion){
            case IZQUIERDA:
                mover(celda.getFila(),celda.getColumna()-1, direccion);
//                 System.out.println("izquierda");
                break;
            case DERECHA:
                mover(celda.getFila(),celda.getColumna()+1, direccion);
//                 System.out.println("derecha");
                break;
            case ARRIBA:
                mover(celda.getFila()-1,celda.getColumna(), direccion);
//                 System.out.println("arriba");
                break;
            case ABAJO:
                mover(celda.getFila()+1,celda.getColumna(), direccion);
//                 System.out.println("abajo");
                break;
                default:
        }
    }

    private void mover(int fila, int columna,Direccion direccion){
        if(validar(fila,columna)){
//            System.out.println(" valido");
            if(tablero.getCelda(fila, columna).getCaja()!=null){
//                System.out.println(" es caja");
                if(tablero.getCelda(fila, columna).getCaja().mover(direccion)) {
                    tablero.limpiarCelda(celda);
                    celda.setEstado();
                    tablero.getCelda(fila, columna).setJugador(this);
                    tablero.getCelda(fila, columna).setEstado(Estado.JUGADOR);
                    setCelda(tablero.getCelda(fila, columna));
//                    System.out.println(" caja y jugador se movieron");
                }
            }else{
                    tablero.limpiarCelda(celda);
                    celda.setEstado();
                    tablero.getCelda(fila, columna).setJugador(this);
                    tablero.getCelda(fila, columna).setEstado(Estado.JUGADOR);
                    setCelda(tablero.getCelda(fila, columna));
//                    System.out.println(" mover");
            }
        }else {
//            System.out.println("no valido");
        }
    }

    private boolean validar(int fila, int columna){
        if(fila < tablero.getFilas() && fila >=0
                && columna < tablero.getColumnas() && columna >= 0){
            if(tablero.getCelda(fila, columna).getEstado()!=Estado.OBSTACULO){
                return true;
            }
        }
        return false;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }
}
