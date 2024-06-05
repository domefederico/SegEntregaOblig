package Funciones;

import Entities.Song;

import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.adt.linkedlist.MyList;


public class Top10 {

       public static void top10(String pais, String dia,HashImpl<String, HashImpl<String,MyList<Song>>> hashDP){

           if (hashDP.getCapacity() != 0) {
               if (hashDP.searchNodo(dia) != null) {
                   if (hashDP.searchNodo(dia).getData().searchNodo(pais) != null) {
                       MyList<Song> listac = hashDP.searchNodo(dia).getData().searchNodo(pais).getData();

                       for (int i = 0; i <= 9; i++) {
                           System.out.println(listac.get(i).getName() + " " + listac.get(i).getArtists()[0] + " " + (i+1));
                       }
                   }
               }
           } else {
               System.out.println("No existe el hashDP");

           }
       }
}
