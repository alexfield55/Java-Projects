package percolation;

public class PercolationApp
{

    public static void main(String[] args)
    {
	/*Percolation perc = new Percolation(10);

	for (int i = 0; i < 10; i++)
	{
	    perc.open(i, 5);
	    System.out.println("Full " +perc.isFull(i, 5));
	    System.out.println("Perc " + perc.percolates());
	    System.out.println();
	}
	*/
	
	PercolationStats percStats = new PercolationStats(10,2);
	
	System.out.println(percStats.mean());
	System.out.println(percStats.stddev());
	System.out.println(percStats.confidenceHigh());
	System.out.println(percStats.confidenceLow());

    }

}
