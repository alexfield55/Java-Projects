package module2Test;

import java.util.ArrayList;

/**
 * Alex Field
 * Module 2 test code
 * 
 * @author alexf
 *
 */
public class PuzzleApp
{

    public static void main(String[] args)
    {
	ArrayList<Puzzle> puzzles = new ArrayList<>(); // creating array list of type Puzzle
	
	//creating 4 different RubiksCube's
	RubiksCube cube3x3x3 = new RubiksCube();
	RubiksCube cube4x4x4 = new RubiksCube();
	RubiksCube cube5x5x5 = new RubiksCube();
	RubiksCube cube6x6x6 = new RubiksCube();
	
	//creating 4 different pyramids
	Pyramid py1 = new Pyramid();
	Pyramid py2 = new Pyramid();
	Pyramid py3 = new Pyramid();
	Pyramid py4 = new Pyramid();
	
	//adding new objects of extended class to array of parent class
	puzzles.add(cube3x3x3);
	puzzles.add(cube4x4x4);
	puzzles.add(cube5x5x5);
	puzzles.add(cube6x6x6);
	
	puzzles.add(py1);
	puzzles.add(py2);
	puzzles.add(py3);
	puzzles.add(py4);
	
	for (Puzzle el: puzzles) //looping array
	{
	    el.solve();
	    
	    if(el instanceof Pyramid) //checking if object is Pyramid class
	    {
		((Pyramid) el).skill();
	    }
	    
	    System.out.println();
	}
	
	

	
	
	
	
	
	

    }

}
