River Crossing Game (with customizable puzzle and solver)


------------------------Description------------------------------

River crossing puzzle is a famous puzzle game. The goal of the game is typically to move all the items/characters from one land to another land. 
Meanwhile, the items/characters may have special relationship with each other or have some restrictions on moving, bringing challenge and difficulty to the puzzle, 
such as “sheep cannot stay with tiger if farmer is not around”, “criminal will hurt others if police is not around”, “only farmer can move ship”. 
 
This project River Crossing Game (with customizable puzzle and solver aims to provide a playable river crossing game, 
and a puzzle solver to find optimal solution of the given puzzle. At the same time, allowing user to customize their own puzzle with simple text editor. 
Hence, our program provides the following features:

Player mode – Players can play the river crossing game in CLI. The program also provides undo and redo function in case players made a undesired move.

Solver mode – this mode can provide detailed optimal solution for the given puzzle using algorithms.

Puzzle customization – A puzzle’ information (e.g., characters, rules, initial state) is stored in an external JSON file. 
Players can modify those attributes and create their own puzzle, then import the modified JSON file to play with or obtain the puzzle solution. 
For the details of the Puzzle JSON format, please check the “Input file (JSON) format”section in Analysis and Design Report.

------------------------Installation------------------------------

--Install Java JRE version 11--

The program required Java Runtime Environment 11 or above to run. 
Previous version of JRE may lead to compatible problem which is not guaranteed to support. User are recommended to upgrade their JRE to ensure the program can run normally. 
To install it, please check https://www.oracle.com/java/technologies/downloads/ 



--Run the program--

The program is compatible with the trending operation system, including Windows, MacOS and Linux. The recommend window version is window 8 or above while Mac OS is version 10 or above. 	

To run the program, first enter the “release” folder, then do the following base on your operating system.
 
Windows:
Double click start.bat 
Or
Open the terminal, type ‘java -jar puzzle.jar’

Linux and MacOS:
Open the terminal, type ‘java -jar puzzle.jar’

------------------------User Guideline------------------------------

Check the following demo videos for quick overview of the system:
https://portland-my.sharepoint.com/personal/waitchau2-c_my_cityu_edu_hk/_layouts/15/onedrive.aspx?ga=1&id=%2Fpersonal%2Fwaitchau2%2Dc%5Fmy%5Fcityu%5Fedu%5Fhk%2FDocuments%2FCS3343%5FGroup%5F28%5FProject%5FDemo


--Select game mode--

After staring the program, select either solver mode or player mode by entering number 1 or 2.

--Select puzzle--

After selecting the game mode, select the puzzle to play/solve by the entering the ‘1’,’2’ or ‘3’. 
1’ and ‘2’ are the provided default puzzles, which can be played/solved immediately.

Entering ‘3’ means importing custom puzzle, which the program will then ask for the path of the custom puzzle JSON file. 
There are some other puzzle JSON files in the “release/json” folder for testing. For example, to use the family.json, type 'json/family.json'.

--Solver mode-- 
If solver mode is selected, the program will solve the given puzzle right away, no extra input is required. 
If the given puzzle has no solution, “No solution” will be displayed. Otherwise, a detailed steps of the optimal solution will be displayed.

--Player mode--
In player mode, first read the game description which will tell you the rules of the puzzle.

The program will receive following text commands as input:
<Full name of the character> to put the character to the boat,			 
's'  to start the boat
'e' to exit the program
'u' to undo the action
'r' to redo the action 

To make a move, first type the full name of character to put him/her on the boat, e.g. you want to put the farmer on the boat, then type 'famrer'. You can only put one character in each command input. 
After that, you should see the character is at the boat, note that the boat can hold up to two characters.

Then type ‘s’ to start the boat. The program will warn you if your move is invalid (violate rules). You can undo undesired move and redo an undo.

Note that the boat is considered as part of the land that it currently stays on, so some rules (e.g., conflict rule) will not be violated before the boat move to another land.
The game will end when the current state of the lands equal to the target state (defined in the given Puzzle JSON) which should be displayed in game description.


--Puzzle customization--

Open existing json files in "release/json" folder or create your own JSON file with any text editor. Modify the values in the JSON file, then import it in --Select puzzle-- process.

Please check the "Input file (JSON) format”section in Analysis and Design Report, which has detail description of each attritbute.
