package board_game;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		
		
		boolean isNumberOfRowsValid = rows > 1;
		boolean isNumberOfColumnsValid = columns > 1;
				
		
		if(!isNumberOfRowsValid || !isNumberOfColumnsValid) {
			throw new BoardException("Error creating Board. Rows and Columns must be higher then 0");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	private boolean positionExists(int row, int column) {
		boolean isRowValid = row >= 0 && row < this.rows;
		boolean isColumnValid = column >= 0 && column < this.columns;
	
		return isRowValid && isColumnValid;
	}
	public boolean positionExists(Position position) {
		int row = position.getRow();
		int column = position.getColumn();
		
		return positionExists(row, column);

	}
	
	public boolean thereIsAPiece(Position position) {

		if(!positionExists(position)) {
			
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null;
	}
	
}
