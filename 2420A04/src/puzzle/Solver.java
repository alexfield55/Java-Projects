package puzzle;
/*
 * 
 * 
 * Alex Field and Ariel Wilson-O'Brien
 * 
 * 
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;

public class Solver
{
    private SearchNode finalnode;
    private int finalmoves;

    private class SearchNode implements Comparable<SearchNode>
    {
	private Board board;
	private int moves;
	private SearchNode previous;
	private int priority;

	public SearchNode(Board board, int moves, SearchNode previous)
	{
	    this.board = board;
	    this.moves = moves;
	    this.previous = previous;
	    this.priority = board.manhattan() + moves;
	}

	@Override
	public int compareTo(SearchNode that)
	{
	    return (this.priority) - (that.priority);
	}
    }

    public Solver(Board initial) // find a solution to the initial board (using the A* algorithm)
    {
	MinPQ<SearchNode> minpqueue = new MinPQ<SearchNode>();
	SearchNode temp;
	Board prevBoard = initial;

	// int moves = 0;

	minpqueue.insert(new SearchNode(initial, 0, null));

	do
	{
	    temp = minpqueue.delMin();
	    for (Board b : temp.board.neighbors())
	    {
		if (!b.equals(prevBoard))
		    minpqueue.insert(new SearchNode(b, temp.moves + 1, temp));
	    }
	    prevBoard = temp.board;
	} while (!temp.board.isGoal());

	if (temp.board.isGoal())
	{
	    finalnode = temp;
	    finalmoves = temp.moves;
	}
    }

    public int moves() // min number of moves to solve initial board
    {
	return finalmoves;
    }

    public Iterable<Board> solution() // sequence of boards in a shortest solution
    {
	Stack<Board> boards = new Stack<>();
	SearchNode tempnode = finalnode;
	while (tempnode != null)
	{
	    boards.push(tempnode.board);
	    tempnode = tempnode.previous;
	}
	return boards;
    }

    public static void main(String[] args) // solve a slider puzzle (given below)
    {
	/*
	 * In in = new In(args[0]); int N = in.readInt(); int[][] blocks = new
	 * int[N][N]; for (int i = 0; i < N; i++) for (int j = 0; j < N; j++)
	 * blocks[i][j] = in.readInt(); Board initial = new Board(blocks);
	 */

	int[][] puz28 =
	{
		{ 7, 8, 5 },
		{ 4, 0, 2 },
		{ 3, 6, 1 } };

	int[][] puz30 =
	{
		{ 8, 4, 7 },
		{ 1, 5, 6 },
		{ 3, 2, 0 } };

	int[][] puz32 =
	{
		{ 3, 1, 6, 4 },
		{ 5, 0, 9, 7 },
		{ 10, 2, 11, 8 },
		{ 13, 15, 14, 12 } };

	Board initial = new Board(puz32);

	// check if puzzle is solvable; if so, solve it and output solution
	if (initial.isSolvable())
	{
	    Solver solver = new Solver(initial);
	    StdOut.println("Minimum number of moves = " + solver.moves());
	    for (Board board : solver.solution())
		StdOut.println(board);
	}

	// if not, report unsolvable
	else
	{
	    StdOut.println("Unsolvable puzzle");
	}
    }
}
