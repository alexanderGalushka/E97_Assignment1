package cscie97.asn1.knowledge.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class QueryEngine
{
	
	private Utilities util;
	
	private List<Triple> listOfTriples;
	
	private BufferedReader br;
	
	public QueryEngine()
	{
		util = new Utilities();
		listOfTriples = new LinkedList<Triple>();
		
	}
	
	public void executeQuery ( String query ) throws QueryEngineException
	{
		String[] tempResult = query.split( " " );
		//make sure the query is correct
		if ( tempResult.length == 3)
		{
			Node subject_obj = new Node ( tempResult[0] );
			Predicate predicate_obj = new Predicate( tempResult[1] );
			Node object_obj = new Node ( tempResult[2] );
			Triple queryTriple = new Triple ( subject_obj, predicate_obj, object_obj );

			Set<Triple> setOfTriples = KnowledgeGraph.getInstance().executeQuery( queryTriple ) ;
			
			System.out.println( query );
			
	        for (Triple triple : setOfTriples)
	        {
	        	System.out.println( triple.getIdentifier() );
	        }
	        
		}
		else
		{
			throw new QueryEngineException( "Incorrect query" );
		}
	}
	
	public void executeQueryFile ( String fileName ) throws QueryEngineException	
	{
		// Construct BufferedReader from FileReader
		try 
		{
			br = new BufferedReader( new FileReader( fileName ) );
		} 
		catch (FileNotFoundException e)
		{
			throw new QueryEngineException( e.toString() );
		}
	 
		String line = null;
		try
		{
			while ( ( line = br.readLine() ) != null )
			{
				String[] tempResult = line.split( " " );
				if ( tempResult.length == 3 )
				{
					//creating duplicate instances???
					Node mySubject = new Node ( tempResult[0].trim() );
					Predicate myPredicate = new Predicate ( tempResult[1].trim() );
					Node myObbject = new Node ( util.removeLastChar ( tempResult[2].trim() ) );
					
					Triple myTriple = new Triple ( mySubject, myPredicate, myObbject );
					listOfTriples.add( myTriple );				
				}
				
			}
		} 
		catch (IOException e)
		{
			throw new QueryEngineException( e.toString() );
		}
		try
		{
			br.close();
		}
		catch (IOException e)
		{
			throw new QueryEngineException( e.toString() );
		}
		
		for ( Triple triple: listOfTriples )
		{
			executeQuery ( triple.getIdentifier() );
		}
	}

}
