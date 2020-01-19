package puzzle;

/*
 * 
 * 
 * Alex Field and Ariel Wilson-O'Brien
 * 
 * 
 */
import edu.princeton.cs.algs4.Stack;

public class Board
{
    private final int[][] grid;
    private final int size;

    public Board(int[][] blocks)
    {
	grid = blocks;
	size = blocks.length;
    }

    private int[][] goalBoard()
    {
	int[][] goalgrid = new int[size][size];
	for (int i = 0; i < size(); i++)
	{
	    for (int j = 0; j < size(); j++)
	    {
		if (i == size() - 1 && j == size() - 1)
		    goalgrid[i][j] = 0;
		else
		    goalgrid[i][j] = conversion(i, j) + 1;
	    }
	}
	return goalgrid;
    }

    public int size()
    {
	return size;
    }

    public int hamming()
    {
	int ham = 0;
	int[][] temp = goalBoard();

	for (int i = 0; i < size; i++)
	{
	    for (int j = 0; j < size; j++)
		if (grid[i][j] != temp[i][j] && grid[i][j] != 0)
		    ham++;

	}

	return ham;
    }

    public int manhattan()
    {
	int sum = 0;
	int[][] temp = goalBoard();

	for (int i = 0; i < size; i++)
	{
	    for (int j = 0; j < size; j++)
	    {
		int value = grid[i][j];
		if (value != 0 && value != temp[i][j])
		{
		    int x = (value - 1) / size;
		    int y = value - 1 - x * size;
		    int distance = Math.abs(i - x) + Math.abs(j - y);
		    sum += distance;
		}
	    }
	}
	return sum;
    }

    // generates a goal board for given size and compares it to given board
    public boolean isGoal()
    {
	Board tempboard = new Board(goalBoard());

	return this.equals(tempboard);
    }

    public boolean isSolvable()
    {
	/*
	 * For even boards: loop through to find number of inversions plus row number of
	 * goal board. If sum is even, board is unsolvable. For odd boards: loop through
	 * to find number of inversions. If odd, board is unsolvable. NOTE: current
	 * method has a lot of loops and is probably over N^4 time permitted.
	 */
	int inversions = 0;
	int index = 0;
	int row = 0;
	int column = 0;
	int key;
	int blankrow = 0;

	while (index < size() * size() - 1)
	{
	    /*
	     * Nested for loop checks each entry in grid against key. REWRITE so it doesn't
	     * require 1D array conversion above.
	     */
	    key = grid[row][column];

	    /*
	     * for (int i = index; i < size() * size(); i++) { if (key == 0) { blankrow =
	     * row; } else if (key > temparray[conversion(row, column) + 1] &&
	     * temparray[conversion(row, column) + 1] != 0) { inversions++; } }
	     */

	    for (int i = row; i < size(); i++)
	    {
		for (int j = column; j < size(); j++)
		{
		    if (key == 0)
		    {
			blankrow = row;
		    } else if (((j % (size() - 1)) == 0) && (i < size() - 1))
		    {
			if (key > grid[i + 1][0] && grid[i + 1][0] != 0)
			    inversions++;
		    } else if ((j < size() - 1) && key > grid[i][j + 1] && grid[i][j + 1] != 0)
			inversions++;
		}
	    }

	    index++;
	    if (index % size() == 0)
	    { // if index is divisible by size of row we increment to next row
		row++;
		column = 0; // reset column each time we move to new row
	    } else
	    {
		column++;
	    }

	}

	if (size() % 2 == 0)
	{ // even boards
	    if ((inversions + blankrow) % 2 == 0)
		return false;
	    else
		return true;
	} else
	{ // odd boards
	    if (inversions % 2 == 0)
	    { // if inversions are even on an odd board, board is solvable
		return true;
	    } else
		return false;
	}
    }

    private int conversion(int i, int j)
    {
	return (size * i) + (j);
    }

    public boolean equals(Object y)
    {
	if (y == this)
	    return true;
	if (y == null)
	    return false;
	if (this.getClass() != y.getClass())
	    return false;
	Board that = (Board) y;
	if (this.size() != that.size())
	    return false;
	for (int i = 0; i < size(); i++)
	{
	    for (int j = 0; j < size(); j++)
	    {
		if (this.grid[i][j] != that.grid[i][j])
		    return false;
	    }
	}
	return true;
    }

    private int[][] swap(int x1, int y1, int x2, int y2)
    {
	int[][] copy = this.grid;
	int[][] tempGrid = new int[size][size];
	for (int i = 0; i < size; i++)
	{
	    for (int j = 0; j < size; j++)
	    {
		tempGrid[i][j] = copy[i][j];
	    }
	}
	int val = this.grid[x1][y1];
	int tempVal = this.grid[x2][y2];
	tempGrid[x1][y1] = tempVal;
	tempGrid[x2][y2] = val;
	return tempGrid;
    }

    public Iterable<Board> neighbors()
    {

	int x = 0;
	int y = 0;

	for (int i = 0; i < size; i++) // looping to find the x and y coordinates of the zero or "blank block" in the
	    // grid
	    for (int j = 0; j < size; j++)
	    {
		if (grid[i][j] == 0)
		{
		    x = i;
		    y = j;
		}
	    }

	Stack<Board> boards = new Stack<Board>();

	// swapping the blank block by one move either horizontal or vertical

	if (x - 1 >= 0 && x < size)
	    boards.push(new Board(swap(x, y, x - 1, y)));
	if (x >= 0 && x + 1 < size)
	    boards.push(new Board(swap(x, y, x + 1, y)));
	if (y >= 0 && y + 1 < size)
	    boards.push(new Board(swap(x, y, x, y + 1)));
	if (y - 1 >= 0 && y < size)
	    boards.push(new Board(swap(x, y, x, y - 1)));

	return boards;

    }

    public String toString()
    {
	StringBuilder sbtemp = new StringBuilder();
	sbtemp.append(size() + "\n");
	for (int i = 0; i < size(); i++)
	{
	    for (int j = 0; j < size(); j++)
	    {
		sbtemp.append(this.grid[i][j] + " ");
	    }
	    sbtemp.append("\n");
	}
	return sbtemp.toString();
    }

    public static void main(String[] args)
    {
	int[][] solvable =
	{
		{ 8, 1, 3 },
		{ 4, 0, 2 },
		{ 7, 6, 5 } };

	int[][] unsolvable =
	{ // unsolvable array: odd board with one inversion
		{ 1, 2, 3 },
		{ 4, 5, 6 },
		{ 8, 7, 0 } };

	int[][] goal =
	{
		{ 1, 2, 3 },
		{ 4, 5, 6 },
		{ 7, 8, 0 } };

	Board testa = new Board(solvable);
	Board testb = new Board(unsolvable);
	Board goalb = new Board(goal);

	System.out.println("Board is " + testb.size() + "X" + testb.size()); // test of size()
	System.out.println(testa); // test of toString()
	System.out.println("A is solvable: " + testa.isSolvable()); // test of solvable on solvable odd board
	System.out.println("A ham distance: " + testa.hamming());
	System.out.println("A manhattan: " + testa.manhattan());
	System.out.println();
	int[][] testboard =
	{
		{ 0, 1, 3 },
		{ 4, 2, 5 },
		{ 7, 8, 6 } };

	Board initial = new Board(testboard);
	System.out.println(goalb.isGoal());

	System.out.println(initial.isSolvable());
	for (Board b : testa.neighbors())
	{
	    System.out.println(b);
	}
    }
}
