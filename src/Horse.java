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

        //check for valid moves of the horse - it can go one cell forward
        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);
        boolean validMove = ((lineDiff == 2) && (columnDiff == 1))
                || (lineDiff == 1 && columnDiff == 2);

        //horse can move max to 8 cells when standing in the middle - can move through the figures

        if(isValidValues(line, column, toLine, toColumn)
                && (isCellNull(chessBoard, toLine, toColumn)
                || isCellOccupiedByEnemy(chessBoard, toLine, toColumn))){
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
