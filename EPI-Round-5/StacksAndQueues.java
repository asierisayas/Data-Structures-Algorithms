/**
 * Implement a stack with a min API
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Evalute RPN
 */
public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    
    for (String token : tokens) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            int sndNum = Integer.parseInt(stack.pop());
            int firstNum = Integer.parseInt(stack.pop());
            int res = 0;
            if (token.equals("+")) {
                res = firstNum + sndNum;
            } else if (token.equals("-")) {
                res = firstNum - sndNum;
            } else if (token.equals("*")) {
                res = firstNum * sndNum;
            } else if (token.equals("/")) {
                res = firstNum / sndNum;
            }

            stack.push(String.valueOf(res));
        } else {
            stack.push(token);
        }
    }
    
    return Integer.parseInt(stack.pop());
}

/**
 * Normalize Pathnames
 */
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String output = "";
    
    for (String elem : path.split("/")) {
        if (elem.equals("") || elem.equals(".")) {
            continue;
        } else if (elem.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(elem);
        }
    }
    
    while (!stack.isEmpty()) {
        output = "/" + stack.pop() + output;
    }
    
    return output.length() != 0 ? output : "/";
}

/**
 * Implement a circular queue
 */

class MyCircularQueue {
    int[] queue;
    int front;
    int back;
    int size;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        back = -1;
        size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size < queue.length) {
            back = (back + 1) % queue.length;
            queue[back] = value;
            size++;
            return true;
        }
        
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size > 0) {
            front = (front + 1) % queue.length;
            size--;
            return true;
        }
        
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : queue[back];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}