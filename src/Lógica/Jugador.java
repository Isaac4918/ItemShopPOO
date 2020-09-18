package Lógica;

import java.util.LinkedList;

public class Jugador {

    LinkedList inventario = new LinkedList();
    float dinero;
    int velocidad;
    int vida;
    int pagoTrabajo;
    int armadura;


    public Jugador(){
        this.pagoTrabajo = 1;
        this.velocidad = 1;
        this.vida = 100;
        this.dinero = 1000;


    }
}
