package Lógica;

import java.util.LinkedList;

public class Tienda {

    LinkedList inventario = new LinkedList();

    public Tienda(){
        Item I1 = new Item("I1", "Negro", 1000);
        Item I2 = new Item("I2", "Negro", 1000);
        Item I3 = new Item("I3", "Negro", 1000);
        Item I4 = new Item("I4", "Negro", 1000);
        Item I5 = new Item("I5", "Negro", 1000);
        Item I6 = new Item("I6", "Negro", 1000);
        this.inventario.add(I1);
        this.inventario.add(I2);
        this.inventario.add(I3);
        this.inventario.add(I4);
        this.inventario.add(I5);
        this.inventario.add(I6);

    }

    public void Vender(int objeto, Jugador comprador){
        verVenta(comprador);
        Item tmp = (Item) this.inventario.get(objeto);
        if(comprador.dinero >= tmp.precio){
            comprador.inventario.add(tmp);
            this.inventario.remove(objeto);
            comprador.dinero -= tmp.precio;
            System.out.println("Compra efectuada");
            verVenta(comprador);
        }
        else{
            System.out.println("Dinero insuficiente");
        }
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

    public void verVenta(Jugador comprador){
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("==================================");
        System.out.println("Inventario de la tienda: ");
        mostrar(this.inventario);
        System.out.println("==================================");
        System.out.println("Inventario del jugador: ");
        mostrar(comprador.inventario);
        System.out.println("==================================");
        System.out.println("Dinero: " + comprador.dinero);
        System.out.println("==================================");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
    }

}