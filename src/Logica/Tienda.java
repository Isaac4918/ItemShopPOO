package Logica;


import java.util.LinkedList;

public class Tienda {

    LinkedList inventario = new LinkedList();

    public Tienda(){
        Item I1 = new Item();
        Item I2 = new Item();
        Item I3 = new Item();
        Item I4 = new Item();

        inventario.add(I1);
        inventario.add(I2);
        inventario.add(I3);
        inventario.add(I4);
    }

    public void vender(int objeto, Jugador comprador){
        //verVenta(comprador);
        Item tmp = (Item) this.inventario.get(objeto);
        if(comprador.dinero >= tmp.precio){
            comprador.inventario.add(tmp);
            this.inventario.remove(objeto);
            comprador.dinero -= tmp.precio;
            tmp.stats(comprador);

            /*System.out.println("==================");
            System.out.println("Vida: " + comprador.vida);
            System.out.println("Armadura: " + comprador.armadura);
            System.out.println("Velocidad: " + comprador.velocidad);
            System.out.println("Pago: " + comprador.pagoTrabajo);
            System.out.println("==================");
            verVenta(comprador);*/
            System.out.println("Compra efectuada");

        }

        else{
            System.out.println("Dinero insuficiente");
        }
    }

 /*   public void mostrar(LinkedList mostrar){
        String aux = "";
        for(int i = 0; i< mostrar.size(); i++){
            Item tmp = (Item) mostrar.get(i);
            aux += tmp.nombre;
            aux += ", ";
        }
        System.out.println(aux);
    }*/

    public LinkedList getItemsTienda() {
        return inventario;
    }
}