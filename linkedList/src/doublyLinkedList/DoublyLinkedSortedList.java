
/*
Journey Allison
3/9/2025
Sources:
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/ref_string_split.asp
https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
asked Googles Gemini, "regex find and replace \ with \\ java"
*/
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	private Object data;
	private DoublyLinkedSortedList prev;
	private DoublyLinkedSortedList next;
	
	//a link in a doubly linked sorted list
	public DoublyLinkedSortedList(Object d)
	{
		data = d;//data to hold
		prev = next = null;//set both the previous link and next link to null;
	}
	
	public DoublyLinkedSortedList()
	{
		//default constructor
		data = null;
		prev = next = null;
	}
	
	public Object getValue()
	{
		//returns data held by link
		return data;
	}
	
	public void setNext(DoublyLinkedSortedList next)
	{
		//sets the next link
		this.next = next;
		next.setPreviousSingle(this);//sets the next link's previous link to this one
	}
	
	public void setNextSingle(DoublyLinkedSortedList next)
	{
		this.next = next;//used for setPrevious to set the previous link's next to this one
	}
	
	public void setPrevious(DoublyLinkedSortedList prev)
	{
		//sets the previous link
		this.prev = prev;
		prev.setNextSingle(this);//sets the previous link's next link to this one
	}
	
	public void setPreviousSingle(DoublyLinkedSortedList prev)
	{
		this.prev = prev;//used for setNxt to set the next link's previous to this one
	}
	
	public DoublyLinkedSortedList getNext()
	{
		return next;//returns the next Link
	}
	public boolean hasNext()
	{
		return this.next !=null;//determines if it has a next Link
	}
	
	public boolean hasPrevious()
	{
		return this.prev !=null;//determines if its has a previous Link
	}
	public DoublyLinkedSortedList getPrevious()
	{
		return prev;//returns the previous Link
	}
	
	public DoublyLinkedSortedList getFirst()
	{
		//returns the first link in the chain
		if(prev == null)
		{
			return this;
		}
		else
		{
			return this.prev.getFirst();
		}
	}
	
	public DoublyLinkedSortedList removeThis()
	{
		//removes this Link
		prev.setNext(next);
		return this;
	}
	
	public void insert(Object newValue)
	{
		//inserts an object into the list in a sorted manner
		getFirst().insertLoop(newValue);
	}
	
	protected void insertLoop(Object newValue)
	{
		//used in the insert method to insert the value into the correct spot in the list
		HurricaneRowData newVal = (HurricaneRowData) newValue;//casts object to HurricaneRowData
		if(newVal.compareTo((HurricaneRowData)this.getValue()) == 1)//if the compare to value is one then repeat loop, unless its the last Link then add the value at the end
		{
			if(next!=null)
			{
				next.insertLoop(newValue);
			}
			else
			{
				this.addLast(newVal);
			}
		}
		else if(newVal.compareTo((HurricaneRowData)this.getValue()) == -1)//if it is negative one then set the previous link to the new Link
		{
			this.setPrevious(new DoublyLinkedSortedList(newVal));
		}
		else
		{
			this.setPrevious(new DoublyLinkedSortedList(newVal));//if it is zero then set the previous link to the new Link
		}
	}
	
	public DoublyLinkedSortedList remove(Object toRemove)
	{
		//removes the Link that matches the data in the object
		return getFirst().removeLoop(toRemove);
	}
	
	public void setValue(Object newData)
	{
		//sets the value of the link to the inputed object
		this.data = newData;
	}
	protected DoublyLinkedSortedList removeLoop(Object toRemove)
	{
		//used to remove the object
		if(this.getValue().equals(toRemove))
		{
			return this.removeThis();//if the Link matches this object then remove it form the list
		}
		else
		{
			return next.remove(toRemove);//else do the remove loop again for the next Link in the list
		}
	}
	
	public DoublyLinkedSortedList getLast()
	{
		//returns the last link in the list
		if(next == null)
		{
			return this;//if the Link has no next then return it
		}
		else
		{
			return this.next.getLast();//else return the value gotten from the get last method of the next Link
		}
	}
	
	public void addFirst(Object data)
	{
		//adds a link with the data in Object to the beginning of the list
		DoublyLinkedSortedList temp = new DoublyLinkedSortedList(data);
		getFirst().setPrevious(temp);
	}
	
	public void addLast(Object data)
	{
		//adds a link with the data in Object to the end of the list
		DoublyLinkedSortedList temp  = new DoublyLinkedSortedList(data);
		getLast().setNext(temp);
	}
	
	public String toString()
	{
		return this.getFirst().toSringLoop();//calls the toString loop on the first Link in the list to ensure the whole list's toString is returned
	}
	protected String toSringLoop()
	{
		if(next == null)
		{
			return this.data.toString();//if is is the end of the list then just return this ones data's toString
		}
		return this.data.toString()+"\n"+ next.toSringLoop();//return this ones data's toString and the toString of the next Link's data
	}
}
