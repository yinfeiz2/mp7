

public class Shape {
	
	int x = 0;
	int y = 0;
	int type = 0;
	
	public static class I extends Shape {
		public void insert(int type, Board board, int x, int y) {
			if (y >= board.height) {
				Board.GameOver(board);
				return;
			}
			if (type == 0) {
				for (int i = y; i <= y + 3; i++) {
					if (i >= board.height) {
						Board.GameOver(board);
						return;
					} else {
						board.grid[x][i] = 1;
					}
				}
			} else {
				for (int i = x; i <= x + 3; i++) {
					board.grid[i][y] = 1;
				}
			}
			Board.clearLines(board);
		}
		
		public int[] detect(Board board) {
			int[] heights = Board.getHeight(board);
			int[] scores = new int[board.width];
			for (int i = 0; i < heights.length; i++) {
				if (i == 0) {
					scores[i] = (heights[i + 1] - heights[i]) * 2;
				}  else if (i == board.width -1) {
					scores[i] = (heights[i - 1] - heights[i]) * 2;
				} else {
					scores[i] = heights[i - 1] + heights[i + 1] - heights[i] * 2;
				}
			}
			int x = 0;
			int max = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] > max) {
					max = scores[i];
					x = i;
				}
			}
			if (max > 2 && heights[x] <= 6) {
				return new int[] {0, x, heights[x]};
			}
			scores = new int[7];
			for (int i = 0; i < heights.length - 3; i++) {
				if (heights[i] == heights[i + 1] && heights[i + 1] == heights[i + 2]
						&& heights[i + 2] == heights[i + 3] && heights[i] != 10) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			int min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {1, x, heights[x]};
			}
			for (int i = 0; i < heights.length - 3; i++) {
				if ((heights[i] == heights[i + 1] && heights[i + 1] == heights[i + 2]
						&& heights[i] == heights[i + 3] + 1) || (heights[i] == heights[i + 1]
						&& heights[i + 1] == heights[i + 3] && heights[i + 2] + 1 == heights[i])
						|| (heights[i] == heights[i + 2] && heights[i + 2] == heights[i + 3] 
						&& heights[i + 1] + 1 == heights[i]) || (heights[i + 1] == heights[i + 2] 
						&& heights[i + 2] == heights[i + 3] && heights[i] + 1 == heights[i + 1])) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {1, x, heights[x]};
			}
			x = 0;
			min = heights[0];
			for (int i = 1; i < heights.length; i++) {
				if (heights[i] < min) {
					min = heights[i];
					x = i;
				}
			}
			return new int[] {0, x, heights[x]};
		}
	}
	
	public static class J extends Shape {
		public void insert(int type, Board board, int x, int y) {
			if (y >= board.height) {
				Board.GameOver(board);
				return;
			}
			if (type == 0) {
				board.grid[x][y] = 1;
				for (int i = y; i <= y + 2; i++) {
					if (i >= board.height) {
						Board.GameOver(board);
						return;
					} else {
						board.grid[x + 1][i] = 1;
					}
				}
			} else if (type == 1) {
				for (int i = x; i <= x + 2; i++) {
					board.grid[i][y] = 1;
				}
				if (y + 1 >= board.height) {
					Board.GameOver(board);
					return;
				} else {
					board.grid[x][y + 1] = 1;
				}
			} else if (type == 2) {
				for (int i = y; i <= y + 2; i++) {
					if (i >= board.height) {
						Board.GameOver(board);
						return;
					} else {
						board.grid[x][i] = 1;
					}
				}
				board.grid[x + 1][y + 2] = 1;
			} else {
				board.grid[x + 2][y - 1] = 1;
				if (y + 1 >= board.height) {
					Board.GameOver(board);
					return;
				} else {
					for (int i = x; i <= x + 2; i++) {
						board.grid[i][y] = 1;
					}
				}
			}
			Board.clearLines(board);
		}
		
		public int[] detect(Board board) {
			int[] heights = Board.getHeight(board);
			int[] scores = new int[board.width - 1];
			for (int i = 0; i < scores.length; i++) {
				if (heights[i + 1] == heights[i] + 2) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			int x = 0;
			int min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 7) {
				return new int[] {2, x, heights[x]};
			}
			scores = new int[8];
			for (int i = 0; i < scores.length; i++) {
				if (heights[i] == heights[i + 1] && heights[i] == heights[i + 2] + 1) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {3, x, heights[x]};
			}
			for (int i = 0; i < heights.length - 2; i++) {
				if (heights[i] == heights[i + 1] && heights[i + 1] == heights[i + 2]) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {1, x, heights[x]};
			}
			scores = new int[8];
			for (int i = 0; i < scores.length; i++) {
				if ((heights[i] == heights[i + 1] + 1 && heights[i] == heights[i + 2] + 1)
						|| (heights[i + 1] == heights[i] + 1 && heights[i + 1] == heights[i + 2] + 1)) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {3, x, heights[x]};
			}
			scores = new int[9];
			for (int i = 0; i < heights.length - 1; i++) {
				if (heights[i] == heights[i + 1]) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {0, x, heights[x]};
			}
			scores = new int [8];
			for (int i = 0; i < heights.length - 2; i++) {
				if ((heights[i] == heights[i + 1] && heights[i] == heights[i + 2] + 1) 
						|| (heights[i] == heights[i + 1] + 1 && heights[i] == heights[i + 2])
						|| (heights[i + 1] == heights[i] + 1 && heights[i + 1] == heights[i + 2])) {
					scores[i] = heights[i];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			if (heights[x] <= 9) {
				return new int[] {1, x, heights[x]};
			}
			for (int i = 0; i <= 7; i++) {
				if (heights[i] > heights[i + 1] && heights[i] > heights[i + 2]) {
					scores[i] = heights[i];
				} else if (heights[i + 1] > heights[i] && heights[i + 1] > heights[i + 2]) {
					scores[i] = heights[i + 1];
				} else if (heights[i + 2] > heights[i] && heights[i + 2] > heights[i + 1]) {
					scores[i] = heights[i + 2];
				} else {
					scores[i] = 10;
				}
			}
			x = 0;
			min = scores[0];
			for (int i = 1; i < scores.length; i++) {
				if (scores[i] < min) {
					min = scores[i];
					x = i;
				}
			}
			return new int[] {1, x, heights[x]};
		}
	}
	
	public static class L extends Shape {
		public void insert(int type, Board board, int x, int y) {
			if (y >= board.height) {
				Board.GameOver(board);
				return;
			}
			if (type == 0) {
				board.grid[x + 1][y] = 1;
				for (int i = y; i <= y + 2; i++) {
					if (i >= board.height) {
						Board.GameOver(board);
						return;
					} else {
						board.grid[x][i] = 1;
					}
				}
			} else if (type == 1) {
				board.grid[x][y] = 1;
				if (y + 1 >= board.height) {
					Board.GameOver(board);
					return;
				} else {
					for (int i = x; i <= x + 2; i++) {
						board.grid[i][y + 1] = 1;
					}
				}
			} else if (type == 2) {
				for (int i = y; i <= y + 2; i++) {
					if (i >= board.height) {
						Board.GameOver(board);
						return;
					} else {
						board.grid[x][i] = 1;
					}
				}
				board.grid[x - 1][y + 2] = 1;
			} else if (type == 3) {
				for (int i = x; i <= x + 2; i++) {
					board.grid[i][y] = 1;
				}
				if (y + 1 >= board.height) {
					Board.GameOver(board);
					return;
				} else {
					board.grid[x + 2][y + 1] = 1;
				}
			}
			Board.clearLines(board);
		}
	}
	
	public static class O extends Shape {
		public void insert(Board board, int x, int y) {
			if (y >= board.height) {
				Board.GameOver(board);
				return;
			}
			board.grid[x][y] = 1;
			board.grid[x + 1][y] = 1;
			if (y + 1 >= board.height) {
				Board.GameOver(board);
				return;
			} else {
				board.grid[x][y + 1] = 1;
				board.grid[x + 1][y + 1] = 1;
			}
			Board.clearLines(board);
		}
	}
	
	public int[] detect(Board board) {
		int[] heights = Board.getHeight(board);
		int[] scores = new int[board.width - 1];
		for (int i = 0; i <= 8; i++) {
			if (heights[i] == heights[i + 1]) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		int x = 0;
		int min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 8) {
			return new int[] {x, heights[x]};
		}
		for (int i = 0; i <= 8; i++) {
			if (heights[i] == heights[i + 1] + 1) {
				scores[i] = heights[i];
			} else if (heights[i] + 1 == heights[i + 1]) {
				scores[i] = heights[i + 1];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 8) {
			return new int[] {x, heights[x]};
		}
		scores = new int[board.width];
		for (int i = 1; i < scores.length; i++) {
			scores[i] = 10;
		}
		for (int i = 0; i <= 9; i++) {
			if (i == 0) {
				if (heights[i] > heights[i + 1]) {
					scores[i] = heights[i];
				}
			} else if (i == 9) {
				if (heights[i] > heights[i - 1]) {
					scores[i] = heights[i];
				}
			} else {
				if (heights[i] > heights[i + 1] || heights[i] > heights[i - 1]) {
					scores[i] = heights[i];
				}
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		return new int[] {x, heights[x]};
	}

public static class T extends Shape {
	
	
	public void insert(int type, Board board, int x, int y) {
		
		if (type == 0) {
			if (y >= board.height) {
				Board.GameOver(board);
				return;
			}
		} else {
			if (y + 1>= board.height) {
				Board.GameOver(board);
				return;
			}
		}
		
		
		
		board.grid[x][y] = 1;     //[x][y]is the center
		if (type == 0) {
			board.grid[x - 1][y] = 1;
			board.grid[x + 1][y] = 1;
			board.grid[x][y - 1] = 1;
		}
		if (type == 1) {
			board.grid[x - 1][y] = 1;
			board.grid[x + 1][y] = 1;
			board.grid[x][y + 1] = 1;
		}
		if (type == 2) {
			board.grid[x][y + 1] = 1;
			board.grid[x][y - 1] = 1;
			board.grid[x - 1][y] = 1;
		}
		if (type == 3) {
			board.grid[x][y + 1] = 1;
			board.grid[x][y - 1] = 1;
			board.grid[x + 1][y] = 1;
		}
		Board.clearLines(board);
		
	}
	public int[] detect(Board board) {
		int[] heights = Board.getHeight(board);
		int[] scores = new int[board.width - 1];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i + 1] == heights[i] + 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		int x = 0;
		int min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 7) {
			return new int[] {3, x, heights[x] + 1};
		}
		
	
		heights = Board.getHeight(board);
		scores = new int[board.width - 1];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i + 1] == heights[i] - 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 7) {
			return new int[] {2, x + 1, heights[x + 1] + 1};
		}
		
		scores = new int[8];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i] == heights[i + 2] && heights[i] == heights[i + 1] + 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 9) {
			return new int[] {0, x + 1, heights[x + 1] + 1};
		}
		
		
		scores = new int[8];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i] == heights[i + 2] && heights[i] == heights[i + 1]) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 6) {
			return new int[] {1, x + 1, heights[x + 1]};
		}
		return new int[] {2, 10, heights[10] + 1};
	}
}

