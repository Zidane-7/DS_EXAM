class doubleLinkedListsPractice {
    
}

class doubleLinkedListsPractice_implementation {
    Node head;
    Node tail;
    doubleLinkedListsPractice_implementation()
    {
        this.tail=null;
        this.head = null;
    }
    void insertAtBeginning(int value)
    {
        Node new_Node = new Node(value);
        if(head==null)
        {
            head =new_Node;
            tail = new_Node;
        }
        new_Node.next=head;
        head.prev=new_Node;
        head = new_Node;
    }
    void insert(int value)
    {
        Node new_node = new Node(value);
        if(tail == null)
        {
            head = new_node;
            tail=new_node;
        }
        else 
        {
            new_node.prev=tail;
            tail.next=new_node;
            tail=new_node;
        }      
    }
    void insertAtPostion(int value, int position)
    {
        Node new_node = new Node(value);
        if(position<1)
        {
            System.out.println("Position out of bounds");
            return;
        }
        if (position==1) {
            insertAtBeginning(value);
            return;            
        }
        else 
        {
            Node current = head;
            int i=1;
            while (current!=null && i<position) {
                current=current.next;
                i++;                
            }
            if(current!=null)
            {
                insert(value);
                return;
            }
             else
            {
                new_node.next=current;
                new_node.prev=current.prev;
                current.prev.next=new_node;
                current.prev=new_node;
            }
        }



    }

    
}




class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next=null;
        this.prev=null;
    }
}