package cscie97.asn1.knowledge.engine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class KnowledgeGraph
{
	
	private Map<String,Node> nodeMap;
	private Map<String, Predicate> predicateMap;
	private Map<String, Triple> tripleMap;
	private Map<String, Set<Triple>> queryMapSet;	
    private static KnowledgeGraph _obj;
    
    private KnowledgeGraph ()
    {
    	nodeMap = new HashMap();
    	predicateMap = new HashMap();
    	tripleMap = new HashMap(); 
    	queryMapSet = new HashMap();
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
			
			//toss into different maps
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
			
			if ( !tripleMap.containsKey( predicate ) )
			{
				tripleMap.put( triple, element );
			}
			

			if ( !queryMapSet.containsKey(triple) )
			{
				Set<Triple> setOfTriples = new HashSet<Triple>();
				
				for ( int i = 0; i<8; i++)
				{
					;
				}
			}
			//Map<String, Set<Triple>> queryMapSet
			
		}
		
		
		// precompute all the permutation per triple for the queryMapSet:
		// triple becomes the key, permutations - values, provides the efficient search
		// due to the MAP implementation
			
		return ;
	}
	
	/*
	public static Set<String> getKeysByValue(Map map, E value)
	{
	    Set<String> keys = new HashSet<String>();
	    for (Entry entry : map.entrySet()) 
	    {
	        if (value.equals(entry.getValue()))
	        {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	*/
	public Set<Triple> executeQuery ( Triple query )
	{
		return queryMapSet.get( queryMapSet );
	}
	
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
	
	private List<int[]> getBinTable ()
	{		
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
   
		return binTable;
	}
	
}
