package cscie97.asn1.knowledge.engine;

public class Triple
{
    	
   private Node subject;
   private Predicate predicate;  
   private Node object;
   private String identifier;

  
   Triple (Node subject, Predicate predicate, Node object)
   {
    this.subject = subject;
    this.predicate = predicate;
    this.object = object;    
   }

   
	public String getIdentifier ()
	{
		identifier = subject.getIdentifier() + " " + predicate.getIdentifier() + " " + object.getIdentifier();
		return identifier;
	}
	
	
	public Node getSubject_obj ()
	{
		return subject;
	}
	
	public Predicate getPredicate_obj ()
	{
		return predicate;
	}	
	
	public Node getObject_obj ()
	{	
		return object;
	}	
	
}
