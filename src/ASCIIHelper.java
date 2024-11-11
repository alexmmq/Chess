public class ASCIIHelper {

    public static String blackKing = "\u2654";
    public static String blackQueen = "\u2655";
    public static String blackRook = "\u2656";
    public static String blackBishop = "\u2657";
    public static String blackHorse = "\u2658";
    public static String blackPawn = "\u2659";
    public static String whiteKing = "\u265A";
    public static String whiteQueen = "\u265B";
    public static String whiteRook = "\u265C";
    public static String whiteBishop = "\u265D";
    public static String whiteHorse = "\u265E";
    public static String whitePawn = "\u265F";

    private ChessPiece chessPiece;
    public ASCIIHelper(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public String printChessPiece() {
        String toReturn = "";
        if(chessPiece.getColor().equals(Color.WHITE)){
            switch (chessPiece.getSymbol()){
                case ("K"): toReturn = whiteKing;
                    break;
                    case ("Q"): toReturn = whiteQueen;
                        break;
                        case ("R"): toReturn = whiteRook;
                            break;
                            case ("B"): toReturn = whiteBishop;
                                break;
                                case ("H"): toReturn = whiteHorse;
                                    break;
                                    case ("P"): toReturn =  whitePawn;
                                        break;
                default:
                    toReturn = " ";

            }
        } else{
            switch (chessPiece.getSymbol()){
                case ("K"):  toReturn = blackKing;
                break;
                case ("Q"):  toReturn = blackQueen;
                break;
                case ("R"):  toReturn = blackRook;
                break;
                case ("B"):  toReturn = blackBishop;
                break;
                case ("H"): toReturn = blackHorse;
                break;
                case ("P"): toReturn = blackPawn;
                break;
                default:
                    toReturn = " ";
            }
        }
        return toReturn;
    }
}
