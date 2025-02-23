package dogs;
/*
Journey Allison
1/21/2025
Sources:
*/
public class Dog {
	private int age;
	private String name;
	private String breed;
	
	public Dog()
	{
		age =0;
		name ="NA";
		breed = "NA";
	}
	
	//constructor
	public Dog(String name, String breed,int age)
	{
		this.age= age;
		this.name= name;
		this.breed = breed;
	}
	
	public String getBreed()
	{
		//returns the breed of the dog
		return breed;
	}
	
	public String getName()
	{
		//returns the name of the dog
		return name;
	}
	
	public int getAge()
	{
		//returns the age of the dog
		return age;
	}
}
