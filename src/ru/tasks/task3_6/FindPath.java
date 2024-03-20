package ru.tasks.task3_6;

import java.util.ArrayDeque;
import java.util.Deque;

import ru.tasks.task3_6.Cell.G;

public class FindPath {
	public static void find() {
		Deque<Cell> deque = new ArrayDeque<>();
		int len = 0;

		deque.add(Task3_6.l.getStart());
		System.out.println(len);
		Cell u = Task3_6.l.getStart();

		while (!u.equals(Task3_6.l.getEnd()) && !deque.isEmpty()) {
			u = deque.pollFirst();
			System.out.println(len);
			len++;
			if (u.getOneTop(G.BOTTOM) != null) {
				deque.add(u.getOneTop(G.BOTTOM));
			}
			if (u.getOneTop(G.RIGHT) != null) {
				deque.add(u.getOneTop(G.RIGHT));
			}
		}
	}
}
