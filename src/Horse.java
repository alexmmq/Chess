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

        //check if the horse is out of the chessboard
        if(line < 0 || line >7) return false;
        if(column < 0 || column >7) return false;
        if(toLine < 0 || toLine >7) return false;
        if(toColumn < 0 || toColumn >7) return false;
        //check if initial position is the same as the toPosition
        if((line == toLine) && (column == toColumn)){
            return false;
        }
        //horse can move max to 8 cells when standing in the middle
        //case #1 offset Line +2 possible offset column -1 & 1
        if(((line+2)==toLine)
                && ((column+1)==toColumn)||((column-1)==toColumn)){
            return true;
        }
        //case #2 offset Line +1 possible offset column -2 & 2
        else if(((line+1)==toLine)
                && ((column+2)==toColumn)||((column-2)==toColumn)){
            return true;
        }
        //case #3 offset Line -1 possible offset column -2 & 2
        else if(((line-1)==toLine)
                && ((column+2)==toColumn)||((column-2)==toColumn)){
            return true;
        }
        //case #4 offset Line -2 possible offset column -1 & 1
        else if(((line-2)==toLine)
                && ((column+1)==toColumn)||((column-1)==toColumn)){
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
