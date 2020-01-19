package queuesdeques;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] a; // array of Items
    private int n; // number of elements in array

    @SuppressWarnings("unchecked")
    public RandomizedQueue() // construct an empty randomized queue
    {
	a = (Item[]) new Object[2];
	n = 0;
    }

    public boolean isEmpty() // is the queue empty, checks for n value, if 0 returns false
    {
	return n == 0;
    }

    public int size() // return the number of items on the queue
    {
	return n;
    }

    public void enqueue(Item item) // add the item
    {
	if (item == null)
	    throw new NoSuchElementException();
	if (n == a.length)
	    resize(a.length * 2);
	a[n++] = item;
    }

    public Item dequeue() // delete and return a random item, basically pulled this out of the ideas from the courses stack example
    {
	if (isEmpty())
	    throw new NoSuchElementException();

	int i = StdRandom.uniform(0, n);
	Item item = a[i];
	a[i] = a[n - 1];
	a[n - 1] = null;
	n--;

	if (n > 0 && n == a.length / 4)
	    resize(a.length / 2);
	return item;

    }

    public Item sample() // return (but do not delete) a random item
    {
	if (isEmpty())
	    throw new NoSuchElementException();

	return a[StdRandom.uniform(0, n)];
    }

    private void resize(int capacity) // from the courses resizing array code provided
    {
	assert capacity >= n;

	// textbook implementation
	@SuppressWarnings("unchecked")
	Item[] temp = (Item[]) new Object[capacity];
	for (int i = 0; i < n; i++)
	{
	    temp[i] = a[i];
	}
	a = temp;
    }

    public int ArraySize() // a class I added for my unit testing to make sure it was resizing correctly
    {
	return a.length;
    }

    public Iterator<Item> iterator()
    {
	return new RandomIterator();
    }

    /**
     * Copies array into new array, shuffles using algs4 libraries uniform shuffle
     */
    private class RandomIterator implements Iterator<Item>
    {

	private Item[] randomArray;
	private int i;

	@SuppressWarnings("unchecked")
	public RandomIterator()
	{
	    randomArray = (Item[]) new Object[n];

	    for (int i = 0; i < n; i++)
	    {
		randomArray[i] = a[i];
	    }

	    StdRandom.shuffle(randomArray);
	}

	@Override
	public boolean hasNext()
	{
	    return i < n;
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

	    return randomArray[i++];
	}
    }

    public static void main(String[] args) // unit testing
    {
	RandomizedQueue<String> rq = new RandomizedQueue<String>();

	System.out.println("New empty RandomizedQueue<String> made");
	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("Size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();

	for (String el : rq)
	{
	    System.out.println(el);
	}

	System.out.println("adding items: Strings cat and dog and print list");
	rq.enqueue("cat");
	rq.enqueue("dog");

	for (String el : rq)
	{
	    System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();

	System.out.println("adding items: Strings fish and frog and print list");
	rq.enqueue("fish");
	rq.enqueue("frog");

	for (String el : rq)
	{
	    System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();

	System.out.println("adding item: Strings hog and print list");
	rq.enqueue("hog");

	for (String el : rq)
	{
	    System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();

	System.out.println("testing nested loops");
	for(String el1 : rq)
	    for(String el2: rq)
	    {
		System.out.println(el1 + " , " + el2);
	    }
	
	System.out.println();
	System.out.println("dequeue three item and print list");
	rq.dequeue();
	rq.dequeue();
	rq.dequeue();

	for (String el : rq)
	{
		System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();
	
	
	System.out.println("Empty the array");
	rq.dequeue();
	rq.dequeue();


	for (String el : rq)
	{
		System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();
	
	System.out.println("Refill the array and print");
	rq.enqueue("cat");
	rq.enqueue("dog");
	rq.enqueue("fish");
	rq.enqueue("frog");
	rq.enqueue("hog");
	for (String el : rq)
	{
		System.out.println(el);
	}

	System.out.println("Empty test: " + rq.isEmpty());
	System.out.println("size test: " + rq.size());
	System.out.println("Array size: " + rq.ArraySize());
	System.out.println();

    }

}
