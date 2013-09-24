package backtracking;

public class MazeSolve {
	
	int[][] solution;
	int[] xMove = {1, -1, 0, 0};
	int[] yMove = {0, 0, 1, -1};
	int noOfSolution;
	
	public MazeSolve(int[][] maze){
		solution = new int[maze.length][maze[0].length];
	}
	
	public boolean isSafe(int[][] maze, int x, int y){
		
		if(x>=0 && x<solution.length && y>=0 && y< solution[0].length && maze[x][y]==1 && solution[x][y]!=1)
			return true;
		else 
			return false;
		
	}
	
	public void printMaze(int[][] maze){
		
		for(int i=0; i< maze.length-1; i++){
			for(int j=0; j<maze[0].length; j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	
	public boolean solve(int[][] maze, int row, int col){
		
		int nextX, nextY;
		
		if(row==0 && col==0){
			solution[row][col] = 1;
		}
		
		for(int i=0; i<4; i++){
			nextX = row + xMove[i];
			nextY = col + yMove[i];
			
			if(isSafe(maze, nextX, nextY)){
				solution[nextX][nextY] = 1;
				
				if(nextX==maze.length-1 && nextY==maze[0].length-1){
					printMaze(solution);
					noOfSolution++;
				}
				
				
				if(solve(maze, nextX, nextY)){
					return true;
				}
				else{
					solution[nextX][nextY] = 0;	// backtrack
				}
				
			}
			
		}
		
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] maze = {{1,1,1,1,1,1,1},
						{0,0,1,1,1,0,0},
						{0,0,1,0,1,1,1},
						{1,1,1,0,0,0,1},
						{0,0,1,1,1,1,1},
						{0,0,0,0,1,0,1}};
		
		
		MazeSolve ref = new MazeSolve(maze);
		ref.solve(maze, 0, 0);
		System.out.println(ref.noOfSolution+" solutions");
		
	}

}
