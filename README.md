ntroduction:

Word games can be a lot of fun and also help to keep our minds working.  In this assignment you will implement a very simple word game in an object-oriented way.  As you will see in the specifications below, most of the work / challenge in this assignment is not in the actual playing of the game – rather it is in logging in new and repeat users and in maintaining the user files.

 

The Game:

The game you will implement is very simple and found in newspapers across the country.  Your program will read in a random word from a file, scramble up the letters and then show the scrambled letters to the player.  The player will then have 5 chances to guess the correct unscrambled word.  If he/she succeeds, he/she wins the game – otherwise he/she loses and the program shows him/her the actual word.

 

In order to play, the game, players must be valid users on a user list.  Anyone can join this list, but a player must be on the list to play the game.  For each player, simple statistics are also kept – the number of games played and the number of times won.

 

Logging In:

Each player must log in before playing the game.  No password is required – just an id identifying each user.  The ids are kept in a file and this file must be searched to check for a returning player.  A player will be given 3 chances to log in as a returning user.  If no valid id is entered after three tries, the game ends.

 

If a player is new to the game, he/she should select a new id and should enter his/her last name and first name.  The id must not already be present in the list of ids – if it is the player should be asked to select a different id (note that this could repeat many times until a final id is chosen).

 

Player Info:

Two types of files will be used to maintain player information:

1)    A file of user ids called "players.txt".  This will store one id per line.  Each id should have no spaces or other "white space" characters (ex: tabs, new lines), but any other characters are ok.  The "players.txt" file will be searched when a player logs in, and when a new player registers his/her id will be appended to the end of this file.

2)    A file for each user containing 4 lines.  The lines will be (in order): Last Name, First Name, # of Games Played, # of Games Won.  These user files will be named based on user ids.  For a given user id, say user1, the file will be named "user1.txt".  Note that given an id obtained from the "players.txt" file above, the individual user file can easily be determined and accessed.  This user file will be created and initialized when a player first registers, and it will be updated after each game to reflect the new number of games played and games won.

 

Word List:

In addition to the player files, there will be a file containing the words that will be used for the game.  This file will be called "words.txt" and will be formatted in the following way: The first line contains an integer representing the number of words in the file.  The remaining lines contain the actual words, one per line.  See an example "words.txt" file on the Assignment page.

 

Program Progression:

Your program should proceed as follows:

1)    Welcome the user and ask if he/she is a new or returning player.

a)     If the player is a returning player, do the following:

i)      Ask him/her to enter his/her id in order to get into the site.

ii)    Check to see if the id is in the "players.txt" file.   If so, continue on to play the game (number (2)  below).  If not, have him/her try again.  If a player is unsuccessful after 3 tries, the program should end without the game being played.

b)     If the player is a new player, do the following:

i)      Ask him/her to enter his/her name (last and first) and read them in.

ii)    Ask him/her to enter a new id

iii)   Check to see if the id is in the "players.txt" file.   If not, append the new id to the end of the file, create the id.txt file for the user, and continue on to play the game (number (2)  below).  If the id IS in the file, have him/her try again with a different id.  Continue this process indefinitely until a valid id has been chosen.

2)    Obtain a random "scramble" word from "words.txt" for the user to guess.  Display only the scrambled version, but also store the original for checking.  See details on how to implement this in the Implementation Requirements section below.

3)    Ask the user to guess words and compare against the original.  Allow at most 5 guesses.  If the user guesses the word correctly within the 5 guesses, he/she has won the game.  If not, he/she has lost the game.

4)    Notify the user that he/she as won or lost and update his/her file to reflect the outcome of the game.

 

Implementation Requirements:

The functionality described above could be implemented in several different ways.  However, in order to get credit for this assignment, you must implement it as specified below:

Your program must be implemented using 3 classes:

1)    A class Player stored in file "Player.java".  This class must store all information related to a player of the game (ex: Name, Id, Rounds played, Rounds Won) in private instance variables.   It must also have methods to allow a player to:

a)     Login – this will test a player's Id against a file (whose name is passed into the method as a parameter).  If the id is found in the file the player's logged status will be marked as "true"; otherwise it will be marked as "false".

b)     Register – this will test a player's Id against a file (whose name is passed into the method as a parameter).  If the Id is not found in the file it will be added to the end of the file and the player's logged status will be marked as "true"; otherwise it will be marked as "false".

c)     Update his/her wins and update his/her losses (since the main program will not be able to access the instance variables directly)

d)     Return a formatted String version of the player's information for output

e)     Write the player's information back to the appropriate file (based on the player's Id).

2)    A class Scramble stored in file "Scramble.java".   This class must have the following:

a)     Two instance variables (one for the original word and one for the scrambled version)

b)     A constructor that takes a file name as an argument and reads a random word from the file.  It then creates a "scrambled version" of the word and stores both the original and the scrambled version.  Think carefully about how you can select a random word from the file (Hint: generate a random number based on the number of words in the file and use it to determine how many words to skip) and about how you can scramble a string (Hint: use a StringBuilder and some of the mutators in that class to exchange characters).

c)     Two accessors – one to return the original word and one to return the scrambled version of the word.

3)    A main program called Assig2 stored in file "Assig2.java".  This program will utilize the Player and Scramble classes to actually execute the game, as described in the paragraphs above.  For example, the game requires that a returning player be given 3 chances to log in.  Thus your main program should call the "Login" method of your Player object up to 3 times before either continuing with the game or quitting.  As another example, after a player logs in, your program should create a Scramble object (using the "words.txt" file).  Its accessors can then be used by the program to obtain the word and its scrambled version.

 

You may not use any arrays (or ArrayLists or other similar types) in this program.  They are not necessary and I want you to think about how to implement the program without using them.  Some places you think you may need arrays (ex: selecting a random word from "words.txt" in the Scramble constructor) do not actually require them if you think about things carefully.

 

You will need to use files in several places in this program.  Some of these files may have to be opened / re-opened several times in the course of a single execution of the program – this is fine.  You can read from files in Java using the Scanner class – you simply need to pass a File into the constructor.  You can write to files using a PrintWriter.  However, there are some quirks to reading/writing text files in Java (related to exceptions that must be dealt with).   See ex10.java and Section 4.10 in your text for some help with file I/O in Java.

 

The words.txt file will be provided for you.  Note, however, that this file could be changed and/or a different version of it could be used to test your programs.  Your program should work for any properly formatted "words.txt" file.

 

The "players.txt" file and individual player files must be generated by you.  Make sure you use the format specified above.

 

Test your program thoroughly before handing it in. Make sure it functions as required in all cases.  I have generated some sample output that may help you with this.  See: a2out.txt.  I may also put additional files online (ex: perhaps some sample code) so be sure to check back regularly for updates.