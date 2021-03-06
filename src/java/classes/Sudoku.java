package classes;

/**
 *
 * @author Alternatief
 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// FILMPJE 13 SUDOKU

public class Sudoku
{
    private int[][] cells;
    private int blockheight;
    private int blockwidth;
    private int size;
    private Stack<Change> changes;
    public static int EMPTY = 0;
    
    private void initialize(int blockheight, int blockwidth)
    {
        this.blockheight = blockheight;
        this.blockwidth = blockwidth;
        size = blockheight * blockwidth;
        cells = new int[size][size];
        changes = new Stack<Change>();
    }
    
    public Sudoku(int blockheight, int blockwidth)
    {
        initialize(blockheight, blockwidth);
    }
    
    public Sudoku(Sudoku origin)
    {
        initialize(origin.blockheight, origin.blockwidth);
        for(int r = 0; r < size; r++)
        {
            for(int c = 0; c < size; c++)
            {
                cells[r][c] = origin.cells[r][c];
            }
        }
    }
    
    public Sudoku(String file)
    {
        Path path = Paths.get(file);
        
        try
        {
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            String[] numberChars = content.split("\\D+");
            initialize(Integer.parseInt(numberChars[0]), Integer.parseInt(numberChars[1]));
            for(int index = 0; index < numberChars.length - 2; index++)
            {
                setValue(1 + index / size, 1 + index % size, Integer.parseInt(numberChars[index + 2]));
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e.toString());
        }
    }
    
    @Override
    public boolean equals(Object theOtherObject)
    {
        if(theOtherObject == this)
        {
            return true;
        }
        if(theOtherObject == null)
        {
            return false;
        }
        if(!(theOtherObject instanceof Sudoku))
        {
            return false;
        }
        Sudoku theOtherSudoku = (Sudoku) theOtherObject;
        if(blockheight != theOtherSudoku.blockheight || blockwidth != theOtherSudoku.blockwidth)
        {
            return false;
        }
        for(int r = 0; r < size; r++)
        {
            for(int c = 0; c < size; c++)
            {
                if(cells[r][c] != theOtherSudoku.cells[r][c])
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Arrays.deepHashCode(this.cells);
        hash = 59 * hash + this.blockheight;
        hash = 59 * hash + this.blockwidth;
        return hash;
    }
    
    public int getBlockWitdth()
    {
        return blockwidth;
    }
    
    public int getBlockHeight()
    {
        return blockheight;
    }
    
    public int getSize() 
    {
        return size;
    }
    
    private boolean isValidIndex(int index)
    {
        return 0 < index && index <= size;
    }
    
    public boolean isValidValue(int row, int column, int value)
    {
        if(0 > value || value > size)
        {
            return false;
        }
        if(getValue(row, column) == value || value == EMPTY)
        {
            return true;
        }
        
        //check row + check column
        for(int i = 1; i <= size; i++)
        {
            if(getValue(row, i) == value)
            {
                return false;
            }
            if(getValue(i, column) == value)
            {
                return false;
            }
        }
        
        //Check block
        int topRowOfBlock = 1 + blockheight * ((row - 1) / blockheight);
        int leftColumnOfBlock = 1 + blockwidth * ((column - 1) / blockwidth);
        
        for(int r = 0; r < blockheight; r++)
        {
            for(int c = 0; c < blockwidth; c++)
            {
                if(getValue(topRowOfBlock + r, leftColumnOfBlock + c) == value)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isEmpty(int row, int column)
    {
        if(isValidIndex(row) && isValidIndex(column))
        {
            return cells[row - 1][column - 1] == EMPTY;
        }
        return true;
    }
    
    public void empty(int row, int column)
    {
        setValue(row, column, EMPTY);
    }
    
    public int getValue(int row, int column)
    {
        if(isValidIndex(row) && isValidIndex(column))
        {
            return cells[row - 1][column - 1];
        }
        return EMPTY;
    }
    
     public void setValue(int row, int column, int value)
    {
        if(isValidValue(row, column, value) && isValidIndex(row) && isValidIndex(column))
        {
            changes.push(new Change(row, column, getValue(row, column), value));
            cells[row - 1][column - 1] = value;
        }
    }
     
    public void undo()
    {
        if(!changes.empty())
        {
        Change lastChange = changes.pop();
        cells[lastChange.getRow() - 1][lastChange.getColumn() - 1] = lastChange.getOldValue();
        }
    }
    
    @Override
    public String toString() 
    {
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < 2 * (size + blockheight) + 1; i++)
        {
           b.append("-");
        }
        String lineSeparator = b.toString();
        b = new StringBuilder();
        for(int r = 0; r < size; r++)
        {
            if(r % blockheight == 0)
            {
                b.append(lineSeparator);
                b.append("\n");
            }
            for(int c = 0; c < size; c++)
            {
                if(c % blockwidth == 0)
                {
                    b.append("| ");
                }
                b.append(cells[r][c]);
                b.append(" ");
            }
            b.append("|\n");
        }
        b.append(lineSeparator);
        return b.toString();
    }
    
}
