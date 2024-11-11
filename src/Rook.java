public class Rook extends ChessPiece{

    public Rook(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!isValidValues(line, column, toLine, toColumn)) return false;



        //defining if it is legal move for the rook, one of the diffs should be equal to 0
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;

        boolean validMoves = (((lineDiff == 0) && (Math.abs(columnDiff)>0))
            ||((columnDiff == 0) && (Math.abs(lineDiff)>0)));

        //parsing through possible cells on the way

        if(validMoves && (Math.abs(columnDiff) > 0)){
            // case 1 - lineDiff == 0 columnDiff positive
            for(int i = column; i < toColumn; i++){
                if (isValidValues(line, column, line, i)
                        && !isCellNull(chessBoard, line, i)){
                    return false;
                }
            }
            // case 2 - lineDiff == 0 columnDiff negative
            for(int i = column; i > toColumn; i--){
                if (isValidValues(line, column, line, i)
                    && !isCellNull(chessBoard, line, i)){
                    return false;
                }
            }
        } else if (validMoves && (Math.abs(lineDiff) > 0)){
            //case 3 - colDiff == 0 lineDiff positive
            for(int i = line; i < toLine; i++){
                if (isValidValues(line, column, i, column)
                    && !isCellNull(chessBoard, i, column)){
                    return false;
                }
            }

            //case 4 - colDiff == 0 lineDiff negative
            for(int i = line; i > toLine; i--){
                if (isValidValues(line, column, i, column)
                && !isCellNull(chessBoard, i, column)){
                    return false;
                }
            }
        }


        // positive outcome
        return validMoves
                && (isCellNull(chessBoard, toLine, toColumn)
                || isCellOccupiedByEnemy(chessBoard, toLine, toColumn));
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
