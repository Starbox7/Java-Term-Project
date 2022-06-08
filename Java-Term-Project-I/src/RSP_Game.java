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
		pane.addTab("게임 시작", new JTextArea("화면 하단에 있는 '시작' 버튼을 클릭하면 상단의 가위, 바위, 보 버튼이 활성화 되면서 플레이타임을 측정합니다."));
		pane.addTab("게임 진행", new JTextArea("게임이 시작되면 '시작'버튼은 비활성화 되고,\n상단의 가위,바위,보 버튼을 클릭할 때마다 컴퓨터와 대결을 해서 이길때까지 플레이 합니다."));
		pane.addTab("게임 종료", new JTextArea("게임이 종료되면 플레이 타임 측정이 끝나고, 하단의 '시작'버튼이 다시 활성화되고, \n'시작'버튼을 다시 클릭하면 새 게임을 진행할 수 있습니다."));
		return pane;
	}
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class RSP_Game extends JFrame {
	MyDialog dialog = new MyDialog(this, "게임방식 설명");

	private JLabel imgLabel = new JLabel();

	public RSP_Game() {
		setTitle("별상자의 게임");
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 300);
		
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();

		MenuActionListener listener = new MenuActionListener();

		JMenu screenMenuA = new JMenu("게임");
		JMenuItem menuItemA = new JMenuItem("게임 실행");
		menuItemA.addActionListener(listener);
		screenMenuA.add(menuItemA);
		screenMenuA.addSeparator();

		JMenuItem menuItemB = new JMenuItem("종료");
		menuItemB.addActionListener(listener);
		screenMenuA.add(menuItemB);

		JMenu screenMenuB = new JMenu("게임 방식");
		JMenuItem menuItemC = new JMenuItem("게임 방식 설명");
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
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "게임 실행":
				new Main_Game();
				break;
			case "게임 방식 설명":
				dialog.setVisible(true);
				break;
			case "종료":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new RSP_Game();
	}
}
