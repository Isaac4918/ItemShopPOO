package Logica;

import java.io.IOException;

public class Testing {

    public static void main(String[] args) throws InterruptedException, IOException {
        Tienda T1 = new Tienda();
        Api C1 = new Api(T1);
        T1.mostrar();


    }
}
