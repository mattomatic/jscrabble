import java.util.*;

public class BoardGenerator 
{   
    LineGenerator lineGenerator;
    BoardValidator boardValidator;
    
    public BoardGenerator(LineGenerator lineGenerator, BoardValidator boardValidator)
    {
        this.lineGenerator = lineGenerator;
        this.boardValidator = boardValidator;
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
            for(String line: this.lineGenerator.generateLines(board.getRow(row), tray))
            {
                Board newBoard = this.makeBoardFromRow(board, row, line);
                
                if (this.boardValidator.isValid(newBoard))
                {
                    System.out.println(newBoard);
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
            for(String line: this.lineGenerator.generateLines(board.getCol(col), tray))
            {
                Board newBoard = this.makeBoardFromCol(board, col, line);
                
                if (this.boardValidator.isValid(newBoard))
                {
                    System.out.println(newBoard);
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
    
    public static void main(String[] args)
    {
        BoardReader r = new BoardReader();
        Board board = r.readBoard("/Users/mattomatic/Projects/scrabble/boards/test1.txt");
        Tray tray = new Tray("aeioumnp");
        Dictionary dict = new Dictionary("/usr/share/dict/words");
        
        BoardValidator bv = new BoardValidator(dict);
        LineSplitter ls = new LineSplitter();
        LineGenerator lg = new LineGenerator(dict, ls);
        BoardGenerator bg = new BoardGenerator(lg, bv);
        
        for (Board newBoard: bg.generateBoards(board, tray))
        {
            System.out.println("---");
            System.out.println(newBoard.toString());
        }
        
    }
}
