public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    //check row
    private static boolean isRowSafe(int[][] board, int row, int number){
        for (int i = 0; i < GRID_SIZE; i++){
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    //check column
    private static boolean isColumnSafe(int[][] board, int column, int number){
        for (int i = 0; i < GRID_SIZE; i++){
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }

    //check square
    private static boolean isSquareSafe(int[][] board, int row, int column, int number){
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

    private static boolean isValidPlacement (int[][] board, int row, int column, int number){
        return isRowSafe(board, row, number) && 
        isColumnSafe(board, column, number) && 
        isSquareSafe(board, row, column, number);
    }

    private static boolean solveBoard(int[][] board){
        //loop through grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++){
                
                if (board[row][column] == 0) {  //empty space = 0

                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++){ //go through numbers 1-9

                        if (isValidPlacement(board, row, column, numberToTry)){ //is current number valid to place
                            board [row][column] = numberToTry; //place it
                            
                            if (solveBoard(board)){ //starts again from top
                                return true; 
                            }
                            else { //unable to place valid number
                                board[row][column] = 0; //set numberToTry back to 0

                            }
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }

    private static void printSolvedBoard(int[][] board){
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) { //every third row
                System.out.println("-----------");
            }
            for(int column = 0; column < GRID_SIZE; column++){
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
        
        printBoard(sudokuEasy);
        printBoard(sudokuEvil);
    }
}