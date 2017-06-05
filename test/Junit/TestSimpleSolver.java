package Junit;

/**
 *
 * @author Alternatief
 */
import classes.SimpleSolver;
import classes.Sudoku;
import org.junit.*;

public class TestSimpleSolver 
{
    @Test
    public void testSolve()
    {
        Sudoku s = new Sudoku("data/small.sudoku.txt");
        SimpleSolver ss = new SimpleSolver();
        
        s = ss.Solve(s);
        
        System.out.println(s.toString());
    }
}
