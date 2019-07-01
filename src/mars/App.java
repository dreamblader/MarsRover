package mars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
	static Boolean commandLine = false;
	static Field field = null;
	static int roverTurn = 0;
	
    public static void main(String[] args) throws IOException
    {
    	
    	BufferedReader reader;
    	
    	if (args.length == 0)
    	{
    		System.out.println("Please provide file PATH in commandline argument");
    	}
    	else
    	{
    		reader = new BufferedReader(new FileReader(args[0]));
    		String line;
    		int lineIndex = 0;
    		
    		try 
    		{
	    		while((line = reader.readLine()) != null)
	    		{
	    			lineReader(line, lineIndex);
	    			lineIndex++;
	    		}
    		  		
    			field.printRovers(); // Output
    			
    			if(args.length>1) // Extra Command (just one for now)
    			{
    				System.out.println();
    				
    				if(args[1].equals("-m"))
    				{
    					field.mapPrint();
    				}
    				else
    				{
    					System.out.println("Extra commands");
    					System.out.println("-m : Show ASCII Field Map");
    				}
    			}
    		}
    		catch(NullPointerException  e)
    		{
    			System.out.println("NO FIELD Instantiated - Check if first line of file declare the Field X and Y Coordinates");
    			System.out.println("EXAMPLE: '5' '5");
    		}
    		catch(NumberFormatException e)
    		{
    			System.out.println("Expecting Number Coordinates");
    			System.out.println("Verify if any String information is in the designed Number Coordinate field");
    		}
    		
    	}
        
    }
    
    private static void lineReader(String line, int lineIndex)
    {
		String [] array = line.split(" ");
		int x = -1;
		int y = -1;
		char dir = 'X';
		
		if(array.length>=2)
		{
			x = Integer.parseInt(array [0]);
			y = Integer.parseInt(array [1]);
			
			if(array.length>=3)
			{
				dir = array[2].charAt(0);
			}
		}
		 
		
		if(lineIndex==0 && (x != -1 && y!=-1)) //field Instantiation
		{
			field = new Field(x,y);
		}
		else if(!commandLine && (x != -1 && y!=-1)) 
		{
			if(field.addRover(x,y,dir)) //do not progress to commandLine until a rover is deployed (skip this rover commandLine)
			{
				commandLine = true;
			}
		}
		else if(commandLine)
		{
			field.roverCommand(line,roverTurn);
			roverTurn++; //next rover
			commandLine = false;
		}
		
    	
    }
}