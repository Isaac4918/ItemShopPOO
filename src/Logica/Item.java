package Logica;

public class Item {

    String nombre;
    String color;
    float precio;
    float velocidad;
    int vida;
    float pagoTrabajo;
    int armadura;

    public Item() {
        this.nombre = "nombre";
        this.color = "color";
        this.precio = 100;
        this.velocidad = 2;
        this.vida = 20;
        this.pagoTrabajo = 4;
        this.armadura = 10;
    }

    public Item(String nombre) {
        this.nombre = nombre;
        this.color = "color";
        this.precio = 100;
        this.velocidad = 0;
        this.vida = 0;
        this.pagoTrabajo = 0;
        this.armadura = 0;
    }

    public Item(String nombre, String color, float precio, float velocidad, int vida, float pagoTrabajo, int armadura) {
        this.nombre = nombre;
        this.color = color;
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