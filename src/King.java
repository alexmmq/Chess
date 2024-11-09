public class King extends ChessPiece{
    public King(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //check for valid moves of the King- it can go one cell everywhere
        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);
        boolean validMove = (lineDiff == 0 && columnDiff == 1)
                || (lineDiff == 1 && columnDiff == 0)
                || (lineDiff == 1 && columnDiff == 1);


//        King moves one cell in any direction, we should check if the cell we move to :
//         - null;
//         - contains an enemy chesspiece;
//         - is not under attack;
        if(validMove
                && (isCellNull(chessBoard, toLine, toColumn)
                || isCellOccupiedByEnemy(chessBoard, toLine, toColumn))
                && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        //parses all the chessboard for enemy pieces that can go to the certain cell
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if (!chessBoard.board[i][j].getColor().equals(this.getColor())) {
                    //check for all other chess pieces
                    if(!chessBoard.board[i][j].getSymbol().equals("P")
                        && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)){
                        return true;
                        //check if it is the pawn, has exception in eating way
                    } else if(chessBoard.board[i][j].getSymbol().equals("P")
                        && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)
                        && Math.abs(column - j) == 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
