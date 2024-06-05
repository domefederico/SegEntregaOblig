package Funciones;

import Entities.Artist;
import Entities.Song;


import uy.edu.um.prog2.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.prog2.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {

    private static HashImpl<String[], MyList<Song>> hashDP;

    private static MySearchBinaryTree<Integer, Song> songstree;

    public static HashImpl<String[], MyList<Song>> getHashDP() {
        CSVLoader();
        return hashDP;
    }

    public void setHashDP(HashImpl<String[], MyList<Song>> hashDP) {
        this.hashDP = hashDP;
    }

    public static MySearchBinaryTree<Integer, Song> getSongstree() {
        return songstree;
    }

    public void setSongstree(MySearchBinaryTree<Integer, Song> songstree) {
        this.songstree = songstree;
    }

    public static void CSVLoader() {
        String line;
        //MyList<Song> songslist = new MyLinkedListImpl<>();
        MySearchBinaryTree<Integer, Song> songstree = new MySearchBinaryTreeImpl<>();
        HashImpl<String[], MyList<Song>> hashDP = new HashImpl<>(10);

        try (BufferedReader br = new BufferedReader(new FileReader("data_set.csv"))) {
            //Lee la primer linea, que no nos importa
            br.readLine();

            while ((line = br.readLine()) != null) {

                //Borra los ;; del final
                line = line.substring(1, line.length() - 2);

                //Cambios en las canciones raras
                line = line.replace(", ","{");
                line = line.replace("\"","");
                line = line.replace("Dear My Friend,","Dear My Friend");
                line = line.replace("Ya no me duele :,)","Ya no me duele");
                line = line.replace("最後一堂課 - 《媽,別鬧了!》影集片尾曲","最後一堂課 - 《媽別鬧了!》影集片尾曲");
                line = line.replace("最後一堂課 (《媽,別鬧了!》影集片尾曲)","最後一堂課 (《媽別鬧了!》影集片尾曲)");
                line = line.replace("Rochy RD,Carlos Boutique Por El Respeto","Rochy RD{Carlos Boutique Por El Respeto");
                line = line.replace("3,14,Gson","3.14,Gson");
                line = line.replace("324763,3,14","324763,3.14");
                line = line.replace("1,2,3 Soleil","1.2.3 Soleil");     // falta darlos vuelta al final

                // Separa por la coma
                String[] fields = line.split(",");

                //deshace los cambios
                line = line.replace("Dear My Friend", "Dear My Friend,");
                line = line.replace("Ya no me duele", "Ya no me duele :,)");
                line = line.replace("最後一堂課 - 《媽別鬧了!》影集片尾曲", "最後一堂課 - 《媽,別鬧了!》影集片尾曲");
                line = line.replace("最後一堂課 (《媽別鬧了!》影集片尾曲)", "最後一堂課 (《媽,別鬧了!》影集片尾曲)");
                line = line.replace("Rochy RD{Carlos Boutique Por El Respeto", "Rochy RD,Carlos Boutique Por El Respeto");
                line = line.replace("3.14,Gson", "3,14,Gson");
                line = line.replace("324763,3.14", "324763,3,14");
                line = line.replace("1.2.3 Soleil", "1,2,3 Soleil");

//
//                //Elimina las comillas dobles
//                for (int i = 0; i < fields.length; i++) {
//                    fields[i] = fields[i].replace("\"", "");
//                }

                //Separa y crea los artistas
                String[] arts = fields[2].split("\\{");
                for (String art : arts) {
                    new Artist(art);
                }

                // Crear la Song
                Song song = new Song(
                        fields[0], // spotifyId
                        fields[1], // name
                        arts, // artists
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

                //Agrega la cancion al hash y al arbol
                songstree.add(1,song);

                String[] clave = new String[2];
                clave[0] = song.getCountry();
                clave[1] = song.getSnapshotDate();
                MyList<Song> auxSong = new MyLinkedListImpl<>();

                if (hashDP.search(clave,auxSong) == -1) {
                    auxSong.add(song);
                    hashDP.insert(clave,auxSong);
                } else {
                    MyList<Song> canciones = hashDP.searchNodo(clave,auxSong).getData();
                    canciones.add(song);
                }

            }
        } catch (IOException e) {e.printStackTrace();}
    }

}
