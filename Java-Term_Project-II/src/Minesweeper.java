import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Minesweeper extends JFrame {
	private JButton bt[] = new JButton[100];
	private JLabel laTimer = new JLabel("Time");
	private int randomNums[] = new int[10];
	private int i = 0;
	private int mineNum = 10;
	private int level = mineNum * mineNum;

	public void randomNums() {
		Random r = new Random();

		for (int i = 0; i < mineNum; i++) {
			randomNums[i] = r.nextInt(level);
			for (int j = 0; j < i; j++) {
				if (randomNums[i] == randomNums[j]) {
					i--;
				}
			}
		}
	}

	public void exploreMap() {

	}

	public Minesweeper() {
		setTitle("별상자의 지뢰찾기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPane(), BorderLayout.NORTH);
		c.add(new CenterPane(), BorderLayout.CENTER);
		setSize(650, 750);
		setVisible(true);

	}

	class NorthPane extends JPanel {

		public NorthPane() {
			this.setBackground(Color.darkGray);
			laTimer.setForeground(Color.WHITE);
			this.add(laTimer);
		}
	}

	class CenterPane extends JPanel {
		public CenterPane() {
			this.setLayout(new GridLayout(mineNum, mineNum, 1, 1));
			this.setBackground(Color.GRAY);
			randomNums();

			for (int i = 0; i < level; i++) {
				bt[i] = new JButton();
				bt[i].setBackground(Color.LIGHT_GRAY);
				bt[i].addActionListener(new MyActionListener());
				this.add(bt[i]);
			}
			for (int i = 0; i < mineNum; i++) {
				bt[randomNums[i]].setText("Mine");
				bt[randomNums[i]].setForeground(Color.LIGHT_GRAY);
			}
			for (int i = 0; i < level; i++) {
				int mineCount = 0;

				if (bt[i].getText() != "Mine") {
					if (i >= mineNum + 1) {
						if (i % mineNum != 0) {
							if (bt[i - (mineNum + 1)].getText() == "Mine") {
								mineCount++;
							}
						}
					}
					if (i >= mineNum) {
						if (bt[i - mineNum].getText() == "Mine") {
							mineCount++;
						}
					}
					if (i >= mineNum - 1) {
						if ((i+1) % mineNum != 0) {
							if (bt[i - (mineNum - 1)].getText() == "Mine") {
								mineCount++;
							}
						}
					}
					if (i >= 1) {
						if (i % mineNum != 0) {
							if (bt[i - 1].getText() == "Mine") {
								mineCount++;
							}
						}
					}

					if (i <= ((level-1) - mineNum)) {
						if (i % mineNum != 0) {
							if (bt[i + (mineNum - 1)].getText() == "Mine") {
								mineCount++;
							}
						}
					}
					if (i <= (level-1) - mineNum) {
						if (bt[i + mineNum].getText() == "Mine") {
							mineCount++;
						}
					}
					if (i <= (level-1) - (mineNum + 1)) {
						if ((i+1) % mineNum != 0) {
							if (bt[i + (mineNum + 1)].getText() == "Mine") {
								mineCount++;
							}
						}
					}
					if (i <= (level - 1)) {
						if (i % mineNum != 0) {
							if (bt[i + 1].getText() == "Mine") {
								mineCount++;
							}
						}
					}

					if (mineCount != 0) {
						bt[i].setText("" + mineCount);
					}
					bt[i].setForeground(Color.LIGHT_GRAY);
				}
			}
		}
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton actionBt = (JButton) e.getSource();
			if (actionBt.getText() == "Mine") {
				for (int i = 0; i < level; i++) {
					bt[i].setForeground(Color.RED);
				}
			} else if (actionBt.getText() == "") {
				for (i = 0; i < level; i++) {
					if (e.getSource() == bt[i]) {
						bt[i].setBackground(Color.GRAY);
						while (true) {
							exploreMap();
						}
					}
				}
			} else {
				actionBt.setBackground(Color.GRAY);
				actionBt.setForeground(Color.BLUE);
			}
		}
	}

	public static void main(String[] args) {
		new Minesweeper();

	}
}
