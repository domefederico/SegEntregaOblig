package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Top7Arts {

    public static MyList<String> top7(String fecha0, String fecha1, HashImpl<String, MyList<Song>> hashDT50){
        MyList<String> listr = new MyLinkedListImpl<>();

        HashImpl<String,Integer> dome = new HashImpl<>(1000);       // string es el nombre del artista

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate f0 = LocalDate.parse(fecha0, formatter);
        LocalDate f1 = LocalDate.parse(fecha1, formatter);

        LocalDate faux = f0;

        while ( !faux.isAfter(f1) ) {
            String fechaaux = faux.format(formatter);
            if (hashDT50.search(fechaaux) != null) {
                MyList<Song> canc = hashDT50.searchNodo(fechaaux).getData();
                for (int i = 0; i < canc.size(); i++) {
                    String[] array = canc.get(i).getArtistsarray();
                    for (String art:array) {
                        if (dome.search(art) == null) {
                            dome.insert(art,0);
                        }
                        if (dome.search(art) != null) {                             //me lo pedia para runear
                            dome.searchNodo(art).setData(dome.search(art) + 1);

                            if (!listr.contains(art)) {
                                listr.sort();
                                if (listr.size() <= 7) {
                                    listr.add(art);
                                } else if (dome.search(art) > dome.search(listr.get(0))) {
                                    listr.remove(listr.get(0));
                                    listr.add(art);
                                }
                            }
                        }
                    }
                }
            }
            faux = faux.plusDays(1);
        }
        return listr;
    }
}
