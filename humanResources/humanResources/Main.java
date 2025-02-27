/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:

Q1: Car and Engine are related
by which, Inheritance or Composition?
 Composition
Q2: Color and Red are related
by which, Inheritance or Composition?
Inheritance
Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
Inheritance
Q4: Furniture and Desk are related
by which, Inheritance or Composition?
Inheritance
Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
Composition
*/
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Main 
{
	public static void main(String[] args) 
	{
		/*
		System.out.println();
		
		String[] nameList = {"Mario", "Toad", "Luigi", "Bowser", "Peach"}; //list of names for random person generation
		int[] heightList = {155,41,158,310,183};//list of accompanying height for random person generation
		int[] widthList = {90,7,83,726,60};//list of accompanying weight for random person generation
		Person testPerson = new Person("John",200,50);//creates test person
		System.out.println(testPerson);//tests all of tests persons public methods
		PersonSet testSet = new PersonSet();//creates test set of people
		for(int i=0; i<5;i++)
		{
			int index = (int)(Math.random()*5);
			Person added = new Person(nameList[index], heightList[index], widthList[index]);
			testSet.add(added);
		}//creates some random people to test the PersonSet class
		System.out.println(testSet);//test toString for set

		// Don't overcomplicate the data
		// reading. After skipping the
		// first row, you can use the 
		// following to read a row of
		// character info, assuming your
		// Scanner is named "fileReader"
		String name = fileReader.next();
		double height = fileReader.nextDouble();
		double weight = fileReader.nextDouble();
		*/
		/*
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the exact location of hr.txt on your machine");
		String FileLocation = userInput.nextLine();
		//System.out.println(FileLocation);
		File hr;
		if(FileLocation.equals(""))
		{
				hr = new File("D:\\Github\\Eclpise\\humanResources\\humanResources\\hr.txt");

		}
		else
		{
				hr = new File(FileLocation);//replace with direct reference to file on your computer
		}
		try {
			Scanner fileReader = new Scanner(hr);//scanner to read file
			fileReader.nextLine();//uses first line of non data
			while(fileReader.hasNext())
			{
				//while there is more to be read from document read it
				String name = fileReader.next();//gets the name of the person from the file
				double height = fileReader.nextDouble();//gets the height of the person from the file
				double weight = fileReader.nextDouble();//gets the width of the person form the file
				System.out.println(new Person(name,height,weight));//creates new person and prints it form the data in file
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*try
		{	
			FileWriter fileWriterOrder = new FileWriter("outputfile.txt");
			fileWriterOrder.write("testing");
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}*/
		
		PersonImperialSet imperialSet = new PersonImperialSet();
		PersonOrderedSet orderedSet = new PersonOrderedSet();
		//Scanner userInput = new Scanner(System.in);
		//System.out.println("Enter the exact location of hr.txt on your machine");
		//String FileLocation = userInput.nextLine();
		String FileLocation = args[0];
		//System.out.println(FileLocation);
		File hr;
		if(FileLocation.equals(""))
		{
				hr = new File("D:\\Github\\Eclpise\\humanResources\\humanResources\\hr.txt");

		}
		else
		{
				hr = new File(FileLocation);
		}
		try {
			Scanner fileReader = new Scanner(hr);//scanner to read file
			fileReader.nextLine();//uses first line of non data
			while(fileReader.hasNext())
			{
				//while there is more to be read from document read it
				String name = fileReader.next();//gets the name of the person from the file
				double height = fileReader.nextDouble();//gets the height of the person from the file
				double weight = fileReader.nextDouble();//gets the width of the person form the file
				Person p = new Person(name,height,weight);//creates new person and prints it form the data in file
				orderedSet.add(p);
				imperialSet.add(new Person(p));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{	
			FileWriter fileWriterImperial = new FileWriter("hr_imperial_set_output.txt");
			FileWriter fileWriterOrdered = new FileWriter("hr_ordered_set_output.txt");
			fileWriterOrdered.write(orderedSet.toString());
			fileWriterOrdered.close();
			fileWriterImperial.write(imperialSet.toString());
			fileWriterImperial.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
		
		System.out.println("Imperial\n"+imperialSet);
		System.out.println("Ordered\n"+orderedSet);
	}
}
