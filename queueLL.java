class queueLL {
    public static void main(String[] args) 
    {
        queueLL_implementation ay = new queueLL_implementation();
        ay.enqueue(3);
        ay.enqueue(4);
        ay.enqueue(5);
        ay.enqueue(6);
        ay.enqueue(7);
        ay.printQueue();
        ay.dequeue();
        ay.dequeue();
        ay.printQueue();
    }
    
}
class queueLL_implementation{
    private Node front;
    private Node rear;
    queueLL_implementation()
    {
        this.front=this.rear=null;
    }
    boolean isEmpty()
    {
        return front==null;
    }
    void enqueue(int value)
    {
        Node new_node = new Node(value);
        if(isEmpty())
        {
            front=rear=new_node;
            printQueue();
            return;
        }
        rear.next=new_node;
        rear=new_node;
        printQueue();
    }
    void dequeue()
    {
        if(isEmpty())
        {
            return;
        }
        Node temp = front;
        front=front.next;
        if(front==null) rear=null;
        temp=null;
        printQueue();
    }
    void printQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp=front;
        System.out.print("Current Queue: ");
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;            
        }
        System.out.println();
    }
}
class Node {
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;        
    }    
}