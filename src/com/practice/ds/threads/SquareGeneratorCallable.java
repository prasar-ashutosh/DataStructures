package com.practice.ds.threads;

import java.util.concurrent.Callable;

public class SquareGeneratorCallable implements Callable<Integer> {

	private int i;

	public SquareGeneratorCallable(int i) {
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		return i*i;
	}
}
