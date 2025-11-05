class SinglyLinkedList {
        public static void main(String[] args) {
        SinglyLinkedListTest sl = new SinglyLinkedListTest();
        Node head = new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(73);
        head.next.next.next=new Node(38);
        sl.traverse(head);
        head = sl.insert(head, 31);
        sl.traverse(head);
        head= sl.insertAtEnd(head,21);
        sl.traverse(head);
        head = sl.insertAtPosition(head,63, 3);
        sl.traverse(head);
        head=sl.delete(head);
        sl.traverse(head);
        head=sl.deleteAtEnd(head);
        sl.traverse(head);
        
    }
    
}
class Node
{
    int data;
    Node next;
    Node(int new_data)
    {
        this.data=new_data;
        this.next=null;
    }
}
class SinglyLinkedListTest{

    void traverse(Node head)
    {
        while (head!=null)
        {
            System.out.print(head.data);
            if(head.next!=null)
            System.out.print("->");
            head = head.next;            
        }
        System.out.println();
    }
    Node insert(Node head, int data)
    {
        Node new_node = new Node(data);
        new_node.next=head;
        return new_node;
    }
    Node insertAtEnd(Node head, int data)
    {
        Node new_node = new Node(data);
        if(head==null)
        {
            return new_node;
        }
        Node last = head;
        while(last.next!=null)
        {
            last = last.next;
        }
        last.next=new_node;
        return head;
    }
    Node insertAtPosition(Node head, int data, int pos)
    {
        if(pos<1)
        {
            System.out.println("Invalid Postion");
            return head;
        }
        if(pos==1)
        {
            head = insert(head, data);
            return head;
        }
        Node curr = head;
        for(int i=1;curr!=null && i<pos-1;i++)
        {
            curr=curr.next;
        }
        if(curr==null)
        {
            return head;
        }
        Node new_node = new Node(data);
        new_node.next=curr.next;
        curr.next=new_node;
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
        temp=null;
        return head;
    }
    Node deleteAtEnd(Node head)
    {
        if(head==null)
        {
            return null;
        }
        Node secondLastNode = head;
        while (secondLastNode.next.next!=null) {
            secondLastNode=secondLastNode.next;
        }
        secondLastNode.next=null;
        return head;

    }
}
