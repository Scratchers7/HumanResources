package keyword_extends;

import java.security.SecureRandom;
public class Lockheed_AC_130 extends Vehicle {
	private int numCannons;
	SecureRandom secureRandom;
	
	public Lockheed_AC_130()
	{
		numCannons= 4;
		this.secureRandom = new SecureRandom();
	}
	
	public Lockheed_AC_130(int numCannons)
	{
		this.numCannons= numCannons;
		this.secureRandom = new SecureRandom();
	}
	
	public void fire()
	{
		int numRounds = secureRandom.nextInt(1000);
		System.out.println("You fired "+numRounds+" rounds at the testing range with "+numCannons+" cannons.");
	}
}
