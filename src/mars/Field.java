package mars;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Field
{
    char[][] map;
    int height;
    int width;
    //int roverTurn=0;
    List<Rover> roverList = new ArrayList<Rover>();

    public Field(int x, int y)
    {
    	height = y+1;
        width = x+1;
        map = new char [height][width];
        
        
        for(char [] line : map)
        {
        	Arrays.fill(line, '.');
        }
    }

    public Boolean addRover(int x, int y, char dir)
    {
    	try
    	{
    		return addRover(new Rover(x,y,dir)); 
    	}
		catch(IllegalArgumentException error)
    	{
    		System.out.println("Cannot deploy rover - invalid direction coordinate");
    		System.out.println("Valid Coordinates: ");
    		System.out.println("'N' or 'n' for NORTH");
    		System.out.println("'E' or 'e' for EAST");
    		System.out.println("'S' or 's' for SOUTH");
    		System.out.println("'W' or 'w' for WEST");
    		return false;
    	}
    }
    
    public Boolean addRover (Rover rover)
    {
    	
	        Rover newRover = rover;
	        int x = rover.getX();
	        int y = rover.getY();
	
	        if(!checkCollision(x,y)) // if no collision then add rover
	        {
	            roverList.add(newRover);
	            return true;
	        }
	        else
	        {
	            System.out.println("Cannot deploy rover - invalid X and Y coordinates");
	            System.out.println("Verify if coordinates ("+ x +","+ y +") is inside the field and no other Rover is in the indicate space");
	            return false;
	        }  	
    	
    }

    public void roverCommand(String commandString, int roverID)
    {
        try
        {
            Rover dummyRover = roverList.get(roverID);
           
            //get char by char from command string
            for(int i=0; i<commandString.length(); i++)
            {
                Boolean CanUpdate = true;
                char command = commandString.charAt(i);

                if (command == 'L'||command == 'l') // CASE INSENSITIVE
                {
                    dummyRover.rotateLeft();
                }
                else if (command == 'R' || command == 'r') // CASE INSENSITIVE
                {
                    dummyRover.rotateRight();
                }
                else if (command == 'M' || command == 'm') // CASE INSENSITIVE
                {
                    dummyRover.moveForward();

                    int x = dummyRover.getX();
                    int y = dummyRover.getY();

                    if(checkCollision(x, y)) //verify if new rover position does not collide into anything
                    {
                       CanUpdate = false; 
                    }
                }
                else //else Invalid Command --> Skip the command (do nothing)
                {
                    continue;
                }

                if(CanUpdate)
                {
                    roverList.set(roverID, dummyRover); // update list with new rover position
                }
                
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid roverID: "+roverID);
            return;
        }

        
    }

    public Boolean checkCollision(int x, int y)
    {
        //out of bounds
        if(x<0 || x>=width || y<0 || y>=height)
        {
            return true;
        }

        //another object in the coordinates of fieldArray
        for(Rover rover : roverList)
        {
            int roverX = rover.getX();
            int roverY = rover.getY();

            if(x == roverX && y == roverY) // two objects cannot occupy the same space
            {
                return true;
            }
        }

        return false;

    }

    public void mapPrint()
    {
        updateRoversOnMap();

        String mapBorder =". X ";

        for(int i=0; i<width; i++)
        {
        	mapBorder+="X ";
        }

        mapBorder+=".";


        System.out.println(mapBorder);

        for(char [] line : map)
        {
            System.out.print("|| ");

            for(char c: line)
            {
                System.out.print(c+" ");
            }

            System.out.println("||");
        }

        System.out.println(mapBorder);
    }

    public void printRovers() //print all rover data in order
    {
        for (Rover rover : roverList)
        {
            int x = rover.getX();
            int y = rover.getY();
            char directionSymbol = rover.getDirection().getSymbol();

            System.out.println(x+" "+y+" "+directionSymbol);
        }
    }

    public void updateRoversOnMap()
    {
        //transform Rover X and Y to map X and Y
        // Rover posX = 0 = Left & posY = 0 = Bottom 
        // Map   posX = 0 = Left & posY = 0 = TOP    (Need to reverse Y coordinate)
        for(Rover rover : roverList)
        {
            int x = rover.getX();
            int y = rover.getY();
            char directionSymbol = rover.getDirection().getSymbol();

            y = (height-1)-y; // reversing Y

            map[y][x] = directionSymbol;
        }
    }
   
}