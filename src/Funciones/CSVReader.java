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
import java.util.Objects;


public class CSVReader {

    private HashImpl<String, HashImpl<String,MyList<Song>>> hashDP;

    private HashImpl<String, MyList<Song>> hashDT50;

    public void setHashDP(HashImpl<String, HashImpl<String,MyList<Song>>> hash){
        this.hashDP = hash;
    }
    public HashImpl<String, HashImpl<String,MyList<Song>>> getHashDP() {
        return hashDP;
    }

    private MySearchBinaryTree<Float, MyList<Song>> Treet;
    public void setTreet(MySearchBinaryTree<Float, MyList<Song>> treet){
        this.Treet = treet;
    }
    public MySearchBinaryTree<Float, MyList<Song>> getTreet() {
        return Treet;
    }

    public HashImpl<String, MyList<Song>> getHashDT50() {
        return hashDT50;
    }

    public void setHashDT50(HashImpl<String, MyList<Song>> hashDT50) {
        this.hashDT50 = hashDT50;
    }

    private MyList<String> paises;
    public void setPaises(MyList<String> paises){
        this.paises = paises;
    }
    public MyList<String> getPaises(){
        return paises;
    }

    public CSVReader() {
        String line;
        HashImpl<String, HashImpl<String,MyList<Song>>> hash = new HashImpl<>(10);
        MySearchBinaryTree<Float, MyList<Song>> Tt = new MySearchBinaryTreeImpl<>();
        MyList<String> lp = new MyLinkedListImpl<>();
        HashImpl<String,MyList<Song>> hashDT = new HashImpl<>(10);

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

                //Separa y crea los artistas
                String[] arts = fields[2].split("\\{");
                String artists=arts[0];
                for (String art : arts) {
                    art = art;
                    //new Artist(art);
                    if (!Objects.equals(art, arts[0])) {
                        artists = artists + ", " + art;
                    }
                }

                //Agrega los paises a la lista de paises
                if (!lp.contains(fields[6])) {
                    lp.add(fields[6]);
                }

                // Crear la Song
                Song song = new Song(
                        fields[0],                   // spotifyId
                        fields[1],                   // name
                        artists,                     // artists
                        arts,                        //artistsarray
                        Integer.parseInt(fields[3]), // dailyRank
                        Integer.parseInt(fields[4]), // dailyMovement
                        Integer.parseInt(fields[5]), // weeklyMovement
                        fields[6],                   // country
                        fields[7],                   // snapshotDate
                        Float.parseFloat(fields[23]) // tempo
                );

                //Agrega la cancion al hash
                if(hash.search(song.getSnapshotDate()) == -1) {
                    hash.insert(song.getSnapshotDate(), new HashImpl<>(10));
                }
                if(hash.searchNodo(song.getSnapshotDate()).getData().search(song.getCountry()) == -1){
                    hash.searchNodo(song.getSnapshotDate()).getData().insert(song.getCountry(), new MyLinkedListImpl<>());
                }
                hash.searchNodo(song.getSnapshotDate()).getData().searchNodo(song.getCountry()).getData().add(song);

                if(!Tt.contains(song.getTempo())){
                    Tt.add(song.getTempo(), new MyLinkedListImpl<>());
                }
                Tt.find(song.getTempo()).add(song);

                // agrega las canciones al hashDT
                if(hashDT.search(song.getSnapshotDate()) == -1) {
                    hashDT.insert(song.getSnapshotDate(), new MyLinkedListImpl<>());
                }
                hashDT.searchNodo(song.getSnapshotDate()).getData().add(song);
            }
        } catch (IOException e) {e.printStackTrace();}
        setHashDP(hash);
        setTreet(Tt);
        setPaises(lp);
        setHashDT50(hashDT);
    }
}
