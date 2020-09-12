package com.company.competitiveProgramming.incomplete;

import java.util.*;
import java.util.zip.ZipInputStream;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cacheList;
    //key can be a negative number
    //when array limit is reached, add the new values at the end of array
    //next time when a new value is added & size of the array is full, we remove the second last value;

    //create an ascii array that'll be used to create hashed values for the KEY & will be used as an index
    //need a pointer for ascii array to know which ascii character was last used to create hash. This will help in popping out the second last value
    //if key is greater than Integer.Max_Value - 127 (127 is the max dec number from the hash array, we use key just as a key)
    public LRUCache(int capacity) {

        if(capacity > Integer.MAX_VALUE)
            capacity = Integer.MAX_VALUE;
        final int mapCapacity = capacity;

        cacheList = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > mapCapacity;
            }
        };
    }
    
    public int get(int key) {
        if(key > cacheList.size() || key > Integer.MAX_VALUE)
            return -1;

        return cacheList.get(key);
    }

    public void put(int key, int value) {
        if(key > cacheList.size() || key > Integer.MAX_VALUE || value > Integer.MAX_VALUE)
            return;

        cacheList.put(key, value);

//        cacheList.add(key+"", value);
    }
}
