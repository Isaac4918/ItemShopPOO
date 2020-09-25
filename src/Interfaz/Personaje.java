package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Personaje extends JPanel{
    int x;

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    int y;
    int direccion; //0 si es izquierda, 1 si es derecha

}
