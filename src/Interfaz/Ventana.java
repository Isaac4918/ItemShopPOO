package Interfaz;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JPanel    {
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


    private int clickX,clickY;
    public int r2_posx=500;
    public int r2_frame=0;

    public Ventana() {
    }


    public void paint(Graphics g){
        super.paint(g);

        setDoubleBuffered(true);
        //se declaran las variable para cada una de las imagenes y frames del juego
        ImageIcon img_fondo=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg")).getImage());//imagen de fondo
        ImageIcon r2f1 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/movimiento.gif")).getImage());//||
        ImageIcon r2f2 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/R2frame2.png")).getImage());//||Sprites de R2D2
        ImageIcon r2f3 = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/R2frame3.png")).getImage());//||

        g.drawImage(img_fondo.getImage(),0,0,null);


        if(clickX>512 && clickX<1024){ //si se detecta un click en la parte izquierda de la pantalla
            r2_posx=r2_posx+40; //el personaje avanza a la izquierda
            r2_frame+=1;
            setClickX(2000);
        }

        if(clickX<512 && clickX>0){

        }
        if (r2_frame==0){
            g.drawImage(r2f1.getImage(),r2_posx, 250, null);
        }
        if (r2_frame==1){
            g.drawImage(r2f3.getImage(),r2_posx, 250, null);
        }
        if (r2_frame==2) {
            g.drawImage(r2f3.getImage(),r2_posx, 250, null);
            r2_frame=0;
        }

        repaint();


    }







}
