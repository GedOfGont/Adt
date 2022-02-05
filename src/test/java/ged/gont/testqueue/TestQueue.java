package ged.gont.testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;
import ged.gont.queue.*;

public class TestQueue {

    static Queue<Integer> queue;

    @BeforeAll
    public static void init(){
        queue = new Queue<Integer>(10);
        queue.enqueue(50);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(10);
        queue.enqueue(30);
    }

    @Test
    public void testDequeue(){
        assertEquals(50, queue.dequeue());
    }

    @Test
    public void testEmpty(){
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueException(){
        while(!queue.isEmpty()){
            queue.dequeue();
        }
        assertThrows(NoSuchElementException.class, ()->{queue.dequeue();});
    }

    @Test
    public void testEnqueueException(){
        while(!queue.isFull()){
            queue.enqueue(100);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->{queue.enqueue(100);});
    }

}
