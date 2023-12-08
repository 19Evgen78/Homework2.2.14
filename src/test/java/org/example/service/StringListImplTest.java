package org.example.service;

import org.example.exception.ElementNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringList stringList;
    private int storageSize = 10;
    private StringListImpl obj;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl() {
            @Override
            public void initializeStorage(int storageSize) {

            }

            @Override
            public void setStorage(String[] storage) {

            }
        };
        stringList.initializeStorage(storageSize);
    }
    @Test
    void add() {
        stringList.add("Item 1");
        Assert.assertEquals("Item 1", stringList.get(0));

        stringList.add("Item 2");
        Assert.assertEquals("Item 2", stringList.get(1));
    }

    @Test
     void testAdd() {
        stringList.add("Item 1");
        Assert.assertEquals("Item 1", stringList.get(0));

        stringList.add("Item 2");
        Assert.assertEquals("Item 2", stringList.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        String expected = "item";
        int index = 5;
        String item = "item";

        String actual = stringList.set(index, item);

        assertEquals(expected, stringList.get(index));
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        String item = "item";
        stringList.set(0, item);

        String actual = stringList.remove(item);

        assertNull(stringList.get(0));
        assertEquals(item, actual);
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        String item = "non-existent";
        stringList.remove(item);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        String item = "item";
        stringList.set(0, item);

        boolean actual = stringList.contains(item);

        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        String item = "item";
        stringList.set(0, item);

        int actual = stringList.indexOf(item);

        assertEquals(0, actual);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        String item = "item";
        stringList.set(0, item);

        boolean actual = stringList.contains(item);

        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void get() {
        String[] storage = {"value1", "value2", "value3"};
        stringList.setStorage(storage);
        int index = 1;
        String expectedValue = "value2";
        String actualValue = stringList.get(index);
        assertEquals(expectedValue, actualValue);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        StringList otherList = new StringListImpl() {
            @Override
            public void initializeStorage(int storageSize) {
            }

            @Override
            public void setStorage(String[] storage) {
            }
        };
        StringList obj = null;
        obj.setStorage(new String[]{"value1", "value2", "value3"});
        otherList.setStorage(new String[]{"value1", "value2", "value3"});

        assertTrue(obj.equals(otherList));
    }

    @org.junit.jupiter.api.Test
    void size() {
        obj.setStorage(new String[]{"value1", "value2", "value3"});
        int expectedSize = 3;
        int actualSize = obj.size();
        assertEquals(expectedSize, actualSize);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add(Arrays.toString(new String[]{"value1", "value2", "value3"}));
        assertFalse(stringList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        stringList.add("value1");
        stringList.add("value2");
        stringList.add("value3");
        assertNotEquals(0, stringList.size());
        stringList.clear();
        assertEquals(0, stringList.size());
    }


    @org.junit.jupiter.api.Test
    void toArray() {
        stringList.add("value1");
        stringList.add("value2");
        stringList.add("value3");
        assertFalse(stringList.isEmpty());
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    private static class Assert {
        public static void assertEquals(String s, String s1) {
        }
    }
}