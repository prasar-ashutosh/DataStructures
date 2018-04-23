package com.practice.ds.queues;

import java.util.Stack;

public class QueueUsingStacks {

	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	// Push every thing to s1
	public static void enQueue(int val) {
		s1.push(val);
	}

	// Only if s2 is empty, push every thing from s1 to s2
	// pop from s2
	public static int deQueue() {
		int val = 0;
		if(s1.isEmpty() && s2.isEmpty())
		{
			// throw Empty Queue Exception						
		}
		else{
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			val = s2.pop();
		}
		return val;
	}

	public static int poll() {
		int val = 0;
		if(s1.isEmpty() && s2.isEmpty())
		{
			// throw Empty Queue Exception						
		}
		else{
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			val = s2.peek();
		}
		return val;
	}

}
