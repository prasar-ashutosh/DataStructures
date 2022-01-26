package com.practice.ds.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerWaitNotify {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		Queue<Integer> queue = new LinkedList<Integer>();
		final int size = 5;

		new MyProducer(queue, size).start();
		new MyConsumer(queue).start();

	}

}

class MyProducer extends Thread {

	Queue<Integer> queue;
	int size;

	public MyProducer(Queue<Integer> queue, int size) {
		this.queue = queue;
		this.size = size;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (queue) {
			
				while (queue.size() == size) {
					try {
						System.out.println("Queue Full!!");
						queue.wait();
					} catch (InterruptedException ex) {
						Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				queue.offer(i);
				queue.notify();
				System.out.println("Produced : " + i);
			}
		}
	}

}

class MyConsumer extends Thread {

	Queue<Integer> queue;

	public MyConsumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (queue) {
				while (queue.size() < 1) {
					try {
						System.out.println("Queue Empty!!");
						queue.wait();
					} catch (InterruptedException ex) {
						Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				System.out.println("Consumed : " + queue.remove());
				queue.notify();
			}
		}
	}
}