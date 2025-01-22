public class Solver { //Inspiration from https://www.geeksforgeeks.org/sudoku-backtracking-7/

    static boolean solveBoard(int[][] board){
        //loop through board
        for (int row = 0; row < Safety.GRID_SIZE; row++) {
            for (int column = 0; column < Safety.GRID_SIZE; column++){
                
                if (board[row][column] == 0) {  //space = 0

                    for(int numberToTry = 1; numberToTry <= Safety.GRID_SIZE; numberToTry++){ //go through numbers 1-9

                        if (Safety.isValidPlacement(board, row, column, numberToTry)){ //current number is valid to place
                            board [row][column] = numberToTry;
                            
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

    static void printSolvedBoard(int[][] board) {
        for (int row = 0; row < Safety.GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) { //every third row
                System.out.println("------+-------+------");
            }
            for (int column = 0; column < Safety.GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) { //every third column
                    System.out.print("| ");
                }
                System.out.print(board[row][column] == 0 ? "." : board[row][column]); //replace 0 with .
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    static void printBoard(int[][] board) {
        System.out.println();
        System.out.println("Original board:");
        System.out.println();
        printSolvedBoard(board);
        System.out.println();
    
        if (solveBoard(board)) {
            System.out.println("Solved board:");
            System.out.println();
        } else {
            System.out.println("Unable to solve board");
        }
        printSolvedBoard(board);
        System.out.println();
    }
}