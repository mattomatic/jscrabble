import java.util.*;

public class Board 
{   
    Character[][] board;
    final int rows = 15;
    final int cols = 15;
    
    public Board(Character[][] board)
    {
        this.board = board;
    }
    
    public int getNumRows()
    {
        return this.rows;
    }
    
    public int getNumCols()
    {
        return this.cols;
    }
    
    public String getRow(int rowNum)
    {
        String row = "";
        
        for (int i = 0; i < this.cols; i++)
        {
            row += this.board[rowNum][i];
        }
        
        return row;
    }
    
    public String getCol(int colNum)
    {
        String col = "";
        
        for (int i = 0; i < this.rows; i++)
        {
            col += this.board[i][colNum];
        }
        
        return col;
    }
    
    public Collection<String> getRows()
    {
        Collection<String> rows = new LinkedList<String>();
        
        for (int row = 0; row < this.rows; row++)
        {
            rows.add(this.getRow(row));
        }
        
        return rows;
    }
    
    public Collection<String> getCols()
    {
        Collection<String> cols = new LinkedList<String>();
        
        for (int col = 0; col < this.cols; col++)
        {
            cols.add(this.getCol(col));
        }
        
        return cols;
    }
    
    public void setRow(int rowNum, String row)
    {
        assert rowNum >= 0 && rowNum < this.rows;
        assert row.length() == this.cols;
        
        for (int colNum = 0; colNum < this.cols; colNum++)
        {
            this.board[rowNum][colNum] = row.charAt(colNum);
        }
    }
    
    public void setCol(int colNum, String col)
    {
        assert colNum >= 0 && colNum < this.cols;
        assert col.length() == this.rows;
        
        for (int rowNum = 0; rowNum < this.rows; rowNum++)
        {
            this.board[rowNum][colNum] = col.charAt(rowNum);
        }
    }
    
    public Board copy()
    {
        Character[][] board = new Character[this.rows][this.cols];
        
        for (int row = 0; row < this.rows; row++)
        {
            for (int col = 0; col < this.cols; col++)
            {
                board[row][col] = this.board[row][col];
            }
        }
        return new Board(board);
    }
    
    public String toString()
    {
        String string = "";
        
        for (int row = 0; row < this.rows; row++)
        {
            string += this.getRow(row);
            string += "\n";
        }
        
        return string;
    }
}
