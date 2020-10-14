package Interfaz;

import Logica.Api;
import Logica.Jugador;
import Logica.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class GestionIU  extends JFrame implements MouseListener {
    Jugador jugador=new Jugador();
    Tienda tienda=new Tienda();
    Api a1;
    Ventana ventana=new Ventana(jugador,tienda);
    static JFrame ventana_frame;
    static JLabel label_dinero;
    static JLabel pago;




    public GestionIU(){
        try {
            this.a1=new Api(tienda);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ventana_frame=new JFrame();
        label_dinero =new JLabel("Dinero:  "+jugador.dinero);
        label_dinero.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 28));
        label_dinero.setForeground(Color.ORANGE);

        pago =new JLabel(""+jugador.PagoIzquierda);
        pago.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 26));
        pago.setForeground(Color.ORANGE);

        JPanel panel_juego=new JPanel(null);
        //Ventana vent = new Ventana(jugador,tienda);



        //panel_juego.add(label_dinero);




        panel_juego.add(ventana);
        panel_juego.add(label_dinero);
        panel_juego.add(pago);
        panel_juego.setBackground(Color.BLACK);

        panel_juego.setComponentZOrder(label_dinero,1);

        ventana.setBounds(88,50,900,500);
        label_dinero.setBounds(515,0,600,60);





        ventana_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana_frame.setResizable(false);
        ventana_frame.addMouseListener(this);
        ventana_frame.add(panel_juego);
        ventana_frame.setSize(1100,576);
        ventana_frame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ventana.setClickX(e.getX()); //metodo que al clickear detecte la posicion X del mouse
        ventana.setClickY(e.getY()); //metodo que al clickear detecte la posicion y del mouse
        //System.out.println("X:"+e.getX()+"   Y:"+e.getY());
        label_dinero.setText("Dinero:  "+jugador.dinero);
        if (e.getX() < 499 && e.getX() > 0) { //si se detecta un click en la parte izquierda de la pantalla
            if (jugador.posX < 85) {
                pago.setText("+"+jugador.PagoIzquierda);
                pago.setBounds(0,e.getY()-65,100,100);
            }
        }

        if (e.getX() > 735 && e.getX() < 1100) { //si se detecta un click en la parte derecha de la pantalla
            if (jugador.posX>730) {
                pago.setText("+"+jugador.PagoDerecha);
                pago.setBounds(1007,e.getY()-65,100,100);
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }






    public static void main(String args[]){
        GestionIU vent=new GestionIU();

    }
}

