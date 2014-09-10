package cscie97.asn1.knowledge.engine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class KnowledgeGraph
{
	private Map<String, Node> nodeMap;
	private Map<String, Predicate> predicateMap;
	private Map<String, Triple> tripleMap;
	private Map<String, Set<Triple>> queryMapSet;	
    private static KnowledgeGraph _obj;
    private List<int[]> binTable;
    
    private KnowledgeGraph ()
    {
    	nodeMap = new HashMap<String, Node>();
    	predicateMap = new HashMap<String, Predicate>();
    	tripleMap = new HashMap<String, Triple>(); 
    	queryMapSet = new HashMap<String, Set<Triple>>();
    	binTable = getBinTable ();
    }
    
    public Map<String, Triple> getTripleMap ()
    {
    	return tripleMap;
    }
    
    // instead of creating new operator, declare a method and that will create object and return it.
    public static KnowledgeGraph getInstance() 
    {
    	//Checking if the instance is null, then it will create new one and return it
        if (_obj == null)  
        //otherwise it will return previous one.
        {
            _obj = new KnowledgeGraph();
        }
        return _obj;
    }
	
	
   
	public void importTriples ( List<Triple> listOfTriples )
	{
		Node subject_obj;
		Predicate predicate_obj;
		Node object_obj;
		
		String subject;
		String predicate;
		String object;
		String triple;
		
		for ( Triple element : listOfTriples )
		{
			triple = element.getIdentifier();
			
			subject_obj= element.getSubject_obj();
			subject = subject_obj.getIdentifier();
			
			object_obj = element.getObject_obj();
			object = object_obj.getIdentifier();
			
			predicate_obj = element.getPredicate_obj(); 
			predicate = predicate_obj.getIdentifier();
			
			//stuff data into different maps
			if ( !nodeMap.containsKey( subject ) )
			{
				nodeMap.put( subject, subject_obj );
			}
			if ( !nodeMap.containsKey( object ) )
			{
				nodeMap.put( object, object_obj );
			}
			
			if ( !predicateMap.containsKey( predicate ) )
			{
				predicateMap.put( predicate, predicate_obj );
			}
			
			if ( !tripleMap.containsKey( triple ) )
			{
				tripleMap.put( triple, element );
			}
			

			if ( !queryMapSet.containsKey( triple ) )
			{
				Set<Triple> setOfTriples = new HashSet<Triple>();
				
				for ( int i = 0; i < binTable.size(); i++)
				{
					setOfTriples.add( createQueryTriple ( binTable.get(i), subject, predicate, object ) );
				}
				
				queryMapSet.put(triple, setOfTriples);
			}
			
			
		}
			
	}
	
	
	public Set<Triple> executeQuery (Triple query)
	{
		Set<Triple> result = new HashSet<Triple>();
		if ( query != null)
		{
			String queryString = query.getIdentifier();
	
		    for (String key : queryMapSet.keySet()) 
		    {
		    	for (Triple tiple_obj : queryMapSet.get( key ) )
		    	{
		    		if ( queryString.equals(tiple_obj.getIdentifier() ) )
		    		{
		    			result.add( tripleMap.get( key ) );
		    		}
		    	}
		    }
		}
	    return result;
	}
	
	
	public Set<Triple> executeQueryString (String queryString)
	{

	    Set<Triple> result = new HashSet<Triple>();
	    
	    for (String key : queryMapSet.keySet()) 
	    {
	    	for (Triple tiple_obj : queryMapSet.get( key ) )
	    	{
	    		if ( queryString.equals(tiple_obj.getIdentifier() ) )
	    		{
	    			result.add( tripleMap.get( key ) );
	    		}
	    	}
	    }
	    return result;
	}
	
	//public Set<Triple> executeQuery ( Triple query )
	//{
	//	return queryMapSet.get( queryMapSet );
	//}
	
	public Node getNode ( String identifier )
	{
		return nodeMap.get( identifier );
	}
	
	public Predicate getPredicate ( String identifier )
	{
		
		return predicateMap.get(identifier);
	}
	
	public Triple getTriple ( Node subject, Predicate predicate, Node object )
	{
		String lookup = subject.getIdentifier() + " " + predicate.getIdentifier() + " " + object.getIdentifier();
		
		if ( !tripleMap.containsKey( lookup ) )
		{			
			Triple newTriple = new Triple ( subject, predicate, object  );
			tripleMap.put( lookup, newTriple );
			//update queryMapSet as well
			//...
			return newTriple;
		}
		
		return tripleMap.get(lookup);
			
	}
	

	//I could hardcode binary table, but have decided to implement the function
	private List<int[]> getBinTable ()
	{	
		List<int[]> binTable = new ArrayList<int[]>();
    	for ( int i = 0; i<8; i++)
		{
    		String binString;
    		binString = String.format("%03d", new BigInteger(Integer.toBinaryString(i)));
    		
            int[] binNum = new int[binString.length()];

            for (int j = 0; j < binString.length(); j++)
            {
            	binNum[j] = binString.charAt(j) - '0';
            }
            
            binTable.add(binNum);    
		}
   
		return binTable;
	}
	
	private Triple createQueryTriple ( int[] binArray, String subject, String predicate, String object)
	{
		Triple resultTriple;
		Node subject_obj;
		Node object_obj;
		Predicate predicate_obj;
		
		String[] arrayOfElements = {subject, predicate, object};
		
		for (int i = 0; i<binArray.length; i++)
		{
			if (binArray[i] == 1)
			{
				arrayOfElements[i] = "?";
			}
		}
		
		subject_obj = new Node ( arrayOfElements[0] );
		predicate_obj = new Predicate( arrayOfElements[1] );
		object_obj = new Node ( arrayOfElements[2] );
		resultTriple = new Triple ( subject_obj, predicate_obj, object_obj );
		return resultTriple;
	}
	
}
