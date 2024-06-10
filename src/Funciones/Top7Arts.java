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

    public static MyList<String> top7(String fecha0, String fecha1, MyList<Artist> artistas, HashImpl<String, HashImpl<String,MyList<Song>>> hashDP, MyList<String> paises){
        MyList<String> listr = new MyLinkedListImpl<>();
//        LocalDate fecha = LocalDate.parse(fecha0, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        int cant = 0;
//        for(int i = 0 ; i< artistas.size() ; i++){
//            fecha = fecha.plusDays(1);
//            artistas.get(i).setCt50(cat(artistas.get(i).getName(), fecha.toString(), hashDP, paises));
//        }
        return listr;
    }

}
