package burgeon;

import java.awt.image.BufferedImage;

public class GetColor 
{

	public static int red = 255;
	public static int green = 255;
	public static int blue = 255;
	
	public static String blockType;
	
	public static void get(int x, int y, BufferedImage lev)
	{
		int clr = lev.getRGB(x, y);
		red   = (clr & 0x00ff0000) >> 16;
		green = (clr & 0x0000ff00) >> 8;
		blue  =  clr & 0x000000ff;
	}
	
	public static String blockId(int r, int g, int b)
	{
		
		blockType = "wall";
		
		if(r == 255 && g == 255 && b == 255)
		{
			blockType = "wall";
		}
		if(r == 255 && g == 0 && b == 220)
		{
			blockType = "spawn";
		}
		if(r == 255 && g == 216 && b == 0)
		{
			blockType = "coin+";
		}
		if(r == 173 && g == 144 && b == 0)
		{
			blockType = "coin-";
		}
		if(r == 0 && g == 148 && b == 255)
		{
			blockType = "gate1";
		}
		if(r == 0 && g == 38 && b == 255)
		{
			blockType = "gate2";
		}
		if(r == 72 && g == 0 && b == 255)
		{
			blockType = "gate3";
		}
		if(r == 255 && g == 127 && b == 127)
		{
			blockType = "mons1";
		}
		if(r == 255 && g == 0 && b == 0)
		{
			blockType = "mons2";
		}
		if(r == 127 && g == 0 && b == 0)
		{
			blockType = "mons3";
		}
		if(r == 76 && g == 255 && b == 0)
		{
			blockType = "exit";
		}
		
		return blockType;
		
	}
	
	
}

