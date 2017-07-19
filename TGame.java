package TicTacToe;
import java.util.Arrays;
import java.util.Scanner;
public class TGame {
	
	private boolean gameOver = false;
	private char currentPlayer = 'X';
	private char[][] gameBoard = new char[5][5];
	
	
	public void play(){
		this.initBoard();
		this.printOutBoard();
		
		int x = -1;
		int y = -1;
		String input = null;
		while(!gameOver){
			boolean goodInput = false;;
			do {
				Scanner reader = new Scanner(System.in);
				System.out.print("Enter (x, y) for player " + currentPlayer+":" );
				input = reader.next();
				
				if(!input.isEmpty()) {
					String[] splits = input.split("[,. ]");
					if (splits.length == 2){
						try {
							x = Integer.parseInt(splits[0]);
							y = Integer.parseInt(splits[1]);
						goodInput = true;
						} catch (Exception e) {
							goodInput = false;
						}
					}
				}
			} while(!goodInput);

			//int x=reader.nextInt();
			//System.out.print("Enter a y for player " + currentPlayer+":" );
			//int y=reader.nextInt();
			
			boolean success = this.insertPlayerIntoBoard(x,y);
			if(success){
				this.printOutBoard();
				int option = this.calculateWinner();
				switch (option) {
				case 1:
						System.out.println("Winner is " + this.currentPlayer);
						gameOver = true;
						break;
				case 2: 
						System.out.println("Game is draw, play again");
						gameOver = true;
						break;
				case 0:
						this.switchPlayer();
						this.gameOver = false;
						break;
				default:
				}
			} else {
				System.out.println("position is not valid");
			}
			
			
			
		}
		
		System.out.println("quit");
	}
	
	private void printOutBoard(){
		for(int i=0; i < this.gameBoard.length; i++){
			
			for(int j=0; j < this.gameBoard[i].length; j++){
				System.out.print("[" + this.gameBoard[i][j] + "] "); 
			}
			System.out.println("");
		}
		
	}
	
	private void switchPlayer(){
		   if( this.currentPlayer == 'X' ){
			   this.currentPlayer = 'O';
		   }else{
			   this.currentPlayer = 'X';
		   }
	}
	
	private void initBoard(){
		for(int i=0; i < this.gameBoard.length; i++){
			for(int j=0; j < this.gameBoard[i].length; j++){
				this.gameBoard[i][j] = ' ';
			}
		}
	}
	
	private boolean insertPlayerIntoBoard(int x, int y){ 
		x--;
		y--;
		if(x >= 0 && x < this.gameBoard.length && y >=0 && y < this.gameBoard[x].length){
			if(this.gameBoard[x][y] == ' '){
				this.gameBoard[x][y]=this.currentPlayer;
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 */
	private int calculateWinner(){
		
		//checking for winner on horizontal 
		for(int row=0; row<this.gameBoard.length; row++ ){
			boolean isWinner = true;
			for(int col=0; col<this.gameBoard[row].length; col++){
				if (this.gameBoard[row][col] != this.currentPlayer) {
					isWinner = false;
					break;
				}
			}
			if (isWinner == true){
				return 1;
			}
		}
		
		//check for winner on vertical
		for (int i=0; i < this.gameBoard.length; i++){
			boolean isWinner = true;
			for(int row=0; row < this.gameBoard.length; row++){
				if(this.gameBoard[row][i] != this.currentPlayer) {
					isWinner = false;
					break;
				}
			}
			if(isWinner == true) {
				return 1;
			}
		}
				
		// check for winner on diagonal
		  
		boolean isWinner = true;
		for(int i = 0; i < this.gameBoard.length; i++)
		{
			if(this.gameBoard[i][i]!=this.currentPlayer)
			{
				isWinner = false;
				break;
			}
	
		}
		if (isWinner)
		{
			return 1;
		}
		
		//check the winner from forward diagonal 
	    isWinner = true;
		for(int i = 0; i < this.gameBoard.length; i++)
		{
			if(this.gameBoard[i][this.gameBoard.length-i-1]!=this.currentPlayer)
			{
				isWinner = false;
				break;
			}
	
		}
		if (isWinner)
		{
			return 1;
		}
		
		
		
		// check for game draw
		 boolean boardisdraw= true;
		 char EMPATY = ' ';
		 for(int row=0; row<this.gameBoard.length; row++){
			 for(int col=0; col<this.gameBoard[row].length;col++){
				  if( this.gameBoard[row][col]==EMPATY){
                	boardisdraw = false;
                	break;
                  }
			 }
			
		 }
		 if (boardisdraw == true){ 
             return 2;
		 }
		 return 0;  
	}
	
	 
		//return currentPlayer;
	
public static void main(String[] args){
	
	TGame game = new TGame();
	game.play();
	//game.switchPlayer();
	
	}






public static char  PlayerExchange(char player) {
	/*  
	   if (player == 'X')		   
	   player = 'O';
	   if (player == 'O')
	   player = 'X';*/
	   
	   if( player == 'X' ){
		   player = 'O';
	   }else{
		   player = 'X';
	   }
	  
	   return player;
   }


private static void initalboard(char[][] arraylist) {
	// TODO Auto-generated method stub
	 for( int row =0; row<arraylist.length; row++){
		  System.out.println();
		  for(int col=0; col<arraylist[row].length; col++)
		     
			  System.out.print("\t"+"-");
		  }	  
		  System.out.println();
}

private static void placetheboard(int x, int y, char[][] arraylist,char player) {
		// TODO Auto-generated method stub
	               if (arraylist[x][y]=='-') 
	        
    	            arraylist[x][y]=player;
	         for( int row =0; row<arraylist.length; row++){
		         System.out.println();
		       for(int col=0; col<arraylist[row].length; col++){
		    	  
			         
			   
				  System.out.print( "\t"+arraylist[row][col]);
		        
		      }   
	         }
	         System.out.println();

    
	
}
}
        
   

    





