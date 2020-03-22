package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumer {

    private Queue<String> queue = new LinkedList<>();
    private AtomicInteger tasknum = new AtomicInteger(0);
    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 20) {
                        queue.notify();
                        System.out.println("队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add("task" + tasknum.getAndIncrement());
                    queue.notify();
                    System.out.println("生产者生成了一条消息"+queue.peek());
                }
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            comsume();
        }

        private void comsume() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(queue.poll());
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Producer producer = producerAndConsumer.new Producer();
        Consumer consumer = producerAndConsumer.new Consumer();
        producer.start();
        consumer.start();
    }
}
