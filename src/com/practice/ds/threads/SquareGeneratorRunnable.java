package com.practice.ds.threads;

public class SquareGeneratorRunnable implements Runnable {

	private int i;

	public SquareGeneratorRunnable(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("Thread" + Thread.currentThread().getName() + 
				" , square of : " + i + " = " + i * i);

	}

}
