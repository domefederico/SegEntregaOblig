package Funciones;

import Entities.Song;
import uy.edu.um.prog2.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.prog2.adt.binarytree.TreeNode;
import uy.edu.um.prog2.adt.hash.HashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.adt.linkedlist.Node;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CantSongsTempo {

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
