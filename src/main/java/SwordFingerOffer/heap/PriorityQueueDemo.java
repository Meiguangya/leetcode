package main.java.SwordFingerOffer.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @author meiguangya
 * @date 2025/8/2 下午4:20
 * @description TODO
 */
@Slf4j
public class PriorityQueueDemo {


    public static void main(String[] args) {

        // 添加 add |  offer
        // 删除 remove | poll
        // 查看栈顶 element | peek
        PriorityQueue<Integer> q = new PriorityQueue();

        // [3,2,1,5,6,4]
        q.add(3);
        q.add(2);
        q.add(1);
        q.add(5);
        q.add(6);
        q.add(4);

        for (Integer i : q) {
            log.info("遍历:{}",i);
        }

        Integer peek = q.peek();
        log.info("{}",peek);

        Integer remove = q.remove();
        log.info("{}",remove);

        for (Integer i : q) {
            log.info("遍历:{}",i);
        }


    }

}
