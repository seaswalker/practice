package net;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

/**
 * swing显示html内容
 * @author skywalker
 *
 */
public class HTMLTest {

	public static void main(String[] args) throws IOException {
		JFrame jFrame = new JFrame();
		JEditorPane panel = new JEditorPane();
		panel.setPage("http://www.baidu.com");
		panel.setText("<body>hello</body>");
		panel.setBackground(Color.white);
		panel.setEditable(false);
		jFrame.setContentPane(panel);
		jFrame.setBounds(200, 200, 500, 400);
		jFrame.setVisible(true);
	}
	
}
