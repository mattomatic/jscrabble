
class main
{    
    public static void main(String[] args)
    {
        BoardReader r = new BoardReader();
        Board board = r.readBoard("../boards/test1.txt");
        Tray tray = new Tray("aeioumnp");
        Dictionary dict = new Dictionary("/usr/share/dict/words");
        
        BoardValidator bv = new BoardValidator();
        LineSplitter ls = new LineSplitter();
        LineGenerator lg = new LineGenerator(dict, ls);
        BoardGenerator bg = new BoardGenerator(lg, bv);
        
        for (Board newBoard: bg.generateBoards(board, tray))
        {
            System.out.println(newBoard.toString());
        }
    }
}
