
import java.util.Scanner;

public class Main {
    public static ChessBoard buildBoard(){
        ChessBoard board = new ChessBoard("WHITE");

        board.board[0][0] =  new Rook(Color.WHITE);
        board.board[0][1] = new Horse(Color.WHITE);
        board.board[0][2] = new Bishop(Color.WHITE);
        board.board[0][3] = new Queen(Color.WHITE);
        board.board[0][4] = new King(Color.WHITE);
        board.board[0][5] = new Bishop(Color.WHITE);
        board.board[0][6] = new Horse(Color.WHITE);
        board.board[0][7] =  new Rook(Color.WHITE);

        for(int i = 0; i<=7; i++){
            board.board[1][i] = new Pawn(Color.WHITE);
        }

        board.board[7][0] = new Rook(Color.BLACK);
        board.board[7][1] = new Horse(Color.BLACK);
        board.board[7][2] = new Bishop(Color.BLACK);
        board.board[7][3] = new Queen(Color.BLACK);
        board.board[7][4] = new King(Color.BLACK);
        board.board[7][5] = new Bishop(Color.BLACK);
        board.board[7][6] = new Horse(Color.BLACK);
        board.board[7][7] = new Rook(Color.BLACK);

        for(int i = 0; i<=7; i++){
            board.board[6][i] = new Pawn(Color.BLACK);
        }

        return board;
    }

    public static void main(String[] args) {

        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
               Чтобы проверить игру надо вводить команды:
               'exit' - для выхода
               'replay' - для перезапуска игры
               'castling0' или 'castling7' - для рокировки по соответствующей линии
               'move e 2 e 4' - для передвижения фигуры""");

        System.out.println();
        board.printBoard();
        while(true){
            String s = scanner.nextLine();
            if(s.equals("exit")) break;
            else if (s.equals("replay")){
                System.out.println("Заново");
                board = buildBoard();
                board.printBoard();
            } else {
                if(s.equals("castling0")){
                    if(board.castling0()){
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else{
                        System.out.println("Рокировка не удалась");
                    }
                } else if(s.equals("castling7")){
                    if(board.castling7()){
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if(s.contains("move")){
                    String[] a = s.split(" ");
                    try{
                        int line = lineTransform(a[2]);
                        int column = columnTransform(a[1]);
                        int toLine = lineTransform(a[4]);
                        int toColumn = columnTransform(a[3]);
                        if(board.moveToPosition(line, column, toLine, toColumn)){
                            System.out.println("Успешно передвинулись");
                            board.printBoard();
                        } else System.out.println("Передвижение не удалось");
                    } catch (Exception e) {
                        System.out.println("Вы что-то ввели не так, попробуйте еще раз");
                    }
                }
            }
        }
    }
    public static Integer columnTransform(String s){
        char c = s.charAt(0);
        return switch (c) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> -1;
        };
    }

    public static Integer lineTransform(String s){
        int i = Integer.parseInt(s);
        return i - 1;
    }
}