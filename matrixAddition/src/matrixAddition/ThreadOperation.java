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
	private int quadrant;//holds which quadrant of the matrix this thread is adding up.
	
	public ThreadOperation(int[][] matrix1, int[][] matrix2, int quadrant)
	{
		//instantiates a new thread to add the matrixes
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
	}
	
	public void run()
	{
		//TODO: make it add the quadrant of matrix assigned.
	}
}
