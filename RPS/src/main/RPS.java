package main;

import java.util.Random;
import java.util.Scanner;

public class RPS{
	/**
	* Compares user input to a randomly generated input to determine a winner for Rock-Paper-Scissors.
	* @author Cason Fluharty
	* @version 1.0
	*/
	
	public static int player = 0, cpu = 0, tie = 0;
	
	public static void main(String[] args)
	{
		playRPS();
	}
	
	
	/**
	* Returns the user's string input to the main method to test it against the randomly generated CPU output.
	* <p>
	* This method utlizes a while statement to ensure user input values are assigned properly.
	* 
	* @var   	sc        the scanner component that reads user input
	* @var   	someIn    the user input as an upper case string
	* @return  	pIn    
	*/
	public static String playerInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input either R for Rock, P for Paper, or S for Scissors:");
		String someIn = sc.next().toUpperCase();
		
		//Uses 2 AND operators to make the while statement true until the user input equals one of the listed values.
		while (!someIn.equals("R") && !someIn.equals("P") && !someIn.equals("S"))
		{
			System.out.println("That is not a valid input. You input: " + someIn);
			System.out.println("Please input either R for Rock, P for Paper, or S for Scissors:");
			someIn = sc.next().toUpperCase();
		}

		String pIn = someIn;
		
		return pIn;
	}
	
	/**
	* Returns a random computer output to compare against user input.
	* <p>
	* This method utlizes a switch-case to get its cIn value.
	* 
	* @var   	r         	the random variable used to resolve an int for RPS
	* @var   	rand_int  	the integer generated using Random r
	* @return  	cIn    	 	the string identifying the computer "choice"
	*/
	protected static String cpuInput()
	{
		Random r = new Random();
		int rand_int = r.nextInt(3); //Generates random int from 0 to 2.
		String cIn;
		
		switch (rand_int)
		{
			case 0: 
				cIn = "R";
				System.out.println("The CPU chose Rock!");
				break;
			case 1: 
				cIn = "P";
				System.out.println("The CPU chose Paper!");
				break;
			case 2: 
				cIn = "S";
				System.out.println("The CPU chose Scissors!");
				break;
			default:
				cIn = "P";
				System.out.println("Something went wrong in RPS randomization...");
				break;
		}
		return cIn;
	}
	
	/**
	* Gets user input and random cpu input and compares them to determine a winner.
	* <p>
	* 
	* 
	* @var   	sc         	the scanner variable that gets user input (Y/N)
	* @var   	pIn  	  	the user input from the playerInput method
	* @var   	cIn    	  	the computer input from the cpuInput method
	* @var  	result     	message with cpu input and winner of the RPS
	* @return     			message through System that tells player the final score
	*/
	protected static void playRPS()
	{
		Scanner sc = new Scanner(System.in);
		String pIn = playerInput();
		String cIn = cpuInput();
		String result = "Something went wrong... Scores were not tallied properly."; //Default value in case values are not passed to the if-else ladder.
		
		// Tests for tie
		if ((pIn.equals("R") && cIn.equals("R")) || (pIn.equals("P") && cIn.equals("P")) || (pIn.equals("S") && cIn.equals("S")))
		{
			result = "It's a tie!";
			tie++;
		}
		// Tests for player win
		else if ((pIn.equals("R") && cIn.equals("S")) || (pIn.equals("P") && cIn.equals("R")) || (pIn.equals("S") && cIn.equals("P")))
		{
			result = "You won!";
			player++;
		}
		// Tests for cpu win
		else if ((pIn.equals("R") && cIn.equals("P")) || (pIn.equals("P") && cIn.equals("S")) || (pIn.equals("S") && cIn.equals("R")))
		{
			result = "CPU won!";
			cpu++;
		}
		else
		{
			System.out.println("pIn = " + pIn + " | cIn = " + cIn);
		}
		
		System.out.println(result);
		System.out.println("Would you like to play again? [Y/N]"); //Default is 'N' in case user misinputs
		
		if (sc.next().toUpperCase().equals("Y"))
		{
			playRPS();
		}
		else
		{
			// Ends game and returns final scores
			System.out.println("Final scores are as follows:");
			System.out.println("Player-" + player + " | CPU-" + cpu + " | Tie-" + tie);
		}
	}
	
	/**
	* Uses String p and c to determine a winner based on playRPS() method.
	* <p>
	* This is a test method used by JUnit to ensure the program runs properly.
	* 
	* @param   p  	  		the user input
	* @param   c    	  	the computer input
	* @return  winner   	String used for comparison to ensure test method works properly
	*/
	public static String testRPS(String p, String c)
	{
		String pIn = p;
		String cIn = c;
		String winner = null;
		
		// Tests for tie
		if ((pIn.equals("R") && cIn.equals("R")) || (pIn.equals("P") && cIn.equals("P")) || (pIn.equals("S") && cIn.equals("S")))
		{
			winner = "T";
			tie++;
		}
		// Tests for player win
		else if ((pIn.equals("R") && cIn.equals("S")) || (pIn.equals("P") && cIn.equals("R")) || (pIn.equals("S") && cIn.equals("P")))
		{
			winner = "P";
			player++;
		}
		// Tests for cpu win
		else if ((pIn.equals("R") && cIn.equals("P")) || (pIn.equals("P") && cIn.equals("S")) || (pIn.equals("S") && cIn.equals("R")))
		{
			winner = "C";
			cpu++;
		}
		else
		{
			System.out.println("Invalid inputs. Only use R, P, or S.");
		}
				
		return winner;
	}
}
