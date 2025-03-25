package matrixAddition;
/*
Journey Allison
3/23/2025
Sources: 
https://www.geeksforgeeks.org/joining-threads-in-java/ to remember what join did
*/
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

Instead of wasting all allocated memory and processor cycles on waiting for the user to perform IO, 
other processes that do not need the IO will continue to run while waiting for the user. 
Multi-threading also allows the processor to more efficiently use multicore machines by running
threads concurrently on different cores allowing for the processes to be run at the same time
reducing time per core and thus overall time on the code. Additionally multi-threading can also 
reduce IO times that don't involve humans because if a program is waiting for data from a file to 
flow in it can perform other tasks, reducing resource usage by using the allocated resources during a
time when they would not otherwise be used.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		
		//int[][] testArray = new int[3][4];//array to test print2DArray
		///testArray = fillArray(testArray);//fills array with a list of numbers to ensure the print method works
		//print2DArray(testArray);//tests print method
		//System.out.println();
		String fileLocation = args[0];//gets file location of matrixes 
		File matrixFile = new File(fileLocation);
		try {
			Scanner fileInput = new Scanner(matrixFile);//to read the matrixes from the file
			int rows = fileInput.nextInt();//gets the number of rows in each of the matrixes
			int columns = fileInput.nextInt();//gets the number of columns in each of the matrixes
			int[][] matrix1 = matrixFromFile(rows,columns,fileInput);//gets the first matrix using the MatrixFromFile method
			int[][] matrix2 = matrixFromFile(rows,columns,fileInput);//gets the second matrix using the MatrixFromFile method
			int[][] matrix3 = new int[rows][columns];//result matrix for matrix addition
			int[][] matrix4 = new int[rows][columns];
			long startTimeThreads = System.nanoTime();//Starting system time for the threaded matrix addition
			ThreadOperation thread1 = new ThreadOperation(matrix1,matrix2,matrix3,1);//threads to split up the work of adding the matrix
			ThreadOperation thread2 = new ThreadOperation(matrix1,matrix2,matrix3,2);
			ThreadOperation thread3 = new ThreadOperation(matrix1,matrix2,matrix3,3);
			ThreadOperation thread4 = new ThreadOperation(matrix1,matrix2,matrix3,4);
			thread1.start();//starts threads
			thread2.start();
			thread3.start();
			thread4.start();
			try {
				thread1.join();//makes main method wait until run method is complete for all threads to finish
				thread2.join();
				thread3.join();
				thread4.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long endTimeThreads = System.nanoTime();//ending time for the threads adding the matrixes
			System.out.println("Time to Finish Multi-Threaded "+((endTimeThreads - startTimeThreads)/1_000_000_000.0));
			
			long startTimeSingle = System.nanoTime();
			for(int i = 0;i<rows;i++)
			{
				for(int j = 0;j<columns;j++)
				{
					matrix4[i][j] = matrix1[i][j] +matrix2[i][j];//adds each if the indices of the matrices and sets the result matrices corresponding index to to result
				}
			}
			long endTimeSingle = System.nanoTime();
			System.out.println("Time to Finish Single Threaded "+((endTimeSingle - startTimeSingle)/1_000_000_000.0));
			print2DArray(matrix3);
			//print2DArray(matrix1);//prints the 2 matrixes from file
			//System.out.println();
			//print2DArray(matrix2);
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
				System.out.printf("%-3d",array[i][j]);//prints each index in the 2dArray making it take up 3 spaces
			}
			System.out.println();//next line of 2dArray
		}
	}
	public static int[][] fillArray(int[][] array)
	{
		int[][] newArray = new int[array.length][array[0].length];//array to return
		for(int i =0; i<array.length;i++)
		{
			for(int j= 0;j<array[0].length; j++)
			{
				newArray[i][j] = (i)*(array.length+1) +j;//fills each index in the array with an increasing number, starting at zero
			}
		}
		return newArray;
	}
	
	public static int[][] matrixFromFile(int rows,int columns,Scanner file_reader)
	{
		int[][] returnArray = new int[rows][columns];//array to return
		for(int i =0;i<rows;i++)
		{
			for(int j = 0; j<columns;j++)
			{
				try
				{
					returnArray[i][j] = file_reader.nextInt();//fills the array with the data from file
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
