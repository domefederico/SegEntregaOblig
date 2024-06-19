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
        int codigo = key.hashCode();
        int absoluto = Math.abs(codigo);
        int marcador = absoluto % size;
        int marcador1 = marcador;

        if (grilla[marcador] != null) {
            if (!grilla[marcador].getKey().equals(key)) {
                while (grilla[marcador] != null) {
                    marcador = (marcador + 1) % size;
                    if (marcador == marcador1) {
                        throw new InformacionInvalida();
                    }
                }
            }
        }

        grilla[marcador] = null;
    }

    @Override
    public T search(K key) {

        int codigo = key.hashCode();
        int absoluto = Math.abs(codigo);
        int marcador = absoluto % size;
        int marcador1 = marcador;

        if (grilla[marcador] == null) {
            return null;
        } else {
            if (!grilla[marcador].getKey().equals(key)) {
                while (grilla[marcador] != null) {
                    marcador = (marcador + 1) % size;
                    if (grilla[marcador] != null) {
                        if (grilla[marcador].getKey().equals(key)) {
                            return grilla[marcador].getData();
                        }
                    }
                    if (marcador == marcador1) {
                        return null;
                    }
                }
            }
        }

        if (grilla[marcador] != null) {
            return grilla[marcador].getData();
        }
        return null;

    }

    @Override
    public HashNode<K, T> searchNodo(K key) {

        int codigo = key.hashCode();
        int absoluto = Math.abs(codigo);
        int marcador = absoluto % size;
        int marcador1 = marcador;

        if (grilla[marcador] == null) {
            return null;
        } else {
            if (!grilla[marcador].getKey().equals(key)) {
                while (grilla[marcador] != null) {
                    marcador = (marcador + 1) % size;
                    if (grilla[marcador] != null) {
                        if (grilla[marcador].getKey().equals(key)) {
                            return grilla[marcador];
                        }
                    }
                    if (marcador == marcador1) {
                        return null;
                    }
                }
            }
        }

        if (grilla[marcador] != null) {
            return grilla[marcador];
        }
        return null;

    }
}
