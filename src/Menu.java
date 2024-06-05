import Entities.Song;
import Funciones.CSVReader;
import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


import java.util.Scanner;

import static Funciones.CantSongsTempo.cst;
import static Funciones.Top10.top10;

public class Menu {

    public static void main(String[] args) {
        System.out.println("Bienvenido");

        CSVReader C = new CSVReader();
        HashImpl<String, HashImpl<String,MyList<Song>>> hashDP = C.getHashDP();
        HashImpl<Float,MyList<Song>> hashT = C.getHashT();


        while (1 == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Top 10 canciones en un pais en un dia\n2. Top 5 canciones que aparecen en un top 50 en un dia\n3. Top 7 artistas que aparecen en el top 50 en un rango de fechas\n4. Cantidad de veces que aparece un artista en un top 50 en una dia\n5. Cantidad de canciones con tempo en un rango para un rango de fechas\n0. Cerrar\nElija la funcion que desea:");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                System.out.println("Indique el pais");
                String pais = scanner.next();
                System.out.println("Indique la fecha");
                String dia = scanner.next();
                MyList<Song> listac = top10(pais,dia,hashDP);
                System.out.println("\n");
                int i = 0;
                while (listac.size()>i){
                    if (i==10) {
                        break;
                    }
                    System.out.println((i+1)+ ". " + listac.get(i).getName() + " - " + listac.get(i).getArtists());
                    i++;
                }
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 2) {
            }
            else if (opcion == 3) {
            }
            else if (opcion == 4) {
            }
            else if (opcion == 5) {
                System.out.println("Indique el tempo");
                Float tempo = Float.parseFloat(scanner.next());
                System.out.println("Indique la fecha de inicio");
                String fecha0 = scanner.next();
                System.out.println("Indique la fecha de finalizacion");
                String fecha1 = scanner.next();
                System.out.println("Existen " + cst(tempo, fecha0, fecha1, hashT) + " canciones con el tempo ingresado.");
            }
            else if (opcion == 0) { break; }
            else { System.out.println("Ingrese un numero del 1 al 5"); }
        }
    }
}