import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTaeToe {
    static List<Integer> playerList = new ArrayList<>();
    static List<Integer> compList = new ArrayList<>();

    static int count = 1;

    public static void game() {
        System.out.println("------TIC TAE TOE GAME--------");
        System.out.println();
        System.out.println("-------Welcome to Game-------");
        System.out.println();
        System.out.println("\tPlayer(You) : X");
        System.out.println("\tComputer    : O");
        System.out.println();

        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', ' ', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };
        printBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice(1-9):");
            int playerPosition = scan.nextInt();

            while (playerList.contains(playerPosition) || compList.contains(playerPosition)) {
                System.out.println("Place is already filled! Enter right position");
                playerPosition = scan.nextInt();
            }

            placeElement(gameBoard, "Player", playerPosition);

            Random random = new Random();
            int compPosition = random.nextInt(9) + 1;
            if (count <= 4) {
                while (playerList.contains(compPosition) || compList.contains(compPosition)) {

                    compPosition = random.nextInt(9) + 1;
                }
                placeElement(gameBoard, "Computer", compPosition);
                count++;

            }

            printBoard(gameBoard);
            checkWinningCondition(gameBoard);
        }
    }

    public static void main(String args[]) {
        game();

    }

    public static void placeElement(char[][] gameBoard, String user, int position) {

        char symbol = ' ';
        if (user.equals("Player")) {
            playerList.add(position);
            symbol = 'X';
        } else if (user.equals("Computer")) {
            compList.add(position);
            symbol = 'O';

        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static void printBoard(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {

            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void playOrExit() {
        System.out.println("Continue:1\nExit:0");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 0) {
            System.out.println("\tGame exited.....");
            System.exit(1);
        } else if (choice == 1) {
            playerList.clear();
            compList.clear();
            count = 1;
            game();
        } else {
            System.out.println("Enter valid choice");
            System.exit(0);

        }
    }

    public static void checkWinningCondition(char[][] gameBoard) {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List> condition = new ArrayList<>();
        condition.add(topRow);
        condition.add(midRow);
        condition.add(botRow);
        condition.add(leftCol);
        condition.add(midCol);
        condition.add(rightCol);
        condition.add(cross1);
        condition.add(cross2);
        for (List list : condition) {

            if (playerList.containsAll(list)) {
                System.out.println();
                System.out.println("You are winner!");
                System.out.println();
                playOrExit();
            } else if (compList.containsAll(list)) {
                System.out.println();
                System.out.println("Computer is winner");
                System.out.println();
                playOrExit();

            } else if (compList.size() + playerList.size() == 9) {
                System.out.println("Game over : it's a DRAW!");
                System.exit(1);

            }
        }

    }
}
