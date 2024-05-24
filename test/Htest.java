import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.Exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.hash.Hash;
import uy.edu.um.prog2.adt.hash.HashImpl;
import static org.junit.Assert.*;

public class Htest {

    public Hash<Integer, Integer> hash = null;

    @Before
    public void initHash() throws InformacionInvalida {
        hash = new HashImpl<>(4);
        hash.insert(1,5);
        hash.insert(3,5);
        hash.insert(5,5);
        hash.insert(2,5);
    }

    @Test
    public void AddTest() {
        assertEquals(hash.search(1,5),1);            // 1 es el absoluto del codigo del nodo
        assertEquals(hash.search(3,5),3);            // 3 es el absoluto del codigo del nodo
        assertEquals(hash.search(5,5),2);            // 5 es el absoluto del codigo del nodo, pero lo desplaza al 2
        assertEquals(hash.search(2,5),0);            // 2 es el absoluto del codigo del nodo, 3 ya esta el 3, va al 0
    }

    @Test
    public void DeleteTest() throws InformacionInvalida {
        hash.delete(1,5);
        assertEquals(hash.search(1,5),-1 );
        hash.delete(3,5);
        assertEquals(hash.search(3,5),-1 );
    }

    @Test
    public void SearchTest() {
        assertEquals(hash.search(1,5),1);            // 1 es el absoluto del codigo del nodo
        assertEquals(hash.search(3,5),3);            // 3 es el absoluto del codigo del nodo
        assertEquals(hash.search(5,5),2);            // 5 es el absoluto del codigo del nodo, pero lo desplaza al 2
        assertEquals(hash.search(2,5),0);            // 2 es el absoluto del codigo del nodo, 3 ya esta el 3, va al 0

    }


}
