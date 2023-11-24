import java.util.Scanner;

public class TicTaeToeAI {

    static char player = 'X', opponent = 'O';

    static class Move {
        int row, col;
    }

    static boolean isMovesLeft(char board[][]) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '_')
                    return true;
        return false;
    }

    static int evaluate(char b[][]) {
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
                if (b[row][0] == player)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == player)
                    return +10;
                else if (b[0][col] == opponent)
                    return -10;
            }
        }

        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == player)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == player)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }

        return 0;
    }

    static int minimax(char board[][], int depth, boolean isMaximizer) {
        int score = evaluate(board);

        if (score == 10)
            return score;

        if (score == -10)
            return score;

        if (!isMovesLeft(board))
            return 0;

        if (isMaximizer) {
            int best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '_') {
                        board[i][j] = player;
                        best = Math.max(best, minimax(board, depth + 1, !isMaximizer));
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        } else {
            int best = 1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '_') {
                        board[i][j] = opponent;
                        best = Math.min(best, minimax(board, depth + 1, !isMaximizer));
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        }
    }

    static Move findBestMove(char board[][]) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    board[i][j] = player;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = '_';

                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin(char board[][], char playerSymbol) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == playerSymbol && board[row][1] == playerSymbol && board[row][2] == playerSymbol) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == playerSymbol && board[1][col] == playerSymbol && board[2][col] == playerSymbol) {
                return true;
            }
        }

        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) {
            return true;
        }

        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char board[][] = { { '_', '_', '_' },
                { '_', '_', '_' },
                { '_', '_', '_' } };

        Scanner scanner = new Scanner(System.in);

        while (isMovesLeft(board)) {
            printBoard(board);

            int position;
            System.out.print("Enter the position (1-9) for your move: ");
            position = scanner.nextInt() - 1;

            int row = position / 3;
            int col = position % 3;

            if (position >= 0 && position < 9 && board[row][col] == '_') {
                board[row][col] = player;

                if (checkWin(board, player)) {
                    printBoard(board);
                    System.out.println("Player wins!");
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (!isMovesLeft(board)) {
                break;
            }

            Move bestMove = findBestMove(board);
            board[bestMove.row][bestMove.col] = opponent;

            if (checkWin(board, opponent)) {
                printBoard(board);
                System.out.println("AI wins!");
                break;
            }
        }

        if (!checkWin(board, player) && !checkWin(board, opponent)) {
            printBoard(board);
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
