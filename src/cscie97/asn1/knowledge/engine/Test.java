package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Test
{
	

    public static void main(String[] args) throws IOException
    {
    	/*String testString;
    	Importer myImp = new Importer();
    	
    	myImp.importTripleFile( "C:/Users/apgalush/Documents/Personal/Harvard/Java/E97_Assignment1/src/inputTriples.nt" );
    	
    	KnowledgeGraph my = KnowledgeGraph.getInstance();
    	
    	testString = my.getNode("Joe").getIdentifier();
    	
        System.out.println( testString ); // Display the string.*/
    	
    	for ( int i = 0; i<8; i++)
		{
    		String binString;
    		List<int[]> binTable = new ArrayList<int[]>();
    		binString = String.format("%03d", new BigInteger(Integer.toBinaryString(i)));
    		
            int[] binNum = new int[binString.length()];

            for (int j = 0; j < binString.length(); j++)
            {
            	binNum[j] = binString.charAt(j) - '0';
            }
            
            binTable.add(binNum);
            
		}
    	

    }
}
