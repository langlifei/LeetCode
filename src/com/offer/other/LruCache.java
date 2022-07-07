package com.offer.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zz
 * @Date: 2022/6/11 12:51
 */
public class LruCache<K,V> {


    /**
     * 容量
     */
    private final int capacity;

    private int size;

    private final Map<K, Entry<K,V>> cache;

    private final Entry<K,V> head = new Entry<>();

    private final Entry<K,V> tail = new Entry<>();

    public LruCache(int capacity){
        this.capacity = capacity;
        //额外添加首位两个虚拟结点
        this.cache = new HashMap<>(capacity);
        head.left = null;
        head.right = tail;
        tail.left = head;
        tail.right = null;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public V get(K key){
        //从缓存中取出结点
        Entry<K,V> value = cache.get(key);
        if(value == null){
            return null;
        }
        //从队列中删除当前结点信息
        deleteEntry(value);
        //将当前信息存储到链头
        insertEntryToHead(value);
        return value.value;
    }

    public void push(K key , V value){
        Entry<K,V> objectEntry = cache.get(key);
        if(objectEntry != null){
            objectEntry.value = value;
            deleteEntry(objectEntry);
            insertEntryToHead(objectEntry);
        }else{
            if(size < capacity){
                //将刚插入的结点存入缓存，并计入到顺序链的首部。
                Entry<K,V> entry = new Entry<>();
                entry.value = value;
                entry.key = key;
                cache.put(key,entry);
                insertEntryToHead(entry);
                size++;
            }else{
                //从链尾获取最近最少使用的结点
                Entry<K,V> entry = tail.left;
                cache.remove(entry.key);
                deleteEntry(entry);
                //修改entry的值
                entry.key = key;
                entry.value = value;
                cache.put(key,entry);
                insertEntryToHead(entry);
            }
        }
    }

    private void insertEntryToHead(Entry<K,V> value) {
        value.right = head.right;
        head.right.left = value;
        head.right = value;
        value.left = head;
    }

    private void deleteEntry(Entry<K,V> value) {
        //移除当前结点的右指针。
        value.left.right = value.right;
        //移除当前结点的左指针。
        value.right.left = value.left;
        value.right = null;
        value.left = null;
    }

    public int getSize() {
        return size;
    }

    /**
     * 使用双指针来建立缓存之间的关系
     */
    private static class Entry<K,V>{
        public Entry<K,V> left;
        public Entry<K,V>  right;
        public K key;
        public V value;

        public Entry(){}

        public Entry(V value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LruCache<String,String> lruCache=new LruCache<>(5);
        lruCache.push("001","用户1信息");
        lruCache.push("002","用户2信息");
        lruCache.push("003","用户3信息");
        lruCache.push("004","用户4信息");
        lruCache.push("005","用户5信息");
        lruCache.get("002");
        lruCache.push("004","用户2信息更新");
        lruCache.push("006","用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
        System.out.println(lruCache.get("004"));
    }
}
