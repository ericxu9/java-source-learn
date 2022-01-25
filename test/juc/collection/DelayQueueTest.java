package juc.collection;

import java.sql.Time;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<MyDelayed> q = new DelayQueue<>();
//        q.put(new MyDelayed(2));
        MyDelayed take = null;
        try {
            System.out.println("take before");
            take = q.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(take);
    }

    /**
     * 需要自定义 Delayed，设置延迟时间
     */
    static class MyDelayed implements Delayed {

        private long second;

        public MyDelayed(long second) {
            this.second = System.nanoTime() + TimeUnit.NANOSECONDS.convert(second, TimeUnit.SECONDS);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.second - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
