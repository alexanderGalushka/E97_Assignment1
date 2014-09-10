package cscie97.asn1.test;

import cscie97.asn1.knowledge.engine.ImportException;
import cscie97.asn1.knowledge.engine.Importer;
import cscie97.asn1.knowledge.engine.QueryEngine;
import cscie97.asn1.knowledge.engine.QueryEngineException;


public class TestDriver
{
    public static void main(String[] args) throws ImportException
    {
    	Importer myImp = new Importer();
    	QueryEngine myQueryEng = new QueryEngine();
    	
    	String tripleFile = "C:/Users/apgalush/Documents/Personal/Harvard/Java/E97_Assignment1/src/inputTriples.nt";
    	String queryFile = "C:/Users/apgalush/Documents/Personal/Harvard/Java/E97_Assignment1/src/sampleQuery.nt";
    	
    	try
    	{
    		myImp.importTripleFile( tripleFile );
    	}
    	catch (ImportException e)
    	{
    		
    	}
    	
    	try 
    	{
    		myQueryEng.executeQueryFile( queryFile );
    	}
    	catch ( QueryEngineException e)
    	{
    		
    	}
    }
}
