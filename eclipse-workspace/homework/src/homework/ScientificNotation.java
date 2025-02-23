/**
 * 
 */
package homework;

/**
 * 
 */
import java.lang.Math;
public class ScientificNotation {
	public static void main(String[] args)
	{
		double x = 0.00000001234;
		double xPart =x;
		int tenPow = 0;
		while(!(xPart >=1))
		{
			xPart *= 10;
			tenPow++;
			System.out.println(tenPow);
		}
		System.out.println(x*Math.pow(10, tenPow));
	}
}
