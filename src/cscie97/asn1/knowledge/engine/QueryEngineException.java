package cscie97.asn1.knowledge.engine;

public class QueryEngineException extends Exception
{
	private static final long serialVersionUID = -3516534599247815129L;
	
	public QueryEngineException()
	{ 
		super();
	}
	public QueryEngineException(String message) 
	{
		super(message);
	}
	public QueryEngineException(String message, Throwable cause)
	{ 
		super(message, cause);
	}
	public QueryEngineException(Throwable cause)
	{
		super(cause); 
	}

}
