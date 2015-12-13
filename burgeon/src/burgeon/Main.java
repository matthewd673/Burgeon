package burgeon;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//Demi is his sister

public class Main {

	public static JFrame frame;
	public static JFrame titleframe;
	
	public static int tilewidth = 16;
	public static int tileheight = 16;
	
	public static int displaywidth = 32;
	public static int displayheight = 32;
	
	public static int currentlevel = 1;
	
	public static int spawnx;
	public static int spawny;
	
	public static int playerx;
	public static int playery;
	
	public static int[][] levelmap = new int[20][20];
	public static boolean[][] modified = new boolean[20][20];
	
	public static File lvlfile;
	
	public static int playersize = 2;
	
	public static String playerdirection = "up";
	
	public static boolean usespawnloc = true;
	
	public static boolean buttonpressed = false;
	
	public static boolean dead = false;
	
	
	public static void main(String[] args)
	{
		switchLevel();
		GraphicSurface.LoadImages();
		initTitleFrame();
	}
	
	public static void initTitleFrame()
	{
		titleframe = new JFrame("burgeon - by @matthewd673");
		titleframe.setBounds(new Rectangle(0, 0, 644, 636));
		titleframe.setResizable(false);
		
		titleframe.add(new TitleSurface());
		titleframe.addKeyListener(new TitleInput());
		
		titleframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			titleframe.setIconImage(ImageIO.read(new File("res/icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		titleframe.setVisible(true);
	}
	
	public static void disableTitleFrame()
	{
		titleframe.setVisible(false);
	}
	
	public static void initFrame()
	{
		frame = new JFrame("burgeon");
		frame.setBounds(new Rectangle(0, 0, 644, 636));
		frame.setResizable(false);
		
		frame.add(new GraphicSurface());
		frame.addKeyListener(new KeyInput());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		try {
			frame.setIconImage(ImageIO.read(new File("res/icon.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PlaySound.playMusic();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void switchLevel()
	{
		
		playersize = 2;
		
		dead = false;
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				levelmap[i][j] = 0;
				modified[i][j] = false;
			}
		}
		
		buttonpressed = true;
		
		switch(currentlevel)
		{
		case 1:
			lvlfile = new File("res/lvl/01.png");
			break;
			
		case 2:
			lvlfile = new File("res/lvl/02.png");
			break;
			
		case 3:
			lvlfile = new File("res/lvl/03.png");
			break;
			
		case 4:
			lvlfile = new File("res/lvl/04.png");
			break;
			
		case 5:
			lvlfile = new File("res/lvl/05.png");
			break;
			
		case 6:
			lvlfile = new File("res/lvl/06.png");
			break;
			
		case 7:
			lvlfile = new File("res/lvl/07.png");
			break;
			
		case 8:
			lvlfile = new File("res/lvl/08.png");
			break;
			
		case 9:
			lvlfile = new File("res/lvl/09.png");
			buttonpressed = false;
			break;
			
		case 10:
			lvlfile = new File("res/lvl/10.png");
			break;
			
		case 11:
			lvlfile = new File("res/lvl/11.png");
			buttonpressed = false;
			break;
			
		case 12:
			lvlfile = new File("res/lvl/12.png");
			buttonpressed = false;
			break;
			
		case 13:
			lvlfile = new File("res/lvl/13.png");
			buttonpressed = false;
			break;
			
		case 14:
			lvlfile = new File("res/lvl/14.png");
			buttonpressed = false;
			break;
			
		case 15:
			lvlfile = new File("res/lvl/15.png");
			buttonpressed = false;
			break;
			
		case 16:
			lvlfile = new File("res/lvl/16.png");
			buttonpressed = false;
			break;
			
		default:
			lvlfile = new File("res/lvl/default.png");
			break;
			
		}
		
		GraphicSurface.loadLevel();
		GraphicSurface.setPlayerSprite();
		
		usespawnloc = true;
		playersize = 2;
	}
	
}
