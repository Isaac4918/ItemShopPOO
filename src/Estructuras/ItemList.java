package Estructuras;

import Logica.Item;

public class ItemList {
    public Item head;
    int lenght = 0;

    public ItemList() {
    }

    public void add(Item objeto){
        if(this.head == null){
            this.head = objeto;
        }
        else{
            Item tmp = this.head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(objeto);
        }
        lenght++;
    }

    public Item index(int index){
        Item tmp = this.head;
        int pos = 0;

        if (index == 0){
            return this.head;
        }
        else{
            while (pos < index){
                tmp = tmp.getNext();
                pos++;
            }
        }
        return tmp;
    }

    public void delete(int index){
        Item tmp = this.head;
        int pos = 0;

        if(index == 0){
            this.head = this.head.getNext();
        }
        else{
            while (pos < index-1){
                tmp = tmp.getNext();
                pos++;
            }
        }
        tmp.setNext(tmp.getNext().getNext());
        lenght--;
    }

    public void printL(){
        StringBuilder lista = new StringBuilder("[");
        Item tmp = this.head;

        while (tmp.getNext() != null){
            lista.append(tmp.getNombre());
            lista.append(", ");
            tmp = tmp.getNext();
        }

        System.out.println(lista);
    }

    public int size() {
        return lenght;
    }
}
