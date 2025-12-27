package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author meiguangya
 * @date 2025/12/27 下午7:31
 * @description 设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构
 */
public class LRUCache {

    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map = new HashMap<>();

    class DLinkedNode {

        DLinkedNode next;
        DLinkedNode pre;
        int val;
        int key;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode(-100,-100);
        this.tail = new DLinkedNode(-200,-200);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {

        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {

        DLinkedNode existNode = map.get(key);
        if (existNode != null) {
            // 更新节点值
            existNode.val = value;
            moveToHead(existNode);
        } else {
            // 往头部添加节点
            DLinkedNode node = new DLinkedNode(key, value);
            addNodeToHead(node);

            map.put(node.key, node);

            size++;

            if (size > capacity) {
                DLinkedNode lastNode = removeLastNode();
                map.remove(lastNode.key);
                size--;
            }
        }

    }

    private void addNodeToHead(DLinkedNode node) {

        DLinkedNode temp = head.next;
        head.next = node;
        node.next = temp;

        temp.pre = node;
        node.pre = head;

    }

    private DLinkedNode removeLastNode() {
        printNodeList();
        DLinkedNode lastNode = tail.pre;
        tail.pre = lastNode.pre;
        lastNode.pre.next = tail;
        lastNode.pre = null;
        lastNode.next = null;
        printNodeList();
        return lastNode;
    }

    private void moveToHead(DLinkedNode node) {

        if (node.pre == head) {
            return;
        }

        DLinkedNode tmp = node.pre;
        tmp.next = node.next;
        node.next.pre = tmp;

        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

    }

    public String printNodeList(){
        StringBuilder sb = new StringBuilder("head");
        DLinkedNode temp = this.head.next;
        while(temp!=this.tail){
            sb.append("->"+"["+temp.key+","+temp.val+"]");
            temp = temp.next;
        }
        sb.append("->tail");
        return sb.toString();
    }


    public static void main(String[] args) {

        /**
         * 输入
         * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         */
        LRUCache cache = new LRUCache(2);

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.printNodeList());
        int i = cache.get(1);
        System.out.println(cache.printNodeList());
        cache.put(3,3);
        System.out.println(cache.printNodeList());
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);



    }


}
