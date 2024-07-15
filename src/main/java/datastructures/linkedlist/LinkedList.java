package datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

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

    public Node findMiddleNode()
    {
        if (head == null && tail == null) return null;
        if (head == tail) return head;
        Node node = head;
        Node anotherNode = head;
        int counter = 1;
        while(node != null)
        {
            if (counter %2 ==0)
            {
                anotherNode = anotherNode.next;
            }
            node = node.next;
            counter++;
        }
        return anotherNode;
    }

    public boolean hasLoop()
    {
        if (head == null && tail == null) return false;
        Node node = head;
        Node anotherNode = head;
        int counter =1;
        while(node.next != null)
        {
            if (node.next == anotherNode)
            {
                return true;
            }
            if (counter %2 ==0)
            {
                anotherNode = anotherNode.next;
            }

            node = node.next;
            counter++;
        }

        return false;
    }

    public Node findKthFromEnd(int k)
    {
        if (head == null && tail == null) return null;
        if (k<0) return null;
        Node node = head;
        Node kthNodeFromEnd = null;
        int counter = 1;
        while(node != null)
        {
            if (counter == k) kthNodeFromEnd = head;
            if (counter > k)
            {
                kthNodeFromEnd = kthNodeFromEnd.next;
            }
            node = node.next;
            counter++;
        }
        return kthNodeFromEnd;
    }

    public void partitionList(int x)
    {
        Node node = head;
        Node firstInferiorNode = null;
        Node lastInferiorNode = null;
        Node firstSuperiorNode = null;
        Node lastSuperiorNode = null;
        while(node != null)
        {
            if (node.value < x)
            {
                if (lastInferiorNode == null)
                {
                    firstInferiorNode = node;
                }
                else{
                    lastInferiorNode.next = node;
                }
                lastInferiorNode = node;

            }
            else
            {
                if (lastSuperiorNode == null)
                {
                    firstSuperiorNode = node;
                }
                else{

                    lastSuperiorNode.next = node;
                }
                lastSuperiorNode = node;
            }
            node = node.next;
        }

        if (lastSuperiorNode != null)
        {
            lastSuperiorNode.next = null;
            tail = lastSuperiorNode;
        }


        if (lastInferiorNode == null && firstSuperiorNode != null)
        {
            head = firstSuperiorNode;
        }


        if (firstInferiorNode != null)
        {
            head = firstInferiorNode;
        }
        if (firstSuperiorNode != null && lastInferiorNode != null)
        {
            lastInferiorNode.next = firstSuperiorNode;
        }

        if (lastSuperiorNode == null && lastInferiorNode != null)
        {
            tail = lastInferiorNode;
            lastInferiorNode.next = null;
        }
    }

    public void removeDuplicates()
    {
        Set<Integer> set = new HashSet();
        Node node = head;
        Node prevNode = null;
        while(node != null)
        {
            if (set.contains(node.value))
            {
                prevNode.next = node.next;
                node.next = null;
            }
            else{
                set.add(node.value);
                prevNode = node;
            }
            node = node.next;
        }
        if (set.size() == 1)
        {
            head.next = null;
        }
    }

    public int binaryToDecimal()
    {
        int num = 0;
        Node node = head;
        while (node != null)
        {
            num = (num * 2) + node.value;
            node = node.next;
        }
        return num;
    }

    public void reverseBetween(int m, int n)
    {
        Node node = head;
        int indexCounter = 0;
        Node headInBetweenRange = null;
        Node originalHeadInBetweenRange = null;
        Node prevNode = null;
        Node connectingStartNode = null;
        Node connectingEndNode = null;

        while(node != null)
        {
            if (indexCounter == m)
            {
                headInBetweenRange = node;
                connectingStartNode = prevNode;
                originalHeadInBetweenRange = node;
            }

            if (indexCounter > m && indexCounter <= n)
            {
                Node nextNode = node.next;
                node.next = headInBetweenRange;
                prevNode.next = nextNode;
                headInBetweenRange = node;
                node = prevNode;
            }
            if (indexCounter == n+1)
            {
                connectingEndNode = node;
            }
            prevNode = node;
            node= node.next;
            indexCounter++;
        }

        if (connectingStartNode != null)
        {
            connectingStartNode.next = headInBetweenRange;
        }
        else{
            head = headInBetweenRange;
        }

        if (connectingEndNode != null && originalHeadInBetweenRange != null)
        {
            originalHeadInBetweenRange.next = connectingEndNode;
        }
        else{
            tail = originalHeadInBetweenRange;
            tail.next = null;
        }

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
