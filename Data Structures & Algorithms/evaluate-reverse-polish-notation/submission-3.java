class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> s = new Stack<Integer>();

        for(String token: tokens) {
            if(isNumber(token)) {
                s.push(Integer.parseInt(token));
            } else {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(performArithmeticOperation(op1, op2, token));
            }
        }
        return s.pop();
        
    }

    private int performArithmeticOperation(int l, int r, String operator) {
        int result = 0;
        if(operator.equals("+")) {
            result = l + r;
        } else if (operator.equals("-")) {
            result = l - r;
        } else if (operator.equals("*")) {
            result = l * r;
        } else if (operator.equals("/")) {
            if(r == 0) {
                result = 0;
            } else {
                result = l / r;
            }
        }

        return result;
    }

    private boolean isNumber(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return false;
        }
        return true;
    }
}
