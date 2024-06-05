package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class CantSongsTempo {

    public static int cst(float tempo, String fecha0, String fecha1, HashImpl<Float, MyList<Song>> hashT){
        int i = 0;
        MyList<Song> songs = hashT.searchNodo(tempo).getData();
        for(int j = 0 ; j<songs.size() ; j++){
            if(songs.get(j).getSnapshotDate().compareTo(fecha1)<0 && songs.get(j).getSnapshotDate().compareTo(fecha0)>0){
                i++;
            }
        }
        return i;
    }

}
