// Non Ai code in C for Tic Tac Toe

#include <stdio.h>
#include <conio.h>

void printBoard();
int checkWin();
void system();
int result = -1;

char arr[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

int main()
{
    int player = 1, input;
    printBoard();

    while (result == -1)
    {
        player = (player % 2 == 0) ? 2 : 1;
        char mark = (player == 1) ? 'X' : 'O';
        printf("Please enter Number For Player %d\n", player);
        scanf("%d", &input);
        if (input < 1 || input > 9)
        {
            printf("invalid input");
        }

        arr[input] = mark;
        printBoard();

        result = checkWin();

        if (result == 1)
        {
            printf("Player %d is the Winner", player);
            return 0;
        }
        else if (result == 0)
        {
            printf("draw");
            return 0;
        }

        player++;
    }
}
void printBoard()
{
    system("cls");
    printf("\n\n");
    printf("=== TIC TAC TOE ===\n\n");
    printf("     |     |     \n");
    printf("  %c  |  %c  |  %c  \n", arr[1], arr[2], arr[3]);
    printf("_____|_____|_____\n");
    printf("     |     |     \n");
    printf("  %c  |  %c  |  %c  \n", arr[4], arr[5], arr[6]);
    printf("_____|_____|_____\n");
    printf("     |     |     \n");
    printf("  %c  |  %c  |  %c  \n", arr[7], arr[8], arr[9]);
    printf("     |     |     \n");
    printf("\n\n");
}

int checkWin()
{

    if (arr[1] == arr[2] && arr[2] == arr[3])
    {
        return 1;
    }
    if (arr[1] == arr[4] && arr[4] == arr[7])
    {
        return 1;
    }
    if (arr[7] == arr[8] && arr[8] == arr[9])
    {
        return 1;
    }
    if (arr[3] == arr[6] && arr[6] == arr[9])
    {
        return 1;
    }
    if (arr[1] == arr[5] && arr[5] == arr[9])
    {
        return 1;
    }
    if (arr[3] == arr[5] && arr[5] == arr[7])
    {
        return 1;
    }
    if (arr[2] == arr[5] && arr[5] == arr[8])
    {
        return 1;
    }
    if (arr[4] == arr[5] && arr[5] == arr[6])
    {
        return 1;
    }

    int count = 0;
    for (int i = 1; i <= 9; i++)
    {
        if (arr[i] == 'X' || arr[i] == 'O')
        {
            count++;
        }
    }

    if (count == 9)
    {
        return 0;
    }
    return -1;
}