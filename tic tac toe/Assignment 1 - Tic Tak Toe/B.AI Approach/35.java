
import java.util.Scanner;
public class TicTacToeAI {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char HUMAN_PLAYER = 'X';
    private static final char AI_PLAYER = 'O';

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        initializeBoard();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe - Human vs. AI");
        System.out.println("You are X, and the AI is O.");
        printNumberedBoard();

        while (!isGameOver()) {
            humanTurn(scanner);
            printNumberedBoard();

            if (isGameOver()) {
                break;
            }

            aiTurn();
            printNumberedBoard();
        }

        scanner.close();

        char winner = checkWinner();
        if (winner == HUMAN_PLAYER) {
            System.out.println("Congratulations! You win!");
        } else if (winner == AI_PLAYER) {
            System.out.println("AI wins! Better luck next time.");
        } else {
            System.out.println("It's a draw! Well played!");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printNumberedBoard() {
        System.out.println("-------------");
        int cellNumber = 1;
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    System.out.print(cellNumber);
                } else {
                    System.out.print(board[i][j]);
                }
                System.out.print(" | ");
                cellNumber++;
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void humanTurn(Scanner scanner) {
        System.out.println("Your turn. Enter a cell number (1-9):");
        int cellNumber = scanner.nextInt();

        if (isValidMove(cellNumber) && board[getRow(cellNumber)][getCol(cellNumber)] == EMPTY_CELL) {
            board[getRow(cellNumber)][getCol(cellNumber)] = HUMAN_PLAYER;
        } else {
            System.out.println("Invalid move. Try again.");
            humanTurn(scanner);
        }
    }

    private static boolean isValidMove(int cellNumber) {
        return cellNumber >= 1 && cellNumber <= 9;
    }

    private static int getRow(int cellNumber) {
        return (cellNumber - 1) / BOARD_SIZE;   //5 =1
    }

    private static int getCol(int cellNumber) {
        return (cellNumber - 1) % BOARD_SIZE;  //5=2
    }

    private static void aiTurn() {
        int[] bestMove = findBestMove();
        board[bestMove[0]][bestMove[1]] = AI_PLAYER; 
    }

    private static int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;  //2147483648  
        int[] bestMove = new int[]{-1, -1};

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    board[i][j] = AI_PLAYER; //O
                    int score = minimax(board, 0, false);
                    board[i][j] = EMPTY_CELL;

                    if (score > bestScore) {  // min or max..but score max..then move assighn and return to 
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private static int minimax(char[][] board, int depth, boolean isMaximizingPlayer) {
        if (isGameOver()) {
            return evaluateBoard();
        }

        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;           
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == EMPTY_CELL) {
                        board[i][j] = AI_PLAYER;  // AI O
                        bestScore = Math.max(bestScore, minimax(board, depth + 1, false));
                        board[i][j] = EMPTY_CELL;
                    }
                }
            }
            return bestScore;  // min or max
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == EMPTY_CELL) {
                        board[i][j] = HUMAN_PLAYER;  //player X 
                        bestScore = Math.min(bestScore, minimax(board, depth + 1, true));
                        board[i][j] = EMPTY_CELL;
                    }
                }
            }
            return bestScore;
        }
    }

    private static boolean isGameOver() {
        return isBoardFull() || checkWinner() != EMPTY_CELL;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false; //  no draw....then checkwin
                }
            }
        }
        return true;  // draw
    }

    private static char checkWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != EMPTY_CELL) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != EMPTY_CELL) {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY_CELL) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY_CELL) {
            return board[0][2];
        }

        return EMPTY_CELL;
    }

    private static int evaluateBoard() {
        char winner = checkWinner();
        if (winner == AI_PLAYER) {
            return 10;
        } else if (winner == HUMAN_PLAYER) {
            return -10;
        } else {
            return 0;
        }
    }
}