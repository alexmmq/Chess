public class Horse extends ChessPiece{
    public Horse(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //horse can move max to 8 cells when standing in the middle - moving through the figures
        //case #1 offset Line +2 possible offset column -1 & 1
        if(isValidValues(line, column, line + 2, column - 1)
                && (isCellNull(chessBoard, line + 2, column - 1)
                || isCellOccupiedByEnemy(chessBoard, line + 2, column - 1))){
            return true;
        }
        if(isValidValues(line, column, line + 2, column + 1)
                && (isCellNull(chessBoard, line + 2, column + 1)
                || isCellOccupiedByEnemy(chessBoard, line + 2, column + 1))){
            return true;
        }
        //case #2 offset Line +1 possible offset column -2 & 2
        if(isValidValues(line, column, line + 1, column - 2)
                && (isCellNull(chessBoard, line + 1, column - 2)
                || isCellOccupiedByEnemy(chessBoard, line + 1, column - 2))){
            return true;
        }
        if(isValidValues(line, column, line + 1, column + 2)
                && (isCellNull(chessBoard, line + 1, column + 2)
                || isCellOccupiedByEnemy(chessBoard, line + 1, column + 2))){
            return true;
        }

        //case #3 offset Line -1 possible offset column -2 & 2
        if(isValidValues(line, column, line - 1, column - 2)
                && (isCellNull(chessBoard, line - 1, column - 2)
                || isCellOccupiedByEnemy(chessBoard, line - 1, column - 2))){
            return true;
        }
        if(isValidValues(line, column, line - 1, column + 2)
                && (isCellNull(chessBoard, line - 1, column + 2)
                || isCellOccupiedByEnemy(chessBoard, line - 1, column + 2))){
            return true;
        }
        //case #4 offset Line -2 possible offset column -1 & 1
        if(isValidValues(line, column, line - 2, column - 1)
                && (isCellNull(chessBoard, line - 2, column - 1)
                || isCellOccupiedByEnemy(chessBoard, line - 2, column - 1))){
            return true;
        }
        if(isValidValues(line, column, line - 2, column + 1)
                && (isCellNull(chessBoard, line - 2, column + 1)
                || isCellOccupiedByEnemy(chessBoard, line - 2, column + 1))){
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
