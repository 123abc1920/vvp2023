package ru.tasks.task3_6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import ru.tasks.task3_6.Cell.G;

public class FindPath {
	public static List<Cell> findStandart() {
		List<Cell> lst = new ArrayList<>();

		Deque<Cell> deque = new ArrayDeque<>();
		deque.add(Task3_6.l.getStart());

		Cell u = Task3_6.l.getStart();

		while (!u.equals(Task3_6.l.getEnd()) && !deque.isEmpty()) {
			u = deque.pollFirst();
			u.setDone(true);

			if (u.getOneTop(G.BOTTOM) != null && u.getOneTop(G.BOTTOM).getDone() == false) {
				deque.add(u.getOneTop(G.BOTTOM));
				u.getOneTop(G.BOTTOM).setPrev(u);
			}
			if (u.getOneTop(G.RIGHT) != null && u.getOneTop(G.RIGHT).getDone() == false) {
				deque.add(u.getOneTop(G.RIGHT));
				u.getOneTop(G.RIGHT).setPrev(u);
			}
			if (u.getOneTop(G.TOP) != null && u.getOneTop(G.TOP).getDone() == false) {
				deque.add(u.getOneTop(G.TOP));
				u.getOneTop(G.TOP).setPrev(u);
			}
			if (u.getOneTop(G.LEFT) != null && u.getOneTop(G.LEFT).getDone() == false) {
				deque.add(u.getOneTop(G.LEFT));
				u.getOneTop(G.LEFT).setPrev(u);
				System.out.println(u.getNum() + " " + deque.peek().getNum() + " " + u.getOneTop(G.LEFT).getNum());
			}
		}

		if (u.equals(Task3_6.l.getEnd())) {
			while (true) {
				lst.add(u);
				if (u.getPrev() == null) {
					break;
				}
				u = u.getPrev();
			}
		}

		Task3_6.l.setAllNotDone();

		return lst;
	}

	public static List<Cell> findMyQueue() {
		List<Cell> lst = new ArrayList<>();

		Queue deque = new Queue();
		deque.add(Task3_6.l.getStart());

		Cell u = Task3_6.l.getStart();
		int c = 0;

		while (!u.equals(Task3_6.l.getEnd()) && !deque.isEmpty()) {
			u = (Cell) deque.getDelete();
			u.setDone(true);

			if (u.getOneTop(G.BOTTOM) != null && u.getOneTop(G.BOTTOM).getDone() == false) {
				deque.add(u.getOneTop(G.BOTTOM));
				u.getOneTop(G.BOTTOM).setPrev(u);
			}
			if (u.getOneTop(G.RIGHT) != null && u.getOneTop(G.RIGHT).getDone() == false) {
				deque.add(u.getOneTop(G.RIGHT));
				u.getOneTop(G.RIGHT).setPrev(u);
			}
			if (u.getOneTop(G.TOP) != null && u.getOneTop(G.TOP).getDone() == false) {
				deque.add(u.getOneTop(G.TOP));
				u.getOneTop(G.TOP).setPrev(u);
			}
			if (u.getOneTop(G.LEFT) != null && u.getOneTop(G.LEFT).getDone() == false) {
				deque.add(u.getOneTop(G.LEFT));
				u.getOneTop(G.LEFT).setPrev(u);
			}
		}

		if (u.equals(Task3_6.l.getEnd())) {
			while (true) {
				lst.add(u);
				if (u.getPrev() == null) {
					break;
				}
				u = u.getPrev();
			}
		}

		Task3_6.l.setAllNotDone();

		return lst;
	}
}
