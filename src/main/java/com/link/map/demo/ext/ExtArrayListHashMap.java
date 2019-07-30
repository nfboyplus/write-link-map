package com.link.map.demo.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于ArrayList实现hashMap集合: 性能特别低
 */
public class ExtArrayListHashMap<Key,Value> {

    /**
     * map 存储容量
     */
    private List<Entry<Key,Value>> tables = new ArrayList<Entry<Key, Value>>();

    /**
     * map容器实际容量
      */
     private int size;

    public void put(Key key, Value value){
        Entry entry = getEntry(key);
        if (entry != null){
            //已经存在
           entry.value = value;
        }else {
            Entry newEntry = new Entry(key, value);
            //调用put的时候，将该 hash存储对象存入到ArrayList中
            tables.add(newEntry);
        }
    }

    public Value get(Key key) {
        Entry<Key,Value> entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public Entry<Key, Value> getEntry(Key key){
        //从头查询到尾做优化### 准
        for (Entry<Key, Value> entry : tables){
            if (entry.key.equals(key))
                return entry;
        }
        return null;
    }

}
