
public class Tetris {

	public static void main(String[] args) {
		int count = 0;
		Board board = new Board();
		while (board.over == false) {
			int shape = (int) (Math.random() * 7);
			count++;
			if (shape == 0) {
				Shape.I i = new Shape.I();
				int[] result = i.detect(board);
				i.insert(result[0], board, result[1], result[2]);
			} else if (shape == 1) {
				Shape.J j = new Shape.J();
				int[] result = j.detect(board);
				j.insert(result[0], board, result[1], result[2]);
			} else if (shape == 2) {
				Shape.L l = new Shape.L();
				int[] result = l.detect(board);
				l.insert(result[0], board, result[1], result[2]);
			} else if (shape == 3) {
				Shape.O o = new Shape.O();
				int[] result = o.detect(board);
				o.insert(board, result[0], result[1]);
			} else if (shape == 4) {
				Shape.T t = new Shape.T();
				int[] result = t.detect(board);
				t.insert(result[0], board, result[1], result[2]);
			} else if (shape == 5) {
				Shape.Z z = new Shape.Z();
				int[] result = z.detect(board);
				z.insert(result[0], board, result[1], result[2]);
			} else if (shape == 6) {
				Shape.S s = new Shape.S();
				int[] result = s.detect(board);
				s.insert(result[0], board, result[1], result[2]);
			}
		}
		System.out.println(count + " blocks dropped!");
	}

}
