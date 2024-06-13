package uy.edu.um.prog2.adt.hash;

import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;

public interface Hash<K,T> {

    void insert(K key,T data) throws InformacionInvalida;

    void delete(K key) throws InformacionInvalida;

    int search(K key);

    HashNode<K,T> searchNodo(K key);
}
