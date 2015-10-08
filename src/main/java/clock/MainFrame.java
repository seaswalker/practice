package clock;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import util.ClockUtil;
import java.awt.Toolkit;

/**
 * 主界面
 * @author skywalker
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 6142025233554231866L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/clock/clock.png")));
		setResizable(false);
		setTitle("\u65F6\u949F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point point = ClockUtil.getMiddlePoint(300, 300);
		setBounds(point.x, point.y, 300, 300);
		Panel contentPane = new Panel(300, 300, 260);
		Thread thread = new Thread(contentPane);
		setContentPane(contentPane);
		thread.start();
	}

}
