package com.link.map.demo;

import com.link.map.demo.ext.LinkedListHashMap;

/**
 * 基于LinkedList实现HashMap(效率低): HasMap使用数组+链表方式实现
 */
public class LinkListHashMapTest {

    public static void main(String[] args) {
        LinkedListHashMap linkedListHashMap = new LinkedListHashMap();
        linkedListHashMap.put("a", "aaaa");
        // 覆盖
        linkedListHashMap.put("a", "cccc");
        System.out.println(linkedListHashMap.get("a"));
    }


    /**
     * 重写equals()方法时，一般都会重写HashCode(),why？
     * 两个对象做比较的时候,如果hashCode相同，对象的值是不一定相同
     * 两个对象做比较的时候,如果equals比较相同，对象的值一定相同相同
     */

}
