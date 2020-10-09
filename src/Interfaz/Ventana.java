package Interfaz;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JPanel {
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
    public int r2_posx = 500;
    public int r2_frame = 0;
    static JLabel label_toque;
    int dinero=15;

    public Ventana() {
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


        String moni=new String("15");
        g.drawString(moni,60,60);


        if (clickX > 631 && clickX < 1024) { //si se detecta un click en la parte derecha de la pantalla
            if (r2_posx<800) {
                r2_posx = r2_posx + 40; //el personaje avanza a la derecha
                r2_frame += 1;  //se cambia el frame que está R2D2
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }else{
                System.out.println("Ganando guita a la derecha");
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }
        }

        if (clickX < 389 && clickX > 0) { //si se detecta un click en la parte izquierda de la pantalla
            if (r2_posx>150) {
                r2_frame += 1;
                r2_posx = r2_posx - 40; //el personaje avanza a la izquierda
                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }else{
                System.out.println("Ganando guita izquierda");
                label_toque.setBounds(clickX,clickY,100,100);

                clickX = -1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
                clickY = -1;
            }
        }
        if (clickX>390 && clickX<630 && clickY>58 && clickY<148){  //si se detecta click dentro de las coordenadas del boton de tienda
            Mostrador mostrador=new Mostrador(); //se abre la ventana del mostrador de la tienda
            System.out.println("equis"+clickY);
            clickX=-1;  //las coordenadas del click se reinician y se colocan en una posicion neutral
            clickY=-1;
        }
        if (r2_frame == 0) {
            g.drawImage(r2f1.getImage(), r2_posx, 250, null);
        }
        if (r2_frame == 1) {
            g.drawImage(r2f2.getImage(), r2_posx, 250, null);
        }
        if (r2_frame == 2) {
            g.drawImage(r2f3.getImage(), r2_posx, 250, null);
            r2_frame = 0;
        }

        repaint();


    }
}