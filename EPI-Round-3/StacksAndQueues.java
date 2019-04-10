/*
9.1 Implement a stack with a min API
*/
public class MinStack {

    private class MinNode {

        public int val;
        public int min;

        public MinNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<MinNode> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }


    public void push(int val) {
        if (stack.isEmpty() || val < stack.peek().min) {
            stack.push(new MinNode(val, val));
        } else {
            stack.push(new MinNode(val, stack.peek().min));
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new Exception
        }

        return stack.pop().val;
    }

    public int min() {
        return stack.peek().min;
    }

}

/*
9.2 Evaluate RPN Expressions
*/
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    
    for (String token : tokens) {
        if (!("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))) {
            stack.push(Integer.valueOf(token));
        } else {
            int secondNum = stack.pop();
            int firstNum = stack.pop();

            if ("+".equals(token)) {
                stack.push(firstNum + secondNum);
            } else if ("-".equals(token)) {
                stack.push(firstNum - secondNum);
            } else if ("*".equals(token)) {
                stack.push(firstNum * secondNum);
            } else if ("/".equals(token)) {
                stack.push(firstNum / secondNum);
            }
        }
    }
    
    return stack.pop();
}