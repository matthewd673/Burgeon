package burgeon;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class TitleSurface extends JComponent {

	public static BufferedImage titlescreen;
	
	public void paint(Graphics g)
	{
		try 
		{
			titlescreen = ImageIO.read(new File("res/titlescreen.png"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(titlescreen, 0, 0, null);
		
	}
	
}
