import java.util.*;

public class FixBuilder {
	private static final String FIX_SEPERATOR = "\1";
	private List<FixField> mFields;
	
	public FixBuilder()
	{
		mFields = new LinkedList<FixField>();
	}
	
	public void addField(FixField field)
	{
		assert !mFields.contains(field);
		mFields.add(field);
	}
	
	public void updateField(FixField field)
	{
		assert mFields.contains(field);
		FixField oldField = mFields.get(mFields.indexOf(field)); 
		oldField.setFieldFrom(field);
	} 
}
