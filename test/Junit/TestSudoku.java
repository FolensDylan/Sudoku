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
    private Sudoku s2x3;
    private Sudoku s3x2;
    private Sudoku s3x3;
    
    private int anyValidRow;
    private int anyValidColumn;
    private int anyValidValue;
    
    private int anInvalidRow;
    private int anInvalidColumn;
    private int anInvalidValue;
    
    @Before
    public void setup()
    {
        s2x3 = new Sudoku(2, 3);
        s3x2 = new Sudoku(3, 2);
        s3x3 = new Sudoku(3, 3);
        
        anyValidRow = 1;//3;
        anyValidColumn = 5;//4;
        anyValidValue = 6;
        
        anInvalidRow = -1;
        anInvalidColumn = -1;
        anInvalidValue = -1;

    }
    
    @Test
    public void testCreateSudoku()
    {
        Assert.assertNotNull(s3x2);
    }
    
    @Test 
    public void testCreateSudoku2By3() 
    {
        Assert.assertEquals("-----------------\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "-----------------\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "-----------------\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "| 0 0 0 | 0 0 0 |\n"
                          + "-----------------", s2x3.toString());
                    
    }
    
    @Test 
    public void testCreateSudoku3By2() 
    {
        Assert.assertEquals("-------------------\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "-------------------\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "| 0 0 | 0 0 | 0 0 |\n"
                          + "-------------------", s3x2.toString());
                    
    }
    
    @Test 
    public void testCreateSudoku3By3() 
    {  
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
                          + "-------------------------", s3x3.toString());
                    
    }
    
    @Test
    public void testReadSudokuFromFile()
    {
        Sudoku s = new Sudoku("data/test.sudoku.txt");
        
        Assert.assertEquals(1, s.getValue(1, 1));
        Assert.assertEquals(1, s.getValue(4, 2));
        Assert.assertEquals(3, s.getValue(6, 6));
    }
    
    @Test
    public void testSetAndGetValueWithNormalValue()
    {
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anyValidColumn));
        
        s3x2.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertEquals(anyValidValue, s3x2.getValue(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testSetValueWithInvalidValue()
    {   
        s3x2.setValue(anyValidRow, anyValidColumn, anInvalidValue);
        
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testSetAndGetValueWithInvalidRow()
    {   
        s3x2.setValue(anInvalidRow, anyValidColumn, anyValidValue);
        
        Assert.assertEquals(Sudoku.EMPTY, s3x2.getValue(anInvalidRow, anyValidColumn));
    }
    
    @Test
    public void testSetAndGetValueWithInvalidColumn()
    {     
        s3x2.setValue(anyValidRow, anInvalidColumn, anyValidValue);
        
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anInvalidColumn));
        Assert.assertEquals(Sudoku.EMPTY, s3x2.getValue(anyValidRow, anInvalidColumn));
    }
    
    @Test
    public void testEmptyCellNormally()
    {
        s3x2.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        s3x2.empty(anyValidRow, anyValidColumn);
        
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anyValidColumn));
    }
    
    @Test
    public void testEmptyCellWithInValidRow()
    {
        s3x2.empty(anInvalidRow, anyValidColumn);
        
        Assert.assertTrue(s3x2.isEmpty(anInvalidRow, anyValidColumn));
    }
    
    @Test
    public void testEmptyCellWithInValidColumn()
    {
        s3x2.empty(anyValidRow, anInvalidColumn);
        
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anInvalidColumn));
    }
    
    @Test
    public void testIsValidValueWithValidValue()
    {       
        Assert.assertTrue(s3x2.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForRow()
    {
        int anyOtherValidColumn = 6;
        
        s3x2.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s3x2.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s3x2.isValidValue(anyValidRow, anyOtherValidColumn, anyValidValue));
        
        s3x2.setValue(anyValidRow, anyOtherValidColumn, anyValidValue);
       
        Assert.assertTrue(s3x2.isEmpty(anyValidRow, anyOtherValidColumn));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForColumn()
    {
        int anyOtherValidRow = 6;
        
        s3x2.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s3x2.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s3x2.isValidValue(anyOtherValidRow, anyValidColumn, anyValidValue));
        
        s3x2.setValue(anyOtherValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s3x2.isEmpty(anyOtherValidRow, anyValidColumn));
    }
    
    @Test
    public void testIsValidValueWithInvalidValueForBlock()
    {
        int anyOtherValidRowInSameBlock = 3;
        int anyOtherValidColumnInSameBlock = 6;

        s3x2.setValue(anyValidRow, anyValidColumn, anyValidValue);
        
        Assert.assertTrue(s3x2.isValidValue(anyValidRow, anyValidColumn, anyValidValue));
        Assert.assertFalse(s3x2.isValidValue(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock, anyValidValue));
        
        s3x2.setValue(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock, anyValidValue);
        
        Assert.assertTrue(s3x2.isEmpty(anyOtherValidRowInSameBlock, anyOtherValidColumnInSameBlock));
    }
    
    @Test
    public void testVopyConstructor()
    {
        Sudoku origin = s2x3;
        origin.setValue(1, 1, anyValidValue);
        origin.setValue(4, 5, anyValidValue);
        origin.setValue(6, 6, anyValidValue);
        
        Sudoku copy = new Sudoku(origin);
        
        Assert.assertEquals(anyValidValue, copy.getValue(1, 1));
        Assert.assertEquals(anyValidValue, copy.getValue(4, 5));
        Assert.assertEquals(anyValidValue, copy.getValue(6, 6));
        Assert.assertTrue(copy.equals(origin));
    }
    
    @Test
    public void testSudokuUndo()
    {
        s2x3.setValue(1, 1, 1);
        s2x3.setValue(4, 5, 3);
        s2x3.setValue(6, 6, 6);
        
        s2x3.undo();
        
        Assert.assertEquals(1, s2x3.getValue(1, 1));
        Assert.assertEquals(3, s2x3.getValue(4, 5));
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(6, 6));
        
        s2x3.undo();
        
        Assert.assertEquals(1, s2x3.getValue(1, 1));
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(4, 5));
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(6, 6));
        
        s2x3.undo();
        
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(1, 1));
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(4, 5));
        Assert.assertEquals(Sudoku.EMPTY, s2x3.getValue(6, 6));
        
        s2x3.undo();
    }
}
