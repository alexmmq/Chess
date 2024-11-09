public class Pawn extends ChessPiece{

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //TODO
        //1.eating of the pawn on the first long go
        //2.converting pawn into the different chessPiece


        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //check for valid moves of the pawn - it can go one cell forward
        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);
        boolean validMove = ((lineDiff > 0 && lineDiff < 3) && columnDiff == 0)
                            || (lineDiff == 1 && columnDiff == 1);


        //Pawn can move only forward
        //check for the first move whites - can move to 2 cells in case if we don't have any obstacles
        if(super.getColor().toString().equals("WHITE")
                && line == 1
                && toLine == 3
                && column == toColumn
                && isValidValues(line, column, line + 1, column)
                && isCellNull(chessBoard, line + 1, column)
                && isValidValues(line, column, line + 2, column)
                && isCellNull(chessBoard, line + 2, column)
                && validMove){
            return true;

        }
        //check for the first move blacks - can move to 2 cells
        if(super.getColor().toString().equals("BLACK")
                && line == 6
                && toLine == 4
                && column == toColumn
                && isValidValues(line, column, line - 1, column)
                && isCellNull(chessBoard, line - 1, column)
                && isValidValues(line, column, line - 2, column)
                && isCellNull(chessBoard, line - 2, column)
                && validMove){
            return true;

        }
        //check that the pawn can move only forward, case whites, one cell
        if(super.getColor().toString().equals("WHITE")
                && line < toLine
                && lineDiff == 1
                && columnDiff == 0
                && isValidValues(line, column, toLine, toColumn)
                && isCellNull(chessBoard, toLine, toColumn)
                && validMove){
            return true;

        }
        //check that the pawn can move only forward, case blacks, one cell
        if(super.getColor().toString().equals("BLACK")
                && line > toLine
                && lineDiff == 1
                && columnDiff == 0
                && isValidValues(line, column, toLine, toColumn)
                && isCellNull(chessBoard, toLine, toColumn)
                && validMove){
            return true;
        }

        //case eating of the white pawn column +1, -1
        if(super.getColor().toString().equals("WHITE")
                && line < toLine
                && column != toColumn
                && lineDiff == 1
                && columnDiff == 1
                && isValidValues(line, column, toLine, toColumn)
                && isCellOccupiedByEnemy(chessBoard, toLine, toColumn)
                && validMove){
            return true;
        }

        //case eating of the black pawn column +1, -1
        if(super.getColor().toString().equals("BLACK")
                && line > toLine
                && column != toColumn
                && lineDiff == 1
                && columnDiff == 1
                && isValidValues(line, column, toLine, toColumn)
                && isCellOccupiedByEnemy(chessBoard, toLine, toColumn)
                && validMove){
            return true;
        }

            return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