public static class Z extends Shape {
	
	
	public void insert(int type, Board board, int x, int y) {
		
		if (y + 1>= board.height) {
			Board.GameOver(board);
			return;
		}
	
		board.grid[x][y] = 1;        //[x][y]is the center
		if (type == 0) {
			board.grid[x + 1][y] = 1;
			board.grid[x][y + 1] = 1;
			board.grid[x - 1][y + 1] = 1;
		}
		if (type == 1) {
			board.grid[x][y - 1] = 1;
			board.grid[x + 1][y] = 1;
			board.grid[x + 1][y + 1] = 1;
		}
		Board.clearLines(board);
		
	}


	public int[] detect(Board board) {
		int[] heights = Board.getHeight(board);
		int[] scores = new int[board.width - 1];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i + 1] == heights[i] + 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		int x = 0;
		int min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 7) {
			return new int[] {1, x, heights[x] + 1};
		}
		
		scores = new int[8];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i + 2] == heights[i + 1] && heights[i + 1] == heights[i] - 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 9) {
			return new int[] {0, x + 1, heights[x + 1]};
		}
		return new int[] {1, 9, heights[9] + 1};
	}
}

public static class S extends Shape {
	
	
public void insert(int type, Board board, int x, int y) {
		
		if (y + 1>= board.height) {
			Board.GameOver(board);
			return;
		}
	
		board.grid[x][y] = 1;        //[x][y]is the center
		if (type == 0) {
			board.grid[x - 1][y] = 1;
			board.grid[x][y + 1] = 1;
			board.grid[x + 1][y + 1] = 1;
		}
		if (type == 1) {
			board.grid[x][y - 1] = 1;
			board.grid[x - 1][y] = 1;
			board.grid[x - 1][y + 1] = 1;
		}
		Board.clearLines(board);
		
	}

	public int[] detect(Board board) {
		int[] heights = Board.getHeight(board);
		int[] scores = new int[board.width - 1];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i + 1] + 1 == heights[i]) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		int x = 0;
		int min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 7) {
			return new int[] {1, x + 1, heights[x + 1] + 1};
		}
		
		scores = new int[8];
		for (int i = 0; i < scores.length; i++) {
			if (heights[i] == heights[i + 1] && heights[i] == heights[i + 2] - 1) {
				scores[i] = heights[i];
			} else {
				scores[i] = 10;
			}
		}
		x = 0;
		min = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				x = i;
			}
		}
		if (heights[x] <= 9) {
			return new int[] {0, x + 1, heights[x + 1]};
		}
		return new int[] {1, 1, heights[1] + 1};
	}
}
}
