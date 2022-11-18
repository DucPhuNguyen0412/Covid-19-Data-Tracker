// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import prj5.LinkedList.Node;
import student.TestCase;

/**
 * SinglyLinkedList testing class
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.15
 * @author Phu Nguyen (nphu01)
 * @version 2021.11.15
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list1;
    private LinkedList<String> emptyList;
    private LinkedList<String> oneEntry;

    private LinkedList<String> list;
    private Iterator<String> iter;

    /**
     * Initializes an empty list, a list with one entry, and a list with
     * multiple entries
     */
    public void setUp() {
        list1 = new LinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        emptyList = new LinkedList<String>();

        oneEntry = new LinkedList<String>();
        oneEntry.add("one");

        list = new LinkedList<String>();
        iter = list.iterator();
    }


    /**
     * Tests size method
     */
    public void testSize() {
        assertEquals(4, list1.size());
        assertEquals(0, emptyList.size());
    }


    /**
     * Tests add method when an index is specified
     */
    public void testAddAtIndex() {
        // object is null
        String n = null;
        Exception exception = null;
        try {
            list1.add(0, n);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

        // index is less than 0
        exception = null;
        try {
            list1.add(-1, "test");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // index is greater than size
        exception = null;
        try {
            list1.add(100, "test");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // stack is empty
        emptyList.add(0, "test");
        assertEquals(1, emptyList.size());
        assertEquals("test", emptyList.get(0));

        // added at index 0
        list1.add(0, "test");
        assertEquals("test", list1.get(0));
        assertEquals(5, list1.size());

        // added at index not 0
        list1.add(2, "test");
        assertTrue(list1.contains("test"));
        assertEquals("test", list1.get(2));
    }


    /**
     * Tests add method
     */
    public void testAdd() {
        // object is null
        String n = null;
        Exception exception = null;
        try {
            list1.add(n);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

        // stack is empty
        emptyList.add("test");
        assertEquals("test", emptyList.get(0));
        assertEquals(1, emptyList.size());

        // other cases
        list1.add("test");
        assertEquals("test", list1.get(4));
        assertEquals(5, list1.size());
    }


    /**
     * Tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(list1.isEmpty());
    }


    /**
     * Tests remove method
     */
    public void testRemove() {
        // stack is empty
        assertFalse(emptyList.remove("test"));

        // object does not exist
        assertFalse(list1.remove("test"));

        // object is the head
        assertTrue(oneEntry.remove("one"));
        assertEquals(0, oneEntry.size());

        // removing last entry
        assertTrue(list1.remove("kiwi"));
        assertEquals(3, list1.size());
        assertEquals("{apple, banana, mango}", list1.toString());

        // multiple entries
        list1.add("kiwi");
        assertTrue(list1.remove("banana"));
        assertEquals(3, list1.size());
        assertEquals("mango", list1.get(1));
    }


    /**
     * Tests remove method when an index is specified
     */
    public void testRemoveAtIndex() {
        // stack is empty
        Exception exception = null;
        try {
            emptyList.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // index is negative
        exception = null;
        try {
            list1.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // index is greater than size
        exception = null;
        try {
            list1.remove(100);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // removing head
        assertTrue(oneEntry.remove(0));
        assertEquals(0, oneEntry.size());

        // removing an index in the middle
        assertTrue(list1.remove(1));
        assertEquals("mango", list1.get(1));
        assertEquals(3, list1.size());

        // removing last index
        list1.add(1, "banana");
        assertTrue(list1.remove(3));
        assertEquals("{apple, banana, mango}", list1.toString());
        assertEquals(3, list1.size());

    }


    /**
     * Tests get method
     */
    public void testGet() {
        // data is null
        Exception exception = null;
        try {
            emptyList.get(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // one entry
        assertEquals("one", oneEntry.get(0));

        // multiple entries
        assertEquals("mango", list1.get(2));
    }


    /**
     * Tests contains method
     */
    public void testContains() {
        // empty stack
        assertFalse(emptyList.contains("test"));

        // one entry
        assertTrue(oneEntry.contains("one"));
        assertFalse(oneEntry.contains("test"));

        // multiple entries
        assertTrue(list1.contains("mango"));
        assertFalse(list1.contains("test"));
    }


    /**
     * Tests clear method
     */
    public void testClear() {
        // empty stack
        emptyList.clear();
        assertTrue(emptyList.isEmpty());

        // one entry
        oneEntry.clear();
        assertTrue(oneEntry.isEmpty());

        // multiple entries
        list1.clear();
        assertTrue(list1.isEmpty());

    }


    /**
     * Tests lastIndexOf method
     */
    public void testLastIndexOf() {
        // empty stack
        assertEquals(-1, emptyList.lastIndexOf("test"));

        // one entry
        assertEquals(-1, oneEntry.lastIndexOf("test"));
        assertEquals(0, oneEntry.lastIndexOf("one"));

        // multiple entries
        assertEquals(-1, list1.lastIndexOf("test"));
        assertEquals(2, list1.lastIndexOf("mango"));
        list1.add("mango");
        assertEquals(4, list1.lastIndexOf("mango"));
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        // empty stack
        assertEquals("{}", emptyList.toString());

        // one entry
        assertEquals("{one}", oneEntry.toString());

        // multiple entries
        assertEquals("{apple, banana, mango, kiwi}", list1.toString());
    }


    /**
     * Tests clearToArray method
     */
    public void testClearToArray() {
        Object[] fruitArray = { "apple", "banana", "mango", "kiwi" };
        Object[] halfArray = { "apple", "banana" };
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list1.toArray(), fruitArray));
        list1.clear();
        assertTrue(Arrays.equals(list1.toArray(), emptyArray));
        list1.add(0, "banana");
        list1.add(0, "apple");
        assertTrue(Arrays.equals(list1.toArray(), halfArray));
    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(list1.equals(list1));

        Object n = null;
        assertFalse(list1.equals(n));

        assertFalse(list1.equals("test"));

        assertFalse(list1.equals(oneEntry));

        LinkedList<String> different = new LinkedList<String>();
        different.add("diff");
        different.add("diff");
        different.add("diff");
        different.add("diff");
        assertFalse(list1.equals(different));

        LinkedList<String> same = new LinkedList<String>();
        same.add("apple");
        same.add("banana");
        same.add("mango");
        same.add("kiwi");
        assertTrue(list1.equals(same));
    }


    /**
     * Tests getHead method
     */
    public void testGetHead() {
        assertEquals("apple", list1.getHead().getData());
    }


    /**
     * Tests setHead method
     */
    public void testSetHead() {
        list1.setHead(new Node<String>("test"));
        assertEquals("test", list1.getHead().getData());
    }


    /**
     * Tests hasNext method
     */
    public void testIterHasNext() {
        assertFalse(iter.hasNext());

        list.add("test");
        iter = list.iterator();
        assertTrue(iter.hasNext());
    }


    /**
     * Tests next method
     */
    public void testIterNext() {
        Exception exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);

        list.add("test");
        iter = list.iterator();
        assertEquals("test", iter.next());
    }


    /**
     * Tests remove method
     */
    public void testIterRemove() {
        list.add("one");
        list.add("two");
        list.add("three");
        iter = list.iterator();
        iter.next();
        iter.next();
        iter.remove();
        assertEquals(2, list.size());
        assertEquals("{one, three}", list.toString());
        assertFalse(list.contains("two"));

        Exception exception = null;
        try {
            iter.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);

        list.clear();
        list.add("one");
        iter = list.iterator();

        exception = null;
        try {
            iter.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);

        iter.next();
        iter.remove();
        assertEquals(0, list.size());
        assertEquals("{}", list.toString());
        assertFalse(list.contains("one"));

    }
}
