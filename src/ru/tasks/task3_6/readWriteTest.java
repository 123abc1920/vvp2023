package ru.tasks.task3_6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.tasks.task3_6.Cell.G;

class readWriteTest {
	private static int[] arr = new int[4];
	private static Map<Integer, List<G>> map = new HashMap<>();

	@BeforeAll
	static void init() throws FileNotFoundException {
		map = readWrite.read();
		arr = readWrite.readSize();
	}

	@Test
	void testRead() {
		assertEquals(map.get(0).get(0), G.RIGHT);
		assertEquals(map.get(5).get(0), G.RIGHT);
		assertEquals(map.get(2).get(0), G.BOTTOM);
		assertEquals(map.get(7).get(0), G.RIGHT);
		assertEquals(map.get(7).get(1), G.BOTTOM);
		assertEquals(map.get(9).get(0), G.BOTTOM);
		assertEquals(map.get(12).get(0), G.RIGHT);
	}

	@Test
	void testReadSize() {
		assertEquals(3, arr[0]);
		assertEquals(5, arr[1]);
		assertEquals(2, arr[2]);
		assertEquals(1, arr[3]);
	}
}
