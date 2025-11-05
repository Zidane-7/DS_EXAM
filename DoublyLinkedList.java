class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListTest dl = new DoublyLinkedListTest();
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        node1.next=node2;
        node2.prev=node1;

        node2.next=node3;
        node3.prev=node2;

        node3.next=node4;
        node4.prev=node3;

        node4.next=node5;
        node5.prev=node4;

        dl.head=node1;
        dl.tail=node5;
        dl.traverse(node1);
        node1=dl.insert(node1, 63);
        dl.traverse(node1);
        node1=dl.insertAtEnd(node1, 82);
        dl.traverse(node1);
        node1=dl.insertAtPos(node1, 34, 4);
        dl.traverse(node1);
        node1=dl.delete(node1);
        dl.traverse(node1);
        node1=dl.deleteAtEnd(node1);
        dl.traverse(node1);       

    }
    
}
class Node 
{
    int data;
    Node next,prev;
    Node(int d)
    {
        this.data =d;
        next = prev=null;
    }
}
class DoublyLinkedListTest{
    Node head, tail;
    DoublyLinkedListTest()
    {
        head = null;
        tail=null;
    }
    void traverse(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data);
            if(temp.next!=null)
            {
                System.out.print(" <-> ");
            }
            temp=temp.next;
        }
        System.out.println();

    }
    Node insert(Node head, int data)
    {
        Node new_node = new Node(data);
        new_node.next=head;
        if(head!=null)
        {
            head.prev=new_node;
        }
        return new_node;
    }
    Node insertAtEnd(Node head, int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            return new_node;
        }
        Node temp = head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_node;
        new_node.prev=temp;
        return head;

    }
    Node insertAtPos(Node head, int data, int pos)
    {
        if(pos<1)
        {
            return null;
        }
        if(pos==1)
        {
            head= insert(head, data);
            return head;
        }
        Node new_node = new Node(data);
        Node curr = head;
        for(int i=1;i<pos-1&&curr!=null;i++)
        {
            curr=curr.next;
        }
        if(curr==null)
        {
            System.out.println("Position out of bounds");
            return head;
        }
        new_node.prev=curr;
        new_node.next=curr.next;
        curr.next=new_node;
        if(new_node.next!=null)
        {
            new_node.next.prev=new_node;
        }
        return head;
    }
    Node delete(Node head)
    {
        if(head==null)
        {
            return null;
        }
        Node temp = head;
        head = head.next;
        if(head!=null){
            head.prev=null;
        }
        return head;

    }
    Node deleteAtEnd(Node head)
    {
        if(head==null)
        return null;
        if(head.next==null)
        return null;
        Node curr = head;
        while (curr.next!=null) {
            curr=curr.next;            
        }
        if(curr.prev!=null)
        {
            curr.prev.next=null;
        }

        return head;
    }
}
