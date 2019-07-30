package com.link.map.demo.ext;

/**
 * hash 存储对象
 */
public class Entry<Key, Value> {

    /**
     * hashMap集合存储的key
     */
    Key key;

    /**
     * hashMap集合存储的value
     */
    Value value;

    public Entry(Key key, Value value) {
        super();
        this.key = key;
        this.value = value;
    }

}
