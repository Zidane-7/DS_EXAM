import java.util.Scanner;

class queues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        int d=sc.nextInt();
        queue_implementation qst =new queue_implementation(d);
        while (true) {
            System.out.println("\nQueue Menu");
            System.out.println("1. Enqueue an element");
            System.out.println("2. Dequeue an element");
            System.out.println("3. Display the Queue");
            System.out.println("4. Front of the Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();   

            switch (choice) {
                case 1:
                    System.out.println("Enqueue called...");
                    for (int i = 0; i < d; i++) {
                        int yt=sc.nextInt();
                        System.out.println("The element "+ qst.enqueue(yt)+" is enqueued.");                        
                    }
                    break;

                case 2:
                    System.out.println("Dequeue called...");
                    System.out.println("The element "+qst.dequeue()+" is dequeued");                    
                    break;

                case 3:
                    System.out.println("Display called...");
                    qst.display();
                    break;
                
                case 4:
                qst.peek();
                break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);  
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

    }
}
class queue_implementation
{
    private static int front,rear,capacity;
    private static int queue[];
    queue_implementation(int n)
    {
        capacity=n;
        front=rear=0;
        queue=new int [capacity];
    }
    int enqueue(int item)
    {
        if(capacity==rear) // front ==0 && rear == capacity -1;
        {
            System.out.println("Queue is Full");
            return -1;
        }
        else
        {
            queue[rear]=item;
            rear++;
            return item;
        }
    }
    int dequeue()
    {
        if(front==rear) // or front ==0 or rear ==0
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            int del=queue[front];
            front++;
            return del;   
        }
    }
    void display()
    {
        int i;
        if(front==rear)
        {
            System.out.println("Queue is Empty");
            return;
        }
        for (i=front; i < rear; i++) 
        {
            System.out.print(queue[i]+"  ");
        }
        System.out.println();
        return;

    }
    void peek()
    {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;

        }
        
        System.out.println("Front Element of the queue: "+ queue[front]);
        return;
}
}
        

    


