public class Sudoku {
    public static void main(String[] args) {
        //Solve Sudoku:
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

        //generate Sudoku with k empty cells:
        int[][] sudokuGenerated = Generator.sudokuGenerator(40);

        for (int[] row : sudokuGenerated) {
            for (int cell : row) {
                System.out.print(cell + ","); //created that way to copy paste easily
            }
            System.out.println();
        }
    
        //generate and solve sudoku:
        int[][] sudoku = Generator.sudokuGenerator(40);
        Solver.printBoard(sudoku);
    }
}
