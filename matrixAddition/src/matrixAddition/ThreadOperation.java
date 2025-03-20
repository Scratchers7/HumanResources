package matrixAddition;

public class ThreadOperation extends Thread{
	private int[][] matrix1;
	private int[][] matrix2;
	private int quadrant;
	
	public ThreadOperation(int[][] matrix1, int[][] matrix2, int quadrant)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
	}
	
	public void run()
	{
		
	}
}
