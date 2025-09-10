class linkedLists2 {
    public static void main(String[] args) {
        linkedLists_implementation2 l3 = new linkedLists_implementation2();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.traverseAndPrint();
        l3.insertAtBeginning(67);
        l3.traverseAndPrint();
        l3.insertAtPostion(76, 3);
        l3.traverseAndPrint();
        l3.delete(4);
        l3.traverseAndPrint();        
        l3.deleteLastNode();
        l3.traverseAndPrint();
        l3.deleteAtPosition(3);
        l3.traverseAndPrint();

    }
    
}
class linkedLists_implementation2 extends linkedLists_implementation1{
    Node head;
    linkedLists_implementation2()
    {
        this.head=null;
    }
    public void delete(int value)
    {
        if(head==null)
        {
            System.out.println("Cannot delete. The linked list is empty");
            return;
        }
        if(head.data==value)
        {
            head=head.next;
            System.out.println("Deleted the node "+value);
            return;
        }
        Node current=head, previous=null;
        while (current!=null && current.data!=value) {
            previous=current;
            current=current.next;
            
        }
        if(current==null)
        {
            System.out.println("Value "+" is not found in the list");
        }
        previous.next=current.next;
        System.out.println("The value "+value+" is deleted.");
    
    }
    public void deleteLastNode()
    {
        if(head ==null)
        {
            System.out.println("Empty Linked list.");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node current=head, previous =null;
        while (current.next!=null) {
            previous=current;
            current=current.next;
        }
        previous.next=null;
    }
public void deleteAtPosition(int pos) {
    if (head == null) { // empty list
        return;
    }

    // 1 based indexed
    if (pos == 1) {
        head = head.next;
        return;
    }

    Node current = head;
    Node previous = null;
    int index = 1;

    // Traverse until the position
    while (current != null && index < pos) {
        previous = current;
        current = current.next;
        index++;
    }

    // If position is out of bounds
    if (current == null) {
        return;
    }

    // Bypass the node at position
    previous.next = current.next;
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
class linkedLists_implementation1
{
    Node head;
    linkedLists_implementation1()
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
            Node current =head;
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
