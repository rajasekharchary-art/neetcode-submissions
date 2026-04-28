class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') {
                    continue;
                }
                char val = board[r][c];
                if(!seen.add(val+"found at row"+r) 
                || !seen.add(val+"found at column"+c)
                || !seen.add(val+"found at box row "+(r/3)*3+", column"+(c/3)*3)) {
                    return false;
                }

                
            }
        }
        return true;
    }
}
