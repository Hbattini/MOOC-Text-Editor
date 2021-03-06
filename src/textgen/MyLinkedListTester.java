/**
 *
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<>();
		longerList = new MyLinkedList<>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

	}


	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

	}


	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			String o = shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			String o = shortList.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		// TODO: Add more tests here
	}

	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
			shortList.add("C");
			assertEquals("Check 2nd element is C: ", "C", shortList.get(shortList.size-1));
			
			
			for(int x = 10; x<20; x++)
			{
				longerList.add(x);
				assertEquals("Check "+x+ " element", (Integer)x, longerList.get(x));
			}
						
		

	}


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size is 2", (Integer)2, (Integer)shortList.size());

		assertEquals("Size is 10", (Integer)10, (Integer)longerList.size());
		
	}



	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		shortList.add(0,"C");
		assertEquals("Check 1st element is 0: ", "C", shortList.get(0));
		assertEquals("Check first", "A", shortList.get(1));
		assertEquals("Check second", "B", shortList.get(2));
		try {
			shortList.add(-1,"b");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(4,"b");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.add(0,null);
			fail("Check out of bounds");
		}
		catch (NullPointerException e) {
		}
		
		longerList.add(9,10);
		assertEquals("Check 10th element is 10: ", (Integer)9, longerList.get(10));
		
		list1.add(2,45);
		assertEquals("Check 2nd element is 45: ", (Integer)45, list1.get(2));

	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		try {
			shortList.set(-1,"b");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.set(4,"b");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.set(0,null);
			fail("Check null element");
		}
		catch (NullPointerException e) {
		}
		longerList.set(9,10);
		assertEquals("Check 10th element is 10: ", (Integer)10, longerList.get(9));

	}


	// TODO: Optionally add more test methods.

}
