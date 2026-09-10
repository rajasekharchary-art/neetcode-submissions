class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        int fr = 0;
        int lr = matrix.length-1;
        int row = -1;
        //find row
        while(fr <= lr) {
            int mr = fr+(lr-fr)/2;
            System.out.println("mr: "+mr);
            if(target >= matrix[mr][0] && target <= matrix[mr][matrix[mr].length-1]) {
                row = mr;
                break;
            } else if(target < matrix[mr][0]){
                lr = mr-1;
            } else {
                fr = mr+1;
            }
        }
        System.out.println("row: "+row);
        if(row == -1) {
            return false;
        }
        int sc = 0;
        int lc = matrix[row].length - 1;
        while(sc <= lc) {
            int mid = sc + (lc - sc)/2;
            if(target == matrix[row][mid]) {
                return true;
            } else if(target < matrix[row][mid]){ 
                lc = mid - 1;
            } else {
                sc = mid + 1;
            }
        }

        return false;

    }
}
