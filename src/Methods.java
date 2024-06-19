import Entities.Song;
import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.prog2.adt.binarytree.TreeNode;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Methods {

    public static MyList<Song> top(String pais, String dia, HashImpl<String, HashImpl<String,MyList<Song>>> hashDP){
        MyList<Song> listac = new MyLinkedListImpl<>();
        if (hashDP.getCapacity() != 0) {
            if (hashDP.searchNodo(dia) != null) {
                if (hashDP.searchNodo(dia).getData().searchNodo(pais) != null) {
                    listac = hashDP.searchNodo(dia).getData().searchNodo(pais).getData();
                }
            }
        } else {
            System.out.println("No existe el hashDP");
        }
        return listac;
    }

    public static MyList<Song> hashDT50(String fecha, HashImpl<String, MyList<Song>> hash1) throws InformacionInvalida {
        MyList<Song> lista = hash1.searchNodo(fecha).getData();
        HashImpl<Song,Integer> hash = new HashImpl<>(100);
        MyList<Song> top5 = new MyLinkedListImpl<>();

        if (lista.size() == 0) {
            throw new InformacionInvalida();
        }

        for (int i = 0; i < lista.size(); i++) {
            if (hash.search(lista.get(i)) == null) {
                hash.insert(lista.get(i),0);
            }

            if (hash.search(lista.get(i)) != null) {
                int var = hash.searchNodo(lista.get(i)).getData();
                hash.searchNodo(lista.get(i)).setData(var + 1);

                int var2 = hash.searchNodo(lista.get(i)).getData();

                top5.sort();
                if (top5.size() < 5) {
                    top5.add(hash.searchNodo(lista.get(i)).getKey());
                } else if (var2 > hash.search(top5.get(0))) {
                    top5.remove(top5.get(0));
                    top5.add(hash.searchNodo(lista.get(i)).getKey());
                }
            }
        }
        return top5;
    }

    public static MyList<String> top7(String fecha0, String fecha1, HashImpl<String, MyList<Song>> hashDT50){
        MyList<String> listr = new MyLinkedListImpl<>();

        HashImpl<String,Integer> dome = new HashImpl<>(1000);       // string es el nombre del artista

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate f0 = LocalDate.parse(fecha0, formatter);
        LocalDate f1 = LocalDate.parse(fecha1, formatter);

        LocalDate faux = f0;

        while ( !faux.isAfter(f1) ) {
            String fechaaux = faux.format(formatter);
            if (hashDT50.search(fechaaux) != null) {
                MyList<Song> canc = hashDT50.searchNodo(fechaaux).getData();
                for (int i = 0; i < canc.size(); i++) {
                    String[] array = canc.get(i).getArtistsarray();
                    for (String art:array) {
                        if (dome.search(art) == null) {
                            dome.insert(art,0);
                        }
                        if (dome.search(art) != null) {                             //me lo pedia para runear
                            dome.searchNodo(art).setData(dome.search(art) + 1);

                            if (!listr.contains(art)) {
                                listr.sort();
                                if (listr.size() <= 7) {
                                    listr.add(art);
                                } else if (dome.search(art) > dome.search(listr.get(0))) {
                                    listr.remove(listr.get(0));
                                    listr.add(art);
                                }
                            }
                        }
                    }
                }
            }
            faux = faux.plusDays(1);
        }
        return listr;
    }

    public static int cat(String name, String fecha, HashImpl<String, HashImpl<String,MyList<Song>>> hashDP, MyList<String> paises){
        int cant = 0 ;
        for (int i = 0 ; i<paises.size() ; i++){
            MyList<Song> songs = top(paises.get(i), fecha, hashDP);
            for (int j = 0 ; j<50 && j<songs.size() ; j++){
                for (int k = 0; k<songs.get(j).getArtistsarray().length ; k++){
                    if (songs.get(j).getArtistsarray()[k].equals(name)){ cant++; }
                }
            }
        }
        return cant;
    }

    public static int cst(float tempo0, float tempo1, String fecha0, String fecha1, MySearchBinaryTree<Float, MyList<Song>> Treet) {
        int cant = 0;
        MyList<TreeNode<Float, MyList<Song>>> nodes = Treet.inOrderNode();
        MyList<Song> songs = new MyLinkedListImpl<>();
        for (int i = 0 ; i< nodes.size() ; i++){
            if(nodes.get(i).getKey()<=tempo1 && nodes.get(i).getKey()>=tempo0){
                for(int j=0 ; j<nodes.get(i).getValue().size() ; j++){
                    songs.add(nodes.get(i).getValue().get(j));
                }
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate f0 = LocalDate.parse(fecha0, formatter);
        LocalDate f1 = LocalDate.parse(fecha1, formatter);
        for (int k=0 ; k<songs.size() ; k++){
            if(LocalDate.parse(songs.get(k).getSnapshotDate(), formatter).isBefore(f1) && LocalDate.parse(songs.get(k).getSnapshotDate(), formatter).isAfter(f0)){
                cant++;
            }
        }
        return cant;
    }

}
