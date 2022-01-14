import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListTests {

	@Test
	public void testAddLast() {
		LinkedList<Double> l = new LinkedList<>();
		l.addLast(3.5);
		assertEquals("3.5 \n", l.toString()); // test1
		l.addLast(4.9);
		assertEquals("3.5 4.9 \n", l.toString()); // test2
		// add a third test here - try calling getFirst
		assertEquals("4.9", l.getLast().toString());
	}

	@Test
	public void testAddFirst() {
		LinkedList<Double> l = new LinkedList<>();
		l.addFirst(3.5);
		assertEquals("3.5 \n", l.toString()); // test1
		l.addFirst(4.9);
		assertEquals("4.9 3.5 \n", l.toString()); // test2
		// add a third test here - try calling getFirst
		assertEquals("4.9", l.getFirst().toString());

	}

	@Test
	public void testToString() {
		LinkedList<Integer> L = new LinkedList<>();
		assertEquals("\n", L.toString()); // test 1

	}

	@Test
	public void testArrayConstructor() {
		LinkedList<String> tester = new LinkedList<>(new String[] { "hello", "world", "bye" });

		assertEquals("hello", tester.getFirst());
		assertFalse(tester.isEmpty()); // test 2
		assertTrue(tester.getLength() == 3);

	}

	@Test
	public void testDefaultConstructor() {
		LinkedList<Integer> tester = new LinkedList<>();
		assertEquals(0, tester.getLength());
		assertTrue(tester.isEmpty()); // test 2
		assertFalse(tester.getLength() == 3); // test 3
	}

	@Test
	public void testRemoveFirst() {
		LinkedList<String> L = new LinkedList<>();
		// testing precondition:
		assertThrows(NoSuchElementException.class, () -> {
			L.removeFirst();
		});
		L.addFirst("hello");
		L.addFirst("world");
		L.addFirst("programmed");
		L.removeFirst();
		// items more than 1
		assertEquals("world", L.getFirst());
		// edge case - just one
		L.removeFirst();
		L.removeFirst();
		assertTrue(L.isEmpty());
	}

	@Test
	public void testRemoveLast() {
		LinkedList<String> L = new LinkedList<>();
		// testing precondition:
		assertThrows(NoSuchElementException.class, () -> {
			L.removeFirst();
		});
		L.addFirst("hello");
		L.addFirst("world");
		L.addFirst("programmed");
		L.removeFirst();
		// items more than 1
		assertEquals("world", L.getFirst());
		// edge case - just one
		L.removeLast();
		L.removeLast();
		assertTrue(L.isEmpty());
	}

	/*
	 * Come back to these two testing methods, as well as the linked list methods
	 * for remove/add
	 */
	@Test
	void testGetLast() {
		LinkedList<String> L = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			L.getLast();
		}); // test 1
		L.addLast("A");
		assertEquals("A", L.getLast()); // test 2
		L.addLast("B");
		assertTrue(L.getLast().equals("B")); // test 3
		L.removeLast();
		assertNotEquals("B", L.getLast()); // test 4
	}

	/* Getter Tester Methods */
	@Test
	void testGetFirst() {
		LinkedList<String> L = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			L.getLast();
		}); // test 1
		L.addFirst("A");
		assertEquals("A", L.getFirst()); // test 2
		L.addFirst("B");
		assertTrue(L.getFirst().equals("B")); // test 3
		L.removeFirst();
		assertNotEquals("B", L.getFirst()); // test 4
	}

	@Test
	void testGetLength() {
		LinkedList<String> L = new LinkedList<>();
		L.addFirst("A");
		assertEquals(1, L.getLength());
		L.removeFirst();
		assertEquals(0, L.getLength());
		L.addFirst("A");
		L.addFirst("A");
		assertEquals(2, L.getLength());
	}

	@Test
	public void testReversible() {
		LinkedList<Integer> nums = new LinkedList<>();
		assertTrue(nums.isReversible());
		nums.addFirst(1);
		assertTrue(nums.isReversible());
		nums = new LinkedList<>(new Integer[] { 1, 2, 3, 2, 1 });
		assertTrue(nums.isReversible());
		nums.positionIterator();
		nums.advanceIterator();
		nums.addIterator(3);
		assertTrue(nums.isReversible());
		nums.advanceIterator();
		nums.addIterator(4);
		assertTrue(nums.isReversible());
		nums.addIterator(5);
		assertFalse(nums.isReversible());

		LinkedList<String> letters = new LinkedList<>(new String[] { "A", "B", "B", "A" });
		assertTrue(letters.isReversible());
		letters.addFirst(new String("D"));
		letters.addLast("D");
		assertTrue(letters.isReversible());
		letters.removeLast();
		assertFalse(letters.isReversible());
	}

	@Test
	public void testZipper() {
		LinkedList<String> nullList = new LinkedList<>();
		LinkedList<String> iList = new LinkedList<>();
		LinkedList<String> sList1 = new LinkedList<>(new String[] { "!", "?", "." });
		LinkedList<String> sList2 = new LinkedList<>(new String[] { "!", "?", ".", "," });

		assertEquals(sList1.zipperLists(nullList).toString(), sList1.toString());
		assertEquals(iList.zipperLists(sList1).toString(), sList1.toString());
		LinkedList<String> temp = sList1.zipperLists(sList2);
		assertEquals(sList1.toString(), "! ? . \n");
		assertEquals(sList2.toString(), "! ? . , \n");
		assertEquals(temp.toString(), "! ! ? ? . . , \n");

		temp = sList2.zipperLists(sList1);
		assertEquals(sList1.toString(), "! ? . \n");
		assertEquals(sList2.toString(), "! ? . , \n");
		assertEquals(temp.toString(), "! ! ? ? . . , \n");

	}

}
