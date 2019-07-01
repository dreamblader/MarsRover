package mars;

public enum Direction
{
    NORTH(+1 , 'N'),
    EAST (+1 , 'E'),
    SOUTH(-1 , 'S'),
    WEST (-1 , 'W');

    protected int value;
    protected char symbol;

    private Direction (int value, char symbol)
    {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue()
    {
        return this.value;
    }

    public char getSymbol()
    {
        return this.symbol;
    }
    
    public static Direction getDirectionByChar(char symbol)
    {
    	Direction [] directions = Direction.values();
    	
    	if(!Character.isUpperCase(symbol)) //transform into Case Insensistive
    	{
    		symbol = Character.toUpperCase(symbol);
    	}
    	
    	for(Direction direction : directions)
    	{
    		char searchSymbol = direction.getSymbol();
    		
    		if(symbol == searchSymbol )
    		{
    			return direction;
    		}
    	}
    	
    	return null;
    }

    public Direction addToIndex(int var)
    {
        Direction [] directions = Direction.values();

        int myIndex = this.ordinal();
        int newIndex = myIndex + var;
        newIndex %= directions.length;
        
        if(newIndex < 0) //negative index (reverse)
        {
            newIndex += directions.length;
        }

        return directions [newIndex];        
    }
}
