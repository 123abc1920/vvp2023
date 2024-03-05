package ru.tasks.task2_25;

import java.util.Iterator;

public class TheList<T> implements Iterable<T> {
	private TheElement head = null;
	private TheElement tail = null;

	public TheList() {
	}

	public TheList(Object a) {
		this.head = new TheElement(a);
		this.tail = head;
	}

	public TheList(Object... a) {
		this.head = new TheElement(a[0]);
		this.tail = head;

		for (int i = 1; i < a.length; i++) {
			this.addEnd(a[i]);
		}
	}

	public void changeHead(TheElement head) {
		this.head = head;
	}

	public void changeTail(TheElement tail) {
		this.tail = tail;
	}

	public void addEnd(Object a) {
		TheElement el = new TheElement(a);
		this.tail.setNext(el);
		el.setPrevious(this.tail);

		this.tail = el;
	}

	public void addStart(Object a) {
		TheElement el = new TheElement(a);
		this.head.setPrevious(el);
		el.setNext(this.head);

		this.head = el;
	}

	public int size() {
		if (this.head == null) {
			return 0;
		}

		TheElement a = this.head;
		int count = 1;

		while (a.getNext() != null) {
			count++;
			a = a.getNext();
		}

		return count;
	}

	public TheElement get(int num) {
		if (num >= this.size()) {
			System.out.println("Error");
			return null;
		}
		TheElement a = this.head;

		for (int i = 0; i < num; i++) {
			a = a.getNext();
		}

		return a;
	}

	public void set(int num, Object value) {
		if (num > this.size()) {
			System.out.println("Error");
			return;
		}
		TheElement a = this.head;

		for (int i = 0; i < num; i++) {
			a = a.getNext();
		}

		a.setValue(value);
	}

	public void clear() {
		this.head.setValue(0);
		this.head.setNext(null);
		this.head.setPrevious(null);
		this.head = null;
		this.tail = this.head;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int a = 0;

			@Override
			public boolean hasNext() {
				return a < Task2_25.l.size();
			}

			@Override
			public T next() {
				return (T) Task2_25.l.get(a++);
			}

		};
	}
}
