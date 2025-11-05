class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue c = new CircularQueue(5);
        c.insert(4);
        c.insert(3);
        c.insert(23);
        c.insert(93);
        c.insert(834);
        c.printQueue();
        c.delete();
        c.delete();
        c.printQueue();
    }    
}
class CircularQueue{
    int front, rear, maxsize;
    int q[];
    CircularQueue(int cap)
    {
        maxsize=cap;
        q = new int[cap];
        front=rear=-1;
    }
    boolean isFull()
    {
        return (rear+1)%maxsize==front;
    }
    boolean isEmpty()
    {
        return (front==-1)&&(rear==-1);
    }
    void insert(int data)
    {
        if(isFull())
        {
            System.out.println("Circular Queue Overflow");
            return;
        }
        if(isEmpty())
        {
            front=0;rear=0;
        }
        else 
        {
            rear = (rear +1)%maxsize;
        }
        q[rear]=data;
        System.out.println(data+" is inserted");
    }
    void delete()
    {
        if(isEmpty())
        {
            System.out.println("Circular Queue Underflow");
            return;
        }
        int value = q[front];
        if(front == rear)
        {
            front=rear =-1;
        }
        else 
        {
            front = (front+1)%maxsize;
        }
        System.out.println(value+" is deleted");
    }
    void printQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Underflow");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(q[i]+"\t");
            if(i==rear) break;
            i = (i+ 1)%maxsize;            
        }
        System.out.println();
    }    
}
