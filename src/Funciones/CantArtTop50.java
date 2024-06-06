package Funciones;

import Entities.Artist;
import Entities.Song;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import static Funciones.Top.top;

public class CantArtTop50 {

    public static int cat(String name, String fecha, HashImpl<String, HashImpl<String,MyList<Song>>> hashDP, MyList<String> paises){
        int cant = 0 ;
        for (int i = 0 ; i<paises.size() ; i++){
            MyList<Song> songs = top(paises.get(i), fecha, hashDP);
            for (int j = 0 ; j<50 && j<songs.size() ; j++){
                for (int k = 0; k<songs.get(j).getArtistsarray().length ; k++){
                    if (songs.get(j).getArtistsarray()[k].equals(name)){ cant++; }
                }
            }
        }
        return cant;
    }

}
