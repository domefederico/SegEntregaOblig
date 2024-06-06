package Funciones;

import Entities.Song;

import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


public class Top {

       public static MyList<Song> top(String pais, String dia,HashImpl<String, HashImpl<String,MyList<Song>>> hashDP){
           MyList<Song> listac = new MyLinkedListImpl<>();
           if (hashDP.getCapacity() != 0) {
               if (hashDP.searchNodo(dia) != null) {
                   if (hashDP.searchNodo(dia).getData().searchNodo(pais) != null) {
                       listac = hashDP.searchNodo(dia).getData().searchNodo(pais).getData();
                   }
               }
           } else {
               System.out.println("No existe el hashDP");
           }
           return listac;
       }
}
