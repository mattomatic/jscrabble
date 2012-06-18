import java.util.*;

public class Dictionary 
{
    Set<String> words;
    
    public Dictionary(String inputFile)
    {
    	this.words = new HashSet<String>();
    	LineReader reader = new LineReader(inputFile);
    	
    	String line;
    	while ((line = reader.readLine()) != null)
    	{
    		this.words.add(line);
    	}
    }
    
    public Boolean exists(String word)
    {
    	return this.words.contains(word);
    }
    
    public Iterable<String> getWords()
    {
    	return this.words;
    }
}
