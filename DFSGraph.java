import java.util.Scanner;

class DFSGraph {
     private int V; // number of vertices 
private LinkedList<Integer>[] adj; // adjacency list 
@SuppressWarnings("unchecked") 
 
    DFSGraph(int v) { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i = 0; i < v; ++i) 
            adj[i] = new LinkedList<>(); 
    } 
    void addEdge(int v, int w) { 
        adj[v].add(w); // directed edge v -> w 
    } 
    void removeEdge(int v, int w) { 
        adj[v].remove((Integer) w); // remove edge v -> w 
    } 
    void dfsUtil(int v, boolean visited[]) { 
        visited[v] = true; 
        System.out.print(v + " "); 
        for (int n : adj[v]) { 
            if (!visited[n]) { 
                dfsUtil(n, visited); 
            } 
        } 
    } 
    void dfs(int s) { 
        boolean visited[] = new boolean[V]; 
        System.out.print("DFS starting from vertex " + s + ": "); 
        dfsUtil(s, visited); 
        System.out.println(); 
    } 
    void displayGraph() { 
        System.out.println("Adjacency List of Graph:"); 
        for (int i = 0; i < V; i++) { 
            System.out.print(i + " -> "); 
            for (int n : adj[i]) { 
                System.out.print(n + " "); 
            } 
            System.out.println(); 
        } 
    }
     public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the no. of vertices: ");
        int v = sc.nextInt();
        DFSGraph g = new DFSGraph(v);
        int choice;

        System.out.println("BFS Menu-Driven Program");
        System.out.println("1. Add Edge");
        System.out.println("2. Remove Edge");
        System.out.println("3. Display Graph");
        System.out.println("4. Perform DFS");
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
                g.DFS(start);
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

