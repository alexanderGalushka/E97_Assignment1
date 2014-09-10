package cscie97.asn1.knowledge.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Importer
{
	
	private List<Triple> listOfTriples;
	private Utilities util; 	
	private BufferedReader br;
	
	public Importer()
	{
		listOfTriples = new LinkedList<Triple>();
		util = new Utilities();
	}
	
	public void importTripleFile ( String fileName ) throws ImportException
	{
		// Construct BufferedReader from FileReader
		try
		{
			br = new BufferedReader( new FileReader( fileName ) );
		}
		catch (IOException e)
		{
			throw new ImportException ( e.toString() );
		}
		 
		String line = null;
		try
		{
			while ( ( line = br.readLine() ) != null )
			{
				String[] tempResult = line.split( " " );
				if ( tempResult.length == 3 && !util.arrayContains( tempResult, "?" ) )
				{
					//creating duplicate instances???
					Node mySubject = new Node ( tempResult[0].trim() );
					Predicate myPredicate = new Predicate ( tempResult[1].trim() );
					Node myObbject = new Node ( util.removeLastChar (tempResult[2].trim() ) );
					
					Triple myTriple = new Triple ( mySubject, myPredicate, myObbject );
					listOfTriples.add( myTriple );				
				}
				
			}
		} 
		catch (IOException e)
		{

			throw new ImportException ( e.toString() );
		}
		
		try
		{
			br.close();
		}
		catch (IOException e)
		{

			throw new ImportException ( e.toString() );
		}
		
		KnowledgeGraph.getInstance().importTriples ( listOfTriples );
	}
}
