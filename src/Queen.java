import java.util.ArrayList;

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
        ArrayList<Boolean> lPlusCSame = new ArrayList<>();
        ArrayList<Boolean> lSameCPlus = new ArrayList<>();
        ArrayList<Boolean> lMinusCSame = new ArrayList<>();
        ArrayList<Boolean> LSameCMinus = new ArrayList<>();
        ArrayList<Boolean> lPlusCPlus = new ArrayList<>();
        ArrayList<Boolean> lPlusCMinus = new ArrayList<>();
        ArrayList<Boolean> lMinusCPlus = new ArrayList<>();
        ArrayList<Boolean> LMinusCMinus = new ArrayList<>();
        if(!isValidValues(line, column, toLine, toColumn)) return false;

        //defining some repetitive booleans
        // 1. checking if the next cell is empty
        // 2. checking if there is another color chess piece on the way

        //filling out the arraylists with possible moves,
        //if there is an enemy chess piece on the way - stops the  iteration
        //Queen moves columns and diagonals, checking Bishop and Rook-like move
        for(int i = 1; i <=7; i++){
            //1. L+i C+i, defining where it can move,checking each value if it is within the board
            //checking if the last entry of arraylist is not false - in case of false already met, generating false
            if(isValidValues(line, column, line + i, column + i)
                    && (isCellNull(chessBoard, line + i, column + i)
                    || isCellOccupiedByEnemy(chessBoard, line + i, column + i))
                    && (lPlusCPlus.getLast() != false)){
                //explicitly checking false, accepted values - null (freshly created) or true

                lPlusCPlus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line + i, column + i)){
                    lPlusCPlus.add(false);
                }
            } else {
                lPlusCPlus.add(false);
            }
            //2. L+i C-i, defining where it can move, checking each value if it is within the board
            if(isValidValues(line, column, line + i, column - i)
                    && (isCellNull(chessBoard, line + i, column - i)
                    || isCellOccupiedByEnemy(chessBoard, line + i, column - i))
                    && (lPlusCMinus.getLast() != false)){

                lPlusCMinus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line + i, column - i)){
                    //checking if the cell occupied by the enemy chess piece, pushing false for the cell right after it
                    lPlusCMinus.add(false);
                }
            } else {
                lPlusCMinus.add(false);
            }

            //3. L-i C+i, defining where it can move, checking each value if it is within the board
            if(isValidValues(line, column, line - i, column + i)
                    && (isCellNull(chessBoard, line - i, column + i)
                    || isCellOccupiedByEnemy(chessBoard, line - i, column + i))
                    && (lMinusCPlus.getLast() != false)){

                lMinusCPlus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line - i, column + i)){
                    lMinusCPlus.add(false);
                }
            } else {
                lMinusCPlus.add(false);
            }

            //4. L-i C-i, defining where it can move, checking each value if it is within the board
            if(isValidValues(line, column, line - i, column - i)
                    && (isCellNull(chessBoard, line - i, column - i)
                    || isCellOccupiedByEnemy(chessBoard, line - i, column - i))
                    && (LMinusCMinus.getLast() != false)){

                LMinusCMinus.add(true);

                if(isCellOccupiedByEnemy(chessBoard, line - i, column - i)){
                    LMinusCMinus.add(false);
                }
            } else {
                LMinusCMinus.add(false);
            }

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

        lPlusCPlus = truncateArray(lPlusCPlus);
        lPlusCMinus = truncateArray(lPlusCMinus);
        lMinusCPlus = truncateArray(lMinusCPlus);
        LMinusCMinus = truncateArray(LMinusCMinus);

        //defining if it is legal move for the queen
        int lineDiff = toLine - line;
        int columnDiff = toColumn - column;

        if((Math.abs(lineDiff) != Math.abs(columnDiff))
                ||(!(lineDiff == 0) || (columnDiff == 0))){
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

        if(lPlusCPlus.size() >= Math.abs(lineDiff)){
            //case lPlusCPlus
            if((lineDiff > 0) && (columnDiff > 0))
                return true;
        }

        if(lPlusCMinus.size() >= Math.abs(lineDiff)){
            //case LPlusCMinus
            if((lineDiff > 0) && (columnDiff < 0))
                return true;
        }

        if(lMinusCPlus.size() >= Math.abs(lineDiff)){
            //case LMinusCPlus
            if((lineDiff < 0) && (columnDiff > 0))
                return true;
        }

        if(LMinusCMinus.size() >= Math.abs(lineDiff)){
            //case LMinusCMinus
            if((lineDiff < 0) && (columnDiff < 0))
                return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
