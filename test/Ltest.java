import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.*;

import static org.junit.Assert.*;


public class Ltest {

    public MyList<Integer> list = null;

    @Before
    public void initlist() {
        list = new MyLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }
    @Test
    public void AddTest(){
        Integer s = 1;
        Integer d = 3;
        assertEquals(s,list.get(0));
        assertEquals(d,list.get(2));
    }

    @Test
    public void GetTest(){
        Integer f = 1;
        Integer g = 2;
        assertEquals(f,list.get(0));
        assertEquals(g,list.get(1));
    }

    @Test
    public void RemoveTest(){
        Integer g = 2;
        list.remove(1);
        assertEquals(g,list.get(0));

        Integer h = 4;
        list.remove(3);
        assertEquals(h,list.get(1));
    }

    @Test
    public void SizeTest(){
        assertEquals(4,list.size());

        list.remove(4);
        assertEquals(3,list.size());
    }

    @Test
    public void SortTest(){
        list.remove(1);
        list.add(1);
        list = list.sort();
        Integer u = 1;
        Integer d = 2;
        Integer t = 3;
        Integer c = 4;
        assertEquals(list.get(0),u);
        assertEquals(list.get(1),d);
        assertEquals(list.get(2),t);
        assertEquals(list.get(3),c);
    }

}
