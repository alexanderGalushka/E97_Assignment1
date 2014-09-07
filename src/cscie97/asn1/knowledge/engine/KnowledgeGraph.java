package cscie97.asn1.knowledge.engine;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class KnowledgeGraph
{
	
	private Map nodeMap;
	private Map predicateMap;
	private Map tripleMap;
	private Map queryMapSet;
	
	
	//tripleMap Map<String, Triple>	
	//queryMapSet Map<String, Set<Triple>> 	
	//predicateMap Map<String, Predicate>	
	//nodeMap Map<String, Node>
	
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
		return ;
	}
	
	public Set<Triple> executeQuery ( Triple query )
	{
		return ;
	}
	
	public Node getNode ( String identifier )
	{
		
		return ;
	}
	
	public Predicate getPredicate ( String identifier )
	{
		
		return ;
	}
	
	public Triple getTriple ( Node subject, Predicate predicate, Node object )
	{
		
		return ;
	}
	
}
