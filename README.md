 

## Design decisions


- I have decided the make the different moves, Rock, Paper and Scissors explicit in the Domain Model. \
It would probably be easier to just use an enum type, and have the Game Rules coded in each Game implementation. 
If we wanted to implement some extended game version, like "Rock, Paper, Scissors, spock, lizard", we would then need to add a 
new value to the enum type, and have a new Game implementation with the new rules coded. The down side is that we 
are modifying the old Move enum, violating then the Open Closed Principle. Having a new nextMove type could have an impact
on the old classic game logic, and break it.

On the other hand, having explicit value objects for the different moves, allows us to implement the game rules
in the moves themselves, and gets us rid of the enum type altogether. Sort of a replace conditional with polymorphism
if you will. 

Implementing an extended version of the game, like "Rock, Paper, Scissors, spock, lizard", requires adding a new class and 
probably subclassing the existing moves to adhere to the new rules too. With this version, we would create a new 
sub-interface of ClassicMove which adds support for the new spock nextMove, and probably extend the classic Paper, 
Rock and Scissors to implement the ExtendedClassicMove interface adding the handling for the spock nextMove.
At least, this allows me to leave Domain Model open for further extension with different exotic moves.

- I have created explicit Value Object classes for the PlayerName and Iterations, which has several benefits. 
One being the possibility to add validation logic to them, instead of having that logic scattered all over the place in 
other classes. In order to ease that pain a little I have used the library AutoValue which takes care of that.


## Building

#### Requirements

- JDK 1.8
- Maven 3.5.3 or later 
 
In order to build the complete project, from the root project folder, type __mvn clean install__ in a command line shell.

## Running

#### Requirements

- JDK 1.8 (Make sure you are not using a later version for running). If you see JAXB errors coming up, you are using
a later version
- Maven 3.5.3 or later (optional)

##### Using the command line tool

You can launch the execution of the Rock Paper Scissors Game like so:<br>

This Command to launch game in Auto Mode : <br>
java -Dspring.profiles.active=tool -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar <br>

This Command to launch game in SINGLE_PLAYER Mode : <br>
java -Dspring.profiles.active=tool -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar --mode=SINGLE_PLAYER --firstPlayer=john <br>

This Command to launch game in BOTH_PLAYER Mode : <br>
java -Dspring.profiles.active=tool -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar --mode=BOTH_PLAYER --firstPlayer=john --secondPlayer=donald<br>

by default iterations value to launch new game is 10. user defined value can be given as : <br>
java -Dspring.profiles.active=tool -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar --iterations=1 <br>
java -Dspring.profiles.active=tool -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar --mode=SINGLE_PLAYER --iterations=1 --firstPlayer=john <br>

###### Enabling debugging
_java -Dspring.profiles.active=tool -Dlogging.level.com.game.rockpaperscissors=DEBUG -jar target\rock-paper-scissors-0.0.1-SNAPSHOT.jar_

