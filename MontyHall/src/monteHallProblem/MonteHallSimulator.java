
package monteHallProblem;

import java.util.Random;

public class MonteHallSimulator
{
	//user input values
	private static final boolean SWAP = false;
	private static final boolean PRINT = false;
	private static String prize = "Car";
	private static String boobyPrize = "Goat";
	private static int numOfTests = 10000000;
	
	//initialize door variables
	private static String[] doors = new String[3];
	private static int[] nonSelectedDoors = new int[2];
	private static int swapChoice;
	
	//win and loss counters
	private static int wins = 0;
	private static int losses = 0;
	
	//random object for use throughout the code
	private static Random rand = new Random();
	
	//door picked by player
	private static int contestantPick = 0;
		
	public static void main(String[] args)
	{
		for (int i = 0; i < numOfTests; i++)
		{
			fillDoors();
			pickDoor();
			if (SWAP) contestantPick = swap();
			winCheck();
			if (PRINT) System.out.println("\n*******************************\n");
		}
		System.out.println(displayResults());
	}
	
	private static String displayResults()
	{
		//determine display output based on whether the player swaps or not
		String swapStatus = "";
		if (SWAP) swapStatus = "On";
		else swapStatus = "Off";
		
		//calculates win and loss percentages
		double winPercent = (wins/((double)wins + (double)losses)) * 100;
		double lossPercent = (losses/((double)wins + (double)losses)) * 100;
		
		return String.format
		(
				"Games Played: %,d\n"
				+"Swap Status: %s\n***********************\n"
				+"Total Wins: %,d (%.2f%%)\n"
				+"Total Losses: %,d (%.2f%%)"
				, numOfTests, swapStatus, wins, winPercent, losses, lossPercent
		); 
	}
	
	private static String winCheck()
	{
		String ret = "";
		if (doors[contestantPick] == prize) {wins++; ret="Player Wins!";}
		else {losses++; ret = "PLayer Loses!";}
		return ret;
	}
	
	private static int swap()
	{
		int j = 0;
		for (int i = 0; i < doors.length; i++)
		{
			if (contestantPick != i)
			{
				nonSelectedDoors[j] = i;
				j++;
			}
		}
		if (PRINT) for (int el: nonSelectedDoors) System.out.println(el);
		
		if (doors[nonSelectedDoors[0]] == prize)
		{
			if (PRINT) System.out.println("Opened Door #" + nonSelectedDoors[1] + " to reveal a Goat");
			swapChoice = nonSelectedDoors[0];
		}
		else
		{
			if (PRINT) System.out.println("Opened Door #" + nonSelectedDoors[0] + " to reveal a Goat");
			swapChoice = nonSelectedDoors[1];
		}
		if (PRINT) System.out.println("Player switched to door #" + swapChoice);
		return swapChoice;
		
	}
	
	private static void pickDoor()
	{
		contestantPick = rand.nextInt(3);
		if (PRINT) System.out.println("\nPlayer Chose: " + contestantPick);
	}
	
	private static void fillDoors()
	{
		//start by filling all doors with goats
		for (int i = 0; i < doors.length; i++)
		{
			doors[i] = boobyPrize;
		}
		
		//create random prize door and assign it a car
		doors[rand.nextInt(3)] = prize;
		
		if (PRINT) for (int i = 0; i < doors.length; i++) System.out.println("Door # " + i + ": " + doors[i]);
	}
}
