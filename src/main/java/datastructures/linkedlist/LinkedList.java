package datastructures.linkedlist;

public class LinkedList
{
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value)
    {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public Node getHead()
    {
        return head;
    }

    public Node getTail()
    {
        return tail;
    }

    public int getLength()
    {
        return length;
    }

    class Node
    {
        int value;
        Node next;

        public Node(int value)
        {
            this.value = value;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) head = newNode;
        if (tail == null) tail = newNode;
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }

    public Node removeLast() {

        // if no elements exists in LL
        if (head == null && tail == null) return null;

        // if oneAndOnlyOneNode exists in LL
        if (head == tail)
        {
            Node oneAndOnlyOneNode = head;
            head = null;
            tail = null;
            length--;
            return oneAndOnlyOneNode;
        }

        // other cases
        Node node = head;
        while(true)
        {
            if (node.next == tail)
            {
                tail = node;
                length--;
                return node.next;
            }
            node = node.next;
        }
    }

    public void prepend(int value)
    {
        Node node = new Node(value);
        if (head == null && tail == null)
        {
            head = node;
            tail = node;
            length++;
            return;
        }
        node.next = head;
        head = node;
        length++;
    }

    public Node removeFirst()
    {
        if (head == null && tail == null) return null;
        if (head == tail)
        {
            Node node = head;
            head = null;
            tail = null;
            length--;
            return node;
        }
        Node node = head;
        head = head.next;
        node.next = null;
        length--;
        return node;
    }

    public Node get(int index)
    {
        if (head == null && tail == null) return null;
        if(index < 0) return null;

        int counter = 0;
        Node node = head;
        while(true)
        {
            if (counter == index)
            {
                return node;
            }
            node = node.next;
            counter++;
            if(node == null) break;
        }
        return null;
    }

    public boolean set(int index, int value)
    {
        if (head == null && tail == null) return false;
        if(index < 0 ) return false;
        int counter = 0;
        Node node = head;
        Node prevNode = null;
        while(node != null)
        {
            if (counter == index)
            {
                Node newNode = new Node(value);
                if (tail == head)
                {
                    tail = newNode;
                    head = newNode;
                }
                if (index == 0)
                {
                    head = newNode;
                }
                if(node == tail)
                {
                    tail = newNode;
                }

                newNode.next = node.next;
                if (prevNode != null)
                {
                    prevNode.next = newNode;
                }

                return true;
            }
            prevNode = node;
            node = node.next;
            counter++;
        }
        return false;
    }

    public boolean insert(int index, int value)
    {
        if (head == null && tail == null) return false;
        if (index < 0) return false;

        Node node = head;
        Node prevNode = null;
        int counter = 0;

        while(node != null)
        {
            if (counter == index)
            {
                Node newNode = new Node(value);
                if (head == tail)
                {
                    head = newNode;
                    tail = newNode;
                }
                if (index == 0)
                {
                    head = newNode;
                }
                newNode.next= node;
                if (prevNode != null)
                {
                    prevNode.next = newNode;
                }

                length++;
                return true;
            }
            prevNode = node;
            node = node.next;
            counter++;
        }

        if (counter == index)
        {
            Node newNode = new Node(value);
            tail = newNode;
            prevNode.next = newNode;
            length++;
            return true;
        }
        return false;
    }

    public Node remove(int index)
    {
        if (head == null && tail == null) return null;
        if (index < 0) return null;

        int counter =0;
        Node node = head;
        Node prevNode = null;
        while(node != null)
        {
            if (counter == index)
            {
                if (head == tail)
                {
                    head = null;
                    tail = null;
                    length--;
                    return node;
                }
                if (node == head)
                {
                    head = head.next;
                    length--;
                    return node;
                }
                if (node == tail)
                {
                    tail = prevNode;
                    prevNode.next = null;
                    length--;
                    return node;
                }
                prevNode.next = node.next;
                length--;
                return node;
            }
            prevNode = node;
            node = node.next;
            counter++;
        }
        return null;
    }

    public void reverse()
    {
        if(head == null && tail == null) return;
        if(head == tail) return;
        Node node = head;
        while(node.next != null)
        {
            Node nextNode = node.next;
            Node prevHead = head;
            head = nextNode;
            node.next = nextNode.next;
            head.next = prevHead;

        }
        tail = node;
    }

    public void printList() {
        Node node = head;
        System.out.println("************************************************************************");
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.printf("head value : %s; tail value : %s; length : %s\n", getHead().value, getTail().value, getLength());
        System.out.println("************************************************************************");
    }

}
