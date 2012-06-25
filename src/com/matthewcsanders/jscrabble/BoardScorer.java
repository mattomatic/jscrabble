package com.matthewcsanders.jscrabble;
import java.util.*;

public class BoardScorer {
    Dictionary mDictionary;
    WordFinder mWordFinder;
    
    public BoardScorer(Dictionary dictionary, WordFinder finder)
    {
        this.mDictionary = dictionary;
        this.mWordFinder = finder;
    }
    
    public int getScore(Board oldBoard, Board newBoard)
    {
        Collection<WordGroup> oldWords = this.mWordFinder.findWords(oldBoard);
        Collection<WordGroup> newWords = this.mWordFinder.findWords(newBoard);
        newWords.removeAll(oldWords);
        
        System.out.format("%d oldWords, %d newWords", oldWords.size(), newWords.size());
        
        for (WordGroup wg: newWords)
        {
            System.out.format("+%s\n", wg.word);
        }
        System.out.format("\n");
        return 0;
    }
}
