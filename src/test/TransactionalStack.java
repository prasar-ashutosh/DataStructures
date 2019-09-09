package test;

import java.util.Stack;

public class TransactionalStack {

	private Stack<Integer> elements;
	// storing a stack of Solution stack
	private Stack<TransactionalStack> transactions;

	public TransactionalStack() {
		// write your code in Java SE 8
		elements = new Stack<>();
		transactions = new Stack<>();
		transactions.push(this);
	}

	public void push(int value) {
		// Find the latest transaction
		TransactionalStack latestTranaction = transactions.peek();
		// Find the latest stack
		Stack<Integer> latestStack = latestTranaction.elements;
		// push to the latest stack
		latestStack.push(value);
	}

	public int top() {
		// Find the latest transaction
		TransactionalStack latestTranaction = transactions.peek();
		// Find the latest stack
		Stack<Integer> latestStack = latestTranaction.elements;
		// peek from the latest stack
		if (latestStack.empty()) {
			return 0;
		} else {
			return latestStack.peek();
		}
	}

	public void pop() {
		// Find the latest transaction
		TransactionalStack latestTranaction = transactions.peek();
		// Find the latest stack
		Stack<Integer> latestStack = latestTranaction.elements;
		// pop from latest stack
		if (!latestStack.empty()) {
			latestStack.pop();
		}
	}

	public void begin() {
		// Start a new transaction
		TransactionalStack transaction = new TransactionalStack();
		// Copy the contents of main stack to the the new transaction stack
		transaction.elements = (Stack<Integer>) elements.clone();
		// add transaction to the transactions stack
		transactions.add(transaction);
	}

	public boolean rollback() {
		// Find the latest transaction
		TransactionalStack latestTranaction = transactions.peek();
		// if we are in a transaction, pop the contents of stack from the current
		// transaction
		if (latestTranaction != this) {
			transactions.pop();
			return true;
		} else {
			return false;
		}
	}

	public boolean commit() {
		// Find the latest transaction
		TransactionalStack latestTranaction = transactions.peek();
		// if we are in a transaction, pop the contents of stack from the current
		// transaction and add them to the prev transaction
		if (latestTranaction != this) {
			latestTranaction = transactions.pop();
			transactions.peek().elements = latestTranaction.elements;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		TransactionalStack sol = new TransactionalStack();
		sol.push(4);
		sol.begin(); // start transaction 1
		sol.push(7); // stack: [4,7]
		sol.begin(); // start transaction 2
		sol.push(2); // stack: [4,7,2]
		System.out.println(sol.rollback());// == true; // rollback transaction 2
		System.out.println(sol.top());// == 7; // stack: [4,7]
		sol.begin(); // start transaction 3
		sol.push(10); // stack: [4,7,10]
		System.out.println(sol.commit());// == true; // transaction 3 is committed
		System.out.println(sol.top()); // == 10;
		System.out.println(sol.rollback());// == true; // rollback transaction 1
		System.out.println(sol.top());// == 4; // stack: [4]
		System.out.println(sol.commit());// == false; // there is no open transaction

	}

}
