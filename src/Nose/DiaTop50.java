package Nose;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class DiaTop50 {

    public static HashImpl<String, MyList<Song>> hashDT50() {
        HashImpl<String, MyList<Song>> hash = new HashImpl<>(10);


        return hash;
    }

}
