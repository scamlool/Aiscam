import java.util.Scanner;

public class TTTAIE {

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe\n");
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        // Start the game
        int moves = 0;
        boolean ishumanTurn = true;
        while (moves < 9 && !isGameOver(board)) {
            printBoard(board);

            char currentPlayer = ishumanTurn ? 'X' : 'O';
            if (ishumanTurn) {
                System.out.println("Your turn. Enter position: ");
                int position = getPlayerMove(board);
                makeMove(board, position, currentPlayer);
            } else {
                System.out.println("AI's turn.");
                int position = getAIMove(board);
                makeMove(board, position, currentPlayer);
            }

            ishumanTurn = !ishumanTurn;
            moves++;
        }
        printBoard(board);
        char winner = getWinner(board);
        if (winner == 'X') {
            System.out.println("You win!");
        } else if (winner == 'O') {
            System.out.println("AI wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" |"+board[i][j] + "| ");
            }
            System.out.println();
            System.out.println("                             ");
        }
        System.out.println();
    }

    public static int getPlayerMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        while (position < 1 || position > 9 || !isValidMove(board, position)) {
            System.out.println("Invalid input! ");
            position = scanner.nextInt();
        }
        return position;
    }

    public static boolean isValidMove(char[][] board, int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    public static void makeMove(char[][] board, int position, char currentPlayer) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = currentPlayer;
    }

    public static char getWinner(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
 
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return ' ';
    }

    public static boolean isGameOver(char[][] board) {
        return getWinner(board) != ' ' || isBoardFull(board);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getAIMove(char[][] board) {
        double minDistance = Double.MAX_VALUE;
        int bestMove = -1;
        int[][] positions = {
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
        };

        for (int i = 0; i < 9; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            if (isValidMove(board, row * 3 + col + 1)) {
                double distance = calculateEuclideanDistance(board, row, col);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestMove = row * 3 + col + 1;
                }
            }
        
        }

        return bestMove;
    }

    public static double calculateEuclideanDistance(char[][] board, int row, int col) {
        int[][] targets = {
            {0, 0}, {0, 2}, {2, 0}, {2, 2},{1, 1},{0, 1}, {1, 0}, {1, 2}, {2, 1}    
        };
        double minDistance = Double.MAX_VALUE;
        for (int[] target : targets) {
            int targetRow = target[0];
            int targetCol = target[1];
            if((row != targetRow && col != targetCol) && board[targetRow][targetCol] != ' '){
            double distance = Math.sqrt(Math.pow(row - targetRow, 2) + Math.pow(col - targetCol, 2));
            minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }
}
