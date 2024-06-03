package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static MyList<Song> CSVLoader() {
        String csvFile = "data_set.csv";                // Especifica la ruta a tu archivo CSV
        String line = "";
        String cvsSplitBy = ",";                // Delimitador del CSV

        MyList<Song> songs = new MyLinkedListImpl<>();


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer la primera línea (encabezados) y descartarla
            br.readLine();


            while ((line = br.readLine()) != null) {

                // Elimina las comillas dobles al principio y al final de la línea
                line = line.substring(1, line.length() - 2);

                line = line.replace(", ","{");
                line = line.replaceAll("\"","");
                line = line.replace("Dear My Friend,","Dear My Friend");
                line = line.replace("Ya no me duele :,)","Ya no me duele");
                line = line.replace("最後一堂課 - 《媽,別鬧了!》影集片尾曲","最後一堂課 - 《媽別鬧了!》影集片尾曲");
                line = line.replace("最後一堂課 (《媽,別鬧了!》影集片尾曲)","最後一堂課 (《媽別鬧了!》影集片尾曲)");
                line = line.replace("Rochy RD,Carlos Boutique Por El Respeto","Rochy RD{Carlos Boutique Por El Respeto");
                line = line.replace("3,14,Gson","3.14,Gson");
                line = line.replace("324763,3,14","324763,3.14");
                line = line.replace("1,2,3 Soleil","1.2.3 Soleil");     // falta darlos vuelta al final



                // Divide la línea utilizando la coma como separador
                String[] fields = line.split(cvsSplitBy);

                // Itera sobre los datos y elimina las comillas dobles
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replace("\"", "");
                }

                for (int j = 0; j < fields.length; j++) {
                    if (j == 2) {
                        String[] art = fields[j].split("\\{");
                    }
                }

                // Itera sobre los datos y reemplaza el asterisco
                for (int i = 0; i < fields.length; i++) {
                    if (i == 2) {
                        fields[i].replace("*",", ");
                    }
                }

                // Crear una instancia de Song usando los campos
                Song song = new Song(
                        fields[0], // spotifyId
                        fields[1], // name
                        fields[2], // artists             //le pone solo el primer artista
                        Integer.parseInt(fields[3]), // dailyRank
                        Integer.parseInt(fields[4]), // dailyMovement
                        Integer.parseInt(fields[5]), // weeklyMovement
                        fields[6], // country
                        fields[7], // snapshotDate
                        Integer.parseInt(fields[8]), // popularity
                        Boolean.parseBoolean(fields[9]), // isExplicit
                        Integer.parseInt(fields[10]), // durationMs
                        fields[11], // albumName
                        fields[12], // albumReleaseDate
                        Float.parseFloat(fields[13]), // danceability
                        Float.parseFloat(fields[14]), // energy
                        Integer.parseInt(fields[15]), // key
                        Float.parseFloat(fields[16]), // loudness
                        Integer.parseInt(fields[17]), // mode
                        Float.parseFloat(fields[18]), // speechiness
                        Float.parseFloat(fields[19]), // acousticness
                        Float.parseFloat(fields[20]), // instrumentalness
                        Float.parseFloat(fields[21]), // liveness
                        Float.parseFloat(fields[22]), // valence
                        Float.parseFloat(fields[23]), // tempo
                        Integer.parseInt(fields[24])  // timeSignature
                );

                // Añadir la canción a la lista
                songs.add(song);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        // Aquí puedes procesar la lista de canciones como desees
//        for (Song song : songs) {
//            System.out.println(song.getName() + " by " + song.getArtists());
//        }
        return songs;
    }
}
