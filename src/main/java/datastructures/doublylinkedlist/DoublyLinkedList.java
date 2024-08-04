package datastructures.doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value)
    {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    class Node
    {
        Node next;
        Node prev;
        int value;

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

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value)
    {
        if (head == null && tail == null)
        {
            Node node = new Node(value);
            head = node;
            tail = node;
            length++;
            return;
        }

        Node node = new Node(value);
        Node prevTail = tail;
        tail.next = node;
        tail = node;
        tail.prev = prevTail;
        length++;
    }

    public Node removeLast()
    {
        if (head == null && tail == null)
        {
            return null;
        }
        if (head == tail)
        {
            Node node = head;
            head = null;
            tail = null;
            length--;
            return node;
        }
        Node prevTail = tail;
        tail = tail.prev;
        tail.next = null;
        prevTail.prev = null;
        length--;
        return prevTail;
    }

    public void prepend(int value)
    {
        if (head == null && tail == null)
        {
            Node node = new Node(value);
            head = node;
            tail = node;
            length++;
            return;
        }
        Node node = new Node(value);
        Node prevHead = head;
        head.prev = node;
        head = node;
        head.next = prevHead;
        length++;
    }

    public Node removeFirst()
    {
        if (head == null && tail == null)
        {
            return null;
        }

        if (head == tail)
        {
            Node node = head;
            head = null;
            tail = null;
            length--;
            return node;
        }

        Node oldHead = head;
        head = head.next;
        head.prev = null;
        oldHead.next = null;
        length--;
        return oldHead;
    }

    public Node get(int index)
    {
        if ((head == null && tail == null) || index < 0)
        {
            return null;
        }


        int counter = 0;
        Node node = head;

        while(node != null)
        {
            if (counter == index)
            {
                return node;
            }
            counter++;
            node = node.next;
        }

        return null;
    }

    public boolean set(int index, int value)
    {
        if ((head == null && tail == null) || index < 0)
        {
            return false;
        }
        int counter = 0;
        Node node = head;
        while(node != null)
        {
            if (index == counter)
            {
                node.value = value;
                return true;
            }
            counter++;
            node = node.next;
        }
        return false;
    }

    public boolean insert(int index, int value)
    {
        if ((head == null && tail == null) || index < 0)
        {
            return false;
        }

        int counter = 0;
        Node node = head;
        Node prevNode = null;
        while(node != null)
        {
            if (index == counter)
            {
                Node newNode = new Node(value);
                Node currentNodeAtPosition = node;
                if (prevNode != null)
                {
                    prevNode.next = newNode;
                }
                else
                {
                    head = newNode;
                }
                newNode.prev = prevNode;
                newNode.next = currentNodeAtPosition;
                currentNodeAtPosition.prev = newNode;
                length++;

                return true;

            }
            counter++;
            prevNode = node;
            node = node.next;
        }

        if (counter == index)
        {
            Node newNode = new Node(value);
            Node oldTail = tail;
            tail = newNode;
            oldTail.next = newNode;
            tail.prev = oldTail;
            length++;
            return true;
        }
        return false;
    }

    public Node remove(int index)
    {
        if ((head == null && tail == null) || index < 0)
        {
            return null;
        }

        int counter = 0;
        Node node = head;
        Node prevNode = null;
        while(node != null)
        {
            if (index == counter)
            {
                Node oldNodeAtPosition = node;
                Node nextNode = node.next;

                if (nextNode != null)
                {
                    nextNode.prev = prevNode;
                }
                else
                {
                    tail = prevNode;
                }

                if (prevNode != null)
                {
                    prevNode.next = nextNode;
                }
                else
                {
                    head = nextNode;
                }

                length--;
                return oldNodeAtPosition;

            }
            counter++;
            prevNode = node;
            node = node.next;
        }
        return null;
    }

    public void swapFirstLast()
    {
        if (head == null && tail == null)
        {
            return;
        }
        int oldTailValue = tail.value;
        int oldHeadValue = head.value;
        head.value = oldTailValue;
        tail.value = oldHeadValue;
    }

    public void reverse()
    {
        if (head == tail)
        {
            Node oldHead = head;
            head = tail;
            tail = oldHead;
            return;
        }

        Node node = tail;
        Node oldHead = head;
        Node oldTail = tail;
        while(node != null)
        {
            Node oldPrev = node.prev;
            node.prev = node.next;
            node.next = oldPrev;
            node = oldPrev;

        }

        head = oldTail;
        tail = oldHead;
    }

    public boolean isPalindrome()
    {
        if (head == tail) return true;

        Node node1 = head, node2 = tail, prevNode = null;
        while(!((prevNode == node2) || node1 == node2))
        {
            if (node1.value != node2.value)
            {
                return false;
            }
            prevNode = node1;
            node1 = node1.next;
            node2 = node2.prev;
        }

        return true;
    }

    public void swapPairs()
    {
        Node node = head;
        while(node != null)
        {
            int nodeOldValue = node.value;
            if (node.next != null)
            {
                node.value = node.next.value;
                node.next.value = nodeOldValue;
                node = node.next.next;
            }
            else{
                node = node.next;
            }
        }
    }


}

