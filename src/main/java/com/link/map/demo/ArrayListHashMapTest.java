package com.link.map.demo;

import com.link.map.demo.ext.ExtArrayListHashMap;

/**
 * 基于ArrayList实现hashMap集合: 性能特别低
 */
public class ArrayListHashMapTest {

    public static void main(String[] args) {
        ExtArrayListHashMap hashMap = new ExtArrayListHashMap<String, String>();
        hashMap.put("a", "aaaa");
        hashMap.put("b", "bbbb");
        // key 相同的情况下， 会覆盖
        hashMap.put("a", "cccc");
        System.out.println(hashMap.get("a"));
        System.out.println(hashMap.get("b"));
    }

    /**
     * 结果：
     * a ---- cccc
     * b ---- bbbb
     */

}
