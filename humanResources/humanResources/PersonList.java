package humanResources;

/*
Journey Allison
2/24/2025
Sources: 
https://www.w3schools.com/java/ref_string_format.asp
*/
public interface PersonList {
	//interface describing what methods its children should have
	public void add(Person p);//adds a person to the list
	public Person get(int index);//returns a person at an index from the list
}
