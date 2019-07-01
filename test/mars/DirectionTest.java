package mars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest 
{
	Direction testDirection;
	Direction expectDirection;

	@Test
	public void testIndexLoopForward()
	{
		testDirection = Direction.WEST;
		expectDirection = Direction.NORTH;
		
		assertEquals(expectDirection, testDirection.addToIndex(1));
	}
	
	@Test
	public void testIndexLoopBackward()
	{
		testDirection = Direction.NORTH;
		expectDirection = Direction.WEST;
		
		assertEquals(expectDirection, testDirection.addToIndex(-1));
	}
	
	@Test
	public void testFullLoop()
	{
		testDirection = Direction.NORTH;
		expectDirection = Direction.NORTH;
		
		assertEquals(expectDirection, testDirection.addToIndex(4));
	}
	
	@Test
	public void forwardLoopBigNumber()
	{
		testDirection = Direction.WEST;
		expectDirection = Direction.NORTH;
		
		assertEquals(expectDirection, testDirection.addToIndex(5));
	}
	
	@Test
	public void backwardLoopBigNumber()
	{
		testDirection = Direction.NORTH;
		expectDirection = Direction.WEST;
		
		assertEquals(expectDirection, testDirection.addToIndex(-5));
	}
	
	@Test
	public void testChardToDirectionLowerCase()
	{
		expectDirection = Direction.WEST;
		
		assertEquals(expectDirection, Direction.getDirectionByChar('w'));
	}
	
	@Test
	public void testChardToDirectionUpperrCase()
	{
		expectDirection = Direction.WEST;
		
		assertEquals(expectDirection, Direction.getDirectionByChar('W'));
	}
	
	@Test
	public void testChardToDirectionInvalidCase()
	{
		expectDirection = null;
		
		assertEquals(expectDirection, Direction.getDirectionByChar('X'));
	}
}
