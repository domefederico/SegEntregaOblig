package Funciones;

import Entities.Artist;
import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Funciones.CantArtTop50.cat;

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
            if (hashDT50.searchNodo(fechaaux) != null) {
                MyList<Song> canc = hashDT50.searchNodo(fechaaux).getData();
                for (int i = 0; i < canc.size(); i++) {
                    String[] array = canc.get(i).getArtistsarray();
                    for (String art:array) {
                        if (dome.searchNodo(art) == null) {
                            dome.insert(art,0);
                        }
                        dome.searchNodo(art).setData(dome.searchNodo(art).getData()+1);

                        listr.sort();
                        if (listr.size() < 7) {
                            listr.add(art);
                        } else if (dome.searchNodo(art).getData() > dome.searchNodo(listr.get(0)).getData()) {
                            listr.remove(listr.get(0));
                            listr.add(dome.searchNodo(listr.get(i)).getKey());
                        }
                    }
                }
            }
            faux.plusDays(1);
        }

        return listr;
    }

}
