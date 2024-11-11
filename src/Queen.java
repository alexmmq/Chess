
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

        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //queen can move to any direction, merged rook and bishop
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;
        boolean validMoves = (((lineDiff == 0) && (Math.abs(columnDiff)>0)
                ||((columnDiff == 0) && (Math.abs(lineDiff)>0)))
                || (Math.abs(lineDiff) == Math.abs(columnDiff)));


        //Bishop-like moves
        if(validMoves && (lineDiff < 0)){
            //case lineDiff negative columnDiff negative
            if(columnDiff < 0){
                int l = line;
                int c = column;
                while(l!= toLine+1){
                    l = l - 1;
                    c = c - 1;
                    if(isValidValues(line, column, l, c)
                            && !isCellNull(chessBoard, l, c)){
                        return false;
                    }
                }

                //case lineDiff negative columnDiff positive
            }
            if(columnDiff > 0){
                int l = line;
                int c = column;
                while(l!= toLine+1){
                    l = l - 1;
                    c = c + 1;
                    if(isValidValues(line, column, l, c)
                            && !isCellNull(chessBoard, l, c)){
                        return false;
                    }
                }
            }
        } else if(validMoves
                &&(lineDiff >0)){
            //case lineDiff positive columnDiff negative
            if(columnDiff < 0){
                int l = line;
                int c = column;
                while(l!= toLine - 1) {
                    l = l + 1;
                    c = c - 1;
                    if(isValidValues(line, column, l, c)
                            &&!isCellNull(chessBoard, l, c)){
                        return false;
                    }
                }
                //case lineDiff positive columnDiff positive
            }
            if(columnDiff > 0){
                int l = line;
                int c = column;
                while(l!= toLine - 1){
                    l = l + 1;
                    c = c + 1;
                    if(isValidValues(line, column, l, c)
                            && !isCellNull(chessBoard, l, c)){
                        return false;
                    }
                }
            }
            //Rook-like moves
        } else if(validMoves && (Math.abs(columnDiff) > 0)){
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
        //checking the positive outcome - eating or moving to empty cell
        return validMoves
                && (isCellNull(chessBoard, toLine, toColumn)
                || isCellOccupiedByEnemy(chessBoard, toLine, toColumn));
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
