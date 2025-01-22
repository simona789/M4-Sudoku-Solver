public class Sudoku{
    static final int GRID_SIZE = 9;

    //check row
    static boolean isRowSafe(int[][] board, int row, int number){
        for (int i = 0; i < GRID_SIZE; i++){
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    //check column
    static boolean isColumnSafe(int[][] board, int column, int number){
        for (int i = 0; i < GRID_SIZE; i++){
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }

    //check square
    static boolean isSquareSafe(int[][] board, int row, int column, int number){
        //get top left box of square
        int localSquareRow = row - row % 3;
        int localSquareColumn = column - column % 3;
        //go through rows
        for (int i = localSquareRow; i < localSquareRow + 3; i ++){
            //go through columns
            for (int j = localSquareColumn; j < localSquareColumn + 3; j++){
                if (board [i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValidPlacement (int[][] board, int row, int column, int number){
        return isRowSafe(board, row, number) && 
        isColumnSafe(board, column, number) && 
        isSquareSafe(board, row, column, number);
    }
}