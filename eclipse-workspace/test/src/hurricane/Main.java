/*
Journey Allison
2/2/2025
Sources:
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/ref_string_split.asp
asked Googles Gemini, "regex find and replace \ with \\ java"
*/
package hurricane;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HurricaneRowData> list = new ArrayList<HurricaneRowData>();//list to contain all rows of the file as HurricaneRowData instances
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
			while(input.hasNextLine())
			{
				int[] vars = new int[5];//list for all vars in a row
				String line = input.nextLine();//gets line
				String[] preVars = line.split(",");//removes commas from line
				for(int index =0; index<preVars.length;index++)
				{
					vars[index] = Integer.valueOf(preVars[index]);//converts the strings to ints in vars
				}
				list.add(new HurricaneRowData(vars));//adds a new HurricaneRowData instance to ArrayList
			}
			int[] maxArr = highestAce(list);//gets the mac Ace and Year from the list of HurricaneRowData rows
			maxYear = maxArr[0];
			maxAce = maxArr[1];
			System.out.println("Max Year: "+maxYear+" Max Ace: "+maxAce);//prints values
			
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
	public static int[] highestAce(ArrayList<HurricaneRowData> data)
	{
		//inputs an ArrayList of rows from the ace class
		//returns an array that contains the year and ace of the year with the maximum ace
		int maxAce =0;
		HurricaneRowData maxAceObj = null;
		for(HurricaneRowData dat:data)
		{
			if(dat.getAce()>maxAce)//finds row with max ace
			{
				maxAce = dat.getAce();
				maxAceObj  =dat;
			}
		}
		int[] arr = {maxAceObj.getYear(),maxAceObj.getAce()};//creates array to return with
		return arr;
	}

}
