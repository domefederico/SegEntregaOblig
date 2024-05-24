import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.binarytree.*;

import static org.junit.Assert.*;

public class SBTtest {

    public MySearchBinaryTree<Integer, Integer> sbt = null;

    @Before
    public void initsbt() {
        sbt = new MySearchBinaryTreeImpl<>();
        sbt.add(4, 25);
        sbt.add(2, 8);
        sbt.add(6, 33);
        sbt.add(3, 50);
        sbt.add(1, 13);
        sbt.add(5, 24);
    }


    @Test
    public void addTest() {
        int s = sbt.getRoot().getKey();
        int d = sbt.getRoot().getLeft().getKey();
        int r = sbt.getRoot().getRight().getLeft().getValue();
        assertEquals(s, 4);
        assertEquals(d, 2);
        assertEquals(r, 24);
    }

    @Test
    public void findTest() {
        int s = sbt.find(3);
        int d = sbt.find(4);
        assertEquals(s, 50);
        assertEquals(d, 25);
        assertNull(sbt.find(8));
    }

    @Test
    public void containsTest() {
        assertTrue(sbt.contains(2));
        assertFalse(sbt.contains(8));
    }


    @Test
    public void removeTest() {
        sbt.remove(6);
        int l = sbt.getRoot().getRight().getKey();
        assertEquals(l, 5);
    }


    @Test
    public void orderTest() {
        int a = sbt.preOrder().get(0);
        int b = sbt.preOrder().get(1);
        int c = sbt.preOrder().get(2);
        int d = sbt.preOrder().get(3);
        int e = sbt.preOrder().get(4);
        int f = sbt.preOrder().get(5);
        int[] g = {a, b, c, d, e, f};
        assertArrayEquals(g, new int[]{4, 2, 1, 3, 6, 5});

        int aa = sbt.inOrder().get(0);
        int bb = sbt.inOrder().get(1);
        int cc = sbt.inOrder().get(2);
        int dd = sbt.inOrder().get(3);
        int ee = sbt.inOrder().get(4);
        int ff = sbt.inOrder().get(5);
        int[] gg = {aa, bb, cc, dd, ee, ff};
        assertArrayEquals(gg, new int[]{1, 2, 3, 4, 5, 6});

        int aaa = sbt.postOrder().get(0);
        int bbb = sbt.postOrder().get(1);
        int ccc = sbt.postOrder().get(2);
        int ddd = sbt.postOrder().get(3);
        int eee = sbt.postOrder().get(4);
        int fff = sbt.postOrder().get(5);
        int[] ggg = {aaa,bbb,ccc,ddd,eee,fff};
        assertArrayEquals(ggg, new int[]{1,3,2,5,6,4});
    }

}


