class Solution {
    public boolean isValid(String s) {
        boolean valid = false;
        Stack<Character> stack = new Stack<Character>();

        int len = s.length();

        
        for(int i = 0; i < len; i++) {
            
            if(!stack.isEmpty() && isMatchingChar(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            } 
        }

        return stack.isEmpty();
    }

    boolean isMatchingChar(char left, char right) {
        
        boolean matching = false;
        if(left == '(' && right == ')') {
            matching = true;
        } else if(left == '[' && right == ']') {
            matching = true;
        } else if(left == '{' && right == '}') {
            matching = true;
        }
        System.out.println("left: "+left+", right: "+right+", matching: "+matching);
        return matching;
    }
}
