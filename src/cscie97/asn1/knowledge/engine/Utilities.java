package cscie97.asn1.knowledge.engine;

public class Utilities
{
	public boolean arrayContains( String[] array, String target )
	{
		for(String s: array)
		{
			if( s.equals( target ) )
				return true;
		}
		return false;
	}

	public String removeLastChar(String s) {
	    if (!s.isEmpty() && s != null)
	    {
	        s = s.substring(0, s.length()-1);
	    }
	    return s;
	}
}
