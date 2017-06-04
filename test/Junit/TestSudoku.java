/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Junit;

import classes.Sudoku;
import org.junit.*;

/**
 *
 * @author Alternatief
 */
public class TestSudoku 
{
    
    @Test
    public void testCreateSudoku() 
    {
        Sudoku s = new Sudoku();
        
        Assert.assertNotNull(s);
    }
    
}
