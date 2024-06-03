package Funciones;



import Entities.Song;
import uy.edu.um.prog2.adt.hash.*;
import uy.edu.um.prog2.adt.binarytree.*;
import uy.edu.um.prog2.adt.linkedlist.*;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import static Funciones.DiaTop50.hashDT50;
import static Funciones.PaisDiaCanciones.hashPD;

public class Top10 {

       public static void top10(String pais, String dia,MyList<Song> songs) {
           HashImpl<String[], MyList<Song>> hash = hashPD(songs);            // hay que sacarlo para q lo haga una vez sola

           String[] clave = new String[2];
           clave[0] = pais;
           clave[1] = dia;
           MyList<Song> auxSong = new MyLinkedListImpl<>();

           MyList<Song> fila = hash.searchNodo(clave,auxSong).getData();

           MySearchBinaryTreeImpl<Integer,Song> arbol = new MySearchBinaryTreeImpl<>();


           for (int n = 0; n <= fila.size(); n++) {
               if (fila.get(n).getDailyRank() < 11) {
                   arbol.add(fila.get(n).getDailyRank(),fila.get(n));
               }
           }

           MyList<Integer> lista = arbol.inOrder();

           for (int i=0; i <= lista.size(); i++) {
               System.out.println(arbol.find(i).getName() + " " + arbol.find(i).getArtists() + " " + i);
           }

       }

       public static void top50(String dia) {
           HashImpl<String, MyList<Song>> hash2 = hashDT50();            // hay que sacarlo para q lo haga una vez sola





       }
}
