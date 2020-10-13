package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fondo_mostrador extends JPanel {


    public void paint(Graphics g) {
        super.paint(g);

        setDoubleBuffered(true);
        //se declaran las variable para cada una de las imagenes y frames del juego
        ImageIcon img_fondo = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo_mostrador.png")).getImage());//imagen de fondo
        g.drawImage(img_fondo.getImage(), 0, 0, null);
    }


}