
public class BoardReader 
{   
    final int rows = 15;
    final int cols = 15;
    
    public Board readBoard(String inputFile)
    {
    	LineReader reader = new LineReader(inputFile);
    	return readBoard(reader);
    }
    
    private Board readBoard(LineReader reader)
    {
        Character[][] board = new Character[this.rows][this.cols];
        int rowNum = 0;
        String row;
        
        while ((row = reader.readLine()) != null)
        {
            assert row.length() == rows;
            
            for (int colNum = 0; colNum < this.cols; colNum++)
            {
                board[rowNum][colNum] = row.charAt(colNum);
            }
            
            rowNum += 1;
        }
        
        return new Board(board);
    }
}
