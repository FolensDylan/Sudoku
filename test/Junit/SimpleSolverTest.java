/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Junit;

import classes.SimpleSolver;
import classes.Sudoku;
import org.junit.*;

/**
 *
 * @author Alternatief
 */
public class SimpleSolverTest {
    
    @Test
    public void testSolve()
    {
        Sudoku s = new Sudoku("data/small.sudoku.txt");
        SimpleSolver ss = new SimpleSolver();
        
        s = ss.Solve(s);
        
        System.out.println(s.toString());
    }
    
}
