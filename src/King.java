public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //check if the queen is out of the chessboard
        if(line < 0 || line >7) return false;
        if(column < 0 || column >7) return false;
        if(toLine < 0 || toLine >7) return false;
        if(toColumn < 0 || toColumn >7) return false;

        //check if initial position is the same as the toPosition
        if((line == toLine) && (column == toColumn)){
            return false;
        }

        //King moves one cell in any direction
        // L+1
        if((line+1 == toLine)&&(column+1 == toColumn)){
            return true;
        }
        if((line+1 == toLine)&&(column == toColumn)){
            return true;
        }
        if((line+1 == toLine)&&(column-1 == toColumn)){
            return true;
        }
        // L
        if((line == toLine)&&(column+1 == toColumn)){
            return true;
        }
        if((line==toLine)&&(column-1==toColumn)){
            return true;
        }
        // L-1
        if((line-1==toLine)&&(column+1==toColumn)){
            return true;
        }
        if((line-1==toLine)&&(column==toColumn)){
            return true;
        }
        if((line-1==toLine)&&(column-1==toColumn)){
            return true;
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        return chessBoard.board[line][column] != null;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
