import org.junit.*;
import uy.edu.um.prog2.adt.ntree.Tree;
import uy.edu.um.prog2.adt.ntree.TreeImpl;

import static org.junit.jupiter.api.Assertions.*;

public class NTtest {

    public TreeImpl<Integer> nt = null;

    @Before
    public void initntree() {

        nt = new TreeImpl<>(1);
        nt.add(2,1);
        nt.add(4,1);
        nt.add(10,1);
        nt.add(20,1);
    }

    @Test
    public void addTest(){
        assertEquals(nt.searchValue(2).getValue(), 2);
        boolean thrown = false;
        try{ nt.add(null, 2); }
        catch(RuntimeException r){ thrown = true; }
        assertTrue(thrown);
    }


    @Test
    public void getValueTest(){
        assertEquals(nt.getValue(), 1);
    }


    @Test
    public void setValueTest(){
        nt.setValue(3);
        assertEquals(nt.getValue(), 3);
    }


    @Test
    public void getChildsTest(){
        Tree<Integer>[] childs = nt.getChilds() ;
        assertEquals(childs[1].getValue(), 4);
    }


    @Test
    public void searchValueTest(){
        assertNotNull(nt.searchValue(10));
    }


}
