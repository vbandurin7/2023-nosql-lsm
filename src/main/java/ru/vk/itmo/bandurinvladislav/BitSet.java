package ru.vk.itmo.bandurinvladislav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
  My simplified implementation of BitSet for getting long[] array without copying data
  (Default java implementation doesn't have this option)
*/
public class BitSet {

    private final long[] longs;

    public BitSet(int capacity) {
        this.longs = new long[capacity];
    }

    public void set(int i) {
        int arrayOffset = i >> 6;
        int longOffset = i - (arrayOffset << 6);

        longs[arrayOffset] =  longs[arrayOffset] | (1L << (63 - longOffset));
    }

    public boolean get(int i) {
        int arrayOffset = i >> 6;
        int longOffset = i - (arrayOffset << 6);

        return ((1L << (63 - longOffset)) & longs[arrayOffset]) != 0;
    }

    public long[] getLongs() {
        return longs.clone();
    }

    public int size() {
        return longs.length;
    }
}
