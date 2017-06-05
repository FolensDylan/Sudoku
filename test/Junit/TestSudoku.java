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
    public void testCreateSudoku3By2() 
    {
        Sudoku s = new Sudoku(3, 2);
        
//        System.err.print(s.toString());
        
        Assert.assertEquals("-------------------\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "-------------------\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "-------------------", s.toString());
                    
    }
    
    @Test 
    public void testCreateSudoku3By3() 
    {
        Sudoku s = new Sudoku(3, 3);
        
//        System.err.print(s.toString());
        
        Assert.assertEquals("-------------------------\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "-------------------------\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "-------------------------\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 | 0 0 0 |\n"
                          + "-------------------------", s.toString());
                    
    }
    
    @Test
    public void testReadSudokuFromFile()
    {
        Sudoku s = new Sudoku("data/test.sudoku");
        
        Assert.assertEquals(1, s.getValue(1, 1));
        Assert.assertEquals(3, s.getValue(6, 6));
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
    
    @Test
    public void testIsValidValueWithValidValue()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 4;
        int anyValidValue = 6;
        
        Assert.assertTrue(s.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForRow()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 6;
        int anyOtherValidColumn = 4;
        int anyValidValue = 6;
        s.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s.isValidValue(anyValidRow, anyOtherValidColumn, anyValidValue));
        
        s.setValue(anyValidRow, anyOtherValidColumn, anyValidValue);
       
        Assert.assertTrue(s.isEmpty(anyValidRow, anyOtherValidColumn));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForColumn()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 3;
        int anyValidColumn = 4;
        int anyOtherValidRow = 6;
        int anyValidValue = 6;
        s.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s.isValidValue(anyOtherValidRow, anyValidColumn, anyValidValue));
        
        s.setValue(anyOtherValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s.isEmpty(anyOtherValidRow, anyValidColumn));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForBlock()
    {
        Sudoku s = new Sudoku(3, 2);
        int anyValidRow = 1;
        int anyValidColumn = 5;
        int anyOtherValidRowInSameBlock = 3;
        int anyOtherValidColumnInSameBlock = 6;
        int anyValidValue = 6;
        s.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s.isValidValue(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock, anyValidValue));
        
        s.setValue(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock, anyValidValue);
        
        Assert.assertTrue(s.isEmpty(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock));
    }
}
