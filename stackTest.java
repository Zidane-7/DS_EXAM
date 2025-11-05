class stackTest
{
    public static void main(String[] args) {
        Stacks s = new Stacks(5);
        s.push(34);
        s.push(30);
        s.push(45);
        s.push(36);
        s.push(30);
        s.pop();
        s.peek();
        s.display();


    }
}
class Stacks
{
    int size;
    int st[];
    int top;
    Stacks(int cap)
    {
        size=cap;
        st = new int[cap];
        top =-1;
    }
    void pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }
        else 
        {
            System.out.println(st[top]+" is popped.");
            top--;            
        }
    }
    void push(int data)
    {
        if(isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }
        else{
            top++;
            st[top]=data;
            System.out.println(data+" is inserted");
        }
    }
    void peek()
    {
        if(!isEmpty())
        {
            System.out.println(st[top]+" is top of the stack");
        }
    }
    boolean isEmpty()
    {
        if(top==-1)
        return true;
        else 
        return false;
    }
    boolean isFull()
    {
        if(top==size-1)
        return true;
        else 
        return false;
    }
    void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");

        }
        else 
        {
            for(int i = 0; i<=top; i++)
            {
                System.out.print(st[i]+"\t");
            }
        }
    }
}