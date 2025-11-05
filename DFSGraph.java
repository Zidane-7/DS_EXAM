import java.util.Scanner;

class DFSGraph {
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
