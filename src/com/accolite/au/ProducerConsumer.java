package com.accolite.au;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer extends Thread{
	public static void main(String[] args) {
		BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
		Thread producer=new Thread() {
			public void run() {
				Random rand=new Random();
				for(int i=0;i<100000;i++) {
					Integer num=new Integer(rand.nextInt());
					try {
						queue.put(num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread consumer=new Thread() {
			public void run() {
				for(int j=0;j<100000;j++) {
					try {
						System.out.println(queue.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		consumer.start();
		producer.start();
	}

}
