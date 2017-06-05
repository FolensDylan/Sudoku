
package classes;

/**
 *
 * @author Alternatief
 */
public class Change 
{
    private final int row;
    private final int column;
    private final int value;
    private final int oldValue;
    
    public Change(int row, int column, int oldValue, int value)
    {
        this.row = row;
        this.column = column;
        this.value = value;
        this.oldValue = oldValue;
    }
    
    @Override
    public String toString()
    {
        StringBuilder res  = new StringBuilder();
        
        res.append("[");
        res.append(row);
        res.append("]");
        res.append("[");
        res.append(column);
        res.append("] : ");
        res.append(oldValue);
        res.append(" --> ");
        res.append(value);       
        
        return res.toString();
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getColumn()
    {
        return column;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public int getOldValue()
    {
        return oldValue;
    }
}
