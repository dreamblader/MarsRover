package mars;

class Rover
{
    private int posX;
    private int posY;
    private Direction direction;


    public Rover(int x, int y, Direction dir)
    {
        posX = x;
        posY = y;
        direction = dir;
    }

    public Rover(int x, int y, char dir)
    {
        posX = x;
        posY = y;
        direction = Direction.getDirectionByChar(dir);
        
        if(direction == null)
        {
        	throw new IllegalArgumentException(dir+" is an Invalid Direction Symbol");
        }
    }

    public int getX()
    {
        return posX;
    }

    public int getY()
    {
        return posY;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void rotateRight()
    {
        direction = direction.addToIndex(1);
    }

    public void rotateLeft()
    {
        direction = direction.addToIndex(-1);
    }

    public void moveForward()
    {
        if(direction == Direction.NORTH || direction == Direction.SOUTH)
        {
            posY += direction.getValue();
        }
        else if(direction == Direction.EAST || direction == Direction.WEST)
        {
            posX += direction.getValue();
        }
    }
}