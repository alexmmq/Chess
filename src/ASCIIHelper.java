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
            toReturn = switch (chessPiece.getSymbol()) {
                case ("K") -> whiteKing;
                case ("Q") -> whiteQueen;
                case ("R") -> whiteRook;
                case ("B") -> whiteBishop;
                case ("H") -> whiteHorse;
                case ("P") -> whitePawn;
                default -> " ";
            };
        } else{
            toReturn = switch (chessPiece.getSymbol()) {
                case ("K") -> blackKing;
                case ("Q") -> blackQueen;
                case ("R") -> blackRook;
                case ("B") -> blackBishop;
                case ("H") -> blackHorse;
                case ("P") -> blackPawn;
                default -> " ";
            };
        }
        return toReturn;
    }
}
