package edu.ceis.umss.sokoban.modelo;

public class Meta {

    private boolean tengoCaja;
    private Celda celda;

    public boolean getTengoCaja(){
        return tengoCaja;
    }

    public Meta(){
        tengoCaja = false;
    }

    public void verificarCaja(){
        if(celda.getCaja()!=null){
            tengoCaja = true;
        }else{
            tengoCaja = false;
        }
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }
}
