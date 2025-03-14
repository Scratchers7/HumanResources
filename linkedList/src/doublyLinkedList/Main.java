package doublyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
Journey Allison
3/9/2025
Sources:
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/ref_string_split.asp
https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
asked Googles Gemini, "regex find and replace \ with \\ java"
*/
public class Main {
	public static void main(String[] args)
	{
		DoublyLinkedSortedList list = new DoublyLinkedSortedList();//list to contain all rows of the file as HurricaneRowData instances
		int maxYear=0;
		int maxAce=0;
		try {
			Scanner input2 = new Scanner(System.in);
			System.out.println("Paste the file path of ace without quotes");//gets the file path of the input file from the user
			String filePath = input2.nextLine();
			filePath = filePath.replaceAll("\\\\", "\\\\\\\\");//Replaces all single quotes with double quotes
			File f = new File(filePath);//instantiates new file from file path
			Scanner input = new Scanner(f);//sets up input for file
			input.nextLine();//Ignores first line
			int[] vars1 = new int[5];//list for all vars in a row
			String line1 = input.nextLine();//gets line
			String[] preVars1 = line1.split(",");//removes commas from line
			for(int index =0; index<preVars1.length;index++)
			{
				vars1[index] = Integer.valueOf(preVars1[index]);//converts the strings to ints in vars
			}
			list.setValue(new HurricaneRowData(vars1));
			while(input.hasNextLine())
			{
				int[] vars = new int[5];//list for all vars in a row
				String line = input.nextLine();//gets line
				String[] preVars = line.split(",");//removes commas from line
				for(int index =0; index<preVars.length;index++)
				{
					vars[index] = Integer.valueOf(preVars[index]);//converts the strings to ints in vars
				}
				list.insert(new HurricaneRowData(vars));//adds a new HurricaneRowData instance to ArrayList
			}
			DoublyLinkedSortedList link = list.getFirst();
			HurricaneRowData dat = (HurricaneRowData)link.getValue();
			int max_year = dat.getYear();
			int max_ace = dat.getAce();
			System.out.println("Year of max ace+ ace: "+max_year+", "+max_ace);
			System.out.println("All data in order of Ace:");
			System.out.println(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			FileWriter myWriter = new FileWriter("outputHurricaneData.txt");
			myWriter.write("Max Year: "+maxYear+" Max Ace: "+maxAce);//writes max year and ace to new file
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
