package classes;

/**
 *
 * @author Alternatief
 */
public class Sudoku
{
    private int[][] cells;
    private int blockheight;
    private int blockwidth;
    private int size;
    public static int EMPTY = 0;
    
    public Sudoku(int blockheight, int blockwidth)
    {
        this.blockheight = blockheight;
        this.blockwidth = blockwidth;
        size = blockheight * blockwidth;
        cells = new int[size][size];
    }
    
    public int getBlockWitdth()
    {
        return blockwidth;
    }
    
    public int getBlockHeight()
    {
        return blockheight;
    }
    
    private boolean isValidIndex(int index)
    {
        return 0 < index && index <= size;
    }
    
    private boolean isValidValue(int row, int column, int value)
    {
        return 0 < value && value <= size;
        //TODO: add sudoku rules
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
        if(isValidIndex(row) && isValidIndex(column))
        {
            cells[row - 1][column - 1] = EMPTY;
        }
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
            cells[row - 1][column - 1] = value;
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
