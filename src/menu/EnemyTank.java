package menu;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class EnemyTank extends JLabel implements Runnable {
	int oponentX, oponentY;
	GameField gf;

	public EnemyTank(GameField gf) {
		this.gf = gf;
		oponentX = (int) (Math.random() * 10);
		oponentY = (int) (Math.random() * 10);
		while (GameField.field[oponentX][oponentY] != 0) {
			oponentX = (int) (Math.random() * 10);
			oponentY = (int) (Math.random() * 10);
		}
		oponentX *= 100;
		oponentY *= 100;

	}

	@Override
	public void run() {
		int rand;
		while (true) {
			rand = (int) (Math.random() * 4);
			System.out.println(rand);
			switch (rand) {
			case 0:
				gf.rOtank.x -= 20;
				if (oponentX > 20 && (!gf.rOtank.intersects(gf.wall[oponentX / 100 - 1][oponentY / 100 + 1])
						&& !gf.rOtank.intersects(gf.wall[oponentX / 100 - 1][oponentY / 100])))
					oponentX -= 20;
				System.out.println(oponentX / 100 + "'" + oponentY / 100);
				break;
			case 1:
				gf.rOtank.x += 20;
				if (oponentX < 960 && (!gf.rOtank.intersects(gf.wall[oponentX / 100 + 1][oponentY / 100 + 1])
						&& !gf.rOtank.intersects(gf.wall[oponentX / 100 + 1][oponentY / 100])))
					oponentX += 20;
				System.out.println(oponentX / 100 + "'" + oponentY / 100);
				break;
			case 2:
				gf.rOtank.y -= 20;
				if (oponentY > 20 && (!gf.rOtank.intersects(gf.wall[oponentX / 100 + 1][oponentY / 100 - 1])
						&& !gf.rOtank.intersects(gf.wall[oponentX / 100][oponentY / 100 - 1])))
					oponentY -= 20;
				System.out.println(oponentX / 100 + "'" + oponentY / 100);
				break;
			case 3:
				gf.rOtank.y += 20;
				if (oponentY < 960 && (!gf.rOtank.intersects(gf.wall[oponentX / 100 + 1][oponentY / 100 + 1])
						&& !gf.rOtank.intersects(gf.wall[oponentX / 100][oponentY / 100 + 1])))
					oponentY += 20;
				System.out.println(oponentX / 100 + "'" + oponentY / 100);
				break;

			}
			gf.rOtank.x = oponentX;
			gf.rOtank.y = oponentY;
			gf.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
