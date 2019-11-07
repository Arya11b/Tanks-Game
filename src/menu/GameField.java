package menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameField extends JFrame implements Runnable {
	static int[][] field = new int[10][10];
	/*int[] iWall=new int[30];
	int[] jWall=new int[30];*/
	FileInputStream map = null;
	ImageIcon[] plain = new ImageIcon[2];
	ImageIcon pTank = new ImageIcon("Tank.png");
	ImageIcon pGun = new ImageIcon("Gun.png");
	ImageIcon oTank = new ImageIcon("enemyTank.png");
	ImageIcon oGun = new ImageIcon("enemyGun.png");
	Rectangle rTank,rOtank;
	PlayerTank pt;
	EnemyTank et;
	//Rectangle[] wall = new Rectangle[40];
	Rectangle[][] wall=new Rectangle[10][10];

	void prepareGui() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1000, 1200);
		setLocation((d.width - 1000) / 2, (d.height - 1200) / 2);
		setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[0].length; j++)
				g.drawImage(plain[field[i][j]].getImage(), j * 100, i * 100, null);
		g.drawImage(pTank.getImage(), pt.playerY, pt.playerX, null);
		g.drawImage(pGun.getImage(), pt.playerY, pt.playerX, null);
		g.drawImage(oTank.getImage(), et.oponentY, et.oponentX, null);
		g.drawImage(oGun.getImage(), et.oponentY, et.oponentX, null);

		// g2.rotate(Math.toRadians(45), arg1, arg2);
	}

	public GameField() {
		super("tanks");
		/*int c=0;
		for (int i = 0; i < iWall.length; i++) {
			iWall[i]=-1;
			jWall[i]=-1;
			
		}*/
		plain[0] = new ImageIcon("open.png");
		plain[1] = new ImageIcon("block.png");
		prepareGui();
		try {
			map = new FileInputStream("map.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Map file not found");
			System.exit(0);
		}
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				try {
					field[i][j] = map.read() - 48;
				} catch (IOException e) {
				}
				if(field[i][j]==1){
					/*iWall[c]=i;
					jWall[c]=j;
					c++;*/
					wall[i][j]=new Rectangle(i*100, j*100, 100, 100);
				}
				else
					wall[i][j]=new Rectangle(1001, 1000,1,1);
			}
			try {
				map.skip(2);
			} catch (IOException e) {
			}
		}
		pt = new PlayerTank(this);
		et = new EnemyTank(pt.gf);
		rTank = new Rectangle(pt.playerX, pt.playerY, 100, 100);
		rOtank=new Rectangle(et.oponentX, et.oponentY, 100, 100);
		addKeyListener(pt);
		(new Thread(et)).start();
	}

	public static void main(String[] args) {
		new GameField();
	}

	@Override
	public void run() {
		while (true) {
		}
	}

}
