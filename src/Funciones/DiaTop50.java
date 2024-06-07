package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class DiaTop50 {

    public static MyList<Song> hashDT50(String fecha, HashImpl<String, MyList<Song>> hash1) {
        MyList<Song> lista = hash1.searchNodo(fecha).getData();
        HashImpl<Song,Integer> hash = new HashImpl<>(100);
        MyList<Song> top5 = new MyLinkedListImpl<>();

        for (int i = 0; i <= lista.size(); i++) {
            if (hash.search(lista.get(i)) == -1) {
                hash.insert(lista.get(i),0);
            }
            int var = hash.searchNodo(lista.get(i)).getData();
            hash.searchNodo(lista.get(i)).setData(var+1);
            int var2 = hash.searchNodo(lista.get(i)).getData();

            if (var2 > hash.searchNodo(top5.get(0)).getData()) {
                if (var2 > hash.searchNodo(top5.get(1)).getData()) {
                    if (var2 > hash.searchNodo(top5.get(2)).getData()) {
                        if (var2 > hash.searchNodo(top5.get(3)).getData()) {
                            if (var2 > hash.searchNodo(top5.get(4)).getData()) {
                                top5.add(lista.get(i));
                            }
                        }
                    }
                }
                top5.remove(top5.get(5));
            }

        }
        return top5;
    }
}
