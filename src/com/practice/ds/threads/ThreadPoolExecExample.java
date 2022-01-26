package com.practice.ds.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService singleSvc = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
			singleSvc.execute(new SquareGeneratorRunnable(i));
			Future<Integer> response = singleSvc.submit(new SquareGeneratorCallable(i));
			System.out.println(response.get());
		}
		singleSvc.shutdown();

		System.out.println(" -------- ");
		System.out.println(" -------- ");

		ExecutorService fixedThreadPoolExec = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			fixedThreadPoolExec.execute(new SquareGeneratorRunnable(i));
			Future<Integer> response = fixedThreadPoolExec.submit(new SquareGeneratorCallable(i));
			System.out.println(response.get());
		}
		fixedThreadPoolExec.shutdown();

		System.out.println(" -------- ");
		System.out.println(" -------- ");

		ExecutorService executorSvc = new ThreadPoolExecutor(2, 5, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
		for (int i = 0; i < 5; i++) {
			executorSvc.execute(new SquareGeneratorRunnable(i));
			Future<Integer> response = executorSvc.submit(new SquareGeneratorCallable(i));
			System.out.println(response.get());
		}
		executorSvc.shutdown();

	}

}
