package edu.ceis.umss.sokoban.modelo;

public class Juego {
    private Tablero tablero;
    private Jugador jugador;

    public Juego(Jugador jugador){
        this.jugador = jugador;
        iniciarTablero();
    }

    private void iniciarTablero(){
        char[][] stage ={
                {'o','o','o','o','o','o','o','o','o','o','o','o','n','n'},
                {'o','f','f','v','v','o','v','v','v','v','v','o','o','o'},
                {'o','f','f','v','v','o','v','c','v','v','c','v','v','o'},
                {'o','f','f','v','v','o','c','o','o','o','o','v','v','o'},
                {'o','f','f','v','v','v','v','j','v','o','o','v','v','o'},
                {'o','f','f','v','v','o','v','o','v','v','c','v','o','o'},
                {'o','o','o','o','o','o','v','o','o','c','v','c','v','o'},
                {'n','n','o','v','c','v','v','c','v','c','v','c','v','o'},
                {'n','n','o','v','v','v','v','o','v','v','v','v','v','o'},
                {'n','n','o','o','o','o','o','o','o','o','o','o','o','o'},
        };

//        char [][] stage = {
//                {'o','o','o','o','o','o','o','o','o','o','o','o','n','n'},
//                {'o','v','v','v','v','o','v','v','v','v','v','o','o','o'},
//                {'o','v','v','v','v','o','v','c','v','v','c','v','v','o'},
//                {'o','v','v','v','v','o','v','o','o','o','o','v','v','o'},
//                {'o','f','c','j','v','v','v','v','v','o','o','v','v','o'},
//                {'o','v','v','v','v','o','v','o','v','v','c','v','o','o'},
//                {'o','o','o','o','o','o','v','o','o','c','v','c','v','o'},
//                {'n','n','o','v','c','v','v','c','v','c','v','c','v','o'},
//                {'n','n','o','v','v','v','v','o','v','v','v','v','v','o'},
//                {'n','n','o','o','o','o','o','o','o','o','o','o','o','o'},
//        };
        tablero = new Tablero(stage,jugador);
    }

    public Tablero getTablero() {
        return tablero;
    }

}
