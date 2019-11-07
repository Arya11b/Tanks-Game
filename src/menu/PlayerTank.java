package menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Watchable;

import javax.swing.JLabel;

public class PlayerTank extends JLabel implements KeyListener {
	int playerX, playerY;
	GameField gf;

	public PlayerTank(GameField gf) {
		this.gf = gf;
		playerX = (int) (Math.random() * 10);
		playerY = (int) (Math.random() * 10);
		while (GameField.field[playerX][playerY] != 0) {
			playerX = (int) (Math.random() * 10);
			playerY = (int) (Math.random() * 10);
		}
		playerX *= 100;
		playerY *= 100;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			gf.rTank.x -= 20;
			if (playerX > 20 && (!gf.rTank.intersects(gf.wall[playerX/100-1][playerY/100+1])&&!gf.rTank.intersects(gf.wall[playerX/100-1][playerY/100])))
				playerX -= 20; 
			System.out.println(playerX/100+"'"+playerY/100);
			break;
		case KeyEvent.VK_DOWN:
			gf.rTank.x += 20;
			if (playerX < 960 && (!gf.rTank.intersects(gf.wall[playerX/100+1][playerY/100+1])&&!gf.rTank.intersects(gf.wall[playerX/100+1][playerY/100])))
				playerX += 20;
			System.out.println(playerX/100+"'"+playerY/100);
			break;
		case KeyEvent.VK_LEFT:
			gf.rTank.y -= 20;
			if (playerY > 20&& (!gf.rTank.intersects(gf.wall[playerX/100+1][playerY/100-1])&&!gf.rTank.intersects(gf.wall[playerX/100][playerY/100-1])))
				playerY -= 20;
			System.out.println(playerX/100+"'"+playerY/100);
			break;
		case KeyEvent.VK_RIGHT:
			gf.rTank.y += 20;
			if (playerY < 960&&(!gf.rTank.intersects(gf.wall[playerX/100+1][playerY/100+1])&&!gf.rTank.intersects(gf.wall[playerX/100][playerY/100+1])))
				playerY += 20;
			System.out.println(playerX/100+"'"+playerY/100);
			break;

		}
		gf.rTank.x = playerX;
		gf.rTank.y = playerY;
		// gf.rTank.setLocation(playerY, playerX);
		gf.repaint();
		// System.out.println(gf.wall.x+","+gf.rTank.y);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
