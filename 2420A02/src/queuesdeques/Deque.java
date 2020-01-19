package queuesdeques;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Public class Deque is a generic data type that can add or remove objects
 * to/from front or back of a queue. Deque implements Iterable and iterates
 * through items in a first in, first out order. Deque is a doubly linked list
 * where each item points to the next item and the previous item (or null if
 * item is last or first respectively.)
 * 
 * @author Ariel Wilson-O'Brien
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item>
{
    /**
     * first item in deque
     */
    private Node<Item> first;
    /**
     * last item in deque
     */
    private Node<Item> last;
    /**
     * size increments when items are added and decrements when items are removed
     */
    private int size;

    /**
     * Private class for constructing nodes, e.g. new items in a list that point
     * towards the next and/or previous item in the list.
     *
     * @param <Item>
     */
    private static class Node<Item>
    {
	private Item item;
	private Node<Item> next;
	private Node<Item> previous;

	// next and previous parameters initialized as null, set explicitly only within
	// methods that call constructor
	Node(Item item)
	{
	    this.item = item;
	    this.next = null;
	    this.previous = null;
	}
    }

    /**
     * Constructor for Deque class initializes first and last as null and sets size
     * to 0.
     * 
     */
    public Deque()
    {
	first = null;
	last = null;
	size = 0;
    }

    /**
     * Checks first and last for null values to verify Deque is empty
     * 
     * @return true if Deque is empty and false if first or last holds a value
     */
    public boolean isEmpty()
    {
	if ((first == null && last == null)) // (first == null && last == null)
	    return true;
	else
	    return false;
    }

    /**
     * Getter for size
     * 
     * @return integer number of items in Deque
     */
    public int size()
    {
	return size;
    }

    /**
     * Add a non-null item to front of Deque. If item is only item in queue, item is
     * set to both first and last. New first item and old first item are updated to
     * point to each other. Size is incremented.
     * 
     * @param item (pass object into Deque)
     */
    public void addFirst(Item item)
    {
	if (item == null)
	{
	    throw new java.lang.NullPointerException();
	}
	Node<Item> newfirst = new Node<Item>(item);
	if (isEmpty())
	{
	    last = newfirst;
	    first = newfirst;
	    size++;
	} else
	{
	    newfirst.next = first;
	    first.previous = newfirst;
	    first = newfirst;
	    size++;
	}
    }

    /**
     * Add a non-null item to front of Deque. If item is only item in queue, item is
     * set to both first and last. New first item and old first item are updated to
     * point to each other. Size is incremented.
     * 
     * @param item (pass object into Deque)
     */
    public void addLast(Item item)
    {
	if (item == null)
	{
	    throw new java.lang.NullPointerException();
	}
	Node<Item> newlast = new Node<Item>(item);
	if (isEmpty())
	{
	    last = newlast;
	    first = newlast;
	    size++;
	} else
	{
	    last.next = newlast;
	    newlast.previous = last;
	    last = newlast;
	    size++;
	}
    }

    /**
     * Remove an item from front of non-empty queue. If item is only item in queue,
     * first and last are set to null. Otherwise, next item in queue is set to first
     * and no longer points to old first item.
     * 
     * @return item removed from front of Deque
     */
    public Item removeFirst()
    {
	if (isEmpty())
	{
	    throw new NoSuchElementException("Queue is empty");
	}
	Item tempfirst = first.item;
	if (size == 1)
	{ // bugfix: nullify first and last if item being removed is last in queue
	    first = null;
	    last = null;
	    size--;
	} else
	{
	    first = first.next;
	    first.previous = null;
	    size--;
	}
	return tempfirst;
    }

    /**
     * Remove an item from back of non-empty queue. If item is only item in queue,
     * first and last are set to null. Otherwise, previous item in queue is set to
     * last and no longer points to old last item.
     * 
     * @return item removed from end of Deque
     */
    public Item removeLast()
    {
	if (isEmpty())
	{
	    throw new NoSuchElementException("Queue is empty");
	}
	Item templast = last.item;
	if (size == 1)
	{ // bugfix: nullify first and last if item being removed is last in queue
	    first = null;
	    last = null;
	    size--;
	} else
	{
	    last = last.previous;
	    last.next = null;
	    size--;
	}
	return templast;
    }

    /**
     * iterator for deque implements Iterator
     */
    public Iterator<Item> iterator()
    {
	return new ListIterator();
    }

    /**
     * Standard iterator for double ended queue steps through items from first to
     * last. Loops in "first in, first out" order.
     */
    private class ListIterator implements Iterator<Item>
    {
	private Node<Item> current = first;

	@Override
	public boolean hasNext()
	{
	    return current != null;
	}

	@Override
	public void remove()
	{
	    throw new UnsupportedOperationException("Unsupported Operation");
	}

	@Override
	public Item next()
	{
	    if (!hasNext())
	    {
		throw new NoSuchElementException();
	    }
	    Item item = current.item;
	    current = current.next;
	    return item;
	}

    }

    public static void main(String[] args)
    {
	Deque<String> testdeck = new Deque<String>();
	testdeck.addFirst("First Item");
	testdeck.addLast("Last Item");

	System.out.println("Initial List (2 items): ");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());
	System.out.println();

	testdeck.addLast("New Last Item");

	System.out.println("New List (3 items, new item on end): ");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());
	System.out.println();

	System.out.println("Remove first item: " + testdeck.removeFirst());
	System.out.println();

	System.out.println("New List (2 items, first item removed): ");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());
	System.out.println();

	System.out.println("Removed item: " + testdeck.removeLast());
	System.out.println();

	System.out.println("Queue with 1 item: ");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());

	System.out.println("\nRemoved item: " + testdeck.removeLast());

	System.out.println("\nEmpty Queue: ");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());

	// testdeck.removeFirst(); // test of NoSuchElementException for empty queue
	// testdeck.removeLast(); // test of NoSuchElementException for empty queue
	// testdeck.addFirst(null); // test of NullPointerException for new items
	// testdeck.addLast(null); // test of NullPointerException for new items

	System.out.println();
	System.out.println("Adding to an Empty Queue (new first):");
	testdeck.addFirst("New First Item");

	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());

	System.out.println("\nRemove first item to empty out queue: " + testdeck.removeFirst());

	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());

	System.out.println("\nAdding to an Empty Queue (new last):");
	testdeck.addLast("Final Item");
	for (String el : testdeck)
	{
	    System.out.println(el);
	}
	System.out.println("Size: " + testdeck.size());
	
	Deque<Integer> testdeck2 = new Deque<Integer>();
	System.out.println("\nTesting with Integers instead of Strings: ");
			
	testdeck2.addFirst(32);
	testdeck2.addLast(74);
	testdeck2.addFirst(45);
	testdeck2.addLast(53);
			
	for (Integer in : testdeck2) {
		System.out.println(in);
	}
	System.out.println("Size: " + testdeck2.size());
			
	System.out.println("Nested for loop test: ");
	for (String el : testdeck) {
		for (Integer in : testdeck2) {
			System.out.println(el);
			System.out.println(in);
		}
	}

    }
}
