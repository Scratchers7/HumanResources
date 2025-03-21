package ticTacToe;
import java.lang.Math;
import java.util.Scanner;
/*
Journey Allison
2/16/2025
Sources:
https://www.w3schools.com/java/java_enums.asp because I did not remember how to use them
https://www.w3schools.com/java/java_switch.asp because I wanted more clarity on switch
*/
public class TicTacToe {
	private enum CellStates{//enum to hold the possible sates of a cell in the TicTacToe Board
			X,
			O,
			Empty
	}
	
	private enum GameState{//enum to hold the possible outcomes of a game at any time, whether it is a draw, a win, or the game should continue
		Win,
		Draw,
		Continue
	}
	private CellStates[][] board;//2d array to represent the board
	private int takenCol;//used for the testing method, holds a taken column
	private int takenRow;//used for the testing method, holds a taken row
	private int moveNum;//used for the gameplay to know how is currently playing, x or o
	
	public TicTacToe(boolean test)
	{
		board = new CellStates[3][3];//Instantiates the board
		for(int i = 0; i < board.length;i++)//fills the array with empty
		{
			for(int j =0; j<board[i].length; j++)
			{
				board[i][j] = CellStates.Empty;
			}
		}
		moveNum = 0;//sets move num to zero
		if(test)//if this game is for testing then continue
		{
			board[(int)(Math.random()*3)][(int)(Math.random()*3)] = CellStates.X;//takes random spot and puts an x there
			int tempx;
			int tempy;
			while(true)//finds a random space that is unoccupied and puts an o there
			{
				tempx =(int)(Math.random()*3);//o column
				tempy =(int)(Math.random()*3);//o row
				if(board[tempy][tempx] == CellStates.Empty)
				{
					board[tempy][tempx] = CellStates.O;
					takenRow = tempy;
					takenCol = tempx;
					break;
				}
			}
			moveNum = 2; //sets move num to 2
		}
	}
	public TicTacToe()
	{
		//creates and empty board if it is not for testing
		board = new CellStates[3][3];
		for(int i = 0; i < board.length;i++)
		{
			for(int j =0; j<board[i].length; j++)
			{
				board[i][j] = CellStates.Empty;
			}
		}
	}
	
	public void play()
	{
		Scanner input = new Scanner(System.in);// creates scanner to get players moves
		System.out.println(printBoard());//prints empty board to begin
		while(true)//play loop
		{
			String player = turnPlayer();//represents either X or O depending on who's turn it is, used for printing
			int rowPlay;//what row they chose to play
			int colPlay;//what column they chose to play
			System.out.println("Player "+player+"'s turn");
			System.out.println("Player "+player+": Enter row (1, 2, or 3):       ");//Gets the players choice for row and column
			rowPlay = input.nextInt();
			System.out.println("Player "+player+": Enter column (1, 2, or 3):    ");
			colPlay = input.nextInt();
			if(!validMove(rowPlay,colPlay))//if it is not a valid move then repeat the loop without continuing the rest of it to get new play
			{
				System.out.println(playMove(rowPlay,colPlay));
				continue;
			}
			System.out.println(playMove(rowPlay,colPlay));//places move on board if it is a valid move
			if(gameStatus() == GameState.Continue)//if the game should continue then do the loop again
			{
				continue;
			}
			if(gameStatus() == GameState.Win)//if it is a win then display who won
			{
				System.out.println("Player "+player+" wins.");
				return;
			}
			System.out.println("It's a draw.");//if its a draw then display that it is a draw
			return;
		}
	}
	public String turnPlayer()
	{
		switch(moveNum%2)//converts move number to what player should be placed down
		{
		case 0://if it is even then play X
			return "X";
			//System.out.println("PrintO");
		case 1://if it is odd play O
			return "O";
			//System.out.println("PrintX");
		}
		return "";
	}
	public boolean validMove(int row, int col)
	{
		//determines if the suggested move is valid
		//takes a row and column of the suggested move
		//returns a boolean of whether or not it is valid
		if(row<4&&row>0&&col<4&&col>0&&board[row-1][col-1] == CellStates.Empty)
		{
			return true;
		}
		return false;
	}
	public GameState gameStatus()
	{
		//returns the current status of the game, needs to continue, win or draw
		if(!diagWin().equals(""))//if any form of win return win
		{
			return GameState.Win;
		}
		else if(!rowWin().equals(""))
		{
			return GameState.Win;
		}
		else if(!colWin().equals(""))
		{
			return GameState.Win;
		}
		else if(boardFull())//if a draw return draw
		{
			return GameState.Draw;
		}
		else//if still needs to continue then continue
		{
			return GameState.Continue;
		}
	}
	
