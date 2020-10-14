package Logica;

import java.util.LinkedList;

public class Jugador {

    public LinkedList inventario = new LinkedList();
    public LinkedList equipado = new LinkedList();

    public int dinero;
    public int velocidad;
    public int vida;
    public int PagoIzquierda;
    public int PagoDerecha;
    public int armadura;
    public int posX;


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Jugador(){
        this.PagoIzquierda = 2;
        this.PagoDerecha = 2;
        this.velocidad = 50;
        this.vida = 100;
        this.dinero = 1500;
        this.armadura = 20;
        this.posX=550;
    }

    public void vender(int objeto){
        Item tmp = (Item) this.inventario.get(objeto);
        tmp.stats_vender(this);
        this.inventario.remove(objeto);
        this.dinero += (tmp.precio * 0.40);
    }

    public void equipar(int objeto){
        Item tmp = (Item) this.inventario.get(objeto);

        if (!tmp.categoria.equals("Consumible")) {
            this.equipado.add(tmp);
        }
        this.inventario.remove(objeto);
        tmp.stats(this);

    }
    public void desequipar(int objeto){
        if(this.equipado.size()>0){
            Item tmp = (Item) this.equipado.get(objeto);
            this.inventario.add(tmp);
            this.equipado.remove(objeto);
            tmp.stats_vender(this);
        }
    }



    public LinkedList getInventario() {
        return inventario;
    }
}
