package ru.tasks.task3_6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.tasks.task3_6.Cell.G;

class LabiryntTest {
	private static Labirynt l;
	private static Map<Integer, List<G>> map = new HashMap<>();

	@BeforeAll
	static void init() {
		//map.put(2, Arrays.asList(G.LEFT));
		l = new Labirynt(2, 2, map);
	}

	@Test
	void testLength() {
		assertEquals(l.getArray().size(), 4);
	}

	@Test
	void testBoundsStart() {
		assertEquals(l.getArray().get(0).getOneTop(G.TOP), null);
		assertEquals(l.getArray().get(0).getOneTop(G.RIGHT), l.getArray().get(1));
		assertEquals(l.getArray().get(0).getOneTop(G.BOTTOM), l.getArray().get(2));
		assertEquals(l.getArray().get(0).getOneTop(G.LEFT), null);
	}

	@Test
	void testBoundsEnd() {
		assertEquals(l.getArray().get(3).getOneTop(G.TOP), null);
		assertEquals(l.getArray().get(3).getOneTop(G.RIGHT), null);
		assertEquals(l.getArray().get(3).getOneTop(G.BOTTOM), null);
		assertEquals(l.getArray().get(3).getOneTop(G.LEFT), null);
	}

	@Test
	void testBoundsMedium1() {
		assertEquals(l.getArray().get(1).getOneTop(G.TOP), null);
		assertEquals(l.getArray().get(1).getOneTop(G.RIGHT), null);
		assertEquals(l.getArray().get(1).getOneTop(G.BOTTOM), l.getArray().get(3));
		assertEquals(l.getArray().get(1).getOneTop(G.LEFT), null);
	}

	@Test
	void testBoundsMedium2() {
		assertEquals(l.getArray().get(2).getOneTop(G.TOP), null);
		assertEquals(l.getArray().get(2).getOneTop(G.RIGHT), l.getArray().get(3));
		assertEquals(l.getArray().get(2).getOneTop(G.BOTTOM), null);
		assertEquals(l.getArray().get(2).getOneTop(G.LEFT), null);
	}
}
