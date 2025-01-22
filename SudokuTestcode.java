public class SudokuTestcode {
    

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
        
        System.out.println("true:" + Sudoku.isRowSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + Sudoku.isRowSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + Sudoku.isColumnSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + Sudoku.isColumnSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + Sudoku.isSquareSafe(sudokuEasy, 0, 0, 3));
        System.out.println("false:" + Sudoku.isSquareSafe(sudokuEasy, 0, 0, 7));

        System.out.println("true:" + Sudoku.isValidPlacement(sudokuEasy, 0, 0,3));
        System.out.println("false:" + Sudoku.isValidPlacement(sudokuEasy, 0, 0,7));
        System.out.println("false:" + Sudoku.isValidPlacement(sudokuEasy, 0, 0,1));

        

    }
}
