import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Timer;
import java.util.TimerTask;

public class Main_Game extends JFrame {
	Timer tmr = new Timer();

	public void tempTask() {
		TimerTask task = new TimerTask() {
			public void run() {
				second++;
				time.setText(""+second);
				
			}
		};
		tmr.schedule(task, 0, 1000);
	}

	static TimerTask tt;

	ImageIcon gawi = new ImageIcon("./images/gawi.jpg");
	ImageIcon bawi = new ImageIcon("./images/bawi.jpg");
	ImageIcon bo = new ImageIcon("./images/bo.jpg");
	// ImageIcon nullImage = new ImageIcon("");

	JButton bt1 = new JButton(gawi);
	JButton bt2 = new JButton(bawi);
	JButton bt3 = new JButton(bo);

	JLabel la1 = new JLabel("��");
	JLabel la2 = new JLabel("��ǻ��");
	JLabel la3 = new JLabel("");

	JLabel imageLabel1 = new JLabel(gawi);
	JLabel imageLabel2 = new JLabel(bawi);
	JLabel imageLabel3 = new JLabel(bo);

	JButton bt = new JButton("����");

	JLabel time = new JLabel("0");

	int result = 0;

	int second = 0;

	public Main_Game() {
		setTitle("���� ���� �� ����");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		c.add(new Nouth_Pane(), BorderLayout.NORTH);
		c.add(new Center_Pane(), BorderLayout.CENTER);
		c.add(new South_Pane(), BorderLayout.SOUTH);

		setSize(1300, 800);
		setVisible(true);
	}

	class Nouth_Pane extends JPanel {
		public Nouth_Pane() {
			this.setBackground(Color.GRAY);

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
					la3.setText("�����ϴ� �ѹ� ��!");
				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.RED);
					la3.setText("�ƽ��׿� �����ϴ�..");
				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.RED);
					la3.setText("�����մϴ�! �¸��ϼ̽��ϴ�~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;
					tmr.cancel();
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
					la3.setText("�����մϴ�! �¸��ϼ̽��ϴ�~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;
					tmr.cancel();

				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.BLACK);
					la3.setText("�����ϴ� �ѹ� ��!");
				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.RED);
					la3.setText("�ƽ��׿� �����ϴ�..");
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
					la3.setText("�ƽ��׿� �����ϴ�..");
				} else if (r == 1) {
					la3.setIcon(bawi);
					la3.setForeground(Color.RED);
					la3.setText("�����մϴ�! �¸��ϼ̽��ϴ�~");
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					bt3.setEnabled(false);
					bt.setEnabled(true);
					result = 1;
					tmr.cancel();
				} else if (r == 2) {
					la3.setIcon(bo);
					la3.setForeground(Color.BLACK);
					la3.setText("�����ϴ� �ѹ� ��!");
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
		JLabel la = new JLabel("������ �����Ϸ��� '����' ��ư�� ��������");

		public South_Pane() {
			this.setLayout(new FlowLayout());
			this.setBackground(Color.PINK);
			this.add(la);

			bt.addActionListener(new MyActionListener());
			this.add(bt);
		}

		class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				bt.setEnabled(false);
				la.setText("���������� ������ �����մϴ�.");
				bt1.setEnabled(true);
				bt2.setEnabled(true);
				bt3.setEnabled(true); // ���ӽ���

				la3.setForeground(Color.BLACK);

				la2.setIcon(null);
				la3.setIcon(null);
				la3.setText("");
				time.setText("0");

				tempTask();
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