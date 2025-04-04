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
import java.util.ArrayList;
public class PersonSet implements PersonList{
	protected ArrayList<Person> people; //array list to hold set of people
	
	public PersonSet()
	{
		people = new ArrayList<Person>();//instantiates array list
	}
	
	public void add(Person p)
	{
		//if the arraylist does not contain the passed person then add it 
		if(!(people.contains(p)))
		{
			people.add(p);
		}
	}
	public Person get(int index)
	{
		return people.get(index);//returns a person at an index in the arraylist
	}
	public String toString()
	{
		String returnString = "Name	Height (cm)     Weight (kg)\n";
		for(Person p:people)
		{
			returnString+=p.toString()+"\n";//returns out information about everyone in the list by line
		}
		return returnString;
	}
}
