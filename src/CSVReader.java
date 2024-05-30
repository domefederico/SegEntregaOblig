import Entities.Song;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\juan.LAPTOP-CFOLLE\\Desktop\\Programacion\\Tercer Semestre\\Programacion II\\Obligatorio\\SegEntregaOblig\\data_set.csv"; // Especifica la ruta a tu archivo CSV
        String line = "";
        String cvsSplitBy = ","; // Delimitador del CSV


        List<Song> songs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer la primera línea (encabezados) y descartarla
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Elimina las comillas dobles al principio y al final de la línea
                line = line.substring(1, line.length() - 2);

                line.replaceAll(" \"\"","");

                // Usa split para dividir la línea en campos
                String[] fields = line.split(cvsSplitBy);

                // Crear una instancia de Song usando los campos
                Song song = new Song(
                        fields[0], // spotifyId
                        fields[1], // name
                        fields[2], // artists
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

        // Aquí puedes procesar la lista de canciones como desees
        for (Song song : songs) {
            System.out.println(song.getName() + " by " + song.getArtists());
        }
    }
}
