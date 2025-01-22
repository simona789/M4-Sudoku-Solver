public class Sudoku {
    public static void main(String[] args) {
        //solve Sudoku:
        int sudokuEvil [][] = { {0,7,0,2,0,0,0,8,0},
                                {0,0,0,0,1,6,0,5,7},
                                {0,8,6,7,0,0,0,0,0},
                                {0,0,0,0,0,0,0,2,0},
                                {0,0,4,6,0,7,8,0,0},
                                {0,9,0,0,0,0,0,0,0},
                                {0,0,0,0,0,2,7,3,0},
                                {2,4,0,3,8,0,0,0,0},
                                {0,6,0,0,0,5,0,9,0}};
        Solver.printBoard(sudokuEvil);

        //generate Sudoku with 40 empty cells:
        int[][] sudokuGenerated = Generator.generateSudoku(40);
        Generator.printGeneratedBoard(sudokuGenerated);
    
        //generate and solve Sudoku:
        int[][] sudoku = Generator.generateSudoku(40);
        Solver.printBoard(sudoku);
    }
}
