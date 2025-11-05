

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSGraph {
    private int V;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked")
    BFSGraph(int v)
    {
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v;i++) 
        adj[i]= new LinkedList<>();
    }
    void addEdge(int src, int dest)
    {
        adj[src].add(dest);
    }
    void removeEdge(int src, int dest)
    {
        adj[src].remove((Integer) dest);
    }
    void BFS(int start)  { 
        boolean[] visited = new boolean[V]; 
        Queue<Integer> queue = new LinkedList<>(); 
 
        visited[start] = true; 
        queue.add(start); 
 
        System.out.print("BFS starting from vertex " + start + ": "); 
 
        while (!queue.isEmpty()) { 
            int v = queue.poll(); 
            System.out.print(v + " "); 
 
            for (int n : adj[v]) { 
                if (!visited[n]) { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        }

        System.out.println();
    }
    void display()
    {
        System.out.println("Adjacency List of the Graph: ");
        for(int i=0; i<V;i++)
        {
            System.out.print(i+" -> ");


            for(int n: adj[i])
            {
                System.out.print(n+" ");
            }
            System.out.println();
        }

    }
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the no. of vertices: ");
        int v = sc.nextInt();
        BFSGraph g = new BFSGraph(v);
        int choice;

        System.out.println("BFS Menu-Driven Program");
        System.out.println("1. Add Edge");
        System.out.println("2. Remove Edge");
        System.out.println("3. Display Graph");
        System.out.println("4. Perform BFS");
        System.out.println("0. Exit");
        do
        {
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                
                System.out.println("Enter source vertex: ");
                int src = sc.nextInt();
                System.out.println("Enter the destination vertex: ");
                int dest = sc.nextInt();
                g.addEdge(src, dest);
                System.out.println("Edge added "+src+" -> "+dest);                 
                break;

                case 2: 
                System.out.println("Enter source vertex: ");
                src = sc.nextInt();
                System.out.println("Enter the destination vertex: ");
                dest = sc.nextInt();
                g.removeEdge(src, dest);
                System.out.println("Edge removed "+src+" -> "+dest);  
                break;

                case 3: 
                g.display();
                break;

                case 4:
                System.out.println("Enter the starting vertex for BFS: ");
                int start = sc.nextInt();
                g.BFS(start);
                break;

                case 0:
                System.out.println("Exiting Program.....");
                break;
                default:
                System.out.println("Invalid choice!");
                break;
            }
        }while (choice!=0);
    }

    

    
}