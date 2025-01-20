public class Testcode {
    

    public static void main(String[] args) {
        //safety
        int sudokuEasy [][] = { {0,4,0,0,0,7,0,0,0},    //0  !! remember row/column starts with 0
                                {0,0,1,8,9,4,0,0,0},    //1
                                {8,2,7,0,6,3,0,9,0},    //2
                                {0,0,0,7,0,8,0,0,4},    //3
                                {0,8,5,0,4,9,6,0,7},
                                {0,7,0,6,5,1,2,8,0},
                                {0,9,6,3,8,2,5,0,0},
                                {7,0,0,9,1,0,0,0,0},
                                {0,0,0,0,0,5,0,0,3}};
        
        System.out.println("true:" + SudokuSolver.isRowSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + SudokuSolver.isRowSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + SudokuSolver.isColumnSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + SudokuSolver.isColumnSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + SudokuSolver.isSquareSafe(sudokuEasy, 0, 0, 3));
        System.out.println("false:" + SudokuSolver.isSquareSafe(sudokuEasy, 0, 0, 7));

        System.out.println("true:" + SudokuSolver.isValidPlacement(sudokuEasy, 0, 0,3));
        System.out.println("false:" + SudokuSolver.isValidPlacement(sudokuEasy, 0, 0,7));
        System.out.println("false:" + SudokuSolver.isValidPlacement(sudokuEasy, 0, 0,1));

        

    }
}
