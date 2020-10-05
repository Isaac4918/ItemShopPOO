package Logica;

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
        this.armadura = 50;
    }

    public void Vender(int objeto){
        System.out.println("****************************************");
        System.out.println("Inventario 1:");
        mostrar(this.inventario);
        System.out.println("Dinero:" + this.dinero);
        System.out.println("****************************************");
        Item tmp = (Item) this.inventario.get(objeto);
        this.inventario.remove(objeto);
        this.dinero += (tmp.precio * 0.40);
        System.out.println("Venta efectuada");
        System.out.println("****************************************");
        System.out.println("Inventario 2:");
        mostrar(this.inventario);
        System.out.println("Dinero:" + this.dinero);
    }

    public void mostrar(LinkedList mostrar){
        String aux = "";
        for(int i = 0; i< mostrar.size(); i++){
            Item tmp = (Item) mostrar.get(i);
            aux += tmp.nombre;
            aux += ", ";
        }
        System.out.println(aux);
    }
}
