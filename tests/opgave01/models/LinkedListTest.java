package opgave01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<String> myStrings = new LinkedList<>();
    String firstString = "Hello";
    String fourthString = "Are";

    @BeforeEach
    void SetUp() {
        myStrings.clear();
        myStrings.add(firstString);
        myStrings.add("World");
        myStrings.add("How");
        myStrings.add(fourthString);
        myStrings.add("You");
    }

    @Test
    void add() {
        String expected = "Testing add method";

        myStrings.add(expected);

        assertTrue(myStrings.contains(expected));
    }

    @Test
    void remove() {
        String expected = "Testing remove method";
        myStrings.add(expected);
        myStrings.remove(expected);

        assertFalse(myStrings.contains(expected));
    }

    @Test
    void addFirstAndGetFirst() {
        String expected = "Testing addFirst";

        myStrings.addFirst(expected);
        String actual = myStrings.getFirst();

        assertTrue(myStrings.contains(expected));
        assertEquals(expected, actual);
    }

    @Test
    void removeFirst() {
        myStrings.removeFirst();

        assertFalse(myStrings.contains(firstString));
    }

    @Test
    void contains() {
        assertTrue(myStrings.contains(fourthString));
    }

    @Test
    void clear() {
        int expected = 0;
        myStrings.clear();

        int actual = myStrings.size();

        assertEquals(expected, actual);
    }

    @Test
    void size() {
        int expected = 5;

        int actual = myStrings.size();

        assertEquals(expected, actual);

        myStrings.add("Test1");
        myStrings.add("Test2");

        expected = 7;
        actual = myStrings.size();

        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        assertFalse(myStrings.isEmpty());

        myStrings.clear();

        assertTrue(myStrings.isEmpty());
    }

    @Test
    void get() {
        String expectedFirst = firstString;
        String expectedFourth = fourthString;

        String actualFirst = myStrings.get(0);
        String actualFourth = myStrings.get(3);

        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedFourth, actualFourth);
    }

    @Test
    void AddAtIndex() {
        String expectedFirst = "TestFirst";
        String expectedMiddle = "TestMiddle";
        String expectedLast = "TestLast";

        myStrings.add(0, expectedFirst);
        myStrings.add(3, expectedMiddle);
        myStrings.add(7, expectedLast);

        assertEquals(expectedFirst, myStrings.get(0));
        assertEquals(expectedMiddle, myStrings.get(3));
        assertEquals(expectedLast, myStrings.get(7));
    }

    @Test
    void removeIndex() {
        String expectedFirst = firstString;
        String expectedMiddle = fourthString;

        String removedMiddle = myStrings.remove(3);
        String removedFirst = myStrings.remove(0);

        assertEquals(expectedFirst, removedFirst);
        assertEquals(expectedMiddle, removedMiddle);
    }

    @Test
    void indexOf() {
        int expectedFirst = 0;
        int expectedMiddle = 3;

        int actualFirst = myStrings.indexOf(firstString);
        int actualMiddle = myStrings.indexOf(fourthString);

        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedMiddle, actualMiddle);
    }

    @Test
    void iterator() {
        LinkedList<String> iteratedStrings = new LinkedList<>();
        String test = "Test";
        iteratedStrings.add(test);

        Iterator<String> iterator = iteratedStrings.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(test, iterator.next());

        LinkedList<String> iteratedStrings1 = new LinkedList<>();
        Iterator<String> iterator1 = iteratedStrings1.iterator();

        assertFalse(iterator1.hasNext());
        assertThrows(RuntimeException.class, () -> iterator1.next());
    }
}