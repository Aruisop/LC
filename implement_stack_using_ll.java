/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}
*/
// Stack class

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

//TC: O(1)
//SC: O(1)
class myStack {
     int ct;
     Node top;
    public myStack() {
        // Initialize your data members
        ct = 0;
        top = null;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top==null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        ct++;
    }

    public void pop() {
        // Removes the front element of the stack.
       if(top==null){
           System.out.println("underflow");
       }
       Node temp = top;
       top = top.next;
       ct--;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if(top==null) return -1;
        return top.data;
    }

    public int size() {
        // Returns the current size of the stack.
        return ct;
    }
}
