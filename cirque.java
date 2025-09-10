import java.util.Scanner;

class cirque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        circularQueue cir = new circularQueue(5);

        cir.insert(5);
        cir.insert(4);
        cir.insert(3);
        cir.insert(2);
        cir.insert(1);

        cir.display();

        cir.delete();
        cir.display();

        cir.insert(65);
        cir.display();
        cir.insert(87);
    }
}

class circularQueue {
    private int front, rear, capacity;
    private int CQ[];

    circularQueue(int n) {
        capacity = n;
        front = rear = -1;
        CQ = new int[capacity];
    }

    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + item);
            return; 
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        CQ[rear] = item;  
        System.out.println(item + " is inserted.");
    }

    void delete() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println(CQ[front] + " is deleted.");
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. No elements to display");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(CQ[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
