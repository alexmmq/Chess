public class Bishop extends ChessPiece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //defining some repetitive booleans
        // 1. checking if the next cell is empty
        // 2. checking if there is another color chess piece on the way
        boolean isCellNullOrOccupiedByEnemy = (chessBoard.board[toLine][toColumn] == null)
                || (chessBoard.board[toLine][toColumn].color != this.getColor());

        //Bishop moves in the diagonal
        for(int i = 1; i <= 7; i++){
            // L+i C+i, defining where it can move

            if((line + i == toLine) && (column + i == toColumn)
                && isCellNullOrOccupiedByEnemy){
                return true;
                //L+i C-i
            }
            if((line + i == toLine) && (column - i == toColumn)
                && isCellNullOrOccupiedByEnemy){
                return true;
                //L-i C+i
            }
            if ((line - i == toLine) && (column + i == toColumn)
                && isCellNullOrOccupiedByEnemy) {
                return true;
                //L-i C-i
            }
            if ((line - i == toLine) && (column - i == toColumn)
                && isCellNullOrOccupiedByEnemy) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
