package edu.ceis.umss.sokoban.controlador;

import edu.ceis.umss.sokoban.modelo.Direccion;
import edu.ceis.umss.sokoban.modelo.Juego;
import edu.ceis.umss.sokoban.modelo.Jugador;
import java.util.Scanner;
/**
 * @autor DieGoChaCo
 * O = Muro
 * J = Jugador
 * C = Caja
 * X = META(donde tiene q llegar la caja)
 * '-' = Vacio
 * ' ' = nada(las esquinas q no tienen nada)
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        Jugador jugador = new Jugador("DieGoChaCo");
        Juego juego = new Juego(jugador);

        Scanner sc = new Scanner(System.in);
        juego.getTablero().mostrar();
        String control = "";
        boolean termino = juego.getTablero().termine();
        while(!termino){
            control = sc.nextLine();
            if(control.equals("q")){break;}
            switch (control){
                case "w":
                    jugador.mover(Direccion.ARRIBA);
                    break;
                case "s":
                    jugador.mover(Direccion.ABAJO);
                    break;
                case "a":
                    jugador.mover(Direccion.IZQUIERDA);
                    break;
                case "d":
                    jugador.mover(Direccion.DERECHA);
                    break;
                    default:
            }
            juego.getTablero().mostrar();
            termino = juego.getTablero().termine();
        }
        if(termino){
            System.out.println("ganaste");
        }
        else {
            System.out.println("intenta otra vez");
        }
    }
}

