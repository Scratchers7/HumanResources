package humanResources;

public class PersonOrderedSet extends PersonSet{
	
	public PersonOrderedSet()
	{
		super();
	}
	@Override
	public void add(Person p)
	{
		super.add(p);
		this.sort();
	}
	private void sort()
	{
		super.people.sort((a,b) -> a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));
	}
}
