package com.matthewcsanders.jscrabble;
import java.util.*;

public class BoardValidator
{
    Dictionary mDictionary;
    
    public BoardValidator(Dictionary dictionary)
    {
        mDictionary = dictionary;
    }
    
    public Boolean isValid(Board board)
    {
        Collection<String> lines = new LinkedList<String>();
        lines.addAll(board.getRows());
        lines.addAll(board.getCols());
        
        for (String line: lines)
        {
            if (!this.isValid(line))
            {
                return false;
            }
        }
        
        return true;
    }
    
    private Boolean isValid(String line)
    {
        for (String word: line.split("[.]+"))
        {
            if (word.isEmpty()) continue;
            
            if (!this.mDictionary.exists(word))
            {
                return false;
            }            
        }
        
        return true;
    }
}
