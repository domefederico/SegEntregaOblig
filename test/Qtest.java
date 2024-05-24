import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;

import static org.junit.Assert.*;

public class Qtest {

    public MyQueue<Integer> q = null;

    @Before
    public void initQueue(){
        q = new MyLinkedListImpl<>();
        q.enqueue(1);
        q.enqueue(2);
    }

    @Test
    public void enqueueTest(){
        q.enqueue(3);
        assertTrue(q.contains(2));
        assertTrue(q.contains(3));
    }


    @Test
    public void dequeueTest() throws EmptyQueueException {
        int a = q.dequeue();
        assertEquals(a,1);
        q.dequeue();
        boolean thrown = false;
        try {q.dequeue();}
        catch(EmptyQueueException e){ thrown=true; }
        assertTrue(thrown);
    }


}
