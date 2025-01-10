public class SudokuSolver {

    public static boolean isSafe(int[][]board, int row, int col, int num){
        

        //check column
        for (int a = 0; a < 9; a++){
            if (board [a][col] == num){
                return false;
            }
        }

        //check row
        for (int b = 0; b < 9; b++){
            if (board [row][b] == num){
                return false;
            } 
        }

        //check square
        int startRow = row - row%3;
        int startCol = col - col%3;
        for (int a = startRow; a < startRow + 3; a++){
            for (int b = startCol; b < startCol + 3; b ++){
                if (board[a][b] == num){
                    return false;
                }
            }
        } 
        return true;

    }

    public static boolean solve(int[][]board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
            {
                if (board[i][j] == 0) 
                {
                    row = i;
                    col = j;
                    
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
            if (isEmpty) {
                return true;
            }
            //find an isSafe number
            for (int num = 1; num <= n; num++ ){ 
                if (isSafe(board, row, col, num)){
                    board [row][col] = num;
                    if (solve(board, n)){
                        return true;
                    }
                }
                //set back if no isSafe number found
                else {
                    board [row] [col] = 0;
                }
            }
        }
        return false;
    }
}



