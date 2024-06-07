/**
 * 
 */
package uy.edu.um.prog2.adt.binarytree;

import Entities.Song;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public interface MySearchBinaryTree<K extends Comparable<K>, V> {

	void add(K key, V value);

	void remove(K key);

	boolean contains(K key);

	V find(K key);

	MyList<K> inOrder();

	MyList<TreeNode<K,V>> inOrderNode();

	MyList<K> postOrder();

	MyList<K> preOrder();

	TreeNode<K, V> getRoot();

}
