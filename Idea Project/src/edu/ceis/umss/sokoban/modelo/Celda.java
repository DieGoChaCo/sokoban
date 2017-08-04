package edu.ceis.umss.sokoban.modelo;

public class Celda {
    private Jugador jugador;
    private Caja caja;
    private Meta meta;
    private Estado estado;
    private int fila;
    private int columna;

    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void setEstado(){
        if(meta!= null){
            estado = Estado.META;
        }else if(jugador != null){
            estado = Estado.JUGADOR;
        }
        else if(caja != null){
            estado = Estado.CAJA;
        }else
            estado = Estado.VACIO;
    }

    public void agregarObject(Object object){
        if(object instanceof Jugador){
            jugador = (Jugador) object;
            jugador.setCelda(this);
        }
        else if(object instanceof Caja){
            caja = (Caja)object;
            caja.setCelda(this);
        }
        else if(object instanceof Meta){
            meta = (Meta)object;
            meta.setCelda(this);
        }
        else if(object == null){
            jugador = null;
            caja = null;
        }
        setEstado();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
