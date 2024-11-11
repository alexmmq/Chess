import java.util.ArrayList;

public class Bishop extends ChessPiece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //defining if it is legal move for the bishop
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;
        boolean validMoves = (Math.abs(lineDiff) == Math.abs(columnDiff));

        ///checking if there are some chess pieces on the way, checking all the way from line to toLine and column to
        //toColumn
        //case lineDiff negative columnDiff negative
        if(validMoves
            && (lineDiff < 0)
            && (columnDiff < 0)){
            int l = line;
            int c = column;
            while((l!= toLine) && (c!= toColumn)){
                l = l - 1;
                c = c - 1;
                if(!chessBoard.board[l][c].isCellNull(chessBoard, l, c)){
                    return false;
                }
            }

            //case lineDiff negative columnDiff positive
        }
        if(validMoves
        && (lineDiff < 0)
        && (columnDiff > 0)){
            int l = line;
            int c = column;
            while((l!= toLine) && (c!= toColumn)){
                l = l - 1;
                c = c + 1;
                if(!chessBoard.board[l][c].isCellNull(chessBoard, l, c)){
                    return false;
                }
            }

            //case lineDiff positive columnDiff negative
        }
        if(validMoves
                && (lineDiff > 0)
                && (columnDiff < 0)){
            int l = line;
            int c = column;
            while((l!= toLine) && (c!= toColumn)){
                l = l + 1;
                c = c - 1;
                if(!chessBoard.board[l][c].isCellNull(chessBoard, l, c)){
                    return false;
                }
            }

            //case lineDiff positive columnDiff positive
        }
        if(validMoves
                && (lineDiff > 0)
                && (columnDiff > 0)){
            int l = line;
            int c = column;
            while((l!= toLine) && (c!= toColumn)){
                l = l + 1;
                c = c + 1;
                if(!chessBoard.board[l][c].isCellNull(chessBoard, l, c)){
                    return false;
                }
            }
        }

        //checking the positive outcome - eating or moving to empty cell
        if(validMoves
            && (isCellNull(chessBoard, toLine, toColumn)
            || isCellOccupiedByEnemy(chessBoard, toLine, toColumn))){
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
