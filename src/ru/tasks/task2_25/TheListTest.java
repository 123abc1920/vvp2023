package ru.tasks.task2_25;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TheListTest {
	static TheList<TheElement> l = new TheList<>();

	@BeforeAll
	static void init() {
		l.addEnd(2);
		l.addEnd(4);
		l.addEnd(67);
		l.addStart("lll");
		l.set(3, true);
	}

	@Test
	void test1() {
		assertEquals(true, l.get(3).getValue());
	}

	@Test
	void test2() {
		assertEquals(4, l.size());
	}

	@Test
	void test3() {
		l.change(0, l.size() - 1);
		assertEquals("true lll", l.get(0).getValue()+" "+l.get(l.size()-1).getValue());
	}
}
