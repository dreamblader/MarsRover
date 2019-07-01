package mars;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RoverTest 
{
	Rover testRover;
	int expectedRoverX;
	int expectedRoverY;
	Direction expectDirection;
	
	@Before
	public void setup()
	{
		testRover = new Rover(0,0,Direction.NORTH);
	}
	
	@Test
	public void testRoverRotateLeft()
	{
		expectDirection = Direction.WEST;
		
		testRover.rotateLeft();
		assertEquals(expectDirection, testRover.getDirection());
	}
	
	@Test
	public void testRoverRotateRight()
	{
		expectDirection = Direction.EAST;
		
		testRover.rotateRight();
		assertEquals(expectDirection, testRover.getDirection());
	}
	
	@Test
	public void moveFromNorth()
	{
		testRover.moveForward();
		expectedRoverY = 1;
		
		assertEquals(expectedRoverY, testRover.getY());
	}
	
	@Test
	public void moveFromEast()
	{
		testRover = new Rover(0,0,Direction.EAST);
		testRover.moveForward();
		expectedRoverX = 1;
		
		assertEquals(expectedRoverX, testRover.getX());
	}
	
	@Test
	public void moveFromSouth()
	{
		testRover = new Rover(0,0,Direction.SOUTH);
		testRover.moveForward();
		expectedRoverY = -1;
		
		assertEquals(expectedRoverY, testRover.getY());
	}
	
	@Test
	public void moveFromWest()
	{
		testRover = new Rover(0,0,Direction.WEST);
		testRover.moveForward();
		expectedRoverX = -1;
		
		assertEquals(expectedRoverX, testRover.getX());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateInvalidRover()
	{
		testRover = new Rover(0,0,'X');
	}
}
