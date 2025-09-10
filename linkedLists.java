class linkedLists {
    public static void main(String[] args) {
        linkedLists_implementation li=new linkedLists_implementation();
        li.add(1);
        li.add(2);
        li.add(3);
        li.traverseAndPrint();
        li.insertAtBeginning(9);
        li.traverseAndPrint();
        li.insertAtPostion(4, 3);
        li.traverseAndPrint();
    }
    
}
class linkedLists_implementation
{
    Node head;
    linkedLists_implementation()
    {
        this.head=null;
    }
    public void add(int data)
    {
        Node newNode= new Node(data);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            Node current = head;
            while (current.next!=null) 
            {
                current=current.next;                
            }
            current.next=newNode;
        }
    }
    public void insertAtBeginning(int data)
    {
        Node newNode=new Node(data);
        newNode.next=head; // new Node points to the current head and then the head
        head=newNode; // is updated with the value of the newnode
    }
    public void insertAtPostion(int data, int position)
    {
        if(position<1)
        {
            System.out.println("The position cannot be less than 1");
            return;
        }
        if(position==1)
        {
            insertAtBeginning(data);
            return;
        }
        Node newNode=new Node(data);
        Node current =head;
        for (int i = 1; i < position-1 && current!=null; i++) 
        {
            current=current.next;            
        }
        if(current==null)
        {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next=current.next;
        current.next=newNode;
    }
    public void traverseAndPrint()
    {
        if(head==null)
        {
            System.out.println("The linked list is empty");
        }
        Node current=head;
        System.out.println("Linked List elements: ");
        while (current!=null) {
            System.out.print(current.data+" ");
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
        this.data = data;
        this.next=null;
    }    
}