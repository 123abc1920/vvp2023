package ru.tasks.task3_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queue {
	private Object head = null;
	private List<Object> lst = new ArrayList<>();
	private int ind = 0;

	public Queue() {

	}

	public Queue(Object o) {
		this.head = o;
		this.lst.add(o);
	}

	public void add(Object o) {
		if (this.head == null) {
			this.head = o;
		}
		this.lst.add(o);
	}

	public Object get() {
		return this.head;
	}

	public Object getDelete() {
		Object o = this.head;
		this.lst.remove(0);

		if (!lst.isEmpty()) {
			this.head = lst.get(0);
		} else {
			this.head = null;
		}

		return o;
	}

	public void delete() {
		if (!lst.isEmpty()) {
			lst.remove(0);
			this.head = lst.get(0);
		}
	}

	public int length() {
		return lst.size();
	}

	public boolean isEmpty() {
		return this.length() == 0 ? true : false;
	}
}
