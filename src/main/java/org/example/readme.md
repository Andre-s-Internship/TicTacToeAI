Playing instructions:

1. Run the TicTacToe file
2. Enter start and 2 of the "user, easy, medium, hard" keywords. Like "start user easy" or "start hard medium" 
Start means starting the game, those four keywords define the players. The First player entered will play as 'X' second 
as 'O' If you chose "user" as one of the players (or even 2), you should enter coordinates to put your characters on the
board. Coordinates are 2 numbers between 1 and 3 separated by space, first number corresponds to the row and second is 
for the column, if the inputted cell is already occupied, or you entered invalid arguments, the program will ask for 
valid input.
3. After each move game will print the state of the board and ask for entering coordinates if that's the turn of user
4. After making those moves, the game will print the character of winner or Draw if the game ended in draw.


Code Structure:
Code consists of six classes:
TicTacToe - is the main class for the game. The game is played here, constantly making the moves of players and checking 
if there's a winner or draw, or the game is not finished yet.
Player — This is interface for all types of players — user, easyAI, mediumAI and hardAI
User — this class handles the case when at least one of the players is a user, it prints corresponding texts for user to 
correctly navigate through the game and makes the moves on the board for user.
EasyAI, MediumAI, HardAI - each of these classes are players, but in these cases computer plays as a player 
with corresponding difficulty levels, each time AI makes a move it prints its difficulty.