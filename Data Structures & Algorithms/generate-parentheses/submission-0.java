class Solution {

    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, 0, 0, new StringBuilder());
        return result;
    }

    public void generateParenthesis(int n, int open, int close, StringBuilder curr) {
        if(curr.length() == 2*n ) {
            result.add(curr.toString());
        }

        if(open < n ) {
            curr.append("(");
            generateParenthesis(n, open + 1, close, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open ) {
            curr.append(")");
            generateParenthesis(n, open, close + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
   
}
