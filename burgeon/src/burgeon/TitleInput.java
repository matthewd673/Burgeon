package burgeon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TitleInput implements KeyListener {

	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Main.initFrame();
			Main.disableTitleFrame();
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}

	
}
