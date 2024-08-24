package datastructures.trees;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree()
    {
    }

    class Node
    {
        int value;
        Node left;
        Node right;

        public Node(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value)
    {
        if (root == null)
        {
            Node node = new Node(value);
            root = node;
            return true;
        }
        Node node = root;
        Node prevNode = null;
        boolean isRight = false;

        while(node != null)
        {
            if (node.value == value)
            {
                return false;
            }

            prevNode = node;

            if(value < node.value)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
                isRight = true;
            }
        }

        if (isRight)
        {
            prevNode.right = new Node(value);
        }
        else
        {
            prevNode.left = new Node(value);
        }
        return true;

    }

    public boolean contains(int value)
    {
        if (root == null) return false;

        Node node = root;
        while(node != null)
        {
            if (node.value == value) return true;
            if (value < node.value)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }
        return false;
    }

}