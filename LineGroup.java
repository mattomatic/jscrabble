
public class LineGroup {
    String lhs;
    String group;
    String rhs;
    
    public LineGroup(String lhs, String group, String rhs)
    {
        this.lhs = lhs;
        this.group = group;
        this.rhs = rhs;
    }
    
    public String toString()
    {
        return String.format("(%s) (%s) (%s)", this.lhs, this.group, this.rhs);
    }
}
