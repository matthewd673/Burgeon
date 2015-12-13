package burgeon;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GraphicSurface extends JComponent {

	public static BufferedImage tiles;
	
	public static BufferedImage level;
	
	public static BufferedImage player;
	
	public static BufferedImage tut1;
	public static BufferedImage tut2;
	public static BufferedImage tut3;
	public static BufferedImage tut4;
	public static BufferedImage tut5;
	public static BufferedImage tut6;
	public static BufferedImage tut8;
	public static BufferedImage tut9;
	public static BufferedImage tut15;
	public static BufferedImage tut16;
	
	public static BufferedImage rip;
	public static BufferedImage endscreen;
	
	public static void LoadImages()
	{
		try 
		{
			tiles = ImageIO.read(new File("res/tiles.png"));
			
			tut1 = ImageIO.read(new File("res/tut/01.png"));
			tut2 = ImageIO.read(new File("res/tut/02.png"));
			tut3 = ImageIO.read(new File("res/tut/03.png"));
			tut4 = ImageIO.read(new File("res/tut/04.png"));
			tut5 = ImageIO.read(new File("res/tut/05.png"));
			tut6 = ImageIO.read(new File("res/tut/06.png"));
			tut8 = ImageIO.read(new File("res/tut/08.png"));
			tut9 = ImageIO.read(new File("res/tut/09.png"));
			tut15 = ImageIO.read(new File("res/tut/15.png"));
			tut16 = ImageIO.read(new File("res/tut/16.png"));
			
			rip = ImageIO.read(new File("res/rip.png"));
			endscreen = ImageIO.read(new File("res/endscreen.png"));
			
			setPlayerSprite();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadLevel()
	{
		try 
		{
			level = ImageIO.read(Main.lvlfile);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setPlayerSprite()
	{
		try 
		{
			if(Main.playersize == 1)
			{
				player = ImageIO.read(new File("res/player-small.png"));
			}
			else if(Main.playersize == 2)
			{
				player = ImageIO.read(new File("res/player.png"));
			}
			else if(Main.playersize == 3)
			{
				player = ImageIO.read(new File("res/player-big.png"));
			}
		} 
		catch (IOException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawTutorial(Graphics g)
	{
		switch(Main.currentlevel)
		{
		case 1:
			g.drawImage(tut1, 5, 10, null);
			break;
			
		case 2:
			g.drawImage(tut2, 5, 10, null);
			break;
			
		case 3:
			g.drawImage(tut3, 5, 10, null);
			break;
			
		case 4:
			g.drawImage(tut4, 5, 10, null);
			break;
			
		case 5:
			g.drawImage(tut5, 5, 10, null);
			break;
			
		case 6:
			g.drawImage(tut6, 5, 10, null);
			break;
			
		case 8:
			g.drawImage(tut8, 5, 10, null);
			break;
			
		case 9:
			g.drawImage(tut9, 5, 10, null);
			break;
			
		case 15:
			g.drawImage(tut15, 5, 10, null);
			break;
			
		case 16:
			g.drawImage(tut16, 5, 10, null);
			break;
			
		}
	}
	
	public void renderTile(Graphics g, int displayx, int displayy, int xcoord, int ycoord)
	{
		int width = Main.tilewidth;
		int height = Main.tileheight;
		
		int displaywidth = Main.displaywidth;
		int displayheight = Main.displayheight;
		
		//TODO: FIX!!!!
		g.drawImage(tiles, displayx * displaywidth, displayy * displayheight, (displayx * displaywidth) + displaywidth, (displayy * displayheight) + displayheight, xcoord * 17, ycoord * 17, xcoord * 17 + width + 1, ycoord * 17 + height, null);
	}
	
	public void paint(Graphics g)
	{
		
		//render floor
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j <= 20; j++)
			{
				renderTile(g, i, j, 1, 0);
			}
		}
		
		//load level
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				
				if(!Main.modified[i][j])
				{
					GetColor.get(i, j, level);
					
					if(GetColor.red == 0 && GetColor.green == 0 && GetColor.blue == 0)
					{
						// = "wall"
						renderTile(g, i, j, 0, 0);
						Main.levelmap[i][j] = 1;
					}
					if(GetColor.red == 255 && GetColor.green == 0 && GetColor.blue == 220)
					{
						// = "spawn";
						Main.spawnx = i;
						Main.spawny = j;
						
						if(Main.usespawnloc)
						{
							Main.playerx = Main.spawnx;
							Main.playery = Main.spawny;
						}
					}
					if(GetColor.red == 255 && GetColor.green == 216 && GetColor.blue == 0)
					{
						// = "coin+";
						renderTile(g, i, j, 6, 0);
						Main.levelmap[i][j] = 2;
					}
					if(GetColor.red == 127 && GetColor.green == 106 && GetColor.blue == 0)
					{
						// = "coin-";
						renderTile(g, i, j, 7, 0);
						Main.levelmap[i][j] = 3;
					}
					if(GetColor.red == 0 && GetColor.green == 148 && GetColor.blue == 255)
					{
						// = "gate1";
						renderTile(g, i, j, 2, 0);
						Main.levelmap[i][j] = 4;
					}
					if(GetColor.red == 0 && GetColor.green == 38 && GetColor.blue == 255)
					{
						// = "gate2";
						renderTile(g, i, j, 3, 0);
						Main.levelmap[i][j] = 5;
					}
					if(GetColor.red == 72 && GetColor.green == 0 && GetColor.blue == 255)
					{
						// = "gate3";
						renderTile(g, i, j, 4, 0);
						Main.levelmap[i][j] = 6;
					}
					if(GetColor.red == 255 && GetColor.green == 127 && GetColor.blue == 127)
					{
						// = "mons1";
						renderTile(g, i, j, 8, 0);
						Main.levelmap[i][j] = 7;
					}
					if(GetColor.red == 255 && GetColor.green == 0 && GetColor.blue == 0)
					{
						// = "mons2";
						renderTile(g, i, j, 9, 0);
						Main.levelmap[i][j] = 8;
					}
					if(GetColor.red == 127 && GetColor.green == 0 && GetColor.blue == 0)
					{
						// = "mons3";
						renderTile(g, i, j, 10, 0);
						Main.levelmap[i][j] = 9;
					}
					if(GetColor.red == 76 && GetColor.green == 255 && GetColor.blue == 0)
					{
						// = "exit";
						if(Main.buttonpressed)
						{
							renderTile(g, i, j, 5, 0);
						}
						else if(!Main.buttonpressed)
						{
							renderTile(g, i, j, 13, 0);
						}
						Main.levelmap[i][j] = 10;
					}
					if(GetColor.red == 178 && GetColor.green == 0 && GetColor.blue == 255)
					{
						// = "button";
						if(!Main.buttonpressed)
						{
							renderTile(g, i, j, 11, 0);
						}
						else if(Main.buttonpressed)
						{
							renderTile(g, i, j, 12, 0);
						}
						Main.levelmap[i][j] = 11;
					}
				}
			}
		}
		
		//draw player
		if(Main.playerdirection == "up")
		{
			g.drawImage(player, Main.playerx * Main.displaywidth, Main.playery * Main.displayheight, Main.playerx * Main.displaywidth + Main.displaywidth, Main.playery * Main.displayheight + Main.displayheight, 0, 0, 16, 16, null);
		}
		if(Main.playerdirection == "left")
		{
			g.drawImage(player, Main.playerx * Main.displaywidth, Main.playery * Main.displayheight, Main.playerx * Main.displaywidth + Main.displaywidth, Main.playery * Main.displayheight + Main.displayheight, 0, 16, 16, 32, null);
		}
		if(Main.playerdirection == "down")
		{
			g.drawImage(player, Main.playerx * Main.displaywidth, Main.playery * Main.displayheight, Main.playerx * Main.displaywidth + Main.displaywidth, Main.playery * Main.displayheight + Main.displayheight, 16, 0, 32, 16, null);
		}
		if(Main.playerdirection == "right")
		{
			g.drawImage(player, Main.playerx * Main.displaywidth, Main.playery * Main.displayheight, Main.playerx * Main.displaywidth + Main.displaywidth, Main.playery * Main.displayheight + Main.displayheight, 16, 16, 32, 32, null);
		}
		
		//draw tut
		drawTutorial(g);
		
		if(Main.dead)
		{
			g.drawImage(rip, 0, 0, null);
		}
		
		if(Main.currentlevel > 16)
		{
			g.drawImage(endscreen, 0, 0, null);
		}
		
	}
	
}
