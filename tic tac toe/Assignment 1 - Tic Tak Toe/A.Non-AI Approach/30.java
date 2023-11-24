import java.util.Scanner;
public class TTT2 {
       Scanner sc = new Scanner(System.in);
       
       public static void main(String[] args) {

        TTT2 x = new TTT2();
     
          char[][] a = new char[3][3];
          System.out.println("Game Start");
           x.start(a);
        while(true){
              x.play1(a);
              x.display(a);
              x.winner1(a);
              x.play2(a);
              x.display(a);
              x.winner2(a);
           }
       }

       public void start(char[][] a){
       System.out.println(" -------------------");
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                a[i][j] = '_';
            }
        }for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                System.out.print(" | " + a[i][j] + " | ");
                
            }
            
            System.out.println();
                System.out.println(" -------------------");
        }
       }

       public int isFull(char[][] a){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                if(a[i][j] == '_'){
                    return 1;
                }
            }
        } 
        return -1;
        
       }

       public void display(char[][] a){  
        System.out.println(" -------------------");
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                
                System.out.print(" | "+a[i][j] + " | ");
            }
                System.out.println();
                System.out.println(" -------------------");
        }
       }

       public void winner2(char[][] a){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                if((i==j && a[0][0] == a[1][1] && a[1][1]== a[2][2] && a[2][2] == 'O' ) || (a[0][j] == 'O' &&  a[1][j] == 'O' && a[2][j]=='O') || (a[i][0] == 'O' &&  a[i][1] == 'O' && a[i][2]=='O') || (a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[2][0] == 'O')){
                     System.out.println("Player2 wins");
                     System.exit(0);
                }
                else if(isFull(a) == -1){
                    System.out.println("Its a draw");
                    System.exit(0);
                }
                else{
             
                }


            }
            
        }
       }

       public void winner1(char[][] a){
       for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                if((i==j && a[0][0] == a[1][1] && a[1][1]== a[2][2] && a[2][2] == 'X' ) || (a[0][j] == 'X' &&  a[1][j] == 'X' && a[2][j]=='X') || (a[i][0] == 'X' &&  a[i][1] == 'X' && a[i][2]=='X') || (a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[2][0] == 'X')){
                     System.out.println("Player1 wins");
                     System.exit(0);
                }
                else if(isFull(a) == -1){
                    System.out.println("Its a draw");
                    System.exit(0);
                }
                else{
                  
                }


            }
            
        }
       }

       public void play1(char[][] a){
         System.out.println("Enter choice Player 1");
         String x = sc.next();
         switch(x){
            case "1" :
            if(a[0][0] == 'O' || a[0][0] == 'X'){
                System.out.println("Enter Again");
                play1(a);
            }
              else{ a[0][0] = 'X';}

             break;

             case "2":
               if(a[0][1] == 'O' || a[0][1] == 'X'){
                System.out.println("Enter Again");
                 play1(a);
                 }
                 else{ a[0][1] = 'X';}
            
             break;

             case "3" :
             if(a[0][2] == 'O' || a[0][2] == 'X'){
                System.out.println("Enter Again");
                   play1(a);
                  }
              else{ a[0][2] = 'X';}
             break;

             case "4":
             if(a[1][0] == 'O' || a[1][0] == 'X'){
                System.out.println("Enter Again");
                  play1(a);
                 }
             else{ a[1][0] = 'X';}
             break;

             case "5" :
             if(a[1][1] == 'O' || a[1][1] == 'X'){
                System.out.println("Enter Again");
                  play1(a);
                  }
              else{ a[1][1] = 'X';}
             break;

             case "6":
             if(a[1][2] == 'O' || a[1][2] == 'X'){
                System.out.println("Enter Again");
                    play1(a);
                  }
              else{ a[1][2] = 'X';}
             break;

             case "7" :
             if(a[2][0] == 'O' || a[2][0] == 'X'){
                System.out.println("Enter Again");
                  play1(a);
                 }
              else{ a[2][0] = 'X';}
             break;

             case "8":
             if(a[2][1] == 'O' || a[2][1] == 'X'){
                System.out.println("Enter Again");
                   play1(a);
                  }
              else{ a[2][1] = 'X';}
             break;

             case "9" :
             if(a[2][2] == 'O' || a[2][2] == 'X'){
                System.out.println("Enter Again");
                      play1(a);
                     }
            else{ a[2][2] = 'X';}
             break;

             default:
             System.out.println("Enter valid output");
             play1(a);
            
         }
         
         

       }
        public void play2(char[][] a){
          System.out.println("Enter choice Player 2");
         String x = sc.next();
         switch(x){
            case "1" :
            if(a[0][0] == 'O' || a[0][0] == 'X'){
                System.out.println("Enter Again");
               play2(a);
            }
             else{ a[0][0] = 'O';}
             break;

             case "2":
               if(a[0][1] == 'O' || a[0][1] == 'X'){
                System.out.println("Enter Again");
                  play2(a);
                  }
             else{ a[0][1] = 'O';}
             break;

             case "3" :
             if(a[0][2] == 'O' || a[0][2] == 'X'){
                System.out.println("Enter Again");
                  play2(a);
                    }
              else{ a[0][2] = 'O';}
              break;

             case "4":
              if(a[1][0] == 'O' || a[1][0] == 'X'){
                System.out.println("Enter Again");
                 play2(a);
                 }
              else{ a[1][0] = 'O';}
             break;

             case "5" :
             if(a[1][1] == 'O' || a[1][1] == 'X'){
                System.out.println("Enter Again");
                   play2(a);
                  }
             else{ a[1][1] = 'O';}
             break;

             case "6":
             if(a[1][2] == 'O' || a[1][2] == 'X'){
                System.out.println("Enter Again");
                   play2(a);
                 }
              else{ a[1][2] = 'O';}
             break;

             case "7" :
             if(a[2][0] == 'O' || a[2][0] == 'X'){
                System.out.println("Enter Again");
                  play2(a);
                 }
              else{ a[2][0] = 'O';}
             break;

             case "8":
             if(a[2][1] == 'O' || a[2][1] == 'X'){
                System.out.println("Enter Again");
                 play2(a);
                 }
              else{ a[2][1] = 'O';}
             break;

             case "9" :
             if(a[2][2] == 'O' || a[2][2] == 'X'){
                System.out.println("Enter Again");
                 play2(a);
                 }
              else{ a[2][2] = 'O';}
             break;

             default:
             System.out.println("Enter valid output");
             play2(a);
         }
    }   
   }


