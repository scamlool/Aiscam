#include <stdio.h>
int count=0;
char gridChar(int i) {
    switch(i) {
        case -1:
            return 'X';
        case 0:
            return ' ';
        case 1:
            return 'O';
    }
}

void draw(int b[9]) {
    printf("\t %c | %c | %c\n",gridChar(b[0]),gridChar(b[1]),gridChar(b[2]));
    printf("\t---+---+---\n");
    printf("\t %c | %c | %c\n",gridChar(b[3]),gridChar(b[4]),gridChar(b[5]));
    printf("\t---+---+---\n");
    printf("\t %c | %c | %c\n",gridChar(b[6]),gridChar(b[7]),gridChar(b[8]));
}

int checkwin(const int board[9]) {
    int wins[8][3] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int i;
    for(i = 0; i < 8; i++){
        if(board[wins[i][0]] != 0 &&
           board[wins[i][0]] == board[wins[i][1]] &&
           board[wins[i][0]] == board[wins[i][2]])
            return board[wins[i][2]];
    }
    return 0;
}

int minimax(int board[9], int player) {
    int temp = checkwin(board);
    if(temp!= 0) 
		return 10*temp*player;
    int move = -1;
    int score = -20;
    int i;
    for(i = 0; i < 9; i++) {
        if(board[i] == 0) {
            board[i] = player;
            temp = -minimax(board, player*-1);
            if(temp > score) {
                score = temp;
                //count++;
                move = i;
            }
            board[i] = 0;
        }
    }
    if(move == -1) 
		return 0;
    return score;
}

void compMove(int board[9]) {
    int move = -1;
    int score = -20;
    int i;
    for(i = 0; i < 9; i++) {
        if(board[i] == 0) {
            board[i] = 1;
            int temp = -minimax(board, -1);
            board[i] = 0;
            if(temp > score) {
                score = temp;
                move = i;
                //printf("\n%d, %d",score,move);
            }
        }
    }
    board[move] = 1;
}

void playerMove(int board[9]) {
    int move = 0;
    int i;
    do{
        printf("\nInput move (1-9): ");
        scanf("%d", &i);
        move=i-1;
        printf("\n");
    } while (move >= 9 || move < 0 || board[move] != 0);
    board[move] = -1;
}

int main() {
    int board[9] = {0,0,0,0,0,0,0,0,0};
    printf("\t### Tic-Tac-Toe ###");
    printf("\n\n* Instructions \n\n");
    printf("\tPlayer  sign = X\n");
    printf("\tComputer sign = O\n");
    printf("Play (1)st or (2)nd? ");
    int player=0;
    scanf("%d",&player);
    printf("\n");
    int i;
    for(i = 0; i < 9 && checkwin(board) == 0; i++) {
        if((i+player) % 2 == 0)
            compMove(board);
        else {
        	draw(board);
            playerMove(board);
        }
    }
    switch(checkwin(board)) {
        case 0:
        	draw(board);
            printf("\tDraw!!\n");
            break;
        case 1:
            draw(board);
            printf("\tComputer wins!!!\n");
            break;
        case -1:
        	draw(board);
            printf("\tYou win!!!\n");
            break;
    }
}
