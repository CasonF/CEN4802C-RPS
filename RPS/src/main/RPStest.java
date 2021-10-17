package main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RPStest {
	
	
	@Test
	public void testTie()
	{
		assertEquals("T", RPS.testRPS("R", "R")); //Should result in a tie
	}
	
	@Test
	public void testPlayerWin()
	{
		assertEquals("P", RPS.testRPS("R", "S")); //Should result in player win
	}
	
	@Test
	public void testCompWin()
	{
		assertEquals("C", RPS.testRPS("R", "P")); //Should result in computer win
	}
	
	@Test
	public void testNull()
	{
		assertEquals(null, RPS.testRPS("Q", "C")); //Should return null
	}
	
}
