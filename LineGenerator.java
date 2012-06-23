import java.util.*;

public class LineGenerator 
{  
    Dictionary mDictionary;
    LineSplitter mLineSplitter;
    
    public LineGenerator(Dictionary dictionary, LineSplitter lineSplitter)
    {
        this.mDictionary = dictionary;
        this.mLineSplitter = lineSplitter;
    }
    
    public Collection<String> generateLines(String line, Tray tray)
    {
        Collection<String> lines = new LinkedList<String>();
        
        for (LineGroup group: this.mLineSplitter.splitLine(line))
        {
            lines.addAll(this.getLines(group, tray));
        }
        
        return lines;
    }
    
    private Collection<String> getLines(LineGroup group, Tray tray)
    {
        Collection<String> lines = new LinkedList<String>();
        
        for (String word: this.getWords(group.group, tray))
        {
            for (String line: this.getLines(group.group, word))
            {
                lines.add(group.lhs + line + group.rhs);
            }
        }
        
        return lines;
    }
    
    private Collection<String> getWords(String line, Tray tray)
    {
        List<String> words = new LinkedList<String>();
        String wordRegex = this.getWordRegex(line, tray);
        
        for (String word: this.mDictionary.getWords())
        {
            if (word.matches(wordRegex) && this.isValid(word, line, tray))
            {
                words.add(word);
            }
        }
        
        return words;
    }
    
    private Boolean isValid(String word, String line, Tray tray)
    {        
        // check that we haven't used more letters than we have to use
        String letters = line.replace(".", "") + tray.getLetters();
        for (int i = 0; i < word.length(); i++)
        {
            String letter = word.substring(i, i + 1);
            if (!letters.contains(letter))
            {
                return false;
            }
            letters = letters.replaceFirst(letter, "");
        }
        
        return true;
    }
    
    private Collection<String> getLines(String line, String word)
    {
        Collection<String> lines = new LinkedList<String>();
        
        for (int i = 0; i <= line.length() - word.length(); i++)
        {
            String newLine = this.getLine(word, i, line.length() - i - word.length());
            
            if (newLine.matches(line))
            {
                lines.add(newLine);
            }
        }
        
        return lines;
    }
    
    private String getLine(String word, int leftPad, int rightPad)
    {
        return String.format("%s%s%s", this.getPad(leftPad, '.'), word,
                this.getPad(rightPad, '.'));
    }
    
    private String getPad(int pad, char padChar)
    {
        if (pad == 0) return "";
        String fmt = String.format("%%%ds", pad);
        return String.format(fmt, "").replace(' ', padChar);
    }
    
    private String getWordRegex(String line, Tray tray)
    {
        String group = String.format("[%s]?", tray.getLetters());
        line = line.replaceAll("[^.]", "[$0]?");
        line = line.replaceAll("[.]", group);
        line = String.format("^%s$", line);
        return line;
    }
    
    public static void main(String[] args)
    {
        // ..hong..kong..phoey.. ->
        // ..hong..kong..phoey..
        // .thong..kong..phoey..
        // ..hong..kongu.phoey..
        Dictionary d = new Dictionary("/usr/share/dict/words");
        LineSplitter ls = new LineSplitter();
        LineGenerator lg = new LineGenerator(d, ls);
        
        for (String line: lg.generateLines("..hong..kong..phoey..", new Tray("tileu")))
        {
            System.out.println(line);
        }
    }    
}
