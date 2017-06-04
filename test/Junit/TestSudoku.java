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
    
    @Test //TO DO
    public void testCreateSudoku() 
    {
        Sudoku s = new Sudoku(3, 2);
        
        System.err.print(s.toString());
        
        Assert.assertNotNull(s);
    }
    
    @Test
    public void testSetAndGetValueWithNormalValue()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 4;
        int anyValidValue = 6;
        
        s.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertEquals(anyValidValue, s.getValue(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testSetValueWithInvalidValue()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 4;
        int anInvalidValue = -1;
        
        s.setValue(anyValidRow, anyValidColumn, anInvalidValue);
        
        Assert.assertTrue(s.isEmpty(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testSetAndGetValueWithInvalidRow()
    {
        Sudoku s = new Sudoku(3, 2);
        int anInvalidRow = -1;
        int anyValidColumn = 4;
        int anyValidValue = 6;
        
        s.setValue(anInvalidRow, anyValidColumn, anyValidValue);
        
        Assert.assertEquals(Sudoku.EMPTY, s.getValue(anInvalidRow, anyValidColumn));
    }
    
    @Test
    public void testSetAndGetValueWithInvalidColumn()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anInvalidColumn = -1;
        int anyValidValue = 6;
        
        s.setValue(anyValidRow, anInvalidColumn, anyValidValue);
        Assert.assertTrue(s.isEmpty(anyValidRow, anInvalidColumn));
        Assert.assertEquals(Sudoku.EMPTY, s.getValue(anyValidRow, anInvalidColumn));
    }
    
    @Test
    public void testEmptyCell()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 4;
        int anyValidValue = 6;
        s.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        s.empty(anyValidRow, anyValidColumn);
        
        Assert.assertTrue(s.isEmpty(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testEmptyCellWithInValidRow()
    {
        Sudoku s = new Sudoku(3, 2);
        int anInValidRow = -1;
        int anyValidColumn = 4;
        int anyValidValue = 6;
        
        s.empty(anInValidRow, anyValidColumn);
        
        Assert.assertTrue(s.isEmpty(anInValidRow, anyValidColumn));
    }
    
    @Test
    public void testEmptyCellWithInValidColumn()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anInvalidColumn = -1;
        int anyValidValue = 6;
        
        s.empty(anyValidRow, anInvalidColumn);
        
        Assert.assertTrue(s.isEmpty(anyValidRow, anInvalidColumn));
    }
}
