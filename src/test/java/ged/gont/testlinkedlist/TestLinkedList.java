package ged.gont.testlinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import ged.gont.linkendlist.*;

public class TestLinkedList {

    static LinkedList<String> linkedList;

    @BeforeAll
    public static void init() {
        linkedList = new LinkedList<>();
        linkedList.append("saturn");
        linkedList.append("soyuz");
        linkedList.append("h2");
        linkedList.append("chang zheng");
    }

    @Test
    public void testFindByValue() {
        assertEquals("h2", linkedList.findByValue("h2").getValue());
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.findByValue("mars");
        });
    }

    @Test
    public void testFindByIndex() {
        assertEquals("chang zheng", linkedList.findByIndex(3).getValue());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            linkedList.findByIndex(44);
        });
    }

    @Test
    public void testInsert() {
        linkedList.insert(2, "ariane");
        assertEquals("ariane", linkedList.findByIndex(2).getValue());
    }

    @Test
    public void testRemove() {
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.remove("soyuz");
            linkedList.findByValue("soyuz");
        });
    }

    @Test
    public void testSize() {
        assertEquals(4, linkedList.size());
    }

}
