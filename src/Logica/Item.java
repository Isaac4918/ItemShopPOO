package Logica;

public class Item {

    String nombre;
    String color;
    float precio;
    Item next;

    public Item(String nombre, String color, float precio){
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}