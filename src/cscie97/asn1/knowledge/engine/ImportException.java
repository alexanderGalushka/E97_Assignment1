package cscie97.asn1.knowledge.engine;

public class ImportException extends Exception
{

	private static final long serialVersionUID = 6583817743178913990L;
	public ImportException()
	{ 
		super();
	}
	public ImportException(String message) 
	{
		super(message);
	}
	public ImportException(String message, Throwable cause)
	{ 
		super(message, cause);
	}
	public ImportException(Throwable cause)
	{
		super(cause); 
	}

}
