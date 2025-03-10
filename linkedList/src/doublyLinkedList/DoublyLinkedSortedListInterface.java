package doublyLinkedList;

/*
Journey Allison
3/9/2025
Sources:
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/ref_string_split.asp
https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
asked Googles Gemini, "regex find and replace \ with \\ java"
*/
public interface DoublyLinkedSortedListInterface
{
	//Get the value of the current DoublyLinkedSortedList
	public Object getValue();
	
	//Return true if next is not null
	public boolean hasNext();
	
	//Set next to be the given DoublyLinkedSortedList
	public void setNext(Link next);
	
	//Return a reference to the next DoublyLinkedSortedList
	public Link getNext();
	
	//Return true if previous is not null
	public boolean hasPrevious();
	
	//Set previous to be the given DoublyLinkedSortedList
	public void setPrevious(Link previous);
	
	//Return a reference to the previous DoublyLinkedSortedList
	public Link getPrevious();
	
	//Return a reference to the first DoublyLinkedSortedList element in the list
	public Link getFirst();
	
	//Return a reference to the last DoublyLinkedSortedList element in the list
	public Link getLast();
	
	//Remove the DoublyLinkedSortedList element that has toRemove as its value
	public Link remove(Object toRemove);
	
	//Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
	public void insert(Object newValue);
	
	//Return the entire list as a multi-line String
	public String toString();
}
