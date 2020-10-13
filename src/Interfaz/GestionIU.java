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
    JLabel label_dinero;






    public GestionIU(){
        try {
            this.a1=new Api(tienda);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame ventana_frame=new JFrame();
        label_dinero =new JLabel("150");
        label_dinero.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 26));
        label_dinero.setForeground(Color.ORANGE);

        JPanel panel_juego=new JPanel(null);
        panel_juego.add(label_dinero);
        label_dinero.setBounds(25,25,200,200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        add(panel_juego);
        add(ventana);
        setSize(1024,576);
        setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ventana.setClickX(e.getX()); //metodo que al clickear detecte la posicion X del mouse
        ventana.setClickY(e.getY()); //metodo que al clickear detecte la posicion y del mouse
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

