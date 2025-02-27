package humanResources;

public class PersonImperialSet extends PersonSet{
	
	public PersonImperialSet()
	{
		super();
	}
	@Override
	public void add(Person p)
	{
		p.setHeight(p.getHeight()/2.54);
		p.setWeight(p.getWeight()*2.20462);
		super.add(p);
	}
	@Override
	public String toString()
	{
		String returnString = "Name	Height (in)		Weight (lbs)";
		for(Person p:people)
		{
			returnString+=p.toString()+"\n";//returns out information about everyone in the list by line
		}
		return returnString;
	}
}
