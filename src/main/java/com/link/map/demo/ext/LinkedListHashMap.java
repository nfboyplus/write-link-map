package com.link.map.demo.ext;

import java.util.LinkedList;

/**
 * 基于LinkedList实现HashMap(效率低): HasMap使用数组+链表方式实现
 */
@SuppressWarnings("rawtypes") //rawtypes是说传参时也要传递带泛型的参数
public class LinkedListHashMap {

    /**
     * Map存放Entry对象
     */
    @SuppressWarnings("unchecked") //告诉编译器忽略 unchecked 警告信息，如使用List，ArrayList等未进行参数化产生的警告信息
    LinkedList<Entry>[] tables = new LinkedList[998];

    /**
     * 如果hashCode相同的对象链表结合中
     */
    public void put(Object key, Object value){
        Entry newEntry = new Entry(key, value);
        int hashCode = key.hashCode();//97
        //hash 取模，获取余数
        int hash = hashCode % tables.length; //998
        //获取该下标元素，是否有LinkedList
        LinkedList<Entry> entryLinkedList = tables[hash];
        if (entryLinkedList == null){
            //没有hash冲突
            entryLinkedList = new LinkedList<Entry>();
            entryLinkedList.add(newEntry);
            //tables 数组
            tables[hash] = entryLinkedList;
        }else {
            for (Entry entry : entryLinkedList){
                if (entry.key.equals(key)){
                    //equals相等,hashCode 一定相同 说明:是同一个对象
                    entry.value = value;//直接覆盖
                }else {
                    //hashCode 相同，对象的值不一定相同
                    //发生hash冲突问题，直接在后面继续添加链表节点
                    entryLinkedList.add(newEntry);
                }
            }
        }
    }

    /**
     * 查询直接使用hash值直接定位在数组那个位置
     */
    public Object get(Object key){
        int hashCode = key.hashCode();//97
        // hash取模，获取余数
        int hash = hashCode % tables.length;// 998 998以内 00997
        LinkedList<Entry> linkedList = tables[hash];
        for (Entry entry : linkedList){
            if (entry.key.equals(key)){
                return entry.value;
            }
        }
        return tables[hash];
    }


}
