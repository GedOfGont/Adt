package ged.gont.testbst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.*;
import ged.gont.bst.*;

@TestMethodOrder(OrderAnnotation.class)
public class TestBinarySearchTree {

    static BinarySearchTree<Integer> binarySearchTree;

    @BeforeAll
    public static void init() {
        binarySearchTree = new BinarySearchTree<Integer>();
    }

    @Test
    @Order(1)
    public void testInsert() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(40);
        assertEquals(20, binarySearchTree.getRoot().getLeftChild().getValue());
    }

    @Test
    @Order(2)
    public void testFind() {
        assertEquals(70, binarySearchTree.find(70).getValue());
        assertThrows(NullPointerException.class, () -> {
            binarySearchTree.find(100);
        });
    }

    @Test
    @Order(3)
    public void testGetRSubTreeMin() {
        assertEquals(60, binarySearchTree.getRSubTreeMin(binarySearchTree.getRoot().getRightChild()).getValue());
    }

    @Test
    @Order(4)
    public void testGetParent() {
        assertEquals(30, binarySearchTree.getParent(40).getValue());
        assertThrows(NullPointerException.class, () -> {
            binarySearchTree.getParent(100);
        });
    }

    @Test
    @Order(5)
    public void testDelete(){
        Integer deletedValue = 70;
        assertThrows(NullPointerException.class, ()->{
            binarySearchTree.delete(deletedValue);
            binarySearchTree.find(deletedValue);
        });
    }
}
