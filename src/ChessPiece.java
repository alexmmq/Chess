import java.util.ArrayList;

public abstract class ChessPiece {
    Color color;
    public boolean check = true;

    public ChessPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    //repetitive check for each chesspiece
    public boolean isValidValues(int line, int column, int toLine, int toColumn) {
        //checking if we're exceeding the board sizes
        if(line < 0 || line >7) return false;
        if(column < 0 || column >7) return false;
        if(toLine < 0 || toLine >7) return false;
        if(toColumn < 0 || toColumn >7) return false;

        //checking if initial position is the same as the toPosition
        return (line != toLine) || (column != toColumn);
    }

    //#TODO split the boolean into two separate implementations
    public boolean isCellNull(ChessBoard chessBoard, int toLine, int toColumn){
        return chessBoard.board[toLine][toColumn] == null;
    }

    public boolean isCellOccupiedByEnemy(ChessBoard chessBoard, int toLine, int toColumn){
        return chessBoard.board[toLine][toColumn].color != this.getColor();
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public ArrayList<Boolean> truncateArray(ArrayList<Boolean> array) {
        //getting rid of extra false values - we need to know only where chess piece can go
        ArrayList<Boolean> returnArray = new ArrayList<>();
        for(Boolean b : array) {
            if(!b){
                break;
            }
            else returnArray.add(b);
        }
        return returnArray;
    }

    public abstract String getSymbol();

}
