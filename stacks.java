class stacks
{
    public static void main(String[] args) {
        stacksImplementation stac= new stacksImplementation(5);
        stac.push("S");
        stac.push("T");
        stac.push("A");
        stac.push("C");
        stac.push("K");
        stac.display();


        
    }
}

class stacksImplementation {
    int top, capacity;
    String st[];

    stacksImplementation(int n)
    {
        capacity=n;
        st= new String[n];
        top=-1;       
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    boolean isFull()
    {
        return top>=capacity-1;
    }

    void push(String value)
    {
        if(isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }
        top=top+1;
        st[top]=value;
        System.out.println(value+" is pushed on the stack.");
    }
    void pop()
    {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;            
        }
        System.out.println(st[top]+ " is popped from the stack.");
        top=top-1;
    }
    void peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(st[top]+" is top of the stack");
    }
    void display()
    {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        int i=top;
        while (i>=0) {
            System.out.print(st[i]+"  ");
            i--;            
        }
        System.out.println();
    }  
}