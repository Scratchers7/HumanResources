package test;
/*
Journey Allison
1/21/2025
Sources:
*/
public class ArraysLoopsAndIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {1,2,3,4,5,6,7,2,424,4};//creates test array with numbers
		int[] result = hasNumsThatAddUpToo(test1, 11); //calls method to test if it can detect that the two numbers do add up
		for(int num: result)
		{
			System.out.println(num);//prints result to see if it is correct
		}
		int[] test2 = {92,935,23,3,5,6,2,5,2,56,63,2,7};//repeats twice
		int[] result2 = hasNumsThatAddUpToo(test2, 70);
		for(int num: result2)
		{
			System.out.println(num);
		}
		int[] test3 = {1,2,3,4,5,6,7,2,424,4};
		int[] result3 = hasNumsThatAddUpToo(test3, 200);
		for(int num: result3)
		{
			System.out.println(num);
		}
	}
	public static int[] hasNumsThatAddUpToo(int[] arr, int target)
	{
		//Inputs an array and target number, searches array to see if any two numbers add up to the target number
		//Index of the numbers that add up to result or -1,-1 if none add up to target
		for(int index1 =0; index1<arr.length-1; index1++)//goes through array up to one before end
		{
			int num = arr[index1];
			for(int index2 = index1+1; index2<arr.length; index2++)//goes through the rest of the array up to the end
				//this prevents duplicate checks and maximizes efficiency
			{
				if(num+arr[index2]==target)
				{	
					int[] newArr = {index1,index2}; //return indexes
					return newArr;
				}
			}
		}
		int[] newArr = {-1,-1};//if none add up return -1,-1
		return newArr;
	}
}
