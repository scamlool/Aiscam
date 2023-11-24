import java.util.*;
import java.lang.String;

class Edge{
    String src;
    String end;
    String size;

    Edge(String a,String b){
        this.src = a;
        this.end = b;
    }


}

public class BDFS{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]){
      System.out.println("Enter number of edges");
      int v = sc.nextInt();
      ArrayList<Edge> g[] = new ArrayList[v];   
      create(g);
      insert(g,0,v);
      bfs(g, v);
      dfs(g, v);
    }

    

    static void create( ArrayList<Edge> g[]){
        for(int i=0;i<g.length;i++){
            g[i] = new ArrayList<Edge>();
        }
    }

    static void insert(ArrayList<Edge> g[],int i,int b){
       
           if(i==b){
              display(g);
                return;
            }
                System.out.println("Enter data to be inserted in the node graph");
                String x1 = sc.next();
                String x2 = sc.next();
                if (i < b) {
                    g[i].add(new Edge(x1, x2));
                }
                insert(g,i+1,b);
         
        }

        static void display(ArrayList<Edge> g[]){
            for(int i = 0; i < g.length; i++){
                Iterator<Edge> iterator = g[i].iterator();
                while(iterator.hasNext()){
                    Edge edge = iterator.next(); // Store the current edge
                    System.out.println("Source is " + edge.src + " End is " + edge.end);
                }
            }
        }

       static void bfs(ArrayList<Edge>[] graph,int v) {
            Queue<String> queue = new LinkedList<>();
            ArrayList<String> a1 = new  ArrayList<>();
            System.out.println("Enter Starting element for BFS");
            String n = sc.next();
            queue.add(n);
           System.out.println("Final BFS Traversal is ");
            System.out.print(n+" ");
            while(!queue.isEmpty()){
                     String current = queue.poll();
                 for(int i=0;i<v;i++){
                  if(current.equals(graph[i].get(0).src) && !a1.contains(graph[i].get(0).end) && !(graph[i].get(0).end).equals(n)){
                     queue.add(graph[i].get(0).end);
                     a1.add(graph[i].get(0).end);
                    
                  }
                  if(current.equals(graph[i].get(0).end) && !a1.contains(graph[i].get(0).src) && !(graph[i].get(0).src).equals(n)){
                    
                     queue.add(graph[i].get(0).src);
                     a1.add(graph[i].get(0).src);
                    
                  }

                }
                  
            }
          
                for(int i=0;i<a1.size();i++){
                   System.out.print(a1.get(i) + " ");
                }
                System.out.println();
        }
        
            static void dfs(ArrayList<Edge>[] graph,int v) {
            Stack<String> s = new Stack<>();
            ArrayList<String> a1 = new  ArrayList<>();
            System.out.println("Enter Starting element for DFS");
            String n = sc.next();
            s.push("aaa");
             s.push(n);
             a1.add(n);
             System.out.println("Final DFS Traversal is ");
          String curr = n;
            while(!curr.equals("aaa")){  
                 for(int i=0;i<v;i++){
                  if(curr.equals(graph[i].get(0).src) && !a1.contains(graph[i].get(0).end)){
                     a1.add(graph[i].get(0).end);
                    curr = graph[i].get(0).end; 
                    s.push(graph[i].get(0).src);
                     s.push(curr);
                    }
                    
                  if(curr.equals(graph[i].get(0).end) && !a1.contains(graph[i].get(0).src)){
                        a1.add(graph[i].get(0).src);
                        curr = graph[i].get(0).src; 
                        s.push(graph[i].get(0).end);
                            s.push(curr);  
                       }        
            }
               curr = s.pop();  
                     
            }
              for(int i=0;i<a1.size();i++){
                   System.out.print(a1.get(i) + " ");
                }
                System.out.println();
        }
        
    }
