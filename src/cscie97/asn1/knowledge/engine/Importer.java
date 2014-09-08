package cscie97.asn1.knowledge.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;



public class Importer
{
	
	public List<Triple> listOfTriples = new LinkedList<Triple>();
	
	public void importTripleFile ( String fileName ) throws IOException
	{
		// Construct BufferedReader from FileReader
		BufferedReader br = new BufferedReader( new FileReader( fileName ) );
	 
		String line = null;
		while ( ( line = br.readLine() ) != null )
		{
			String[] tempResult = line.split( " " );
			if ( tempResult.length == 3 && !arrayContains( tempResult, "?" ) )
			{
				//creating duplicate instances???
				Node mySubject = new Node ( tempResult[0].trim() );
				Predicate myPredicate = new Predicate ( tempResult[1].trim() );
				Node myObbject = new Node ( removeLastChar (tempResult[2].trim() ) );
				
				Triple myTriple = new Triple ( mySubject, myPredicate, myObbject );
				listOfTriples.add(myTriple);				
			}
			
		}
		br.close();
		
		KnowledgeGraph.getInstance().importTriples ( listOfTriples );
	}
	
	private static boolean arrayContains( String[] array, String target )
	{
		for(String s: array)
		{
			if( s.equals( target ) )
				return true;
		}
		return false;
	}

	private static String removeLastChar(String s) {
	    if (!s.isEmpty() && s != null)
	    {
	        s = s.substring(0, s.length()-1);
	    }
	    return s;
	}
}
