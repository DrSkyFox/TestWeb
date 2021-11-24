package ru.test.models;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapSized<K,V> extends LinkedHashMap<K,V> {

    private final int maxSize;

    public HashMapSized(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size()  > maxSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HashMapSized<?, ?> that = (HashMapSized<?, ?>) o;
        return maxSize == that.maxSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSize);
    }
}
