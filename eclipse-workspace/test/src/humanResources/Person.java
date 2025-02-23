package humanResources;

public class Person {
	private String name;
	private double weight;
	private double height;
	
	public Person(String name,double height,double weight)
	{
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	public String toString()
	{
		return String.format("%8s%32f%f",this.getName(),this.getHeight(),this.getWeight());
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
