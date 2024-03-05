package ru.tasks.task2_25;

import java.util.List;

public class Task2_25 {
	public static TheList<TheElement> l = null;

	public static void main(String[] args) {
		l = new TheList("kkk", 0, 5.9, false, -9);

		change(0, 4);

		/*
		 * for (int i = l.size() - 1; i >= 0; i--) { if (l.get(i).getPrevious() != null)
		 * { System.out.printf("%d -> %d%n", l.get(i).getValue(),
		 * l.get(i).getPrevious().getValue()); } }
		 * 
		 * System.out.println();
		 * 
		 * for (int i = l.size() - 1; i >= 0; i--) { if (l.get(i).getNext() != null) {
		 * System.out.printf("%d -> %d%n", l.get(i).getValue(),
		 * l.get(i).getNext().getValue()); } }
		 */

		for (TheElement i : l) {
			System.out.print(i.getValue() + " ");
		}
	}

	private static void change(int a, int b) {
		TheElement from = Task2_25.l.get(a);
		TheElement to = Task2_25.l.get(b);
		TheElement a1 = from.getPrevious();
		TheElement a2 = from.getNext();
		TheElement b1 = to.getPrevious();
		TheElement b2 = to.getNext();

		setMains(from, b1, b2);
		setMains(to, a1, a2);
		setRefs(to, a1, a2);
		setRefs(from, b1, b2);

		if (a == 0) {
			l.changeHead(to);
		}
		if (b == l.size() - 1) {
			l.changeTail(from);
		}
	}

	private static void setRefs(TheElement A, TheElement a1, TheElement a2) {
		if (a1 != null) {
			a1.setNext(A);
		}
		if (a2 != null) {
			a2.setPrevious(A);
		}
	}

	private static void setMains(TheElement A, TheElement a1, TheElement a2) {
		A.setNext(a2);
		A.setPrevious(a1);
	}
}
