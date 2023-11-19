package student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void move(int i) {
		if (this.row >= 0 && this.row < 8)
			setRow(this.row + 1);
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		if (this.row == q.row || (this.row == this.column && q.row == q.column))
			return true;
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
