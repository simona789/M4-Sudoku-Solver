public class Testcode {
    

    public static void main(String[] args) {
        //safety
        int sudokuEasy [][] = {{0,4,0,0,0,7,0,0,0},    //0  !! remember row/column starts with 0
                                {0,0,1,8,9,4,0,0,0},    //1
                                {8,2,7,0,6,3,0,9,0},    //2
                                {0,0,0,7,0,8,0,0,4},    //3
                                {0,8,5,0,4,9,6,0,7},
                                {0,7,0,6,5,1,2,8,0},
                                {0,9,6,3,8,2,5,0,0},
                                {7,0,0,9,1,0,0,0,0},
                                {0,0,0,0,0,5,0,0,3}};
        

        int sudokuEvil [][] = {{0,7,0,2,0,0,0,8,0},
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

        //test safety
        System.out.println("true:" + Safety.isRowSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + Safety.isRowSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + Safety.isColumnSafe(sudokuEasy, 0, 3));
        System.out.println("false:" + Safety.isColumnSafe(sudokuEasy, 0, 7));

        System.out.println("true:" + Safety.isSquareSafe(sudokuEasy, 0, 0, 3));
        System.out.println("false:" + Safety.isSquareSafe(sudokuEasy, 0, 0, 7));

        System.out.println("true:" + Safety.isValidPlacement(sudokuEasy, 0, 0,3));
        System.out.println("false:" + Safety.isValidPlacement(sudokuEasy, 0, 0,7));
        System.out.println("false:" + Safety.isValidPlacement(sudokuEasy, 0, 0,1));

        //test solver
        System.out.println("true:" + Solver.solveBoard(sudokuEasy));
        Solver.printBoard(sudokuGenerated50);
        Solver.printBoard(sudokuGenerated80);
        Solver.printBoard(sudokuGenerated);
        Solver.printBoard(sudokuEasy);
        Solver.printBoard(sudokuEvil);
        
        //test generator
        int[][] sudoku = Generator.generateSudoku(40);

        for (int[] row : sudoku) {
            for (int cell : row) {
                System.out.print(cell + ","); //created that way to copy paste more easily
            }
            System.out.println();
        }
        Solver.printBoard(sudoku);

        int[][] sudoku2 = Generator.generateSudoku(40);
        Solver.printBoard(sudoku2);

    }
}
