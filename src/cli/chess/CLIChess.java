package cli.chess;
public class CLIChess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Running");
       startGame();
    }
    
    //Creates pieces, and maps out game
    public static void startGame(){
        Board board = new Board();
        board.showBoard();
    }
}
