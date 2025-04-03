import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntContainerTest {
    private Container container;

    // Этот метод выполняется перед каждым тестом
    @BeforeEach
    void setUp() {
        container = new Container();
        container.add(10);
        container.add(20);
        container.add(30);
    }

    @Test
    void testAdd() {
        assertEquals(3, container.getSize());
        container.add(40);
        assertEquals(4, container.getSize());
    }

    @Test
    void testGet() {
        assertEquals(20, container.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(10));
    }

    @Test
    void testRemove() {
        container.remove(0);
        assertEquals(2, container.getSize());
        assertEquals(20, container.get(0));
    }

    @Test
    void testSize() {
        assertEquals(3, container.getSize());
        container.add(100);
        assertEquals(4, container.getSize());
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(3));
    }
}