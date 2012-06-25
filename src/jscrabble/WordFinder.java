package jscrabble;
import java.util.*;
import java.util.regex.*;

public class WordFinder {
    public Collection<WordGroup> findWords(Board board)
    {
        Collection<WordGroup> words = new LinkedList<WordGroup>();
        
        for (int i = 0; i < board.getNumRows(); i++)
        {
            String row = board.getRow(i);
            words.addAll(this.getWordsFromRow(row, i));
        }
        
        for (int i = 0; i < board.getNumCols(); i++)
        {
            String col = board.getCol(i);
            words.addAll(this.getWordsFromCol(col, i));
        }
        
        return words;
    }
    
    private Collection<WordGroup> getWordsFromRow(String row, int rowNum)
    {
        Collection<WordGroup> wordGroups = new LinkedList<WordGroup>();
        Pattern pattern = Pattern.compile("[^.][^.]+");
        Matcher matcher = pattern.matcher(row);
        
        while (matcher.find())
        {
            String word = matcher.group();
            int col = matcher.start();
            WordGroup wg = new WordGroup(word, true, rowNum, col);
            wordGroups.add(wg);
        }
        
        return wordGroups;
    }
    
    private Collection<WordGroup> getWordsFromCol(String col, int colNum)
    {
        Collection<WordGroup> wordGroups = new LinkedList<WordGroup>();
        Pattern pattern = Pattern.compile("[^.][^.]+");
        Matcher matcher = pattern.matcher(col);
        
        while (matcher.find())
        {
            String word = matcher.group();
            int row = matcher.start();
            WordGroup wg = new WordGroup(word, true, row, colNum);
            wordGroups.add(wg);
        }
        
        return wordGroups;
    }
}
