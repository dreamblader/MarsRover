# MarsRover

## Instructions

The Application require an Input File to get the designed commands.  
The Input File PATH is expected as first argument  
The Application will ask for a File PATH if no arguments passed 

See **File Design** Section for how to structure your *INPUT FILE*

Run Example *INPUT*:
* Execute code with argument = "input.txt"

Run Any Text *INPUT*:
* Execute code with argument = [File Path]
  * [File Path] = Your INPUT file PATH (txt format)

It is possible to pass a second argument for an Extra Command

***

## Extra Command

The Application gets a second argument to run an Extra Command.  
Only one command implemented

| Command     | Description  |
|-------------| -----------  |
| *-m*        | Print an ASCII map representing the App Field

### *-m* Output Example:

``` 
. X X X X X X X .  
|| . . . . . . ||  
|| . . . . . . ||  
|| . N . . . . ||  
|| . . . . . . ||  
|| . . . . . E ||  
|| . . . . . . ||  
. X X X X X X X .
```
The Character **.** represents an empty field space  
If a Rover is in the space  
Prints a Character representing the current Rover Direction (N, E, S, W)  
The Bottom-Left of the Map is represented by the coordinates (0, 0)  
The Upper-Right of the Map is represented by the coordinates (X, Y)  
X and Y being the Map Maximum designed coordinates by the Input File

***

## File Design
The Application always expect the following File Data Pattern:
|Line| Label                      |Expected Data Types (separated by space)|
|----|----------------------------|----------------------------------------|
| 1  | Field Information Header   | *int* x  *int* y                       |
| 2  | Rover 1 Instantiation Data | *int* x  *int* y  *char* direction     |
| 3  | Rover 1 Command Data       | *String* commands                      |
|... |                            |                                        |
|N+1 | Rover N Instantiation Data | *int* x  *int* y  *char* direction     |
|N+2 | Rover N Command Data       | *String* commands                      |

N being the quantity of rovers which the user want to instantiate.

**IF** Field Information Header have an invalid data pattern
* The Application will not instantiate a FIELD and will return a message

**IF** Rover [NUMBER] Instantiation Data have an invalid data pattern
* The Application will not instantiate a ROVER and will return a message
* The follow-up Command Data will be skipped

**IF** Rover [NUMBER] Command Data have an invalid data pattern
* The Command Data will be skipped

***

## Application

The Application assume that the rover can only move in the four cardinal directions
* N - NORTH
* E - EAST 
* S - SOUTH
* W - WEST

Before any rover instantiation or movement
* The Application will check if Rover Position is valid with checkCollision(int x , int y)
* Rover Position is valid
  * IF Rover is inside the Field coordinates
  * AND Rover Position is not previous occupied by another Rover
* Rover will not update current position if it is invalid

The Application is CASE INSENSITIVE  
Commands and Direction Symbols can be either Lower Case or Upper Case inside the INPUT FILE

You cannot instantiate a Rover with an invalid Direction Symbol inside the INPUT FILE
* 'N' or 'n' - NORTH
* 'E' or 'e' - EAST
* 'S' or 's' - SOUTH
* 'W' or 'w' - WEST

Any Character in Rover Command Line that does not invoke a command will be skipped
* 'L' or 'l' - rotateLeft()
* 'R' or 'r' - rotateRight()
* 'M' or 'm' - moveForward()

## Credits
Program by: Carlos Gabriel Luz Monnazzi (Dreamblader)  

LinkedIn: [Carlos Gabriel Luz Monnazzi](https://www.linkedin.com/in/carlos-gabriel-luz-monnazzi-340201156/)  
GitHub: [Dreamblader](https://github.com/dreamblader)  
E-Mail: carlosgabrielmaster@gmail.com
