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

        /*
         *                      50
         *             20                  70
         *     10          30            60      80
         *                    40              75      100
         *                                         90      120
         *                                            95
         */
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(40);
        binarySearchTree.insert(10);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(90);
        binarySearchTree.insert(75);
        binarySearchTree.insert(120);
        binarySearchTree.insert(95);

        assertEquals(20, binarySearchTree.getRoot().getLeftChild().getValue());
    }

    @Test
    @Order(2)
    public void testFind() {
        assertEquals(70, binarySearchTree.find(70).getValue());
        assertThrows(NullPointerException.class, () -> {
            binarySearchTree.find(1000);
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
            binarySearchTree.getParent(1000);
        });
    }

    @Test
    @Order(5)
    public void testDelete() {
        Integer deletedValue = 70;
        assertThrows(NullPointerException.class, () -> {
            binarySearchTree.delete(deletedValue);
            binarySearchTree.find(deletedValue);
        });
        binarySearchTree.inOrder(binarySearchTree.getRoot());
    }

    @Test
    @Order(6)
    public void testGetHeight() {
        assertEquals(5, binarySearchTree.getHeight());
    }
}
