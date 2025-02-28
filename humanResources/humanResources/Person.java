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
public class Person {
	//describes a person with a name height and weight
	private String name;
	private double weight;
	private double height;
	
	public Person(String name,double height,double weight)
	{
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public Person(Person p)
	{
		this.name = p.getName();
		this.height = p.getHeight();
		this.weight = p.getWeight();
	}
	
	public String getName()
	{
		return this.name;//returns the name of the person
	}
	
	public double getHeight()
	{
		return this.height;//returns the height of the person
	}
	
	public double getWeight()
	{
		return this.weight;//returns the weight of the person
	}
	
	public void setHeight(double height)
	{
		this.height = height;//change height to the inputed value
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;//change weight to the inputed value
	}
	
	public String toString()
	{
		return String.format("%-8s%-16d%-16d",this.getName(),(int)this.getHeight(),(int)this.getWeight());//returns their name, height and weight in a formatted manner
	}
	@Override
	public boolean equals(Object o)
	{
		//if Object o is null then return false
		if(o == null)
		{
			return false;
		}
		//if Object o == this then return true
		if(o == this)
		{
			return true;
		}
		//if Object o is not an instance of Person then return false
		if(!(o instanceof Person))
		{
			return false;
		}
	//Declare a new variable of type Person (perhaps named p) 
//		and assign it to Object o cast as type Person
		Person p = (Person)(o);
	//if Person p has the same name, height, and weight as 
//		this then return true
		if(p.getHeight()==this.getHeight()  &&  p.getWeight()==this.getWeight()  &&  p.getName().equals(this.getName()))
		{
			return true;
		}
	//else return false
		return false;
	}

}
