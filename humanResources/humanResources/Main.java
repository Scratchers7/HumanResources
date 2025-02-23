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
		
		System.out.println();
		
		String[] nameList = {"Mario", "Toad", "Luigi", "Bowser", "Peach"};
		int[] heightList = {155,41,158,310,183};
		int[] widthList = {90,7,83,726,60};
		Person testPerson = new Person("John",200,50);
		System.out.println(testPerson);
		PersonSet testSet = new PersonSet();
		for(int i=0; i<5;i++)
		{
			int index = (int)(Math.random()*5);
			Person added = new Person(nameList[index], heightList[index], widthList[index]);
			testSet.add(added);
		}
		System.out.println(testSet);
		/*
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
		File hr = new File("D:\\Github\\Eclpise\\humanResources\\humanResources\\hr.txt");//replace with direct reference to file on your computer
		try {
			Scanner fileReader = new Scanner(hr);
			fileReader.nextLine();
			while(fileReader.hasNext())
			{
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();
				System.out.println(new Person(name,height,weight));
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
	}
}
