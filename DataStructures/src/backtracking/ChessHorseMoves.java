package backtracking;

public class ChessHorseMoves {
	
	int[][] solution;
	int[] xMoves = {2,1,-2,-1,2,1,-2,-1};
	int[] yMoves = {1,2,1,2,-1,-2,-1,-2};
	int count;
	
	
	
	public ChessHorseMoves(int N){
		solution = new int[N][N];
		
		for(int i=0; i< solution.length; i++){
			for(int j=0; j<solution[0].length; j++){
				solution[i][j] = -1;
			}
		}
		
		solution[0][0] = 0;
	}
	
	public boolean isSafe(int[][] solution, int x, int y){
		
		if(x>=0 && x< solution.length && y>=0 && y<solution[0].length && solution[x][y]==-1){
			return true;
		}
		return false;
	}
	
	
	public void printBoard(int[][] board){
		for(int[] i: board){
			for(int j : i){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
			
	}
	
	
	public boolean solve(int row, int col, int iterCount){
		
		int nextX, nextY;
		
		if(iterCount>=solution.length*solution.length){
			printBoard(solution);
			System.out.println("soln done");
			return true;
		}
		
		
		for(int i=0; i<8; i++){
			
			nextX = row + xMoves[i];
			nextY = col + yMoves[i];
			
			if(isSafe(solution, nextX, nextY)){
				solution[nextX][nextY] = iterCount;
				
				if(solve(nextX, nextY, iterCount++)){
					System.out.print("valid..");
					return true;
					
				}
				else{
					solution[nextX][nextY] = -1;	// backtrack
					System.out.println(".");
				}			
			}		
		}		
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		ChessHorseMoves ref = new ChessHorseMoves(8);
		ref.solve(0, 0, 1);
	}
	
	

}
