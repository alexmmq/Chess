public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //TODO
        //1.eating of the pawn on the first long go
        //2.converting pawn into the different chessPiece

        //checks the possible moves of pawn within columns
        boolean columnCheck = (column == toColumn) || (column-1 == toColumn) || (column+1 == toColumn);

        //check if the pawn is not out of the chessboard
        if(line < 0 || line >7) return false;
        if(column < 0 || column >7) return false;
        if(toLine < 0 || toLine >7) return false;
        if(toColumn < 0 || toColumn >7) return false;

        //check if initial position is the same as the toPosition
        if((line == toLine) && (column == toColumn)){
            return false;
        }

        //Pawn can move only forward
        //check for the first move whites - can move to 2 cells
        if(color.equals("white") && line==1){
            return (toLine == 3) && (column == toColumn);
            //check for the first move blacks - can move to 2 cells
        }
        else if(color.equals("black") && line==6){
            return (toLine == 4) && (column == toColumn);
            //check that the pawn can move only forward, case whites
        }
        else if(color.equals("white") && line<toLine && columnCheck){
            return true;
            //check that the pawn can move only forward, case blacks
        }
        else if(color.equals("black") && line>toLine && columnCheck){
            return true;
        } else
            return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
