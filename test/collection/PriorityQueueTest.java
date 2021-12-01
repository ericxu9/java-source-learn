package collection;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 优先队列测试
 *
 * leftNo = parentNo*2+1
 *
 * rightNo = parentNo*2+2
 *
 * parentNo = (nodeNo-1)/2
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(15);
        priorityQueue.add(10);
        priorityQueue.add(8);
        priorityQueue.add(20);
        priorityQueue.add(5);
        System.out.println(priorityQueue);

       while (priorityQueue.size() != 0) {
           System.out.print(priorityQueue.poll() + "  ");
       }

    }
}
