package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {



        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        //lld2.removeFirst();
        System.out.println(lld2.removeFirst());
        //boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }
 @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {



        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* Test get and getRecursive methods */
    public void getTest(){
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        lld2.addFirst(1);
        lld2.addFirst(2);
        lld2.addFirst(4);
        lld2.addFirst(8);

        Integer getNum2 = lld2.get(0);
        Integer getRecursiveNum2 = lld2.getRecursive(0);
        assertEquals(8, (long)getNum2);
        assertEquals(8, (long)getRecursiveNum2);

        Integer getNum1 = lld2.get(1);
        Integer getRecursiveNum1 = lld2.getRecursive(1);
        assertEquals(4, (long)getNum1);
        assertEquals(4, (long)getRecursiveNum1);

        assertEquals(null, lld2.get(-1));
        assertEquals(null, lld2.get(100));
        assertEquals(null, lld2.getRecursive(-1));
        assertEquals(null, lld2.getRecursive(100));

    }
    @Test
    /* Test equal method */
    public void equalTest(){
        //
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(4);
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        lld2.addFirst(1);
        lld2.addFirst(2);
        lld2.addFirst(4);
        LinkedListDeque<Integer> lld3 = new LinkedListDeque<>();
        lld3.addFirst(1);
        lld3.addLast(2);
        lld3.addFirst(4);
        assertTrue("should return true", lld1.equals(lld2));
        assertFalse("should return false", lld1.equals(lld3));

        lld2.removeFirst();
        assertFalse("shoud return false", lld1.equals(lld2));

        //

    }
    @Test
    /* Test printDeque method */
    public void printDequeTest(){
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        lld2.addFirst(1);
        lld2.addFirst(2);
        lld2.addFirst(4);

        String corrStr = new String("4 2 1");
        lld2.printDeque();

    }
    @Test
    /* Test iterator (enhanced for loop) */
    public void iteratorTest(){
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        lld2.addFirst(1);
        lld2.addFirst(2);
        lld2.addFirst(4);
        lld2.addFirst(8);
        int i = 0;
        for (Integer item:lld2){
            assertEquals((long)lld2.get(i++), (long)item);
        }
    }

}
