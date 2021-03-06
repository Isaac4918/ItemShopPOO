package Interfaz;

import Logica.Jugador;
import Logica.Tienda;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JPanel {
    Jugador j1;
    Tienda t2;
    public int getClickX() {
        return clickX;
    }

    public void setClickX(int clickX) {
        this.clickX = clickX;
    }

    public int getClickY() {
        return clickY;
    }

    public void setClickY(int clickY) {
        this.clickY = clickY;
    }


    private int clickX, clickY;
    public int r2_frame = 0;
    int dinero=15;

    public Ventana(Jugador j1,Tienda t2) {
        this.j1=j1;
        this.t2=t2;

    }


    public void paint(Graphics g) {
        super.paint(g);

        setDoubleBuffered(true);
        //se declaran las variable para cada una de las imagenes y frames del juego
        ImageIcon img_fondo = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo.png")).getImage());//imagen de fondo
        ImageIcon r2f1 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/R2frame1.png")).getImage());//||
        ImageIcon r2f2 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/R2frame2.png")).getImage());//||Sprites de R2D2
        ImageIcon r2f3 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/R2frame3.png")).getImage());//||

        g.drawImage(img_fondo.getImage(), 0, 0, null);







        if (clickX > 735 && clickX < 1100) { //si se detecta un click en la parte derecha de la pantalla
            if (j1.posX<730) {
                j1.posX = j1.posX + j1.velocidad; //el personaje avanza a la derecha
                r2_frame += 1;  //se cambia el frame que está R2D2
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }else{
                j1.dinero+= j1.PagoDerecha;
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }
        }

        if (clickX < 499 && clickX > 0) { //si se detecta un click en la parte izquierda de la pantalla
            if (j1.posX>85) {
                r2_frame += 1;
                j1.posX = j1.posX - j1.velocidad; //el personaje avanza a la izquierda
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }else{
                j1.dinero+= j1.PagoIzquierda;
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }
        }
        if (clickX>500 && clickX<734 && clickY>95 && clickY<187){  //si se detecta click dentro de las coordenadas del boton de tienda
            Mostrador mostrador=new Mostrador(j1,t2); //se abre la ventana del mostrador de la tienda
            clickX=-1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
            clickY=-1;
        }
        if (r2_frame == 0) {
            g.drawImage(r2f1.getImage(), j1.posX, 250, null);
        }
        if (r2_frame == 1) {
            g.drawImage(r2f2.getImage(), j1.posX, 250, null);
        }
        if (r2_frame == 2) {
            g.drawImage(r2f3.getImage(), j1.posX, 250, null);
            r2_frame = 0;
        }

        repaint();


    }
}