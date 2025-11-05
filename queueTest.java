class queueTest {
    public static void main(String[] args) {
        Queues q = new Queues(5);
        q.enqueue(54);
        q.enqueue(73);
        q.enqueue(83);
        q.enqueue(93);
        q.enqueue(43);
        q.dequeue();
        q.dequeue();
        q.printQueue();
        q.frontItem();
        q.rearItem();
        q.size();       
    }
    
}
class Queues{
    int front, rear, size;
    int Q[];
    Queues(int cap)
    {
        front = rear =0;
        size = cap;
        Q=new int[cap];
    }
    void enqueue(int data)
    {
        if(isFull())
        {
            System.out.println("Queue Overflow");
            return;
        }
        else
        {
            Q[rear]=data;
            rear++;
            System.out.println(data+" is enqueued.");
        }


    }
    void dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Underflow");
            front=rear=0;
            return;
        }
        else
        {
            System.out.println(Q[front]+" is being dequeued");
            front++;
        }

    }
    void printQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Underflow");
            return;
        }
        else 
        {
            for(int i=front;i<rear; i++)
            {
                System.out.print(Q[i]+"\t");
            }
            System.out.println();
        }

    }
    boolean isEmpty()
    {
        return (front==rear);
    }
    boolean isFull()
    {
        return (rear==size);
    }
    void frontItem()
    {
        System.out.println("The front item is "+Q[front]);
    }
    void rearItem()
    {
        System.out.println("The rear item is "+Q[rear-1]);
    }
    void size()
    {
        System.out.println("Size of the queue is "+(rear-front));
    }
}
