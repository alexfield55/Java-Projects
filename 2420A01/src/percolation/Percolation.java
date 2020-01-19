/**
 * Assignment: A01 Percolation - Percolation Class
 * @author Alex Field & Ariel Wilson-O'Brien
 *
 */

package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class Percolation
{
    private boolean[][] grid;
    WeightedQuickUnionUF quickfind;
    WeightedQuickUnionUF quickfindtop; // second UF object connected only to top to solve backwash problem
    private int virtualTop;
    private int virtualBottom;
    private int size;
    private int openSites; // optional field for PercolationVisualizer class / numberOfOpenSites method

    public Percolation(int N)
    {
	if (N <= 0)
	{
	    throw new IllegalArgumentException("Error: invalid grid size.");
	}
	this.size = N;
	this.virtualTop = 0; // virtualTop will be 0th element in UF 1D object
	this.virtualBottom = size * size + 1; // virtualBottom will be last element of UF object; total size of grid + 1
	quickfind = new WeightedQuickUnionUF(N * N + 2); // UF object with size of array plus virtual top + bottom
	quickfindtop = new WeightedQuickUnionUF(N * N + 1); // second UF object with size of array plus virtual top
	grid = new boolean[N][N]; // O(N^2) time complexity because 2D array initializes every value as false

	for (int i = 0; i < size; i++) // connects top row to virtual top & second virtual top
	{
	    quickfind.union(virtualTop, conversion(0, i));
	    quickfindtop.union(virtualTop, conversion(0, i));
	}

	for (int i = 0; i < size; i++) // connects bottom row to virtual bottom
	{
	    quickfind.union(virtualBottom, conversion(size - 1, i));
	}

    }

    public void open(int i, int j)
    {
	if (i < 0 || j < 0 || i >= this.size || j >= this.size)
	{
	    throw new IndexOutOfBoundsException("Error: index out of bounds");
	}
	grid[i][j] = true;
	// checks all 4 potential positions around to find open blocks and form unions
	// if true
	if (i > 0)
	    if (grid[i - 1][j])
	    {
		quickfind.union(conversion(i, j), conversion(i - 1, j));
		quickfindtop.union(conversion(i, j), conversion(i - 1, j));
	    }
	if (i < size - 1)
	    if (grid[i + 1][j])
	    {
		quickfind.union(conversion(i, j), conversion(i + 1, j));
		quickfindtop.union(conversion(i, j), conversion(i + 1, j));
	    }
	if (j > 0)
	    if (grid[i][j - 1])
	    {
		quickfind.union(conversion(i, j), conversion(i, j - 1));
		quickfindtop.union(conversion(i, j), conversion(i, j - 1));
	    }
	if (j < size - 1)
	    if (grid[i][j + 1])
	    {
		quickfind.union(conversion(i, j), conversion(i, j + 1));
		quickfindtop.union(conversion(i, j), conversion(i, j + 1));
	    }
	openSites++;
    }

    public boolean isOpen(int i, int j)
    {
	if (i < 0 || j < 0 || i >= this.size || j >= this.size)
	{
	    throw new IndexOutOfBoundsException("Error: index out of bounds");
	}
	if (grid[i][j])
	    return true;
	return false;
    }

    public boolean isFull(int i, int j)
    { // calls quickfindtop ONLY to check whether grid space is connected to top, not
      // bottom, to avoid backwash
	if (i < 0 || j < 0 || i >= this.size || j >= this.size)
	{
	    throw new IndexOutOfBoundsException("Error: index out of bounds");
	}

	if ((grid[i][j]) && quickfindtop.connected(virtualTop, conversion(i, j)))
	{
	    return true;
	} else
	    return false;
    }

    public boolean percolates()
    {
	return quickfind.connected(virtualTop, virtualBottom);
    }

    private int conversion(int i, int j)
    {
	// private method for converting [i][j] grid to 1D int compatiple with UF object
	return (size * i) + (j + 1);
    }

    public int numberOfOpenSites() // added OPTIONAL method for PercolationVisualizer class
    {
	return openSites;
    }
}
