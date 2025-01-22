import java.util.Random;
public class SudokuGenerator {

    static void fillSquare(int [][] board, int row, int column){
        int num;
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = rand.nextInt(9) + 1;
                } 
                while (!Sudoku.isSquareSafe(board, row, column, num));
                board[row + i][column + j] = num;
                }
            }
        }
    static void fillDiagonal(int[][] board) {
        for (int i = 0; i < 9; i = i + 3) {
            fillSquare(board, i, i);
            }
     }

     static boolean fillRemaining(int[][] board, int row, int col) {
        // Move to next row if column exceeds grid size
        if (col >= Sudoku.GRID_SIZE) {
            row++;
            col = 0;
        }
    
        // end of board reached
        if (row >= Sudoku.GRID_SIZE) {
            return true;
        }
    
        // Skip pre-filled cells
        if (board[row][col] != 0) {
            return fillRemaining(board, row, col + 1);
        }
    
        // Try numbers 1-9 in the current cell
        for (int num = 1; num <= Sudoku.GRID_SIZE; num++) {
            if (Sudoku.isValidPlacement(board, row, col, num)) {
                board[row][col] = num; // Place the number
    
                // Recursively try to fill the rest of the board
                if (fillRemaining(board, row, col + 1)) {
                    return true;
                }
    
                board[row][col] = 0; // Backtrack
            }
        }
    
        return false; // No valid number found
    }

    // Remove K digits randomly
    static void deleteKDigits(int[][] board, int k) {
        Random rand = new Random();
        while (k > 0) {
            int delete = rand.nextInt(81);
            int i = delete / 9;
            int j = delete % 9;

            if (board[i][j] != 0) {
                board[i][j] = 0;
                k--;
            }
        }
    }

    // Generate a Sudoku grid with K empty cells
    static int[][] sudokuGenerator(int k) {
        int[][] board = new int[9][9];

        fillDiagonal(board);
        fillRemaining(board, 0, 3);
        deleteKDigits(board, k);

        return board;
    }

    public static void main(String[] args) {
        int[][] sudoku = sudokuGenerator(40);

        for (int[] row : sudoku) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}
