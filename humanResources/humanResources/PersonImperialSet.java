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
}
