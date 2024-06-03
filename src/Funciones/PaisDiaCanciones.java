package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


public class PaisDiaCanciones {

    public static HashImpl<String[], MyList<Song>> hashPD(MyList<Song> songs) {
        HashImpl<String[], MyList<Song>> hash = new HashImpl<>(10);

        for (int i = 0; i <= songs.size(); i++) {       // i : songs
            String[] clave = new String[2];
            clave[0] = songs.get(i).getCountry();
            clave[1] = songs.get(i).getSnapshotDate();
            MyList<Song> auxSong = new MyLinkedListImpl<>();
            for (int n = 0; n <= hash.getSize(); n++) {
                if (hash.search(clave,auxSong) == -1) {
                    auxSong.add(songs.get(i));
                    hash.insert(clave,auxSong);
                } else {
                    int b = hash.search(clave,auxSong);
                    MyList<Song> canciones = hash.searchNodo(clave,auxSong).getData();
                    canciones.add(songs.get(i));
                }
            }
        }
        return hash;
    }
}
