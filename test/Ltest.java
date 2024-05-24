import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.*;

import static org.junit.Assert.*;


public class Ltest {

    public MyList<String> list = null;

    @Before
    public void initlist() {
        list = new MyLinkedListImpl<>();
        list.add("Uno");
        list.add("Dos");
        list.add("Tres");
        list.add("Cuatro");
    }
    @Test
    public void AddTest(){
        String s = "Uno";
        String d = "Tres";
        assertEquals(s,list.get(0));
        assertEquals(d,list.get(2));
    }

    @Test
    public void GetTest(){
        String f = "Uno";
        String g = "Dos";
        assertEquals(f,list.get(0));
        assertEquals(g,list.get(1));
    }

    @Test
    public void RemoveTest(){
        String g = "Dos";
        list.remove("Uno");
        assertEquals(g,list.get(0));

        String h = "Cuatro";
        list.remove("Tres");
        assertEquals(h,list.get(1));
    }

    @Test
    public void SizeTest(){
        assertEquals(4,list.size());

        list.remove("Cuatro");
        assertEquals(3,list.size());
    }
}
