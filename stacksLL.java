class stacksLL {
    public static void main(String[] args) {
        stacksLL_implementation stacks = new stacksLL_implementation();
        stacks.push(5);
        stacks.push(4);
        stacks.push(3);
        stacks.push(2);
        stacks.push(1);
        stacks.display();
        stacks.pop();
        stacks.pop();
        stacks.display();
        stacks.push(10);
        stacks.display();
        stacks.pop();
        stacks.pop();
        stacks.pop();
        stacks.pop();
        stacks.pop();
        stacks.push(51);
        stacks.push(42);
        stacks.push(32);
        stacks.push(22);
        stacks.push(144);
        stacks.display();
    }
    
}
class stacksLL_implementation {
    Node head;
    stacksLL_implementation()
    {
        this.head=null;
    }
    boolean isEmpty()
    {
        return head==null;
    }
    void push(int value)
    {
        Node new_node = new Node(value);
        new_node.next=head;
        head=new_node;
    }
    void pop()
    {
        if(isEmpty())
        {System.out.println("The stack is empty.");
        return;}
        head=head.next;
    }
    int peek()
    {
        if(!isEmpty()) return head.data;
        return Integer.MIN_VALUE;
    }
    void display()
    {
        Node current = head;
        if(isEmpty())
        {
            return;
        }
        while (current!=null) {
            System.out.print(current.data);
            if(current.next!=null)
            {
                System.out.print("->");
            }
            current=current.next;
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
