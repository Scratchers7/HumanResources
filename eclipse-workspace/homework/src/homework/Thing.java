package homework;
import java.util.ArrayList;

public class Thing {
	public static void main(String[] args) {
		//ThingClass someThing = null;
		for(int i = 3; i <=30; i+=2)
		{
			ArrayList<Integer> braid = new ArrayList<Integer>();
			ArrayList<Integer> condition = new ArrayList<Integer>();
			int counter = 0;
			for(int j =1 ;j <= i; j++)
			{
				braid.add(j);
				condition.add(j);
			}
			braid.add(braid.size() / 2,braid.remove(0));
			counter ++;
			while(!braid.equals(condition))
			{
				braid.add(braid.size() / 2,braid.remove(counter% 2 * (braid.size() -1)));
				counter ++;
			}
			System.out.println(counter);
		}
	}
}
