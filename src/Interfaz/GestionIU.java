package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GestionIU  extends JFrame {
    //Ventana ventana=new Ventana();
    Mostrador mostrador=new Mostrador();
    //static JFrame f;
    //static JList b;

    public GestionIU(){


        /*
        JFrame ventana_frame=new JFrame();
        f=new JFrame("frame");
        setTitle("Tienda");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //addMouseListener(this);
        JPanel panel_tienda=new JPanel();
        JLabel label_articulos= new JLabel("seleccione el articulo a comprar");
        String articulos[]={"bombillo          jsjs          ","propulsor      sjsj","cable sj"};
        b=new JList(articulos);
        //b.setSelectedIndex(2);
        panel_tienda.add(b);
        panel_tienda.setBackground(Color.BLACK);
        f.add(panel_tienda);
        f.setSize(300,300);
        f.show();
        b.getSelectedIndex();




        add(ventana);
        setSize(1024,576);
        setVisible(true);

*/
    }
/*
    @Override
    public void mouseClicked(MouseEvent e) {
    //mostrador.setClickX(e.getX()); //metodo que al clickear detecte la posicion X del mouse
    //mostrador.setClickY(e.getY());
    //ventana.setClickX(e.getX()); //metodo que al clickear detecte la posicion X del mouse
    //ventana.setClickY(e.getY()); //metodo que al clickear detecte la posicion y del mouse
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

*/


    public static void main(String args[]){
        GestionIU vent=new GestionIU();

    }
}

