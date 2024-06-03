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
           HashImpl<String[], MyList<Song>> hash = hashPD();            // hay que sacarlo para q lo haga una vez sola


           String[] clave = new String[2];
           clave[0] = pais;
           clave[1] = dia;
           MyList<Song> auxSong = new MyLinkedListImpl<>();

           HashNode<String[], MyList<Song>> fila = hash.searchNodo(clave,auxSong);

           MySearchBinaryTreeImpl<Integer,Song> arbol = new MySearchBinaryTreeImpl<>();


//           for (int n = 0; n <= fila.getData().size(); n++) {
//               if (fila.getData().get(n).getDR < 11) {
//                   arbol.add(fila.getData().get(n).getDR,fila.getData().get(n));
//               }
//           }
//
//           MyList<DR> lista = arbol.inorder();
//
//           for (int i : lista) {
//               System.out.println(arbol.find(i).getnombrecancion + " " + arbol.find(i).getnombreartist + " " + i);
//           }

       }

       public static void top50(String dia) {
           HashImpl<String, MyList<Song>> hash2 = hashDT50();            // hay que sacarlo para q lo haga una vez sola





       }
}
