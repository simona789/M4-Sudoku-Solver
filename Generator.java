import java.util.Random;
public class Generator {  //Inspiration: https://www.geeksforgeeks.org/program-sudoku-generator/

    static void fillSquare(int [][] board, int row, int column){
        int num;
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //add random number to square aslong as it is safe
                do {
                    num = rand.nextInt(9) + 1; 
                } 
                while (!Safety.isSquareSafe(board, row, column, num));
                board[row + i][column + j] = num;
                }
            }
        }

    static void fillDiagonal(int[][] board) { //fill squares diagonally
        for (int i = 0; i < 9; i = i + 3) {
            fillSquare(board, i, i); 
            }
     }

     static boolean fillRemaining(int[][] board, int row, int col) {
        //move to next row if column exceeds board size
        if (col >= Safety.GRID_SIZE) {
            row++;
            col = 0;
        }
    
        //end of board reached
        if (row >= Safety.GRID_SIZE) {
            return true;
        }
    
        //skip pre-filled cells
        if (board[row][col] != 0) {
            return fillRemaining(board, row, col + 1);
        }
    
        //try numbers 1-9 in the current cell
        for (int num = 1; num <= Safety.GRID_SIZE; num++) {
            if (Safety.isValidPlacement(board, row, col, num)) { //check if num is safe 
                board[row][col] = num;
    
                //recursively fill the rest of the board
                if (fillRemaining(board, row, col + 1)) {
                    return true;
                }
    
                board[row][col] = 0; //backtrack
            }
        }
    
        return false; //no valid number found
    }

    
    static void deleteKDigits(int[][] board, int k) { //delete K digits randomly
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

    //generate sudoku grid with K empty cells
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
                System.out.print(cell + ","); //created to copy paste into SudokuTestcode.java
            }
            System.out.println();
        }
    }

}
