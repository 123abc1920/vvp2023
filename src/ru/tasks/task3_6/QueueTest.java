package ru.tasks.task3_6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QueueTest {
	@Test
	void testConst() {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add("test");
		q.add(false);

		assertEquals(4, q.length());
	}

	@Test
	void testGet() {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add("test");
		q.add(false);

		assertEquals(1, q.get());
	}

	@Test
	void testDelete() {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add("test");
		q.add(false);

		q.delete();
		assertEquals(2, q.get());
	}

	@Test
	void testGetDelete() {
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add("test");
		q.add(false);

		assertEquals(1, q.getDelete());
		assertEquals(2, q.getDelete());
		assertEquals("test", q.getDelete());
		assertEquals(false, q.getDelete());
		assertEquals(0, q.length());
	}

	@Test
	void testIsEmpty() {
		Queue q = new Queue();
		assertEquals(true, q.isEmpty());

		q.add(1);
		assertEquals(false, q.isEmpty());
	}
}
