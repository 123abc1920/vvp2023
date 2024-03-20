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
	private static Map<Integer, List<G>> map = new HashMap<>();
	private static List<G> lst = new ArrayList<>();

	@BeforeAll
	static void init() throws FileNotFoundException {
		map = readWrite.read();
	}

	@Test
	void testRead() {
		assertEquals(map.get(0).get(0), G.RIGHT);
	}

}
