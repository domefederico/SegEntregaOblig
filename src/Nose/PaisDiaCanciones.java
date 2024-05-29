package Nose;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class PaisDiaCanciones {

    public static HashImpl<String[], MyList<Song>> hashPD() {
        HashImpl<String[], MyList<Song>> hash = new HashImpl<>(10);


//        for (int i = 0; i <= database.size; i++) {
//            String[] clave = new String[2];
//            clave[0] = database(i).getpais;
//            clave[1] = database(i).getdia;
//            MyList<Song> auxSong = new MyLinkedListImpl<>();
//            for (int n = 0; n <= hash.getSize(); n++) {
//                if (hash.search(clave,auxSong) == -1) {
//                    hash.insert(clave,database(i));
//                } else {
//                    int b = hash.search(clave,auxSong);
//                    MyList<Song> canciones = hash.searchNodo(clave,auxSong).getData();
//                    canciones.add(database(i));
//                }
//            }
//        }
        return hash;
    }
}
