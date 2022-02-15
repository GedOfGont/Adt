package ged.gont.testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.*;
import ged.gont.queue.*;

@TestMethodOrder(OrderAnnotation.class)
public class TestPriorityQueue {

    static PriorityQueue<Integer> priorityQueue;

    @BeforeAll
    public static void init() {
        priorityQueue = new PriorityQueue<Integer>(10);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(8);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(9);
    }

    @Test
    @Order(1)
    public void testEnqueue() {
        priorityQueue.display();
        assertEquals(8, priorityQueue.get(2));
    }

    @Test
    @Order(2)
    public void testDequeue() {
        assertEquals(1, priorityQueue.dequeue());
        assertEquals(2, priorityQueue.dequeue());
    }

    @Test
    @Order(3)
    public void testEmpty() {
        assertFalse(priorityQueue.isEmpty());
        while (!priorityQueue.isEmpty()) {
            priorityQueue.dequeue();
        }
        assertTrue(priorityQueue.isEmpty());
    }
}
