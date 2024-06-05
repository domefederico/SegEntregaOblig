package uy.edu.um.prog2.adt.hash;

import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class HashImpl<K,T> implements Hash<K,T> {
    private HashNode<K,T>[] grilla;
    public int size;
    private int capacity;

    private static final float loadfactor = 0.95F;


    public HashImpl(int size) {
        this.size = size;
        this.capacity = 0;
        this.grilla = new HashNode[size];
    }

    public HashNode<K, T>[] getGrilla() {
        return grilla;
    }

    public void setGrilla(HashNode<K, T>[] grilla) {
        this.grilla = grilla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void insert(K key, T data) {
        HashNode<K, T> nuevo = new HashNode<>(key, data);
        int codigo = key.hashCode();
        int absoluto = Math.abs(codigo);
        int marcador = absoluto % size;

        if (capacity >= size*loadfactor) {
            resize();
        }

        while (grilla[marcador] != null ) {
            marcador = (marcador + 1) % size;
        }

        grilla[marcador] = nuevo;
        capacity++;

    }

    public void resize() {
        HashNode<K,T>[] grillaVieja = grilla;
        size = size*2;
        grilla = new HashNode[size];
        for ( HashNode<K,T> nodo : grillaVieja ) {
            if (nodo != null) {
                insert(nodo.key, nodo.data);
            }
        }
    }

    @Override
    public void delete(K key) throws InformacionInvalida {
        int a = search(key);
        if (a != -1) {
            grilla[a] = null;
        } else {
            throw new InformacionInvalida();
        }
    }

    @Override
    public int search(K key) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (grilla[i] != null) {
                if (grilla[i].getKey().equals(key)) {
                    a = i;
                }
            }
        }
        return a;
    }

    @Override
    public HashNode<K, T> searchNodo(K key) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (grilla[i] != null) {
                if (grilla[i].getKey().equals(key)) {
                    a = i;
                }
            }
        }
        if ( a != -1) {
            return grilla[a];
        }
        return null;
    }
}
