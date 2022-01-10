import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class testAddLast {

	@Test
	public void testAddLast() {
		 LinkedList<Double> l = new LinkedList<>();
		        l.addLast(3.5);
		        assertEquals("3.5 \n", l.toString()); //test1
		        l.addLast(4.9);
		        assertEquals("3.5 4.9 \n", l.toString()); //test2
		        //add a third test here - try calling getFirst
		        assertEquals("4.9", l.getLast().toString());
		}
	
	@Test
	public void testAddFirst() {
	   LinkedList<Double> l = new LinkedList<>();
	        l.addFirst(3.5);
	        assertEquals("3.5 \n", l.toString()); //test1
	        l.addFirst(4.9);
	        assertEquals("4.9 3.5 \n", l.toString()); //test2
	        //add a third test here - try calling getFirst
	        assertEquals("4.9", l.getFirst().toString());
	  
	}
	
	
	@Test
	public void testToString() {
	  LinkedList<Integer> L = new LinkedList<>();
	  assertEquals("\n", L.toString()); //test 1
	  
	}
	
	@Test
	public void testArrayConstructor() {
	  //   LinkedList<String> tester = new LinkedList<>(new String[]{"hello", "world", "bye"});
	  
	  // assertEquals("hello", tester.getFirst());
	  // assertFalse(tester.isEmpty()); // test 2
	  // assertTrue(tester.getLength()==3); 

	}
	
	@Test
	public void testDefaultConstructor() {
	  LinkedList<Integer> tester = new LinkedList<>();
	  assertEquals(0, tester.getLength());
	  assertTrue(tester.isEmpty()); // test 2
	  assertFalse(tester.getLength() == 4); // test 3
	}
	
	@Test
	public void testRemoveFirst() {
	   LinkedList<String> L = new LinkedList<>();
	        //testing precondition:
	    assertThrows(NoSuchElementException.class, ()->{L.removeFirst();});
	       L.addFirst("hello");
	       L.addFirst("world");
	       L.addFirst("programmed");
	      L.removeFirst(); 
	      //items more than 1
	      assertEquals("world", L.getFirst()); 
	      //edge case - just one
	      L.removeFirst();
	      L.removeFirst();
	      assertTrue(L.isEmpty());
	}
	
	@Test
	public void testRemoveLast() {
		LinkedList<String> L = new LinkedList<>();
        //testing precondition:
		assertThrows(NoSuchElementException.class, ()->{L.removeFirst();});
		L.addFirst("hello");
		L.addFirst("world");
		L.addFirst("programmed");
		L.removeFirst(); 
      //items more than 1
       assertEquals("world", L.getFirst()); 
      //edge case - just one
       L.removeLast();
       L.removeLast();
       assertTrue(L.isEmpty());
	}
	/*Come back to these two testing methods, as well as the linked list methods for remove/add*/
	@Test
    void testGetLast() {
        LinkedList<String> L = new LinkedList<>();
        assertThrows(NoSuchElementException.class, ()->{L.getLast();}); //test 1
        L.addFirst("A");
        assertEquals("A", L.getLast()); //test 2
        L.addLast("B");
        assertTrue(L.getLast().equals("B")); //test 3
        L.removeLast();
        assertNotEquals("B", L.getLast()); //test 4
    }
	
	
	/*Getter Tester Methods*/
	
	
	
}
