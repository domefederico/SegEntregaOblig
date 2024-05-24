import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.stack.EmptyStackException;
import uy.edu.um.prog2.adt.stack.MyStack;

import static org.junit.Assert.*;

public class Stest {
    public MyStack<String> stack = null;

    @Before
    public void initstack(){
        stack = new MyLinkedListImpl<>();
        stack.push("Uno");
        stack.push("Dos");
        stack.push("Tres");
        stack.push("Cuatro");
    }


    @Test
    public void PushTest(){
        String s = "Cuatro";
        assertEquals(s,stack.peek());
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        String d = "Tres";
        assertEquals(d,stack.peek());
    }

    @Test
    public void PopTest(){
        try { assertEquals("Cuatro",stack.pop()); }
        catch (EmptyStackException e) {
            throw new RuntimeException(e); }
        try { assertEquals("Tres",stack.pop()); }
        catch (EmptyStackException e) {
            throw new RuntimeException(e); }
        try { assertEquals("Dos",stack.pop()); }
        catch (EmptyStackException e) {
            throw new RuntimeException(e); }
        try { assertEquals("Uno",stack.pop()); }
        catch (EmptyStackException e) {
            throw new RuntimeException(e); }
        boolean thrown = false;
        try { stack.pop(); }
        catch (EmptyStackException e) {
            thrown = true; }
        assertTrue(thrown);
    }

    @Test
    public void PeekTest() {
        String s = "Cuatro";
        assertEquals(s, stack.peek());
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        String d = "Tres";
        assertEquals(d, stack.peek());
    }
}
