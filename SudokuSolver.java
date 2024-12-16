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
}
