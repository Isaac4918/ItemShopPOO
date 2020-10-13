package Logica;


import java.util.LinkedList;

public class Tienda {

    public LinkedList inventario = new LinkedList();

    public Tienda(){
    }

    public void vender(int objeto, Jugador comprador){
        Item tmp = (Item) this.inventario.get(objeto);
        if(comprador.dinero >= tmp.precio){
            comprador.inventario.add(tmp);
            this.inventario.remove(objeto);
            comprador.dinero -= tmp.precio;
            //tmp.stats(comprador);
            System.out.println("Compra efectuada");

        }

        else{
            System.out.println("Dinero insuficiente");
        }
    }

    public void mostrar(){
        String aux = "";
        for(int i = 0; i< inventario.size(); i++){
            Item tmp = (Item) inventario.get(i);
            aux += "Nombre: " + tmp.nombre + "\n";
            aux += "Vida: " + tmp.vida + "\n";
            aux += "Armadura: " + tmp.armadura + "\n";
            aux += "Velocidad: " + tmp.velocidad + "\n";
            aux += "Pago: " + tmp.PagoIzquierda + "\n";
            aux += "==============================\n";
        }
        System.out.println(aux);
    }

    public LinkedList getItemsTienda() {
        return inventario;
    }
}