package percolation; 

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import java.lang.IllegalArgumentException;

public class PercolationStats
{
    Percolation perc; // Percolation variable declaration for use in experiments
    private int numExperiments; // Upper bound for experiment loop & used for calculating stats
    private double threshold[]; // StdStats mean & stddev methods require 1D array of double values

    public PercolationStats(int N, int T)
    {
	if (N <= 0 || T <= 0)
	{
	    throw new IllegalArgumentException("Error: invalid grid size" + " and/or number of experiments.");
	}
	numExperiments = T;
	threshold = new double[numExperiments];

	for (int i = 0; i < numExperiments; i++)
	{
	    threshold[i] = runExperiment(N); // each time experiment is run new threshold data is added to array
	}
    }

    // Private method for running experiments to structure code.
    // Called from inside PercolationStats constructor T times.
    private double runExperiment(int N)
    {
	perc = new Percolation(N);
	int opensites = 0; // tracks number of sites opened before object Percolates
	double newthreshold;
	do
	{
	    // do-while loop for randomly opening grid sites until experiment percolates
	    int i = StdRandom.uniform(0, N);
	    int j = StdRandom.uniform(0, N);
	    if (!perc.isOpen(i, j))
	    {
		perc.open(i, j);
		opensites++;
	    }
	} while (!perc.percolates());
	newthreshold = (double) opensites / (N * N);
	return newthreshold;
    }

    public double mean()
    {
	double mean = StdStats.mean(threshold);
	return mean;
    }

    public double stddev()
    {
	double stddev = StdStats.stddev(threshold);
	return stddev;
    }

    public double confidenceLow()
    {
	double conlow = mean() - ((1.96 * stddev()) / Math.sqrt(numExperiments));
	return conlow;
    }

    public double confidenceHigh()
    {
	double conhigh = mean() + ((1.96 * stddev()) / Math.sqrt(numExperiments));
	return conhigh;
    }
}
