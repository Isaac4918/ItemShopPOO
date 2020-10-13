package Logica;

public class Item {

    public String nombre;
    public int precio;
    public int velocidad;
    public int vida;
    public int PagoIzquierda;
    public int PagoDerecha;
    public int armadura;
    public String categoria;

    public Item() {
        this.nombre = "nombre";
        this.precio = 100;
        this.velocidad = 2;
        this.vida = 20;
        this.PagoIzquierda = 4;
        this.PagoDerecha = 4;
        this.armadura = 10;
    }

    public Item(String nombre, int precio, int velocidad, int vida, int PagoIzquierda, int PagoDerecha, int armadura) {
        this.nombre = nombre;
        this.precio = precio;
        this.velocidad = velocidad;
        this.vida = vida;
        this.PagoIzquierda = PagoIzquierda;
        this.PagoDerecha = PagoDerecha;
        this.armadura = armadura;
    }

    public void stats(Jugador J1){
        J1.armadura += this.armadura;
        J1.vida += this.vida;
        J1.velocidad += this.velocidad;
        J1.PagoIzquierda += this.PagoIzquierda;
        J1.PagoDerecha += this.PagoDerecha;
    }

    public void stats_vender(Jugador J1){
        J1.armadura -= this.armadura;
        J1.vida -= this.vida;
        J1.velocidad -= this.velocidad;
        J1.PagoIzquierda -= this.PagoIzquierda;
        J1.PagoDerecha -= this.PagoDerecha;
    }
}