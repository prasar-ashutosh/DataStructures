package com.practice.ds.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		Queue<Integer> queue = new LinkedList<Integer>();
		ReentrantLock lock = new ReentrantLock();
		Condition con = lock.newCondition();
		final int size = 5;

		new Producer(lock, con, queue, size).start();
		new Consumer(lock, con, queue).start();

	}

}

class Producer extends Thread {

	ReentrantLock lock;
	Condition con;
	Queue<Integer> queue;
	int size;

	public Producer(ReentrantLock lock, Condition con, Queue<Integer> queue, int size) {
		this.lock = lock;
		this.con = con;
		this.queue = queue;
		this.size = size;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			while (queue.size() == size) {
				try {
					con.await();
				} catch (InterruptedException ex) {
					Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			queue.add(i);
			System.out.println("Produced : " + i);
			con.signal();
			lock.unlock();
		}
	}

}

class Consumer extends Thread {

	ReentrantLock lock;
	Condition con;
	Queue<Integer> queue;

	public Consumer(ReentrantLock lock, Condition con, Queue<Integer> queue) {
		this.lock = lock;
		this.con = con;
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			while (queue.size() < 1) {
				try {
					con.await();
				} catch (InterruptedException ex) {
					Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			System.out.println("Consumed : " + queue.remove());
			con.signal();
			lock.unlock();
		}
	}
}