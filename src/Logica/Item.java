package Logica;

public class Item {

    String nombre;
    int precio;
    int velocidad;
    int vida;
    int pagoTrabajo;
    int armadura;

    public Item() {
        this.nombre = "nombre";
        this.precio = 100;
        this.velocidad = 2;
        this.vida = 20;
        this.pagoTrabajo = 4;
        this.armadura = 10;
    }

    public Item(String nombre, int precio, int velocidad, int vida, int pagoTrabajo, int armadura) {
        this.nombre = nombre;
        this.precio = precio;
        this.velocidad = velocidad;
        this.vida = vida;
        this.pagoTrabajo = pagoTrabajo;
        this.armadura = armadura;
    }

    public void stats(Jugador J1){
        J1.armadura += this.armadura;
        J1.vida += this.vida;
        J1.velocidad += this.velocidad;
        J1.pagoTrabajo += pagoTrabajo;
    }
}