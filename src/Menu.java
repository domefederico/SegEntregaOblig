import Entities.Song;
import Funciones.CSVReader;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


import java.io.IOException;
import java.util.Scanner;

import static Funciones.CantArtTop50.cat;
import static Funciones.CantSongsTempo.cst;
import static Funciones.DiaTop50.hashDT50;
import static Funciones.Top.top;
import static Funciones.Top7Arts.top7;

public class Menu {

    public static void main(String[] args) throws InterruptedException, IOException, InformacionInvalida {
        System.out.println("Bienvenido");
        Terminal terminal = TerminalBuilder.terminal();
        terminal.writer().print("Aguarde un momento");
        terminal.flush();
        Thread.sleep(400);
        terminal.writer().print("\r\033[2K");
        terminal.flush();
        terminal.writer().print("Aguarde un momento.");
        terminal.flush();
        Thread.sleep(400);
        terminal.writer().print("\r\033[2K");
        terminal.flush();
        terminal.writer().print("Aguarde un momento..");
        terminal.flush();
        Thread.sleep(400);
        terminal.writer().print("\r\033[2K");
        terminal.flush();
        terminal.writer().print("Aguarde un momento...");
        terminal.flush();

        long t0 = System.currentTimeMillis();
        CSVReader C = new CSVReader();
        long t1 = System.currentTimeMillis();
        System.out.println("\nLa carga de datos demoro: " + (t1-t0) + " ms");
        HashImpl<String, HashImpl<String,MyList<Song>>> hashDP = C.getHashDP();
        MySearchBinaryTree<Float, MyList<Song>> Treet = C.getTreet();
        MyList<String> paises = C.getPaises();
        HashImpl<String,MyList<Song>> hashDT50 = C.getHashDT50();
        terminal.writer().print("\r\033[2K");
        terminal.flush();

        while (1 == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Top 10 canciones en un pais en un dia\n2. Top 5 canciones que aparecen en un top 50 en un dia\n3. Top 7 artistas que aparecen en el top 50 en un rango de fechas\n4. Cantidad de veces que aparece un artista en un top 50 en una dia\n5. Cantidad de canciones con tempo en un rango para un rango de fechas\n0. Cerrar\nElija la funcion que desea:");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                System.out.println("Indique el pais");
                String pais = scanner.next();
                System.out.println("Indique la fecha(YYYY-MM-DD)");
                String dia = scanner.next();
                t0 = System.currentTimeMillis();
                MyList<Song> listac = top(pais,dia,hashDP);
                System.out.println("\n");
                int i = 0;
                while (listac.size()>i){
                    if (i==10) {
                        break;
                    }
                    System.out.println((i+1)+ ". " + listac.get(i).getName() + " - " + listac.get(i).getArtists());
                    i++;
                }
                t1 = System.currentTimeMillis();
                System.out.println("Tiempo: " + (t1-t0) + " ms");
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 2) {
                System.out.println("Indique la fecha(YYYY-MM-DD)");
                String fecha = scanner.next();
                System.out.println("\n");
                t0 = System.currentTimeMillis();
                MyList<Song> lista = hashDT50(fecha,hashDT50);

//                try {
//                    lista = hashDT50(fecha,hashDT50);           //chequear
//                } catch (InformacionInvalida e) {
//                    System.out.println("no hay canciones en esa fecha");
//                }
                for (int i = 0; i<5; i++){
                    System.out.println(lista.get(i).getName());
                }
                t1 = System.currentTimeMillis();
                System.out.println("Tiempo: " + (t1-t0) + " ms");
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 3) {
                System.out.println("Indique la fecha de inicio");
                String fecha0 = scanner.next();
                System.out.println("Indique la fecha de finalizacion");
                String fecha1 = scanner.next();
                MyList<String> list = top7(fecha0, fecha1, hashDT50);
                t0 = System.currentTimeMillis();
                System.out.println("\n");
                for (int i = 0; i< list.size(); i++){
                    System.out.println(list.get(i));
                }
                t1 = System.currentTimeMillis();
                System.out.println("Tiempo: " + (t1-t0) + " ms");
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 4) {
                scanner.nextLine();
                System.out.println("Indique el artista");           //chequear
                String artista = scanner.nextLine();
                artista = artista;
                System.out.println("Indique la fecha(YYYY-MM-DD)");
                String fecha = scanner.next();
                t0 = System.currentTimeMillis();
                System.out.println("\n" + artista + " aparecio " + cat(artista, fecha, hashDP, paises) + " veces en tops 50 en la fecha ingresada");
                t1 = System.currentTimeMillis();
                System.out.println("Tiempo: " + (t1-t0) + " ms");
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 5) {
                System.out.println("Indique el tempo minimo");
                Float tempo0 = Float.parseFloat(scanner.next());
                System.out.println("Indique el tempo maximo");
                Float tempo1 = Float.parseFloat(scanner.next());
                System.out.println("Indique la fecha de inicio(YYYY-MM-DD)");
                String fecha0 = scanner.next();
                System.out.println("Indique la fecha de finalizacion(YYYY-MM-DD)");
                String fecha1 = scanner.next();
                System.out.println("\n");
                t0 = System.currentTimeMillis();
                System.out.println("\nExisten " + cst(tempo0, tempo1, fecha0, fecha1, Treet) + " canciones con un tempo entre " + tempo0 + " y " + tempo1 + " en el rango de fechas entre " + fecha0 + " y " + fecha1);
                t1 = System.currentTimeMillis();
                System.out.println("Tiempo: " + (t1-t0) + " ms");
                System.out.println("\n------------------------------------------------\n");
            }
            else if (opcion == 0) { break; }
            else { System.out.println("Ingrese un numero del 1 al 5"); }
        }
    }
}