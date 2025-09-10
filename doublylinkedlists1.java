class doublylinkedlists1 {
    public static void main(String[] args) {
        doublylinkedlists1_implementation dl=new doublylinkedlists1_implementation();
        dl.insertAtBeginning(1);
        dl.traverseForward();
        dl.traverseBackward();
        dl.insertAtBeginning(2);
        dl.traverseForward();
        dl.traverseBackward();
        dl.insertAtEnd(3);
        dl.traverseForward();
        dl.traverseBackward();
        dl.insertAtPostion(4, 3);
        dl.traverseForward();
        dl.traverseBackward();
        dl.insertAtBeginning(5);
        dl.traverseForward();
        dl.traverseBackward();
    }
    
}
class doublylinkedlists1_implementation

{
    Node head;
    Node tail;
    public doublylinkedlists1_implementation()
    {
        this.head=null;
        this.tail=null;
    }
    void traverseForward()
    {
        Node current=head;
        while (current!=null) {
            System.out.print(current.data+" ");
            current=current.next;            
        }
        System.out.println();
    }
    void traverseBackward()
    {
        Node current=tail;
        while (current!=null) {
            System.out.print(current.data+" ");
            current=current.prev;
            
        }
        System.out.println();
    }
    void insertAtBeginning(int value)
    {
        Node temp = new Node(value);
        if(head==null)
        {
            head=temp;
            tail=temp;
        }
        else
        {
            temp.next=head;
            head.prev=temp;
            head=temp;
        }
        System.out.println(value+" is inserted at the beginning of the list.");

    }
    void insertAtPostion(int value, int position)
    {
        Node temp=new Node(value);
        if(position<1)
        {
            System.out.println("Position out of bounds.");
        }
        if(position==1)
        {
            insertAtBeginning(value);
            return;
        }
        else
        {
            Node current=head;
            int currPostion=1;
            while (current!=null && currPostion<position) {
                current=current.next;
                currPostion++;                
            }
            if(current==null)
            {
                insertAtEnd(value);
                return;
            }
            else
            {
                temp.next=current;
                temp.prev=current.prev;
                current.prev.next=temp;
                current.prev=temp;
            }

        }

    }
    void insertAtEnd(int value)
    {
        Node temp = new Node(value);
        if(tail==null)
        {
            head=temp;
            tail=temp;
        }
        else
        {
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
    }

}
class Node{
    int data;
    Node prev;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}