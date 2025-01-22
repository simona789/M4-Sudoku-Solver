public class SudokuSolver {

    private static boolean solveBoard(int[][] board){
        //loop through grid
        for (int row = 0; row < Sudoku.GRID_SIZE; row++) {
            for (int column = 0; column < Sudoku.GRID_SIZE; column++){
                
                if (board[row][column] == 0) {  //space = 0

                    for(int numberToTry = 1; numberToTry <= Sudoku.GRID_SIZE; numberToTry++){ //go through numbers 1-9

                        if (Sudoku.isValidPlacement(board, row, column, numberToTry)){ //current number is valid to place
                            board [row][column] = numberToTry; //place it
                            
                            if (solveBoard(board)){ //starts again from top
                                return true; 
                            }
                            else { //unable to place a valid number
                                board[row][column] = 0; //set numberToTry back to 0

                            }
                        }
                    }
                    return false; //unable to solve board
                }
            }
        }
        return true;
    }

    private static void printSolvedBoard(int[][] board){
        for (int row = 0; row < Sudoku.GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) { //every third row
                System.out.println("-----------");
            }
            for(int column = 0; column < Sudoku.GRID_SIZE; column++){
                if (column % 3 == 0 && column != 0){ //every third column
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    private static void printBoard(int[][] board){
        System.out.println("original board:");
        System.out.println();
        printSolvedBoard(board);
        System.out.println();

        if(solveBoard(board)){
            System.out.println("solved board:");
            System.out.println();
        }
        else {
            System.out.println("unable to solve board");
        }
        printSolvedBoard(board);
        System.out.println();
    }

    public static void main(String[] args) {
        int sudokuEasy [][] = { {0,4,0,0,0,7,0,0,0},    //0  !! remember row/column starts with 0
                                {0,0,1,8,9,4,0,0,0},    //1
                                {8,2,7,0,6,3,0,9,0},    //2
                                {0,0,0,7,0,8,0,0,4},    //3
                                {0,8,5,0,4,9,6,0,7},
                                {0,7,0,6,5,1,2,8,0},
                                {0,9,6,3,8,2,5,0,0},
                                {7,0,0,9,1,0,0,0,0},
                                {0,0,0,0,0,5,0,0,3}};
        
        int sudokuEvil [][] = { {0,7,0,2,0,0,0,8,0},
                                {0,0,0,0,1,6,0,5,7},
                                {0,8,6,7,0,0,0,0,0},
                                {0,0,0,0,0,0,0,2,0},
                                {0,0,4,6,0,7,8,0,0},
                                {0,9,0,0,0,0,0,0,0},
                                {0,0,0,0,0,2,7,3,0},
                                {2,4,0,3,8,0,0,0,0},
                                {0,6,0,0,0,5,0,9,0}};
                        
        int sudokuGenerated [][] = {{1,7,0,2,3,4,0,9,5},
                                    {2,9,5,6,7,1,4,3,0}, 
                                    {0,6,3,5,8,9,1,0,2}, 
                                    {7,1,0,0,5,6,0,8,0}, 
                                    {3,2,4,1,9,8,0,0,6},
                                    {0,8,6,4,0,7,0,1,0}, 
                                    {8,4,2,7,1,0,5,6,0},
                                    {6,0,1,9,4,5,8,2,7},
                                    {9,5,7,0,6,2,3,0,1}};
        
        int sudokuGenerated50 [][] = {{6,0,0,1,2,0,0,0,0},
            {0,0,9,0,3,0,1,8,4},
            {7,0,4,0,0,0,0,6,0},
            {1,0,0,0,8,0,0,0,0},
            {4,0,0,7,1,5,3,0,0},
            {0,0,7,0,4,0,0,0,0},
            {0,0,0,0,0,1,9,0,7},
            {0,0,1,0,0,0,6,4,8},
            {0,0,6,8,0,0,0,2,1}};

        int sudokuGenerated80 [][] = {{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {6,0,0,0,0,0,0,0,0}};

        
        printBoard(sudokuGenerated);
        printBoard(sudokuEasy);
        printBoard(sudokuEvil);
        
    }
}