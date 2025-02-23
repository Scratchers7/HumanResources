package humanResources;


import java.util.ArrayList;
public class PersonSet implements PersonList{
	protected ArrayList<Person> people;
	
	public PersonSet()
	{
		people = new ArrayList<Person>();
	}
	
	public void add(Person p)
	{
		if(!(people.contains(p)))
		{
			people.add(p);
		}
	}
	public Person get(int index)
	{
		return people.get(index);
	}
	public String toString()
	{
		String returnString = "";
		for(Person p:people)
		{
			returnString+=p.toString()+"\n";
		}
		return returnString;
	}
}
