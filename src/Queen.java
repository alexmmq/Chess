public class Queen extends ChessPiece{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
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

        //Queen moves columns and diagonals, checking Bishop and Rook-like move
        for(int i = 1; i <=7; i++){
            //L C+i
            if((line==toLine) && (column+i==toColumn)){
                return true;
            }
            //L C-i
            if((line==toLine) && (column-i==toColumn)){
                return true;
            }

            //L-i C
            if((line-i==toLine) && (column==toColumn)){
                return true;
            }

            //L+i C
            if((line+i==toLine) && (column==toColumn)){
                return true;
            }

            //L+i C+i
            if((line+i == toLine)&&(column+i == toColumn)){
                return true;
                //L+i C-i
            }
            if((line+i == toLine)&&(column-i == toColumn)){
                return true;
                //L-i C+i
            }
            if ((line-i == toLine)&&(column+i == toColumn)) {
                return true;
                //L-i C-i
            }
            if ((line-i == toLine)&&(column-i == toColumn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
