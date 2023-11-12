package chess;

import board_game.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	

	public ChessPosition(char column, int row) {
		
		boolean isColumnValid = column >= 'a' && column <= 'h';
		boolean isRowValid = row >= 1 && row <= 8;
		
		if(!isColumnValid || !isRowValid) {
			throw new ChessException(
				"Error instantiating ChessPosition. Column must be between a or h and row between 1 or 8"
				);
		}
		this.column = column;
		this.row = row;
	}


	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPositon(Position position) {
		char columnAsChar = (char) ('a' - position.getColumn());
		int row = position.getRow();
		
		return new ChessPosition(columnAsChar, row );
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
