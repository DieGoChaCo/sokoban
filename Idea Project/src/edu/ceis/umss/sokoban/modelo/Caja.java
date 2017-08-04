package edu.ceis.umss.sokoban.modelo;

public class Caja {
    private Tablero tablero;
    private Celda celda;

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public boolean mover(Direccion direccion){
        switch (direccion){
            case ABAJO:
//                System.out.println("Caja abajo");
                return mover(celda.getFila()+1,celda.getColumna());

            case ARRIBA:
//                System.out.println("Caja arriba");
                return mover(celda.getFila()-1,celda.getColumna());

            case DERECHA:
//                System.out.println("Caja derecha");
                return mover(celda.getFila(),celda.getColumna()+1);

            case IZQUIERDA:
//                System.out.println("Caja Izquierda");
                return mover(celda.getFila(),celda.getColumna()-1);

                default:
        }
        return false;
    }

    private boolean mover(int fila, int columna){
        if(validar(fila, columna)){
//            System.out.println("caja valido mov");
            tablero.limpiarCelda(celda);
            celda.setEstado();
            tablero.getCelda(fila, columna).setCaja(this);
            tablero.getCelda(fila, columna).setEstado(Estado.CAJA);
            setCelda(tablero.getCelda(fila, columna));
            return true;
        }else{
//            System.out.println("caja no valido mov");
        return false;}
    }

    private boolean validar(int fila, int columna){
//        System.out.println("Caja esta validando");
        if(fila<tablero.getFilas() && fila>=0
                && columna<tablero.getColumnas() && columna>=0){
            if(tablero.getCelda(fila, columna).getEstado() == Estado.VACIO ||
                    tablero.getCelda(fila, columna).getEstado() == Estado.META){
                return true;
            }
        }
        return false;
    }
}
