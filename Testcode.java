public class Testcode {
    public static void main(String[] args) {
        //safety
        int sudokuEasy [][] = { {0,4,0,0,0,7,0,0,0},
                                {0,0,1,8,9,4,0,0,0},
                                {8,2,7,0,6,3,0,9,0},
                                {0,0,0,7,0,8,0,0,4},
                                {0,8,5,0,4,9,6,0,7},
                                {0,7,0,6,5,1,2,8,0},
                                {0,9,6,3,8,2,5,0,0},
                                {7,0,0,9,1,0,0,0,0},
                                {0,0,0,0,0,5,0,0,3}};
        System.out.println(SudokuSolver.isSafe(sudokuEasy, 8, 6, 6));
    }
}
