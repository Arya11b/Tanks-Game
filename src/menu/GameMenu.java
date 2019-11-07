package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class GameMenu extends JWindow {
	JLabel name, tankNumber, difficulty;
	JTextField enterName, enterTankNumber;
	JButton ok, exit;
	JPanel buttonPanel, namePanel, numberPanel, difficultyPanel;
	JComboBox enterDifficulty;
	private int tankSize = 750;
	private String[] difficultyOptions = { "easy", "medium", "hard" };

	void labelInitialize() {
		namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2));
		namePanel.add(name);
		namePanel.add(enterName);
		numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(1, 2));
		numberPanel.add(tankNumber);
		numberPanel.add(enterTankNumber);
		difficultyPanel = new JPanel();
		difficultyPanel.setLayout(new GridLayout(1, 2));
		difficultyPanel.add(difficulty);
		difficultyPanel.add(enterDifficulty);
	}

	void componentInitialize() {
		name = new JLabel("enter your name:", JLabel.CENTER);
		enterName = new JTextField(8);
		tankNumber = new JLabel("Enter The Number of Tanks:", JLabel.CENTER);
		enterTankNumber = new JTextField(8);
		difficulty = new JLabel("set the difficulty:", JLabel.CENTER);
		enterDifficulty = new JComboBox(difficultyOptions);
		namePanel = new JPanel();
		numberPanel = new JPanel();
		buttonPanel = new JPanel();
		ok = new JButton("Start");
		exit = new JButton("Exit Game");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(ok);
		buttonPanel.add(exit);
	}

	public GameMenu() {
		super();
		componentInitialize();
		labelInitialize();
		// labelInitialize(numberPanel, tankNumber, enterTankNumber);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new GridLayout(4, 1, 0, 200));
		setSize(tankSize, tankSize);
		getContentPane().setBackground(new Color(100, 102, 100, 190));
		add(namePanel);
		add(numberPanel);
		add(difficultyPanel);
		add(buttonPanel);
		setLocation((d.width - tankSize) / 2, (d.height - tankSize) / 2);
		setVisible(true);
	}

	public static void main(String[] args) {
		GameMenu main = new GameMenu();

	}

}
