/*
package classes;

/**
 *
 * @author Alternatief
 */
public class Change 
{
    private int row;
    private int column;
    private int value;
    private int oldValue;
    
    public Change(int row, int column, int value, int oldValue)
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
}
