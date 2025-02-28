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
public interface PersonList {
	//interface describing what methods its children should have
	public void add(Person p);//adds a person to the list
	public Person get(int index);//returns a person at an index from the list
}
