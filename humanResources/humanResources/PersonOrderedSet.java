package humanResources;
/*
Journey Allison
2/24/2025
Sources: 
https://www.w3schools.com/java/ref_string_format.asp
https://www.w3schools.com/java/ref_string_compareto.asp
https://www.w3schools.com/java/ref_arraylist_sort.asp
https://www.w3schools.com/java/java_lambda.asp
https://www.w3schools.com/java/ref_string_tolowercase.asp
asked gemini, "what should the lambda expression for sort return java" so I could understand what the sort method wanted from the lambda expression
*/
public class PersonOrderedSet extends PersonSet{
	//PersonSet which is ordered alphabetically by name
	public PersonOrderedSet()
	{
		super();
	}
	@Override
	public void add(Person p)
	{
		super.add(p);//adds the person to the set
		this.sort();//sorts the whole set
	}
	private void sort()
	{
		super.people.sort((a,b) -> a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));//sorts the people list by name
	}
}
