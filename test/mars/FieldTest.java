package mars;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FieldTest
{

	Rover testRover;
	Rover initRover;
	Field testField;
	
	@Before
	public void setup() 
	{
		initRover = new Rover(1,1,Direction.NORTH);
		testField = new Field(2,2);
		testField.addRover(initRover);
	}
	
    @Test
    public void testAddInvalidRover() 
    {
    	testRover = new Rover(3,3,Direction.NORTH); //valid rover BUT OUT of FIELD Coordinates
    	
    	assertEquals(false ,testField.addRover(0,0,'X')); //invalid direction
    	assertEquals(false ,testField.addRover(testRover)); //invalid coordinates
    	assertEquals(false ,testField.addRover(initRover)); //collide with another rover
    }
    
    @Test
    public void testAddRoverOverRover() 
    {
    	testRover = initRover;
    	
    	int x = testRover.getX();
    	int y = testRover.getY();
    	
    	assertEquals(true ,testField.checkCollision(x,y));
    }
    
    @Test
    public void testAddRoverOutOfBounds() 
    {
    	assertEquals(true ,testField.checkCollision(3,0)); // Out of X axis bound
    	assertEquals(true ,testField.checkCollision(0,3)); // Out of Y axis bound
    	assertEquals(true ,testField.checkCollision(3,3)); // Out of X AND Y axis bound
    }
    

}

