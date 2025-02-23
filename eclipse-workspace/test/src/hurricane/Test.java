package hurricane;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = new File("\\C:\\\\Users\\journ\\\\eclipse-workspace\\\\test\\\\src\\\\hurricane\\\\ace.csv\\");
			Scanner input = new Scanner(f);
			input.nextLine();
			while(input.hasNextLine())
			{
				System.out.println(input.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
