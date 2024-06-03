import Entities.Song;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.util.Scanner;

import static Funciones.CSVReader.CSVLoader;
import static Funciones.Top10.top10;

public class Menu {
    public static void main(String[] args) {
        MyList<Song> songs = CSVLoader();

        while (1 == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido\n1. Top 10 canciones en un pais en un dia\n2. Top 5 canciones que aparecen en un top 50 en un dia\n3. Top 7 artistas que aparecen en el top 50 en un rango de fechas\n4. Cantidad de veces que aparece un artista en un top 50 en una dia\n5. Cantidad de canciones con tempo en un rango para un rango de fechas\nElija la funcion que desea:\n0. Para terminar.");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                System.out.println("Indique el pais");
                String pais = scanner.nextLine();
                System.out.println("Indique el dia");
                String dia = scanner.nextLine();
                top10(pais,dia,songs);
            }
            else if (opcion == 2) {
            }
            else if (opcion == 3) {
            }
            else if (opcion == 4) {
            }
            else if (opcion == 5) {
            }
            else if (opcion == 0) { break; }
            else { System.out.println("Ingrese un numero del 1 al 5"); }
        }
    }
}