	public boolean boardFull()
	{
		//returns if the board is full
		//helper method for game state
		for(CellStates[] stateRow:board)
		{
			for(CellStates state:stateRow)
			{
				if(state == CellStates.Empty)
				{
					return false;
				}
			}
		}
		return true;
	}
	public String diagWin()
	{
		//determines if there are any diagonal wins on the board
		//returns if there is a win and the winner
		if(board[0][0] == CellStates.X&&board[1][1] == CellStates.X&&board[2][2] == CellStates.X)//checks one diagonal for x win
		{
			return"x";
		}
		if(board[0][2] == CellStates.X&&board[1][1] == CellStates.X&&board[2][0] == CellStates.X)//checks other diagonal for x win
		{
			return"x";//return this if x won
		}
		if(board[0][0] == CellStates.O&&board[1][1] == CellStates.O&&board[2][2] == CellStates.O)//checks one diagonal for o win
		{
			return"o";
		}
		if(board[0][2] == CellStates.O&&board[1][1] == CellStates.O&&board[2][0] == CellStates.O)//checks other diagonal for o win
		{
			return"o";//return this if o won
		}
		return "";//return this if no win
	}
	public String rowWin()
	{
		//determines if there are any horizontal wins on the board
		//returns if there is a win and the winner
		for(int row =0; row<board.length;row++)
		{
			boolean xWin = true;
			boolean oWin = true;
			for(int col =0; col<board[0].length;col++)
			{
				if(board[row][col] == CellStates.X)//if an x is encountered on that row then it must not be an o win
				{
					oWin = false;
				}
				else if(board[row][col] == CellStates.O)//if an o is encountered on that row then it must not be an x win
				{
					xWin = false;
				}
				else
				{
					xWin = false;
					oWin = false;
				}
			}
			if(xWin)
			{
				return"x";
			}
			else if(oWin)
			{
				return"o";
			}
		}
		return"";//return this if no win
	}
	public String colWin()
	{
		//determines if there are any vertical wins on the board
		//returns if there is a win and the winner
		for(int col =0; col<board[0].length;col++)
		{
			boolean xWin = true;
			boolean oWin = true;
			for(int row =0; row<board.length;row++)
			{
				if(board[row][col] == CellStates.X)//if an x is encountered on that column then it must not be an o win
				{
					oWin = false;
				}
				else if(board[row][col] == CellStates.O)//if an o is encountered on that column then it must not be an x win
				{
					xWin = false;
				}
				else
				{
					xWin = false;
					oWin = false;
				}
			}
			if(xWin)
			{
				return"x";
			}
			else if(oWin)
			{
				return"o";
			}
		}
		return""; //return this if no win
	}
	public void runTests()
	{
		//runs some tests to ensure that the methods are working properly
		int smallRow = (int)(Math.random()*6) - 5;//row that is below the limit
		int bigRow = (int)(Math.random()*5) +4;//row that is above the limit
		int smallCol = (int)(Math.random()*6) - 5;//column that is below the limit
		int bigCol = (int)(Math.random()*5) + 4;//column that is above the limit
		int tempx;//good column
		int tempy;//good row
		while(true)
		{
			tempx =(int)(Math.random()*3);//assigns a value to tempX and tempY that is available
			tempy =(int)(Math.random()*3);
			if(board[tempy][tempx] == CellStates.Empty)
			{
				break;
			}
		}
		System.out.println(playMove(smallRow,smallCol));//tests all the combinations of: to small, to big, taken and okay rows and columns
		System.out.println(playMove(bigRow,bigCol));
		System.out.println(playMove(takenRow+1,takenCol+1)+"    Not Empty");
		System.out.println(playMove(smallRow,bigCol));
		System.out.println(playMove(bigRow,smallCol));
		System.out.println(playMove(smallRow,tempx+1));
		System.out.println(playMove(bigRow,tempx+1));
		System.out.println(playMove(tempy+1,smallCol));
		System.out.println(playMove(tempy+1,bigCol));
		System.out.println(playMove(tempy+1,tempx+1));
		while(!(gameStatus() == GameState.Win || gameStatus() == GameState.Draw))//runs full game tests to verify the function of game status
		{
			while(true)
			{
				tempx =(int)(Math.random()*3);//finds random move to play
				tempy =(int)(Math.random()*3);
				if(board[tempy][tempx] == CellStates.Empty)
				{
					break;
				}
			}
			System.out.println(playMove(tempy+1,tempx+1));//plays move
			System.out.println(gameStatus());//checks game status for working properly
		}
	}
	
	public String playMove(int row, int col)
	{
		//plays the selected move
		//inputs the selected row and column of move
		//returns if the move was valid or not
		if(validMove(row,col))//determines if move was valid
		{
			switch(moveNum%2)//converts move number to what player should be placed down
			{
			case 0://if it is even then play X
				board[row-1][col-1] = CellStates.X;
				//System.out.println("PrintO");
				break;
			case 1://if it is odd play O
				board[row-1][col-1] = CellStates.O;
				//System.out.println("PrintX");
				break;
			}
			moveNum++;//increment move
			//System.out.println("Move Num: "+moveNum);
			System.out.println(printBoard());//prints board after every play
			return "row "+row+" column "+col+" is VALID";//returns it was valid
		}
		return "row "+row+" column "+col+" is INVALID";//returns move of invalid
	}
	public String printBoard()
	{
		//returns the current state of the board
		String returnString = "_________________________";
		for(CellStates[] stateRow:board)
		{
			returnString+="\n|       |       |       |\n";//neatly organizes it into large squares
			for(CellStates state:stateRow)
			{
				switch(state) {
				  case X:
					  returnString+="|   X   ";//converts the state of each row into and output
					  break;
				  case O:
					  returnString+="|   O   ";
					  break;
				  case Empty:
					  returnString+="|       ";
					  break;
				}
			}
			returnString+="|\n|       |       |       |\n_________________________";
		}
		return returnString;//returns the board
	}
}
