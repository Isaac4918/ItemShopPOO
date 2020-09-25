package Lógica;

import java.util.LinkedList;

public class Tienda {

    LinkedList inventario = new LinkedList();

    public Tienda(){

    }

    public void Vender(int objeto, Jugador comprador){
        verVenta(comprador);
        Item tmp = (Item) this.inventario.get(objeto);
        if(comprador.dinero >= tmp.precio){
            comprador.inventario.add(tmp);
            this.inventario.remove(objeto);
            comprador.dinero -= tmp.precio;
            System.out.println("Compra efectuada");
            //verVenta(comprador);
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