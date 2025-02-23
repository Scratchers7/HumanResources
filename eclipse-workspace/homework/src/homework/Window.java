package homework;
import javax.swing.JFrame;
import java.awt.*; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.MouseInfo;

public class Window {
	static boolean pressed = false;

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Throw Me");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1,1,250,100);
		frame.setVisible(true);
		frame.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
	            pressed = true;
	          } 
	          public void mouseReleased(MouseEvent me) { 
		            pressed = false;
		          } 
	        }); 
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
		// width will store the width of the screen 
		int width = (int)size.getWidth(); 
		// height will store the height of the screen 
		int height = (int)size.getHeight(); 
		int slopeX = 0;
		int slopeY = 0;
		int lastX = 0;
		int lastY = 0;
		int counter = 0;
		while(true)
		{
			
			int mouseX = (int)MouseInfo.getPointerInfo().getLocation().getX();
	        int mouseY = (int)MouseInfo.getPointerInfo().getLocation().getY();
			if(frame.getY()<=height - 100 && !pressed &&frame.getY()>=0 &&frame.getX()<=width - 250&&frame.getX()>=0)
			{
				frame.setLocation(frame.getX()+slopeX/5, frame.getY()+slopeY/5);
			}
			else if(pressed)
			{
				frame.setLocation(mouseX-125,mouseY-50);
				if(counter%10 == 0)
				{
					lastX = frame.getX();
					lastY = frame.getY();
				}
				if(counter%10 != 0)
				{
				slopeX=-lastX+frame.getX();
				slopeY=-lastY+frame.getY();
				System.out.println(slopeX);
				System.out.println(slopeY);
				}
			}
			if(frame.getY() >height - 100)
			{
				frame.setLocation(frame.getX(), height - 100);
			}
			if(frame.getX() >width - 250)
			{
				frame.setLocation(width - 250, frame.getY());
			}
			if(frame.getX() <0)
			{
				frame.setLocation(0, frame.getY());
			}
			if(frame.getY() <0)
			{
				frame.setLocation(frame.getX(), 0);
			}
			if(frame.getY() ==height - 100)
			{
				slopeY *=-1;
				slopeY += 1;
			}
			if(frame.getY()==0)
			{
				slopeY *=-1;
				slopeY += -1;
			}
			if(frame.getX() ==width - 250)
			{
				slopeX *=-1;
				slopeX += 1;
			}
			if(frame.getX()==0)
			{
				slopeX *=-1;
				slopeX += -1;
			}
			counter++;
			try {
	            // Pause for 2 seconds (2000 milliseconds)
	            Thread.sleep(1); 

	        } catch (InterruptedException e) {
	            System.err.println("Interrupted: " + e.getMessage());
	        }
		}
	}

}
