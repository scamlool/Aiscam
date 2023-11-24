import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AStar{

    static String[][] ix =  {{"1","0", "8"}, {"4", "2", "3"},{"7", "6", "5"}};
    static String[][] fx = {{"1","3","4"},{"8","0","2"},{"7","6","5"}};
   static int level=0;
   static int minimum = 0;
   static  Set<String> previous = new HashSet<>();
           
    public static void main(String args[]){
    previous.add(stateToString(ix));
       System.out.println("Initial state is !!!");
        print(ix);
        best(ix);
    } 

    static void print(String[][] a){
        for(int i=0;i<a.length;i++){
         for(int j=0;j<a.length;j++){
            System.out.print(" |"+a[i][j]+"| ");
         }
         System.out.println();
        }
    }

      static int compare(String[][] a,String[][] b){
      if(stateToString(a).equals(stateToString(b))){
        return 0;
      }
        return -1;
    }

      static int misplace(String[][] a,String[][] b){
        int i1=0;
        for(int i=0;i<a.length;i++){
         for(int j=0;j<a.length;j++){
           if(!a[i][j].equals(b[i][j])){
             i1++;
           }
         }
        }
      return i1;
    }

    static void best(String[][] a){
      if(compare(a,fx)==0){
        System.out.println("Found at level : " + level);
        print(a);
        System.out.println("Number of states explored: " + previous.size());
         System.out.println(previous);
        System.exit(0);
      }
        ArrayList<String[][]> a1 = new ArrayList<>();
         ArrayList<Integer> size1 = new ArrayList<>();
        int k =0,l=0;
        int i1=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
               if(a[i][j].equals("0")){
                    k=i;
                    l=j;
               }
            }
        } 
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
               if(Math.abs(pos(k,l)-pos(i,j))==1 || Math.abs(pos(k,l)-pos(i,j))==3 ){
                  String[][] b = swap(a[i][j],a[k][l],a);
                  if(compareP(b,previous)==0){
                  a1.add(b);
                  }
               }
            }
        } 
        if (a1.isEmpty()) {
            System.out.println("No valid moves left.");
            System.out.println("Number of states explored: " + previous.size());
            System.out.println(previous);
            return;
        }
       level++;
       int u=0;
       while(u<a1.size()){
          size1.add(misplace(a1.get(u),fx)+level);
          u++;
       }
       String[][] v = new String[3][3];
       int t=0;int g=0;
       System.out.println();
       System.out.println("Next item is");
       while(g < a1.size() && t != 10){
        minimum = min(size1);
        String stateStr = stateToString(a1.get(minimum));
       
        if (!previous.contains(stateStr)) {
       previous.add(stateToString(a1.get(minimum)));
       a = a1.get(minimum);
        t = 10;
        }
         size1.set(minimum,99999);
        g++;
       }
        print(a);
      
   best(a);
        
    }

    static String[][] swap(String a,String b,String[][] a1){
        int k =0,l=0,m=0,n=0;String temp="qqqq";
       String[][] b1 = new String[3][3];
      for(int i1=0;i1<a1.length;i1++){
            for(int j1=0;j1<a1.length;j1++){
              b1[i1][j1] = a1[i1][j1] ; 
        }
    }
        for(int i=0;i<a1.length;i++){
            for(int j=0;j<a1.length;j++){
               if(b1[i][j].equals(b)){
                 k=i;
                 l=j; 
               }
              if(b1[i][j].equals(a)){
                 m=i;
                 n=j;
            }
        } 
     
    }

        temp = b1[k][l];
        b1[k][l] = b1[m][n];
        b1[m][n] = temp; 
       return b1; 
    }

static int pos(int i,int j){
    return i*3 + j +1;
}

static int min( ArrayList<Integer> s){
    int min = Integer.MAX_VALUE;
    int x = 0;
    for(int i=0;i<s.size();i++){
        if(s.get(i)<min){
            min = s.get(i);
            x=i;
        }
    }
    return x;
}

static int compareP(String[][] a,Set<String> p){
        if(!p.contains(stateToString(a))){
           return 0;
        }

    return 1;
}

static String stateToString(String[][] state) {
  StringBuilder sb = new StringBuilder("A");
  for (int i = 0; i < state.length; i++) {
      for (int j = 0; j < state[i].length; j++) {
          sb.append(state[i][j]);
      }
  }
  return sb.toString();
}

}

