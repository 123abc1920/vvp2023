package ru.tasks.task2_25;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TheElementTest {
	static TheElement el = new TheElement(6);
	static TheElement next = new TheElement("next");
	static TheElement prev = new TheElement(true);

	@BeforeAll
	static void init() {
		el.setNext(next);
		el.setPrevious(prev);

		next.setPrevious(el);
		prev.setNext(el);
	}

	@Test
	void valueTest() {
		assertEquals(6, el.getValue());
	}

	@Test
	void nextTest() {
		assertEquals(next.getValue(), el.getNext().getValue());
	}

	@Test
	void prevTest() {
		assertEquals(prev, el.getPrevious());
	}

	@Test
	void prevEl() {
		assertEquals("null6", prev.getPrevious() + "" + prev.getNext().getValue());
	}

	@Test
	void nextEl() {
		assertEquals(el, next.getPrevious());
		assertEquals(null, next.getNext());
	}
}
