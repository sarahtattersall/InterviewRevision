package com.st809.interview.datastructures.hash;

import com.st809.interview.datastructures.list.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ChainedHashMap<Key, Value> implements HashMap<Key, Value> {

    /**
     * Number of key value pairs
     */
    private int N;

    /**
     * Hash table size
     */
    private int M;

    private List<LinkedList<Entry<Key, Value>>> table;

    public ChainedHashMap(int M) {
        this.M = M;
        table = new ArrayList<>(M);
        while (table.size() < M) {
            table.add(new LinkedList<Entry<Key, Value>>());
        }
    }

    @Override
    public Value get(Key key) {
        int hash = hash(key);
        LinkedList<Entry<Key, Value>> list = table.get(hash);
        for (Entry<Key, Value> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public void put(Key key, Value value) {
        int hash = hash(key);
        LinkedList<Entry<Key, Value>> values = table.get(hash);

        for (Entry<Key, Value> entry : values) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        Entry<Key, Value> entry = new Entry<>(key, value);
        values.insert(entry);

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff % M);
    }

    public void delete(Key key) {
        int hash = hash(key);
        LinkedList<Entry<Key, Value>> values = table.get(hash);
        Entry<Key, Value> delete = null;
        for (Entry<Key, Value> entry : values) {
            if (entry.key.equals(key)) {
                delete = entry;
            }
        }
        if (delete != null) {
            values.delete(delete);
        }
    }

    public static class Entry<Key, Value> {
        public Key key;

        public Value value;

        public Entry(Key key, Value value) {

            this.key = key;
            this.value = value;
        }
    }
}
