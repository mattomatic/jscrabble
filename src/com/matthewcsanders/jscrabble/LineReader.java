package com.matthewcsanders.jscrabble;
import java.io.*;

public class LineReader 
{   
    BufferedReader reader;
    
    LineReader(String inputFile)
    {
        try 
        {
            FileInputStream fis = new FileInputStream(inputFile);
            DataInputStream dis = new DataInputStream(fis);
            InputStreamReader isr = new InputStreamReader(dis);
            this.reader = new BufferedReader(isr);
        } 
        catch (IOException e) 
        {
            throw new RuntimeException();
        }
    }
    
    public String readLine()
    {
        try
        {
            return reader.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
    }
}
