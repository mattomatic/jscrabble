package jscrabble;

public class WordGroup {
    String word;
    Boolean horizontal;
    int row;
    int col;
    
    public WordGroup(String word, Boolean horizontal, int row, int col)
    {
        this.word = word;
        this.horizontal = horizontal;
        this.row = row;
        this.col = col;
    }
    
    public boolean equals(WordGroup that)
    {
        return (this.word == that.word &&
                this.horizontal == that.horizontal &&
                this.row == that.row &&
                this.col == that.col);
    }
}
