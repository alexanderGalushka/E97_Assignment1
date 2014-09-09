package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Test
{
	

    public static void main(String[] args) throws IOException
    {
    	String testString;
    	Importer myImp = new Importer();
    	
    	myImp.importTripleFile( "C:/Users/apgalush/Documents/Personal/Harvard/Java/E97_Assignment1/src/inputTriples.nt" );
    	
    	KnowledgeGraph my = KnowledgeGraph.getInstance();
    	
    	//testString = my.getNode("Joe").getIdentifier();
    	
        //System.out.println( testString ); // Display the string.
    	
        Set<Triple> result = my.executeQueryString ( "? plays_sport ?" );
    	
        for (Triple triple : result)
        {
        	System.out.println( triple.getIdentifier() );
        }
    }
}
