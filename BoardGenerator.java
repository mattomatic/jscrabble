import java.util.*;

public class BoardGenerator 
{   
    LineGenerator mLineGenerator;
    BoardValidator mBoardValidator;
    
    public BoardGenerator(LineGenerator lineGenerator, BoardValidator boardValidator)
    {
        this.mLineGenerator = lineGenerator;
        this.mBoardValidator = boardValidator;
    }
    
    public Collection<Board> generateBoards(Board board, Tray tray)
    {
        Collection<Board> boards = new LinkedList<Board>();
        boards.addAll(this.generateRowBoards(board, tray));
        boards.addAll(this.generateColBoards(board, tray));
        return boards;
    }
    
    private Collection<Board> generateRowBoards(Board board, Tray tray)
    {
        List<Board> boards = new ArrayList<Board>();
        
        for (int row = 0; row < board.getNumRows(); row++)
        {
            for(String line: this.mLineGenerator.generateLines(board.getRow(row), tray))
            {
                Board newBoard = this.makeBoardFromRow(board, row, line);
                
                if (this.mBoardValidator.isValid(newBoard))
                {
                    boards.add(newBoard);    
                }
                
            }
        }
        
        return boards;
    }
    
    private Collection<Board> generateColBoards(Board board, Tray tray)
    {
        List<Board> boards = new ArrayList<Board>();
        
        for (int col = 0; col < board.getNumRows(); col++)
        {
            for(String line: this.mLineGenerator.generateLines(board.getCol(col), tray))
            {
                Board newBoard = this.makeBoardFromCol(board, col, line);
                
                if (this.mBoardValidator.isValid(newBoard))
                {
                    boards.add(newBoard);    
                }
            }
        }
        
        return boards;
    }
    
    private Board makeBoardFromRow(Board board, int rowNum, String line)
    {
        Board newBoard = board.copy();
        newBoard.setRow(rowNum, line);
        return newBoard;
    }
    
    private Board makeBoardFromCol(Board board, int colNum, String line)
    {
        Board newBoard = board.copy();
        newBoard.setCol(colNum, line);
        return newBoard;
    }
}
