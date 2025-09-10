class linkedListsPractice {
    public static void main(String[] args) {
        ll_implementation linkedLists = new ll_implementation();
        linkedLists.insertAtBeginning(1); // 1
        linkedLists.insertAtBeginning(2); // 2 1
        linkedLists.insertAtEnd(3); // 2 1 3
        linkedLists.insertAtPosition(4, 2); // 2 4 1 3
        linkedLists.display();
        linkedLists.delete_value(4);//2 1 3
        linkedLists.display();
        linkedLists.deletionAtEnd();//2 1 
        linkedLists.display();
        linkedLists.deletionAtPosition(1);// 1
        linkedLists.display();
        linkedLists.insertAtBeginning(6);// 6
        linkedLists.display();

    }

    
}
class Node{

    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next=null;
    }
}
class ll_implementation {
    Node head;
    ll_implementation()
    {
        this.head=null;
    }
    void insertAtBeginning(int value)
    {
        Node new_node = new Node(value);
        new_node.next=head;
        head = new_node;     
    }
    void insertAtEnd(int value)
    {
        Node new_node = new Node(value);
        Node current = head;
        if(head==null)
        {
            head=new_node;
        }
        else 
        {
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=new_node;
        }

    }
    void insertAtPosition(int value, int position)
    {
        Node new_node = new Node(value);
        Node current = head;
        if(position<1)
        {
            System.out.println("Position out of bounds");
            return;
        }
        else if(position==1)
        {
            insertAtBeginning(value);
            return;
        }

        else 
        {
            int i = 1;
            while(current!=null && i<position-1)
            {
                current=current.next;
                i++;
            }
            if(current==null)
            {
                System.out.println("position out of bounds");
                return;
            }
            new_node.next = current.next;
            current.next = new_node;

        }
    }
    void delete_value(int value)
    {
        if(head == null)
        {
            System.out.println("The linked list is empty.");
            return;
        }
        if(head.data == value)
        {
            System.out.println(head.data+ " is deleted");
            head=head.next;
            return;
        }
        Node current = head, previous = null;
        while(current!=null && current.data != value)
        {
            previous=current;
            current=current.next;
        }
        if(current==null)
        {
            System.out.println("The element is not found");
            return;
        }
        previous.next=current.next;
        System.out.println(value+ " is deleted.");
    }
    void deletionAtEnd()
    {
        if(head==null)
        {
            System.out.println("Empty linked list can't delete");
            return;
        }
        if(head.next==null)
        {
            head=null;
        }
        Node current = head, previous=null;
        while(current.next!=null)
        {
            previous=current;
            current=current.next;
        }
        previous.next=null;     
    }
    void deletionAtPosition(int position)
    {
        Node current = head, previous=null;
        if(position<1)
        {
            System.out.println("Invalid position");
            return;
        }
        if(head==null)
        {
            System.out.println("Empty list");
            return;
        }
        if(position==1)
        {
            head=head.next;
            return;
        }
        int i=1;
        while(i<position)
        {
            previous=current;
            current=current.next;i++;
        }
        if (current==null) {
            System.out.println("Position out of bounds");
            return;            
        }
        previous.next=current.next;



       
    }
    void display()
    { 
        Node current = head;
        if(head==null)
        {
            System.out.println("Empty list");
        }
        while(current!=null)
        {

            System.out.print(current.data + "  ");
            current=current.next;
        }
        System.out.println();

    }    
}