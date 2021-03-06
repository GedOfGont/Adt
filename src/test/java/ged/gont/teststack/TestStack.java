package ged.gont.teststack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import ged.gont.stack.Stack;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class TestStack {

    static Stack<Integer> stack;

    @BeforeAll
    public static void init() {
        stack = new Stack<Integer>(10);
        stack.push(10);
        stack.push(4);
        stack.push(20);
        stack.push(30);
    }

    @Test
    @Order(1)
    public void testEmpty() {
        assertFalse(stack.isEmtpy());
    }

    @Test
    @Order(2)
    public void testPeek() {
        assertEquals(30, stack.peek());
    }

    @Test
    @Order(3)
    public void testPop() {
        assertEquals(30, stack.pop());
    }

    @Test
    public void testEmptyStackException() {
        while (!stack.isEmtpy()) {
            stack.pop();
        }
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void testIndexOutOfRangeException() {
        while (!stack.isFull()) {
            stack.push(100);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stack.push(100);
        });
    }

}
