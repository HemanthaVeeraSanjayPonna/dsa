package datastructures.queue;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(Integer val)
    {
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        stack2.push(val);

        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

    }

    public Integer dequeue()
    {
        if (isEmpty())
        {
            return null;
        }
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
