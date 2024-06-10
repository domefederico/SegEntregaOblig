package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class DiaTop50 {

    public static MyList<Song> hashDT50(String fecha, HashImpl<String, MyList<Song>> hash1) throws InformacionInvalida {
        MyList<Song> lista = hash1.searchNodo(fecha).getData();
        HashImpl<Song,Integer> hash = new HashImpl<>(100);
        MyList<Song> top5 = new MyLinkedListImpl<>();

        if (lista.size() == 0) {
            throw new InformacionInvalida();
        }

        for (int i = 0; i < lista.size(); i++) {
            if (hash.search(lista.get(i)) == -1) {
                hash.insert(lista.get(i),0);
            }
            int var = hash.searchNodo(lista.get(i)).getData();
            hash.searchNodo(lista.get(i)).setData(var+1);
            int var2 = hash.searchNodo(lista.get(i)).getData();

            top5.sort();
            if (top5.size() < 5) {
                top5.add(hash.searchNodo(lista.get(i)).getKey());
            } else if (var2 > hash.searchNodo(top5.get(0)).getData()) {
                top5.remove(top5.get(0));
                top5.add(hash.searchNodo(lista.get(i)).getKey());
            }
        }
        return top5;
    }
}
