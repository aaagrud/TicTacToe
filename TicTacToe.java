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
    }

    //ELDHO
    private void computerMove() {
    }

    //DEVI
    private void showAlert(String message) {
    }

    //DEVI #2
    private void resetBoard() {
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
        }

        //DURGA
        public void setCell(int row, int col, int value) {
        }

        //EMIL
        public boolean checkWin(int player) {
        }

        //ELDHO
        public boolean isFull() {
        }

        //DEVI
        public int computerMoves() {
        }

        //DEVI #2
        public boolean isValidMove(int move) {
        }
    }
}
