package RMI;

public class GenericComponent
{
	private String type;

	public GenericComponent ()
	{
		this.type = ComponentKeys.GENERIC_KEY;
	}

	public GenericComponent (String type)
	{
		this.type = type;
	}

	public String getType ()
	{
		return this.type;
	}
}
