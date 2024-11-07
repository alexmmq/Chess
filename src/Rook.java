import java.util.ArrayList;

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
        ArrayList<Boolean> lPlusCSame = new ArrayList<>();
        ArrayList<Boolean> lSameCPlus = new ArrayList<>();
        ArrayList<Boolean> lMinusCSame = new ArrayList<>();
        ArrayList<Boolean> LSameCMinus = new ArrayList<>();
        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //Rook moves on columns and lines, iterating through all possible cells that rook can move to
        for(int i = 0; i <= 7; i++){
            //1. L C+i
            //a. first check - if the valid move
            //b. Check for null and occupied by enemy cell
            if(isValidValues(line, column, line, column+i)
                && (isCellNull(chessBoard, line, column+i)
                || isCellOccupiedByEnemy(chessBoard, line, column+i))
                && (lPlusCSame.getLast() != false)){

                lSameCPlus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line, column+i)){
                    //checking if the cell occupied by the enemy chess piece, pushing false for the cell right after it
                    lSameCPlus.add(false);
                }
            }
            else{
                lSameCPlus.add(false);
            }

            //2. L C-i
            if(isValidValues(line, column, line, column-i)
                    && (isCellNull(chessBoard, line, column-i)
                    || isCellOccupiedByEnemy(chessBoard, line, column-i))
                    && (LSameCMinus.getLast() != false)){


                LSameCMinus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line, column-i)){
                    //checking if the cell occupied by the enemy chess piece, pushing false for the cell right after it
                    LSameCMinus.add(false);
                }
            }
            else{
                LSameCMinus.add(false);
            }

            //3. L-i C
            if(isValidValues(line, column, line-i, column)
                    && (isCellNull(chessBoard, line-i, column)
                    || isCellOccupiedByEnemy(chessBoard, line-i, column))
                    && (lMinusCSame.getLast() != false)){


                lMinusCSame.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line-i, column)){
                    //checking if the cell occupied by the enemy chess piece, pushing false for the cell right after it
                    lMinusCSame.add(false);
                }
            }
            else{
                lMinusCSame.add(false);
            }

            //4. L+i C
            if(isValidValues(line, column, line+i, column)
                    && (isCellNull(chessBoard, line+i, column)
                    || isCellOccupiedByEnemy(chessBoard, line+i, column))
                    && (lPlusCSame.getLast() != false)){


                lPlusCSame.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line+i, column)){
                    //checking if the cell occupied by the enemy chess piece, pushing false for the cell right after it
                    lPlusCSame.add(false);
                }
            }
            else{
                lPlusCSame.add(false);
            }
        }

        //getting rid of false values within the arrays
        lPlusCSame = truncateArray(lPlusCSame);
        lSameCPlus = truncateArray(lSameCPlus);
        lMinusCSame = truncateArray(lMinusCSame);
        LSameCMinus = truncateArray(LSameCMinus);

        //defining if it is legal move for the rook, one of the diffs should be equal to 0
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;

        if(!(lineDiff == 0) || (columnDiff == 0)){
            return false;
        }

        //case LSame CPlus
        if(lSameCPlus.size() >= Math.abs(columnDiff)){
            if((lineDiff == 0) && (columnDiff > 0)){
                return true;
            }
        }

        //case LSame CMinus
        if(LSameCMinus.size() >= Math.abs(columnDiff)){
            if((lineDiff == 0) && (columnDiff < 0)){
                return true;
            }
        }

        //case LPlus CSame
        if(lPlusCSame.size() >= Math.abs(columnDiff)){
            if((lineDiff > 0) && (columnDiff == 0)){
                return true;
            }
        }

        //case LMinus CSame
        if(lMinusCSame.size() >= Math.abs(columnDiff)){
            if((lineDiff < 0) && (columnDiff == 0)){
                return true;
            }
        }


        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
