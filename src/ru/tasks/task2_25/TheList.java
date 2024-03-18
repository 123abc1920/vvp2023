package ru.tasks.task2_25;

import java.util.Iterator;

public class TheList<T> implements Iterable<TheElement<T>> {
	private TheElement head = null;
	private TheElement tail = null;

	public TheList() {
	}

	public TheList(T a) {
		this.head = new TheElement<>(a);
		this.tail = head;
	}

	public TheList(T... a) {
		this.head = new TheElement<>(a[0]);
		this.tail = head;

		for (int i = 1; i < a.length; i++) {
			this.addEnd(a[i]);
		}
	}

	public void change(int a, int b) {
		if (a > b) {
			int c = b;
			b = a;
			a = c;
		}

		TheElement from = this.get(a);
		TheElement to = this.get(b);
		TheElement a1 = from.getPrevious();
		TheElement a2 = from.getNext();
		TheElement b1 = to.getPrevious();
		TheElement b2 = to.getNext();

		if (Math.abs(a - b) > 1) {
			setMains(from, b1, b2);
			setMains(to, a1, a2);
			setRefs(to, a1, a2);
			setRefs(from, b1, b2);
		} else if (Math.abs(a - b) == 0) {
			return;
		} else {
			setRefs(to, a1, null);
			setRefs(from, null, b2);
			setMains(to, a1, from);
			setMains(from, to, b2);
		}

		if (a == 0) {
			head = to;
		}
		if (b == this.size() - 1) {
			tail = from;
		}
	}

	public void setRefs(TheElement A, TheElement a1, TheElement a2) {
		if (a1 != null) {
			a1.setNext(A);
		}
		if (a2 != null) {
			a2.setPrevious(A);
		}
	}

	private void setMains(TheElement A, TheElement a1, TheElement a2) {
		A.setNext(a2);
		A.setPrevious(a1);
	}

	public void addEnd(Object a) {
		TheElement el = new TheElement(a);
		if (this.head == null) {
			this.head = el;
		} else {
			this.tail.setNext(el);
			el.setPrevious(this.tail);
		}

		this.tail = el;
	}

	public void addStart(Object a) {
		TheElement el = new TheElement(a);
		if (this.head != null) {
			this.head.setPrevious(el);
			el.setNext(this.head);
		} else {
			this.tail = el;
		}

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

	public TheList<TheElement> copy(int start, int end) {
		TheList<TheElement> lst = new TheList<>();

		for (int i = start; i < end; i++) {
			lst.addEnd(this.get(i).getValue());
		}

		return lst;
	}

	@Override
	public Iterator<TheElement<T>> iterator() {
		return new Iterator<TheElement<T>>() {
			int a = 0;

			@Override
			public boolean hasNext() {
				return a < Win2_25.l.size();
			}

			@Override
			public TheElement<T> next() {
				return Win2_25.l.get(a++);
			}

		};
	}
}
