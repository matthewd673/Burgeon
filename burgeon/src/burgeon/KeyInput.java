package burgeon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	public void keyPressed(KeyEvent e) 
	{
		
		Main.usespawnloc = false;
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			Main.playerdirection = "up";
			
			
			if(Main.levelmap[Main.playerx][Main.playery - 1] == 1)
			{
				
			}
			else
			{
				if(Main.levelmap[Main.playerx][Main.playery - 1] == 4 && Main.playersize != 1)
				{
					
				}
				else if(Main.levelmap[Main.playerx][Main.playery - 1] == 5 && Main.playersize != 2)
				{
					
				}
				else if(Main.levelmap[Main.playerx][Main.playery - 1] == 6 && Main.playersize != 3)
				{
					
				}
				else
				{
					Main.playery -= 1;
				}
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			Main.playerdirection = "left";
			
			if(Main.levelmap[Main.playerx - 1][Main.playery] == 1)
			{
				
			}
			else
			{
				if(Main.levelmap[Main.playerx - 1][Main.playery] == 4 && Main.playersize != 1)
				{
					
				}
				else if(Main.levelmap[Main.playerx - 1][Main.playery] == 5 && Main.playersize != 2)
				{
					
				}
				else if(Main.levelmap[Main.playerx - 1][Main.playery] == 6 && Main.playersize != 3)
				{
					
				}
				else
				{
					Main.playerx -= 1;
				}
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			Main.playerdirection = "down";
			
			if(Main.levelmap[Main.playerx][Main.playery + 1] == 1)
			{
				
			}
			else
			{
				if(Main.levelmap[Main.playerx][Main.playery + 1] == 4 && Main.playersize != 1)
				{
					
				}
				else if(Main.levelmap[Main.playerx][Main.playery + 1] == 5 && Main.playersize != 2)
				{
					
				}
				else if(Main.levelmap[Main.playerx][Main.playery + 1] == 6 && Main.playersize != 3)
				{
					
				}
				else
				{
					Main.playery += 1;
				}
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			Main.playerdirection = "right";
			
			if(Main.levelmap[Main.playerx + 1][Main.playery] == 1)
			{
				
			}
			else
			{
				if(Main.levelmap[Main.playerx + 1][Main.playery] == 4 && Main.playersize != 1)
				{
					
				}
				else if(Main.levelmap[Main.playerx + 1][Main.playery] == 5 && Main.playersize != 2)
				{
					
				}
				else if(Main.levelmap[Main.playerx + 1][Main.playery] == 6 && Main.playersize != 3)
				{
					
				}
				else
				{
					Main.playerx += 1;
				}
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			Main.switchLevel();
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 2)
		{
			if(Main.playersize < 3)
			{
				Main.playersize++;
				
				Main.levelmap[Main.playerx][Main.playery] = 0;
				Main.modified[Main.playerx][Main.playery] = true;
			}
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 3)
		{
			Main.playersize--;
			
			Main.levelmap[Main.playerx][Main.playery] = 0;
			Main.modified[Main.playerx][Main.playery] = true;
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 10)
		{
			//TODO: MOVE ON!!!!
			if(Main.buttonpressed == true)
			{
				Main.currentlevel++;
				Main.switchLevel();
			}
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 11)
		{
			//BUTTON!
			Main.buttonpressed = true;
		}
		
		//TODO
		
		if(Main.levelmap[Main.playerx][Main.playery] == 7)
		{
			if(Main.playersize >= 1)
			{
				Main.playersize++;
				Main.levelmap[Main.playerx][Main.playery] = 0;
				Main.modified[Main.playerx][Main.playery] = true;
			}
			else
			{
				Main.playersize--;
			}
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 8)
		{
			if(Main.playersize >= 2)
			{
				Main.playersize++;
				Main.levelmap[Main.playerx][Main.playery] = 0;
				Main.modified[Main.playerx][Main.playery] = true;
			}
			else
			{
				Main.playersize--;
			}
		}
		
		if(Main.levelmap[Main.playerx][Main.playery] == 9)
		{
			if(Main.playersize == 3)
			{
				Main.playersize++;
				Main.levelmap[Main.playerx][Main.playery] = 0;
				Main.modified[Main.playerx][Main.playery] = true;
			}
			else
			{
				Main.playersize--;
			}
		}
		
		if(Main.playersize > 3)
		{
			Main.playersize = 3;
		}
		
		GraphicSurface.setPlayerSprite();
		
		if(Main.playersize == 0)
		{
			Main.dead = true;
		}
		
		Main.frame.repaint();
		
		System.out.println(Integer.toString(Main.playersize));
		
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}

}
