package backtracking;

public class NQueenProblem {

	int[] board;
	int noOfSoln;
	
	public NQueenProblem(int boardSize){
		this.board = new int[boardSize];
	}
	
	
	public boolean isSafe(int row, int col){
		
		for(int i=0; i<row; i++){
			if(col == board[i] || Math.abs(i-row) == Math.abs(board[i]-col))
				return false;
		}
		return true;
	}
	
	
	
	public void printBoard(int[] board){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				if(j==board[i])
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public boolean solve(int row, int col){		
		
		for(int i=0; i<col; i++){			
			
			if(isSafe(row, i)){
				board[row] = i;
				
				if(row==col-1){
					printBoard(board);
					noOfSoln++;
				}
				
				if(solve(row+1, col)){
					return true;
				}
				else{
					board[row] = -1;	// backtrack
				}
			}		
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		int boardSize = 8;
		NQueenProblem ref = new NQueenProblem(boardSize);
		ref.solve(0, boardSize);
		System.out.println(ref.noOfSoln+" solutions");
	}
	
}
