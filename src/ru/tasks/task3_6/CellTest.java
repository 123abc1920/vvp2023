package ru.tasks.task3_6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.tasks.task3_6.Cell.G;

class CellTest {
	private static Cell first = new Cell();
	private static Cell second = new Cell();
	private static Cell third = new Cell();
	private static Cell fourth = new Cell();

	private static Cell[] cells = new Cell[4];

	@BeforeAll
	static void init() {
		first.addTop(second, G.BOTTOM);
		first.addTop(third, G.RIGHT);
		first.setNum(0);

		second.addTop(fourth, G.RIGHT);
		third.addTop(fourth, G.BOTTOM);

		cells[G.TOP.getI()] = null;
		cells[G.BOTTOM.getI()] = second;
		cells[G.RIGHT.getI()] = third;
		cells[G.LEFT.getI()] = null;
	}

	@Test
	void testFirst() {
		assertEquals(second, first.getOneTop(G.BOTTOM));
		assertEquals(null, first.getOneTop(G.LEFT));
		assertEquals(null, first.getOneTop(G.TOP));
		assertEquals(third, first.getOneTop(G.RIGHT));
	}

	@Test
	void testThird() {
		assertEquals(null, third.getOneTop(G.LEFT));
		assertEquals(fourth, third.getOneTop(G.BOTTOM));
		assertEquals(null, third.getOneTop(G.TOP));
		assertEquals(null, third.getOneTop(G.RIGHT));
		assertEquals(third, first.getOneTop(G.RIGHT));
	}

	@Test
	void testTops() {
		assertEquals(cells.length, first.getTops().length);
		assertEquals(cells[0], first.getTops()[0]);
		assertEquals(cells[1], first.getTops()[1]);
		assertEquals(cells[2], first.getTops()[2]);
		assertEquals(cells[3], first.getTops()[3]);
	}

	@Test
	void testNum() {
		assertEquals(0, first.getNum());
	}
}
