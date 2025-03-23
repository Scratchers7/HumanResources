package matrixAddition;

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		int[][] testArray = new int[3][4];
		testArray = fillArray(testArray);
		print2DArray(testArray);
		System.out.println();
		String fileLocation = args[0];
		File matrixFile = new File(fileLocation);
		try {
			Scanner fileInput = new Scanner(matrixFile);
			int rows = fileInput.nextInt();
			int columns = fileInput.nextInt();
			int[][] matrix1 = matrixFromFile(rows,columns,fileInput);
			int[][] matrix2 = matrixFromFile(rows,columns,fileInput);
			print2DArray(matrix1);
			System.out.println();
			print2DArray(matrix2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void print2DArray(int[][] array)
	{
		for(int i =0; i< array.length;i++)
		{
			for(int j = 0; j<array[0].length;j++)
			{
				System.out.printf("%-3d",array[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] fillArray(int[][] array)
	{
		int[][] newArray = new int[array.length][array[0].length];
		for(int i =0; i<array.length;i++)
		{
			for(int j= 0;j<array[0].length; j++)
			{
				newArray[i][j] = (i)*(array.length+1) +j;
			}
		}
		return newArray;
	}
	
	public static int[][] matrixFromFile(int rows,int columns,Scanner file_reader)
	{
		int[][] returnArray = new int[rows][columns];
		for(int i =0;i<rows;i++)
		{
			for(int j = 0; j<columns;j++)
			{
				try
				{
					returnArray[i][j] = file_reader.nextInt();
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println("Rows or Columns are likely incorrect");
				}
			}
		}
		return returnArray;
	}
}
