package heapSort;

import edu.princeton.cs.algs4.MinPQ;

public class DemoHeap
{
    public static void main(String[] args)
    {
	MinPQ<Mail> minPQ = new MinPQ<>();
	
	for(int i=0;i<25;i++)
	{
	    minPQ.insert(new Mail());
	}
	
	System.out.println("Elements in Priority Queue");
	for(Mail el: minPQ)
	{
	    System.out.println(el);
	}
	
	System.out.println();
	System.out.println("Remove elements one by one from the priority queue:");
	while(!minPQ.isEmpty())
	{
	    System.out.println(minPQ.delMin());
	}
    }
    
}
