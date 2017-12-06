
public class Board {
	
	/**
	 * @param grid the board itself as a 2-D array of int. 
	 * @param over whether the game is over. 
	 * @param clear the number of lines cleared so far. 
	 */
	int width = 10;
	int height = 20;
	int[][] grid = new int[width][height];
	boolean over = false;
	int clear = 0;
	
	/**
	 * This function is called during insertion if the inserted block ends the game. 
	 */
	public static void GameOver(Board board) {
		board.over = true;
		System.out.println("Game over! " + board.clear + " lines cleared!");
	}

	/**
	 * This function is called after a block is inserted each time. 
	 * It clears the lines that are full and moves down the lines above. 
	 */
	public static void clearLines(Board board) {
		for (int i = 0; i < board.height; i++) {
			for (int j = 0; j < board.width; j++) {
				if (board.grid[j][i] == 0) {
					break;
				}
				if (j == board.width - 1) {
					for (int a = i; a < board.height; a++) {
						for (int b = 0; b < board.width; b++) {
							if (a == board.height - 1) {
								board.grid[b][a] = 0;
							} else {
								board.grid[b][a] = board.grid[b][a + 1];
							}
						}
					}
					board.clear++;
				}
			}
		}
	}
	
	public static int[] getHeight(Board board) {
		int[] heights = new int[board.width];
		for (int i = 0; i < board.width; i++) {
			for (int j = 0; j < board.height; j++) {
				if (board.grid[i][j] == 1) {
					heights[i] = j + 1;
				}
			}
		}
		return heights;
	}
	
}
