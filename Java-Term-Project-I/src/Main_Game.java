import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main_Game extends JFrame {
	Timer tmr = new Timer();

	public void tempTask() {
		TimerTask task = new TimerTask() {
			public void run() {
				if (result == 0) {
					second++;
					time.setText("" + second);
				}
			}
		};
		tmr.schedule(task, 0, 1000);
	}

	static TimerTask tt;

	ImageIcon gawi = new ImageIcon("./images/gawi.jpg");
	ImageIcon bawi = new ImageIcon("./images/bawi.jpg");
	ImageIcon bo = new ImageIcon("./images/bo.jpg");
	// ImageIcon nullImage = new ImageIcon("");

	Image img1 = gawi.getImage();
	Image img2 = bawi.getImage();
	Image img3 = bo.getImage();
	Image changeImg1 = img1.getScaledInstance(135,170, Image.SCALE_SMOOTH);
	Image changeImg2 = img2.getScaledInstance(135,170, Image.SCALE_SMOOTH);
	Image changeImg3 = img3.getScaledInstance(135,170, Image.SCALE_SMOOTH);
	ImageIcon changeIcon1 = new ImageIcon(changeImg1);
	ImageIcon changeIcon2 = new ImageIcon(changeImg2);
	ImageIcon changeIcon3 = new ImageIcon(changeImg3);
	
	
	JButton bt1 = new JButton(changeIcon1);
	JButton bt2 = new JButton(changeIcon2);
	JButton bt3 = new JButton(changeIcon3);

	JLabel la1 = new JLabel("나");
	JLabel la2 = new JLabel("컴퓨터");
	JLabel la3 = new JLabel("");

	JLabel imageLabel1 = new JLabel(gawi);
	JLabel imageLabel2 = new JLabel(bawi);
	JLabel imageLabel3 = new JLabel(bo);

	JButton bt = new JButton("시작");

	JLabel time = new JLabel("0");

	int result = 0;
	int count = 0;
	int second = 0;

	Font font1 = new Font("", Font.BOLD, 150);
	Font font2 = new Font("", Font.BOLD, 30);

	public Main_Game() {
		setTitle("가위 바위 보 게임");
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,1,0,0));

		time.setFont(font1);
		
		la1.setFont(font2);
		la2.setFont(font2);
		la3.setFont(font2);

		c.add(new Nouth_Pane());
		c.add(new Center_Pane1());
		c.add(new Center_Pane2());
		//c.add(new Center_Pane());
		c.add(new South_Pane());

		setSize(1300, 800);
		setVisible(true);
	}

	class Nouth_Pane extends JPanel {
		public Nouth_Pane() {
			this.setLayout(new FlowLayout());
			this.setBackground(Color.GRAY);
			
			bt1.setPreferredSize(new Dimension(180, 180));
			bt2.setPreferredSize(new Dimension(180, 180));
			bt3.setPreferredSize(new Dimension(180, 180));

			bt1.setEnabled(false);
			bt2.setEnabled(false);
			bt3.setEnabled(false);

			bt1.addActionListener(new MyActionListener1());
			bt2.addActionListener(new MyActionListener2());
			bt3.addActionListener(new MyActionListener3());

			this.add(bt1);
			this.add(bt2);
			this.add(bt3);
		}

		class MyActionListener1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				la2.setIcon(gawi);
				Random rd = new Random();
				int r = (int) (Math.random() * 3);
				if (r == 0) {
					la3.setIcon(gawi);
					la3.setForeground(Color.BLACK);
					la3.setText("비겼습니다 한번 더!");
				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.RED);
					la3.setText("아쉽네요 졌습니다..");
				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.RED);
					la3.setText("축하합니다! 승리하셨습니다~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;

				}
			}
		}

		class MyActionListener2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				la2.setIcon(bawi);
				Random rd = new Random();
				int r = (int) (Math.random() * 3);
				if (r == 0) {
					la3.setIcon(gawi);
					la3.setForeground(Color.RED);
					la3.setText("축하합니다! 승리하셨습니다~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;

				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.BLACK);
					la3.setText("비겼습니다 한번 더!");
				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.RED);
					la3.setText("아쉽네요 졌습니다..");
				}
			}
		}

		class MyActionListener3 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				la2.setIcon(bo);
				Random rd = new Random();
				int r = (int) (Math.random() * 3);
				if (r == 0) {
					la3.setIcon(gawi);
					la3.setForeground(Color.RED);
					la3.setText("아쉽네요 졌습니다..");
				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.RED);
					la3.setText("축하합니다! 승리하셨습니다~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;

				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.BLACK);
					la3.setText("비겼습니다 한번 더!");
				}
			}
		}
	}

	class Center_Pane extends JPanel {
		public Center_Pane() {
			this.setLayout(new BorderLayout());
			this.add(new Center_Pane1(), BorderLayout.CENTER);
			this.add(new Center_Pane2(), BorderLayout.SOUTH);
		}
	}

	class South_Pane extends JPanel {
		JLabel la = new JLabel("게임을 시작하려면 '시작' 버튼을 누르세요");

		public South_Pane() {
			this.setMaximumSize(new Dimension(1300,200));
			this.setLayout(new FlowLayout());
			this.setBackground(Color.PINK);
			this.add(la);

			bt.addActionListener(new MyActionListener());
			this.add(bt);
		}

		class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				bt.setEnabled(false);
				la.setText("가위바위보 게임을 시작합니다.");
				bt1.setEnabled(true);
				bt2.setEnabled(true);
				bt3.setEnabled(true); // 게임시작

				la3.setForeground(Color.BLACK);

				la2.setIcon(null);
				la3.setIcon(null);
				la3.setText("");
				time.setText("0");

				second = 0;
				result = 0;
				if (count == 0) {
					tempTask();
					count++;
				}
			}
		}
	}

//----------------------------------------------------------------------------------------------------------

	class Center_Pane1 extends JPanel {

		public Center_Pane1() {
			this.setBackground(Color.YELLOW);

			this.add(la1);
			this.add(la2);
			this.add(la3);
		}
	}

	class Center_Pane2 extends JPanel {
		public Center_Pane2() {
			this.setBackground(Color.YELLOW);

			this.add(time);
		}
	}

//-------------------------------------------------------------------------------------------------------------
}