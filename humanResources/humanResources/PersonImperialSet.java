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
public class PersonImperialSet extends PersonSet{
	
	//Person Set 
	public PersonImperialSet()
	{
		super();
	}
	@Override
	public void add(Person p)
	{
		p.setHeight(p.getHeight()/2.54);//converts height to imperial inches
		p.setWeight(p.getWeight()*2.20462);//converts weight to imperial lbs
		super.add(p);//adds person to list
	}
	@Override
	public String toString()
	{
		String returnString = "Name	Height (in)     Weight (lbs)\n";//returns the data formatted like hr.txt
		for(Person p:people)
		{
			returnString+=p.toString()+"\n";//returns out information about everyone in the list by line
		}
		return returnString;
	}
}
