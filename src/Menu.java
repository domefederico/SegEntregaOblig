import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        while (1 == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido\n1. Top 10 canciones en un pais en un dia\n2. top 5 canciones que aparecen en un top 50 en un dia\n3. top 7 artistas que aparecen en el top 50 en un rango de fechas\n4. cantidad de veces que aparece un artista en un top 50 en una dia\n5. Cantidad de canciones con tempo en un rango para un rango de fechas\nElija la funcion que desea:");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
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