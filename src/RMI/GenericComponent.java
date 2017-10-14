package RMI;

import java.io.Serializable;

public class GenericComponent implements Serializable
{
	private static final long serialVersionUID = 0; // First version, required for serialization

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
