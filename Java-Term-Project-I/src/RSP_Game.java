import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyDialog extends JDialog {

	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		setLayout(new BorderLayout());
		JTabbedPane pane = createTabbedPane();
		add(pane, BorderLayout.CENTER);

		setSize(750, 120);
	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("���� ����", new JTextArea("ȭ�� �ϴܿ� �ִ� '����' ��ư�� Ŭ���ϸ� ����� ����, ����, �� ��ư�� Ȱ��ȭ �Ǹ鼭 �÷���Ÿ���� �����մϴ�."));
		pane.addTab("���� ����", new JTextArea("������ ���۵Ǹ� '����'��ư�� ��Ȱ��ȭ �ǰ�,\n����� ����,����,�� ��ư�� Ŭ���� ������ ��ǻ�Ϳ� ����� �ؼ� �̱涧���� �÷��� �մϴ�."));
		pane.addTab("���� ����", new JTextArea("������ ����Ǹ� �÷��� Ÿ�� ������ ������, �ϴ��� '����'��ư�� �ٽ� Ȱ��ȭ�ǰ�, \n'����'��ư�� �ٽ� Ŭ���ϸ� �� ������ ������ �� �ֽ��ϴ�."));
		return pane;
	}
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class RSP_Game extends JFrame {
	MyDialog dialog = new MyDialog(this, "���ӹ�� ����");

	private JLabel imgLabel = new JLabel();

	public RSP_Game() {
		setTitle("�������� ����");
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 300);
		
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();

		MenuActionListener listener = new MenuActionListener();

		JMenu screenMenuA = new JMenu("����");
		JMenuItem menuItemA = new JMenuItem("���� ����");
		menuItemA.addActionListener(listener);
		screenMenuA.add(menuItemA);
		screenMenuA.addSeparator();

		JMenuItem menuItemB = new JMenuItem("����");
		menuItemB.addActionListener(listener);
		screenMenuA.add(menuItemB);

		JMenu screenMenuB = new JMenu("���� ���");
		JMenuItem menuItemC = new JMenuItem("���� ��� ����");
		menuItemC.addActionListener(listener);
		screenMenuB.add(menuItemC);

		screenMenuB.addActionListener(listener);

		mb.add(screenMenuA);
		mb.add(screenMenuB);
		setJMenuBar(mb);
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) { // �޴� �������� ���� ����
			case "���� ����":
				new Main_Game();
				break;
			case "���� ��� ����":
				dialog.setVisible(true);
				break;
			case "����":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new RSP_Game();
	}
}
