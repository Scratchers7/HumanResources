package midterm;

public class Vector extends Direction{
	private int distance;
	public Vector(int angle,int dist)
	{
		super(angle);
		this.distance = dist;
	}
	
	public String toString()
	{
		return super.toString()+" and "+this.distance+" meters";
	}
}
