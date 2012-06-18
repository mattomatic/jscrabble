
public class FixField
{
	String tag;
	String val;
	
	public FixField(String tag, String val)
	{
		this.tag = tag;
		this.val = val;
	}
	
	public void setFieldFrom(FixField field)
	{
		this.tag = field.tag;
	}
	
	static public Boolean equals(FixField lhs, FixField rhs)
	{
		return lhs.tag == rhs.tag;
	}
}