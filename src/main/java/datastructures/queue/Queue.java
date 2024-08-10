package datastructures.queue;

public class Queue {
    Node first;
    Node last;
    int length;


    public Queue(int value)
    {
        Node node = new Node(value);
        first = node;
        last = node;
        length++;
    }

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }


    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(int value)
    {
        if (first == null)
        {
            Node node = new Node(value);
            first = node;
            last = node;
            length++;
            return;
        }
        Node node = new Node(value);
        last.next = node;
        last = node;
        length++;
    }

    public Node dequeue()
    {
        if (first == null)
        {
            return null;
        }

        Node oldFirst = first;
        first = first.next;
        oldFirst.next = null;
        length--;
        if (last == oldFirst)
        {
            last = first;
        }
        return oldFirst;

    }

}