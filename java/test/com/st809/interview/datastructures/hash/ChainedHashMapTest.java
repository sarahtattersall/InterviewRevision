package com.st809.interview.datastructures.hash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChainedHashMapTest {
    ChainedHashMap<Integer, String> hashMap;

    @Before
    public void setUp() {
        hashMap = new ChainedHashMap<>(10);
    }

    @Test
    public void getSingleItem() {
        hashMap.put(4, "test");
        assertEquals("test", hashMap.get(4));
    }

    @Test
    public void collisionItems() {
        hashMap.put(4, "test");
        hashMap.put(14, "test2");
        assertEquals("test2", hashMap.get(14));
        assertEquals("test", hashMap.get(4));
    }

    @Test
    public void overWriteSameKey() {
        hashMap.put(4, "test");
        hashMap.put(4, "test2");
        assertEquals("test2", hashMap.get(4));

    }

    @Test
    public void nullForNoItem() {
        assertNull(hashMap.get(1));
    }

    @Test
    public void deleteItem() {
        hashMap.put(4, "test");
        hashMap.delete(4);
        assertNull(hashMap.get(4));
    }


    @Test
    public void deleteCollisionItems() {
        hashMap.put(4, "test");
        hashMap.put(14, "test2");
        hashMap.delete(4);
        assertNull(hashMap.get(4));
    }
}
