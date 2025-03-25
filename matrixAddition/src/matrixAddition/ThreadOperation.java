package matrixAddition;
/*
Journey Allison
3/23/2025
Sources: 
https://www.geeksforgeeks.org/joining-threads-in-java/ to remember what join did
*/
public class ThreadOperation extends Thread{
	private int[][] matrix1;//holds first matrix to add
	private int[][] matrix2;//holds second matrix to add
	private int[][] matrix3;
	private int quadrant;//holds which quadrant of the matrix this thread is adding up.
	private int rows;
	private int columns;
	
	public ThreadOperation(int[][] matrix1, int[][] matrix2, int[][] matrix3, int quadrant)
	{
		//instantiates a new thread to add the matrixes
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.matrix3 = matrix3;
		this.quadrant = quadrant;
		this.rows =matrix1.length;
		this.columns = matrix1[0].length;
	}
	
	public void run()
	{
		int[] indexes = getQuadrantIndexes(rows, columns, quadrant);
		for(int i = indexes[0];i<=indexes[1];i++)
		{
			for(int j = indexes[2];j<=indexes[3];j++)
			{
				matrix3[i][j] = matrix1[i][j] +matrix2[i][j];
			}
		}
	}
	
	public static int[] getQuadrantIndexes(int rows, int columns, int quadrant)
	{
		if(quadrant == 1)
		{
			int[] returnArray = {0,rows/2-1,0,columns/2-1};
			return returnArray;
		}
		else if(quadrant ==2)
		{
			int[] returnArray = {0,rows/2-1,columns/2, columns-1};
			return returnArray;
		}
		else if(quadrant ==3)
		{
			int[] returnArray = {rows/2, rows-1,0,columns/2-1};
			return returnArray;
		}
		else
		{
			int[] returnArray = {rows/2, rows-1,columns/2, columns-1};
			return returnArray;
		}
	}
}
