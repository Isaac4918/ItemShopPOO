package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Mostrador extends JFrame{

    int dinero=10;
    static JFrame frame;
    static JList inventario_tienda;
    static JList inventario_personaje;
    static JScrollPane scroll_tienda;
    static JScrollPane scroll_inventario;
    static JLabel velocidad;
    static JLabel vida;
    static JLabel pago;
    static JLabel label_dinero;
    static JLabel armadura;
    static JButton b_comprar;
    static JButton b_vender;

    public Mostrador(){
        //se crean las instancias principales que va a tener la ventana del mostrador de la tienda
        frame=new JFrame("Tienda");
        velocidad=new JLabel("9");
        vida=new JLabel("12");
        pago=new JLabel("15:");
        armadura=new JLabel("5");
        label_dinero=new JLabel("1519");
        b_comprar=new JButton("Comprar");
        b_vender=new JButton("Vender");
        Fondo_mostrador fondo=new Fondo_mostrador();

        //se define la fuente y el tamaño que van a tener los label que informan de las estadicas
        velocidad.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        vida.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        pago.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        armadura.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        label_dinero.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 26));


        b_comprar.setBackground(Color.BLACK);
        b_comprar.setForeground(Color.YELLOW);

        b_vender.setBackground(Color.BLACK);
        b_vender.setForeground(Color.YELLOW);

        velocidad.setForeground(Color.WHITE);
        vida.setForeground(Color.WHITE);
        pago.setForeground(Color.WHITE);
        armadura.setForeground(Color.WHITE);
        label_dinero.setForeground(Color.ORANGE);



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

        inventario_personaje.setBackground(Color.black);
        inventario_tienda.setBackground(Color.black);


        inventario_personaje.setForeground(Color.WHITE);
        inventario_tienda.setForeground(Color.WHITE);


        inventario_personaje.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
        inventario_tienda.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));


        scroll_tienda=new JScrollPane();
        scroll_inventario=new JScrollPane();

        scroll_tienda.setViewportView(inventario_tienda);
        scroll_inventario.setViewportView(inventario_personaje);


        panel_tienda.add(b_comprar);
        panel_tienda.add(b_vender);
        panel_tienda.add(scroll_inventario);
        panel_tienda.add(scroll_tienda);
        panel_tienda.add(velocidad);
        panel_tienda.add(vida);
        panel_tienda.add(pago);
        panel_tienda.add(armadura);
        panel_tienda.add(label_dinero);
        panel_tienda.add(fondo);

        fondo.setBounds(0,0,800,600);
        b_comprar.setBounds(400,501,85,49);
        b_vender.setBounds(693,250,85,49);

        scroll_inventario.setBounds(500,300,280,250);
        scroll_tienda.setBounds(0,150,400,400);

        velocidad.setBounds(540,83,200,100);
        vida.setBounds(500,106,200,100);
        pago.setBounds(588,128,200,100);
        armadura.setBounds(535,150,200,100);
        label_dinero.setBounds(700,-5,200,60);



        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setResizable(false);


        frame.add(panel_tienda);
        frame.setSize(800,600);
        frame.show();


        inventario_tienda.getSelectedIndex();
        inventario_personaje.getSelectedIndex();

    }

}
