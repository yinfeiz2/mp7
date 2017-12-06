
public class Tetris {

	public static void main(String[] args) {
		Board board = new Board();
		while (board.over == false) {
			int shape = (int) (Math.random() * 3);
			if (shape == 0) {
				Shape.I i = new Shape.I();
				int[] result = i.detect(board);
				i.insert(result[0], board, result[1], result[2]);
			} else if (shape == 1) {
				Shape.J j = new Shape.J();
				int[] result =j.detect(board);
				j.insert(result[0], board, result[1], result[2]);
			} else if (shape == 2) {
				Shape.O o = new Shape.O();
				int[] result =o.detect(board);
				o.insert(board, result[0], result[1]);
			}
		}
	}

}
