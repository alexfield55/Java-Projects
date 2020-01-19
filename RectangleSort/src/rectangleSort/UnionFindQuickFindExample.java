package rectangleSort;

import java.util.Arrays;

import edu.princeton.cs.algs4.QuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindQuickFindExample
{

    public static void main(String[] args)
    {
	     int n = StdIn.readInt();
	        QuickUnionUF uf = new QuickUnionUF(n);
	        while (!StdIn.isEmpty()) {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.connected(p, q)) continue;
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        StdOut.println(uf.count() + " components");
	               
    }

}
