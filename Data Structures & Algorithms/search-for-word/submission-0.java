class Solution {
    public boolean exist(char[][] board, String word) {

        for(int r =0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if(exist(board, word, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int i, int r, int c) {
        if(i == word.length()) {
            return true;
        }

        if(r < 0 ||   r >= board.length || c < 0 || c >= board[0].length || word.charAt(i) != board[r][c]) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = exist(board, word, i+1, r+1, c) || exist(board, word, i+1, r-1, c)
        || exist(board, word, i+1, r, c+1) || exist(board, word, i+1, r, c-1);
        board[r][c] = temp;

        return found;
    }
}
