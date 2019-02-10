/*
9.2 Evaluate RPN expressions
WRite a program that takes an arithmetical expression in RPN and 
returns the number that the expression evaluates to
*/

public int RPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
        //Number
        if (token.charAt(0) - '0' <= 9 && token.charAt(0) - '0' >= 0) {
            stack.push(token.charAt(0) - '0');
        } else { //operation
            int x = stack.pop();
            int y = stack.pop();

            switch(token.charAt(0)) {
                case '+':
                stack.push(x + y);
                break;

                case '-':
                stack.push(x - y);
                break;

                case 'x':
                stack.push(x * y);
                break;

                case '/':
                stack.push(x / y);
                break;
            }
        }
    }

    return stack.pop();
}

/*
9.3 Balanced brackets
Write a program that tests if a string made up of the characters 
'(', ')', '[', and"}' is well-formed.
*/
public boolean isValid(String s) {
    char[] brackets = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    
    for (char br : brackets) {
        if (br == '(' || br == '{' || br == '[') {
            stack.push(br);
        } else {
            if (stack.isEmpty())
                return false;
            
            char eval = stack.peek();
            if ((eval == '(' && br == ')') ||
                (eval == '{' && br == '}') ||
                (eval == '[' && br == ']') ) {
                stack.pop();
            } else {
                return false;
            }
        }
    }
    
    return stack.isEmpty();
}