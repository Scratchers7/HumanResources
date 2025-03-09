package doublyLinkedList;
/*
Journey Allison
2/2/2025
Sources:
https://www.w3schools.com/java/java_files_create.asp
https://www.w3schools.com/java/ref_string_split.asp
asked Googles Gemini, "regex find and replace \ with \\ java"
*/
public class HurricaneRowData implements Comparable<HurricaneRowData> {
	//class to store data from one row of the ace.txt file relating to hurricane power and frequency
	private int year;
	private int ace;
	private int trop;//instance variables
	private int hurr;
	private int majHurr;
	
	//constructor
	public HurricaneRowData()
	{
		year = 0;
		ace =0;
		trop = 0;
		hurr = 0;
		majHurr = 0;
	}
	
	//constructor
	public HurricaneRowData(int year, int ace, int trop, int hurr, int majHurr)
	{
		this.year = year;
		this.ace =ace;
		this.trop = trop;
		this.hurr = hurr;
		this.majHurr = majHurr;
	}
	
	public HurricaneRowData(int[] arr)
	{
		this.year = arr[0];
		this.ace =arr[1];
		this.trop = arr[2];
		this.hurr = arr[3];
		this.majHurr = arr[4];//takes an array to simplify input
	}
	
	public int getYear()
	{
		//returns year instance variable
		return year;
	}
	
	public int compareTo(HurricaneRowData other)
	{
		if(other.getAce()>this.getAce())
		{
			return 1;
		}
		if(this.getAce()>other.getAce())
		{
			return -1;
		}
		return 0;
	}
	
	public int getAce()
	{
		//returns ace instance variable
		return ace;
	}
	
	public String toString()
	{
		return this.year+","+this.ace+","+this.trop+","+this.hurr+","+this.majHurr;
	}
}
