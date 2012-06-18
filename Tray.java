
public class Tray 
{   
    String letters;
    
    public Tray(String letters)
    {
        this.letters = letters;
    }
    
    public String getLetters()
    {
        return this.letters;
    }
    
    public void Remove(String letter)
    {
        this.letters.replaceFirst(letter, "");
    }
}
