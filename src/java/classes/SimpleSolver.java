package classes;

/**
 *
 * @author Alternatief
 */
public class SimpleSolver 
{
    public Sudoku Solve(Sudoku SudokuToSolve)
    {
        Sudoku solution = new Sudoku(SudokuToSolve);
        int size = solution.getSize();
        int numberOfCells = size * size;
        
        for(int i = 0; i < numberOfCells; i++)
        {
            int row = 1 + i / size;
            int column = 1 + i % size;
            System.err.println(row + ", " + column);
        }
        
        return solution;
    }
   
}
