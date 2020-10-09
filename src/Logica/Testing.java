package Logica;

public class Testing {
    private static Tienda T1;
    private static Jugador J1;


    public static void main(String[] args) throws InterruptedException {
        T1 = new Tienda();
        J1 = new Jugador();
        T1.vender(0, J1);
        Thread.sleep(1000);
        J1.vender(0);
    }
}
