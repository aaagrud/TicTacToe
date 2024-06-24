import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToe extends Application {
    private Board board = new Board(); 
    private Button[][] buttons = new Button[3][3];
    private boolean playerTurn = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");

        GridPane grid = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button("");
                button.setMinSize(100, 100);

                final int row = i;
                final int col = j;

                button.setOnAction(e -> handleButtonClick(row, col, button));

                buttons[i][j] = button;

                grid.add(button, j, i);
            }
        }

        board.initialise();
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //EMIL
    private void handleButtonClick(int row, int col, Button button) {
        
        if (playerTurn && board.isCellEmpty(row, col)) {
            button.setText("X");
            board.setCell(row, col, 1);
            if (board.checkWin(1)) {
                showAlert("Player wins!");
                resetBoard();
            } else if (board.isFull()) {
                showAlert("It's a tie!");
                resetBoard();
            } else {
                playerTurn = false;
                computerMove();
            }
        }
    }


    //ELDHO
    private void computerMove() {
        int move = board.computerMoves();
        if (move != 0) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            buttons[row][col].setText("O");
            board.setCell(row, col, 0);
            if (board.checkWin(0)) {
                showAlert("Computer wins!");
                resetBoard();
            } else if (board.isFull()) {
                showAlert("It's a tie!");
                resetBoard();
            } else {
                playerTurn = true;
            }
        }
    }


    //DEVI
    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //DEVI #2
    private void resetBoard() {
        board.initialise();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        playerTurn = true;
    }


    class Board {
        private int[][] arr = new int[3][3];

        public void initialise() {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    arr[i][j] = -1;
                }
            }
        }

        //DURGA
        public boolean isCellEmpty(int row, int col) {
            return arr[row][col] == -1;
        }

        //DURGA
        public void setCell(int row, int col, int value) {
            arr[row][col] = value;
        }

        //EMIL
        public boolean checkWin(int player)  {
              
            for (int i = 0; i < 3; i++) {
                if ((arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) ||
                    (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player)) {
                    return true;
                }
            }
         
            if ((arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) ||
                (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player)) {
                return true;
            }
            return false;
        }


        //ELDHO
        public boolean isFull() {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j){
                    if (arr[i][j] == -1) return false;
                }
            }
            return true;
        }

        //DEVI
        public int computerMoves() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == -1) {
                        arr[i][j] = 0;
                        if (checkWin(0)) {
                            return 3 * i + j + 1;
                        }
                        arr[i][j] = -1;
                    }
                }
            }
        }

        //DEVI #2
        public boolean isValidMove(int move) {
    
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            return arr[row][col] == -1;
        }
    }
}
