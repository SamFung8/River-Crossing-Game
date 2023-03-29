# Documentation

## Project clarfication (Important, please read carefully)

- There are only two modes: Player Mode and Puzzle solver Mode.

- There is NO diffcutly, we can prepare different JSON file for differnt diffculty setup (easy.json, hard.json). Thus, please DO NOT WRITE any code regarding the concept of diffcutly, It will be a waste of time.

- Any game checking (including game win/lose checking) should be handled in the RuleSet, other classes should only care about the result not the process.

## Coding and naming convention

class name always start with Upper case.
`public class Puzzle` (OK)
`public class puzzle` (No ok)


## Class description
this part list all **IMPORTANT** information of how different classes communicating with each other. Please make sure you read and understand all.

## Puzzle pakage (The common pakage)
### Puzzle
Storing all the esstiental information about the Puzzle for others to access

`String name, description , etc.`

`PuzzleState currState`  store current state of the game

`JSONObject puzzleJSON` store the COMPLETE json of the file when loading, for others to access 

`RuleSet ruleSet` use this for checking if a Move is valid, see usage below

`Puzzle(String path)` load JSON, initialize ruleset

### PuzzleState
`ArrayList<String> landA, landB` storing what roles are on land A and land B

`int boatPos`

`boolean isIdentical(PuzzleState)`

### Move
A move is storing the informaton resemble the player input in the game. Such as what roles is traveling to another side? What is their origin and destinatation land? 

`ArrayList<String> travlers`

`int origin, destination` landA= 0, landB = 1.

## PuzzleLogic
### RuleSet
`Hashset<String, boolean> travelables` 

`PuzzleState targetState`

`RuleSet(Puzzle)` parse the JSON string (not the path) into set of rules.

`ArrayList<Rule> rules` store the rule one by one, not one class for all rules

`Response isValidMove(PuzzleState, Move)` check if the move is valid by loop through all the rules.

`Boolean isWin(PuzzleState)`

### Rule (abstract)
`Rule exception` the exception rule

`Response isValid(PuzzleState)`

### ConflictRule, CoexistRule (inherit Rule)

### Response
`boolean isValid`

`String msg`

`String toString()`
## PuzzleSolver
### Solver
`Solution solve(Puzzle)` 
### Solution
`boolean isSolved`

`String msg`

`String toString()`
