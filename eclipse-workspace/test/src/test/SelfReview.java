/*
Journey Allison
1/19/2025
Purpose: To briefly review (or learn) Java content in order to be prepared for CSCI 2251.
Sources:
	I reveiwed printf from https://www.w3schools.com/java/ref_output_printf.asp
*/
package test;
import java.util.Scanner;
public class SelfReview
{
	public static void main(String[] args) {
		//4    Prints a doctor sues quote with escape characters for next line and tab at the beginning of every line.
		System.out.println("\tThink left and think right\n\tand think low and think high.\n\tOh, the thinks you can think up\n\tif only you try!");
		//5    prints e to 4 decimal places
		double value = 2.71828;
		System.out.printf("%15.4f",value);
		System.out.println();
		//6     displays a set of variables in the terminal
		int volume = 4;
		double height = 9.46;
		String mountain = "Chicoma";
		System.out.println("Volume: "+volume+" Height: "+height+" Mountain: " + mountain);
		//7     gets user input via a scanner on what type of table they want
		Scanner input = new Scanner(System.in);
		System.out.println("What sort of table do you want?");
		int length = input.nextInt();
		int width = input.nextInt();
		input.nextLine();
		String type = input.nextLine();
		//8
		if(length*width >48) //if table area is more than 48 it will cost more
		{
			System.out.println("There will be an extra fee for a table that large.");
		}
		else
		{
			System.out.println("The regular fee applies.");
		}
		//9
		if(length >12 ||width>12)
		{
			System.out.println("This table will have to be cut on a special saw.");
		}
		if(type.equals("teak")||type.equals("Teak"))
		{
			System.out.println("This is a fancy table!");
		}
		//10
		int sum=0;
		for(int i =7;i<=700;i+=7)//tracks sum of series from 7 to 700
		{
			sum+=i;
		}
		System.out.println(sum);
		int sum2 = 0;
		int count = 1;
		while(sum2<=1000)//tracks sum of series from 7 until sum is more than 1000
		{
			sum2+=count*7;
			count++;
		}
		System.out.println("Sum2: "+sum2+", Count: "+(count-1));
		//11
		int[] numbers = {8, 3, 1, 2, -4, 9, 1, 6};
		for(int num: numbers)
		{
			if(num!=6)
			{
				System.out.print(num+", ");
			}
			else
			{
				System.out.print(num+".");
			}
		}
		System.out.println();
		int[] array300 = new int[900]; //creates an array with 300 1s followed by 300 2s then 300 1s again
		for(int i =0; i<300;i++)
		{
			array300[i] = 1;
		}
		for(int i =0; i<300;i++)
		{
			array300[300+i] = 2;
		}
		for(int i =0; i<300;i++)
		{
			array300[600+i] = 1;
		}/*   in my opinion more fun option to code, but not optimal
		for(int i =0; i<3;i++)
		{
			int num = 2; // this could have been shorter and simpler but I wanted to use a nested loop
			if(i%2==0)
			{
				num=1;
			}
			for(int j =0; j<300;j++)
			{
				array300[(i*300)+j] = num;
			}
		}*/
		//12
		int[] newNumbers = getEvens(numbers);
		for(int num: newNumbers)
		{
			if(num!=6)
			{
				System.out.print(num+", ");
			}
			else
			{
				System.out.print(num+".");
			}
		}
 
		System.out.println();
		//13
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(getMedianOfTwo(nums1,nums2));
		int[] nums3 = {1,2};
		int[] nums4 = {3,4};
		System.out.println(getMedianOfTwo(nums3,nums4));
	}
	public static int[] getEvens(int[] array)
	{
		//returns the input array with all of the odd numbers removed
		int numEven = numEvens(array);
		int num =0;
		int[] newArr = new int[numEven];
		for(int i =0;i<array.length; i++)
		{
			if(array[i]%2==0)
			{
				newArr[num] = array[i];
				num++;
			}
		}
		return newArr;
	}

	public static int numEvens(int[] array)
	{
		//returns the number of even numbers in the input array
		int sum=0;
		for(int num: array)
	{
			if(num%2==0)
			{
				sum++;
			}
	}
		return sum;
	}
	public static double getMedianOfTwo(int[] arr1, int[] arr2)
	{
		// returns the median of the two input arrays compiled together
		int[] newArray = getCombinedArray(arr1, arr2);
		double half = newArray.length / 2.0;
		if(1.0*((int)(half)) == half)
		{
			return(newArray[(int)(half)]+newArray[(int)(half) -1])/2.0;
		}
		else
		{
			return 1.0*(newArray[(int)(half)]);
		}
	}

	public static int[] getCombinedArray(int[] arr1, int[] arr2)
	{
		// returns the 2 input arrays complied together into one array that is in ascending order
		int[] newArr= new int[arr1.length + arr2.length];
		int[] array;
		int count = 0;
		if(arr1.length>=arr2.length) //set array to the bigger of the two input arrays or to arr2 for compiling
		{
			array = arr2;
		}
		else
		{
			array = arr1;
		}
		for(int i =0; i<array.length; i++) //combines the 2 arrays up to the size of the smallest array
		{
			if(arr1[i] > arr2[i])
			{
				newArr[count] = arr2[i];
				newArr[count+1] = arr1[i];
				count+=2;
			}
			else
			{
				newArr[count] = arr1[i];
				newArr[count+1] = arr2[i];
				count+=2;
			}
		}
		if(array == arr2)//adds the rest of the largest array onto the end of the result array
		{
			for(int i = arr2.length; i<arr1.length; i++)
			{
				newArr[count] = arr1[i];
			}
		}
		else
		{
			for(int i = arr1.length; i<arr2.length; i++)
			{
				newArr[count] = arr2[i];
			}
		}
		return newArr;
	}
}