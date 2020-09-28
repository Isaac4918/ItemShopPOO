package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Mostrador extends JFrame{

    static JFrame frame;
    static JList inventario_tienda;
    static JList inventario_personaje;
    static JScrollPane scroll_tienda;
    static JScrollPane scroll_inventario;
    static JLabel velocidad;
    static JLabel vida;
    static JLabel pago;
    static JLabel armadura;
    static JButton b_comprar;

    public Mostrador(){
        //se crean las instancias principales que va a tener la ventana del mostrador de la tienda
        frame=new JFrame("frame");
        velocidad=new JLabel("9");
        vida=new JLabel("12");
        pago=new JLabel("15:");
        armadura=new JLabel("5");
        b_comprar=new JButton("Comprar");
        Fondo_mostrador fondo=new Fondo_mostrador();

        //se define la fuente y el tamaño que van a tener los label que informan de las estadicas
        velocidad.setFont(new Font("Helvetica", Font.PLAIN, 14));
        vida.setFont(new Font("Helvetica", Font.PLAIN, 14));
        pago.setFont(new Font("Helvetica", Font.PLAIN, 14));
        armadura.setFont(new Font("Helvetica", Font.PLAIN, 14));



        JPanel panel_tienda=new JPanel(null);

        JLabel label_articulos= new JLabel("seleccione el articulo a comprar");
        String articulos[]={"bombillo          jsjs          ","propulsor      sjsj","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable ",
                "bombillo          fusil          ","propulsor      fusil","cable ",
                "bombillo          fusil          ","propulsor      fusil","cable ",
                "bombillo          fusil          ","propulsor      fusil","cable ",
                "bombillo          fusil          ","propulsor      fusil","cable ",
                "bombillo          fusil          ","propulsor      fusil","cable ",};

        String string_inventario[]={"bombillo          jsjs          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",
                "bombillo          fusil          ","propulsor      fusil","cable sj",};



        inventario_tienda=new JList(articulos);
        inventario_personaje=new JList(string_inventario);


        scroll_tienda=new JScrollPane();
        scroll_inventario=new JScrollPane();

        scroll_tienda.setViewportView(inventario_tienda);
        scroll_inventario.setViewportView(inventario_personaje);


        panel_tienda.add(b_comprar);
        panel_tienda.add(scroll_inventario);
        panel_tienda.add(scroll_tienda);
        panel_tienda.add(velocidad);
        panel_tienda.add(vida);
        panel_tienda.add(pago);
        panel_tienda.add(armadura);
        panel_tienda.add(fondo);

        fondo.setBounds(0,0,800,600);
        b_comprar.setBounds(400,500,80,49);

        scroll_inventario.setBounds(500,300,280,250);
        scroll_tienda.setBounds(0,150,400,400);

        velocidad.setBounds(540,83,200,100);
        vida.setBounds(500,106,200,100);
        pago.setBounds(583,126,200,100);
        armadura.setBounds(535,149,200,100);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.add(panel_tienda);
        frame.setSize(800,600);
        frame.show();


        inventario_tienda.getSelectedIndex();
        inventario_personaje.getSelectedIndex();

    }

}
