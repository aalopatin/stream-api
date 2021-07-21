package com.example.practice;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayListSpliterator implements Spliterator<String> {

    private final int fence;
    private int index;
    private List<String> list;

    public ArrayListSpliterator(List<String> list) {

        this(0, list.size(), list);
    }

    protected ArrayListSpliterator(int start, int fence, List<String> list) {
        this.list = list;
        this.index = start;
        this.fence = fence;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        if (index >= fence) {
            return false;
        }
        action.accept(list.get(index));
        index++;
        return true;
    }

    @Override
    public Spliterator<String> trySplit() {
        int lo = index;
        int mid = (lo + fence) >>> 1;
        if (lo >= mid) {
            return null;
        }
        index = mid;
        return new ArrayListSpliterator(lo, mid, list);
    }

    @Override
    public long estimateSize() {
        return fence - index;
    }

    @Override
    public int characteristics() {
        return ORDERED | DISTINCT | SIZED | SUBSIZED | IMMUTABLE | NONNULL;
    }
}
