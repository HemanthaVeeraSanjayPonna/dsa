package datastructures.stacks;

public class Main {

    public static String reverseString(String input)
    {
        if(input == null)
        {
            return null;
        }

        StackArrayList<Character> stack = new StackArrayList();
        for(Character it : input.toCharArray())
        {
            stack.push(it);
        }
        stack.printStack();
        String reversedString = "";
        while(!stack.isEmpty())
        {
            reversedString += stack.pop();
        }

        return reversedString;
    }


    public static boolean isBalancedParentheses(String input)
    {
        StackArrayList<Character> stack = new StackArrayList<>();
        if (input.length() % 2 != 0)
        {
            return false;
        }
        for (Character it : input.toCharArray())
        {
            if (it == '(')
            {
                stack.push(it);
            }
            else if(it == ')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void sortStack(StackArrayList<Integer> stack)
    {
        StackArrayList<Integer> tempStack = new StackArrayList<>();
        while(!stack.isEmpty())
        {
            Integer topItem = stack.pop();
            if (tempStack.peek() == null)
            {
                tempStack.push(topItem);
                continue;
            }
            while(tempStack.peek() != null && topItem < tempStack.peek())
            {
                stack.push(tempStack.pop());
            }
            tempStack.push(topItem);
        }

        while(!tempStack.isEmpty())
        {
            stack.push(tempStack.pop());
        }

    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }



    public static void main(String[] args) {

        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(4);
        stack.push(3);

         System.out.println("Before sorting:");
         stack.printStack();

         sortStack(stack);

         System.out.println("\nAfter sorting:");
         stack.printStack();

    }

}