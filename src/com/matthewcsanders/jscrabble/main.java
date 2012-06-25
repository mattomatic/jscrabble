package com.matthewcsanders.jscrabble;

import com.matthewcsanders.jscrabble.validators.Validator;
import com.matthewcsanders.jscrabble.validators.WordValidator;

class main
{    
    public static void main(String[] args)
    {
        BoardReader r = new BoardReader();
        Board board = r.readBoard("boards/test1.txt");
        Tray tray = new Tray("aeioumnp");
        Dictionary d = new Dictionary("/usr/share/dict/words");
        
        BoardValidator bv = new BoardValidator(d);
        LineSplitter ls = new LineSplitter();
        Validator val = new WordValidator(d.getWords());
        LineGenerator lg = new LineGenerator(d, ls, val);
        BoardGenerator bg = new BoardGenerator(lg, bv);
        
        WordFinder wf = new WordFinder();
        BoardScorer bs = new BoardScorer(d, wf);
        
        for (Board newBoard: bg.generateBoards(board, tray))
        {
            System.out.println("---");
            System.out.println(newBoard.toString());
            bs.getScore(board, newBoard);
        }
    }
}
