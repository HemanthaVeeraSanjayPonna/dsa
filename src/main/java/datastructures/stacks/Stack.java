package datastructures.stacks;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value)
    {
        Node node = new Node(value); // value of first node of the stack
        top = node;
        height++;
    }


    class Node
    {
        int value;
        Node next;

        public Node(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.format("value - %s" , value);
        }

    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value)
    {
        if (top == null)
        {
            Node node = new Node(value);
            top = node;
            height++;
            return;
        }
        Node oldTop = top;
        Node node = new Node(value);
        top = node;
        top.next = oldTop;
        height++;

    }

    public Node pop()
    {
        if (top == null)
        {
            return null;
        }
        Node oldTop = top;
        top = top.next;
        oldTop.next = null;
        height--;
        return oldTop;
    }

}

