package mystack;

import java.util.*;

public class MyStack<T extends Comparable<T>> {
	Node<T> top;
	int count;
	int size;
	
	public MyStack(int _size) throws MyStackException {
		if (_size < 0) {
			throw new MyStackException("Illegal size: " + _size);
		}

		size = _size;
		top = null;
		count = 0;
	}

	public MyStack() {
		top = null;
		size = 10;
		count = 0;
	}

	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (count == size) {
			return true;
		}
		return false;
	}
	
	public void push(T _data) throws MyStackException {
		if (isFull()) {
			throw new MyStackException("Stack is full");
		}

		top = new Node<T>(_data, top);
		count++;
	}
	
	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("Stack is empty");
		}

		T _data = top.getData();
		top = top.next;
		count--;
		return _data;
	}
		
	public T peek() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("Stack is empty");
		}
		return top.getData();
	}
	
	public void sort() {
	}

	public String toString() {
		return null;
	}
}

class Node<T extends Comparable<T>> {
	T data;
	Node<T> next;

	protected Node() {
		data = null;
		next = null;
	}

	protected Node(T _data) {
		data = _data;
		next = null;
	}

	protected Node(T _data, Node<T> _next) {
		data = _data;
		next = _next;
	}

	protected T getData() {
		return data;
	}

}
