package Logica;

import java.util.LinkedList;

public class Jugador {

    public LinkedList inventario = new LinkedList();
    public int dinero;
    public int velocidad;
    public int vida;
    public int pagoTrabajo;
    public int armadura;


    public Jugador(){
        this.pagoTrabajo = 1;
        this.velocidad = 1;
        this.vida = 100;
        this.dinero = 1000;
        this.armadura = 20;
    }

    public void vender(int objeto){
        Item tmp = (Item) this.inventario.get(objeto);
        this.inventario.remove(objeto);
        this.dinero += (tmp.precio * 0.40);
    }


    public LinkedList getInventario() {
        return inventario;
    }
}
