package Interfaz;

import Logica.Item;
import Logica.Jugador;
import Logica.Tienda;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;


public class Mostrador extends JFrame implements ActionListener {
    Jugador jug;
    Tienda t1;
    int index_personaje=0;
    int index_tienda=0;
    int index_equipado=0;
    static JFrame frame;
    static JList inventario_tienda;
    static JList inventario_personaje;
    static JList inv_equipado;
    static JScrollPane scroll_tienda;
    static JScrollPane scroll_inventario;
    static JScrollPane scroll_equipado;
    static JLabel velocidad;
    static JLabel vida;
    static JLabel pagoi;
    static JLabel pagod;
    static JLabel armadura;
    static JLabel velocidad_rel;
    static JLabel vida_rel;
    static JLabel pagoi_rel;
    static JLabel pagod_rel;
    static JLabel armadura_rel;
    static JLabel label_dinero;
    static JButton b_comprar;
    static JButton b_vender;
    static JButton b_equipar;
    static JButton b_desequipar;

    public Mostrador(Jugador jug1,Tienda tienda){
        this.jug=jug1;
        this.t1=tienda;
        //se crean las instancias principales que va a tener la ventana del mostrador de la tienda
        frame=new JFrame("Tienda");
        velocidad=new JLabel(""+jug.velocidad);
        vida=new JLabel(""+jug.vida);
        pagoi=new JLabel(""+jug.PagoIzquierda);
        pagod=new JLabel(""+jug.PagoIzquierda);

        armadura=new JLabel(""+jug.armadura);
        //se declaran las caracteristicas relativas sumadas por el item seleccionado
        velocidad_rel=new JLabel("9");
        vida_rel=new JLabel("12");
        pagoi_rel=new JLabel("15");
        pagod_rel=new JLabel("15");
        armadura_rel=new JLabel("5");

        label_dinero=new JLabel(""+jug.dinero);
        b_comprar=new JButton("Comprar");
        b_vender=new JButton("Vender");
        b_equipar=new JButton("Equipar");
        b_desequipar=new JButton("Desequipar");

        Fondo_mostrador fondo=new Fondo_mostrador();

        //se define la fuente y el tamaño que van a tener los label que informan de las estadicas
        velocidad.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        vida.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        pagoi.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        pagod.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        armadura.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        label_dinero.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 26));

        velocidad_rel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        vida_rel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        pagoi_rel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        pagod_rel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));

        armadura_rel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));


        b_comprar.setBackground(Color.BLACK);
        b_comprar.setForeground(Color.YELLOW);


        b_vender.setBackground(Color.BLACK);
        b_vender.setForeground(Color.YELLOW);

        b_equipar.setBackground(Color.BLACK);
        b_equipar.setForeground(Color.YELLOW);

        b_desequipar.setBackground(Color.BLACK);
        b_desequipar.setForeground(Color.YELLOW);


        velocidad.setForeground(Color.WHITE);
        vida.setForeground(Color.WHITE);
        pagoi.setForeground(Color.WHITE);
        pagod.setForeground(Color.WHITE);

        armadura.setForeground(Color.WHITE);

        velocidad_rel.setForeground(Color.WHITE);
        vida_rel.setForeground(Color.WHITE);
        pagoi_rel.setForeground(Color.WHITE);
        pagod_rel.setForeground(Color.WHITE);

        armadura_rel.setForeground(Color.WHITE);


        label_dinero.setForeground(Color.ORANGE);



        JPanel panel_tienda=new JPanel(null);

        JLabel label_articulos= new JLabel("seleccione el articulo a comprar");
        String articulos[]=new String[t1.inventario.size()];

        String string_inventario[]=new String[jug.inventario.size()];

        String string_equipado[]=new String[jug.equipado.size()];

        for (int i=0;i<jug.equipado.size();i++){
            articulos[i]= ( (Item) jug.equipado.get(i)).nombre;

        }

        for (int i=0;i<t1.inventario.size();i++){
            articulos[i]= ( (Item) t1.inventario.get(i)).nombre;

        }

        for (int j=0;j<jug.inventario.size();j++){
            string_inventario[j]= ( (Item) jug.inventario.get(j)).nombre;

        }


        inventario_tienda=new JList(articulos);
        inventario_personaje=new JList(string_inventario);
        inv_equipado=new JList(string_equipado);

        inventario_personaje.setBackground(Color.black);
        inventario_tienda.setBackground(Color.black);
        inv_equipado.setBackground(Color.BLACK);


        inventario_personaje.setForeground(Color.WHITE);
        inventario_tienda.setForeground(Color.WHITE);
        inv_equipado.setForeground(Color.WHITE);


        inventario_personaje.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
        inventario_tienda.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
        inv_equipado.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));

        scroll_tienda=new JScrollPane();
        scroll_inventario=new JScrollPane();
        scroll_equipado=new JScrollPane();

        scroll_tienda.setViewportView(inventario_tienda);
        scroll_inventario.setViewportView(inventario_personaje);
        scroll_equipado.setViewportView(inv_equipado);

        inventario_personaje.setSelectedIndex(index_personaje);
        inventario_tienda.setSelectedIndex(index_tienda);
        inv_equipado.setSelectedIndex(index_equipado);
        panel_tienda.add(b_comprar);
        panel_tienda.add(b_vender);
        panel_tienda.add(b_equipar);
        panel_tienda.add(b_desequipar);
        panel_tienda.add(scroll_inventario);
        panel_tienda.add(scroll_tienda);
        panel_tienda.add(scroll_equipado);
        panel_tienda.add(velocidad);
        panel_tienda.add(vida);
        panel_tienda.add(pagoi);
        panel_tienda.add(pagod);
        panel_tienda.add(armadura);
        panel_tienda.add(velocidad_rel);
        panel_tienda.add(vida_rel);
        panel_tienda.add(pagoi_rel);
        panel_tienda.add(pagod_rel);

        panel_tienda.add(armadura_rel);
        panel_tienda.add(label_dinero);
        panel_tienda.add(fondo);


        fondo.setBounds(0,0,1050,600);
        b_comprar.setBounds(400,501,85,49);
        b_vender.setBounds(510,500,80,49);
        b_equipar.setBounds(690,500,80,49);
        b_desequipar.setBounds(910,500,95,49);

        b_comprar.addActionListener(this);
        b_vender.addActionListener(this);
        b_equipar.addActionListener(this);
        b_desequipar.addActionListener(this);



        scroll_inventario.setBounds(500,230,280,250);
        scroll_tienda.setBounds(0,150,400,400);
        scroll_equipado.setBounds(800,230,230,250);


        velocidad.setBounds(820,42,200,100);
        vida.setBounds(820,65,200,100);
        armadura.setBounds(820,88,200,100);
        pagoi.setBounds(820,111,200,100);
        pagod.setBounds(820,134,200,100);



        velocidad_rel.setBounds(880,42,200,100);
        vida_rel.setBounds(880,65,200,100);
        armadura_rel.setBounds(880,88,200,100);
        pagoi_rel.setBounds(880,111,200,100);
        pagod_rel.setBounds(880,134,200,100);


        label_dinero.setBounds(945,-5,200,60);



        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setResizable(false);


        frame.add(panel_tienda);
        frame.setSize(1050,600);
        frame.show();


        actualizar();
    }
    public void actualizar() {
        String articulos[]=new String[t1.inventario.size()];

        String string_inventario[]=new String[jug.inventario.size()];

        String string_equipado[]=new String[jug.equipado.size()];

        inventario_tienda=new JList(articulos);
        inventario_personaje=new JList(string_inventario);
        inv_equipado=new JList(string_equipado);

        inventario_tienda.setSelectedIndex(index_tienda);
        inventario_personaje.setSelectedIndex(index_personaje);
        inv_equipado.setSelectedIndex(index_equipado);


        inventario_personaje.setBackground(Color.black);
        inventario_tienda.setBackground(Color.black);
        inv_equipado.setBackground(Color.BLACK);


        inventario_personaje.setForeground(Color.WHITE);
        inventario_tienda.setForeground(Color.WHITE);
        inv_equipado.setForeground(Color.WHITE);

        inventario_personaje.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
        inventario_tienda.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));
        inv_equipado.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 18));

        for (int i=0;i<t1.inventario.size();i++){
            articulos[i]= ( (Item) t1.inventario.get(i)).nombre+"          "+( (Item) t1.inventario.get(i)).precio;

        }

        for (int j=0;j<jug.inventario.size();j++){
            string_inventario[j]= ( (Item) jug.inventario.get(j)).nombre;

        }

        for (int j=0;j<jug.equipado.size();j++){
            string_equipado[j]= ( (Item) jug.equipado.get(j)).nombre;

        }

        inventario_tienda.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    index_personaje=inventario_personaje.getSelectedIndex();
                    index_tienda=inventario_tienda.getSelectedIndex();
                    actualizar();
                }

            }
        });
        inventario_personaje.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    index_personaje=inventario_personaje.getSelectedIndex();
                    index_tienda=inventario_tienda.getSelectedIndex();
                    actualizar();
                }

            }
        });

        scroll_tienda.setViewportView(inventario_tienda);
        scroll_inventario.setViewportView(inventario_personaje);
        scroll_equipado.setViewportView(inv_equipado);
        label_dinero.setText(""+jug.dinero);
        velocidad.setText(""+jug.velocidad);
        vida.setText(""+jug.vida);
        pagoi.setText(""+jug.PagoIzquierda);
        pagod.setText(""+jug.PagoDerecha);

        armadura.setText(""+jug.armadura);
        int index=inventario_tienda.getSelectedIndex();
        int velocidad_obj=((Item) t1.inventario.get(index)).velocidad;
        int vida_obj=((Item) t1.inventario.get(index)).vida;
        int pago_objI= ((Item) t1.inventario.get(index)).PagoIzquierda;
        int pago_objD= ((Item) t1.inventario.get(index)).PagoDerecha;
        int armadura_obj=((Item) t1.inventario.get(index)).armadura;



        int cambio_velocidad=jug.velocidad+ velocidad_obj;
        int cambio_vida=jug.vida+vida_obj;
        int cambio_pagoi=jug.PagoIzquierda +pago_objI;
        int cambio_pagod=jug.PagoDerecha +pago_objD;
        int cambio_armadura=jug.armadura+armadura_obj;

        if (cambio_velocidad>= jug.velocidad){
            velocidad_rel.setForeground(Color.GREEN);
        }else{velocidad_rel.setForeground(Color.RED);}

        if (cambio_vida>= jug.vida){
            vida_rel.setForeground(Color.GREEN);
        }else{vida_rel.setForeground(Color.RED);}

        if (cambio_pagoi>= jug.PagoIzquierda){
            pagoi_rel.setForeground(Color.GREEN);
        }else{pagoi_rel.setForeground(Color.RED);}

        if (cambio_pagod>= jug.PagoDerecha){
            pagod_rel.setForeground(Color.GREEN);
        }else{pagod_rel.setForeground(Color.RED);}

        if (cambio_armadura>= jug.armadura){
            armadura_rel.setForeground(Color.GREEN);
        }else{armadura_rel.setForeground(Color.RED);}


        velocidad_rel.setText(""+cambio_velocidad);
        vida_rel.setText(""+cambio_vida);
        pagoi_rel.setText(""+cambio_pagoi);
        pagod_rel.setText(""+cambio_pagod);
        armadura_rel.setText(""+cambio_armadura);
    }




    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b_comprar){
            if (t1.inventario.size()!=0) {
                t1.vender(inventario_tienda.getSelectedIndex(), jug);
                System.out.println("inventario total de la tienda= " + t1.inventario.size());
                inventario_personaje.setSelectedIndex(0);
                inventario_tienda.setSelectedIndex(0);
                actualizar();
            }

        }

        if (e.getSource()==b_vender){
            if (jug.inventario.size()!=0) {
                System.out.println("vendiendo " + inventario_personaje.getSelectedIndex());
                jug.vender(inventario_personaje.getSelectedIndex());
                inventario_personaje.setSelectedIndex(0);
                inventario_tienda.setSelectedIndex(0);
                actualizar();
            }
        }
        if (e.getSource()==b_equipar){
            if(jug.inventario.size()!=0){
                jug.equipar(inventario_personaje.getSelectedIndex());
                inventario_personaje.setSelectedIndex(0);
                actualizar();
            }
        }
        if (e.getSource()==b_desequipar){
            if (jug.equipado.size()!=0) {
                jug.desequipar(inv_equipado.getSelectedIndex());
                inv_equipado.setSelectedIndex(0);
                actualizar();
            }
        }


    }

}