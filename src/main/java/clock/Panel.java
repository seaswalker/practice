package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.util.Calendar;

import javax.swing.JPanel;

/**
 * 自定义面板
 * @author skywalker
 *
 */
public class Panel extends JPanel implements Runnable {

	private static final long serialVersionUID = -7660471285610393704L;
	/**windows标题栏高度**/
	private static final int TOOLBARHEIGHT = 30;
	/**圆心的直径**/
	private static final int OVALDIAMETER = 16;
	/**刻度的长度**/
	private static final int SCALELENGTH = 20;
	/**时针长度**/
	private static final int HOURHAND = 60;
	/**分针长度**/
	private static final int MINUTEHAND = 80;
	/**秒针长度**/
	private static final int SECONDHAND = 100;
	/**panel的尺寸**/
	private int panelWidth;
	private int panelHeight;
	/**表的大小**/
	private int clockDigmeter;
	private Color color = null;
	/**表盘圆心**/
	private Point clockCenter = null;
	/**圆框的起点**/
	private int ovalX;
	private int ovalY;

	public Panel(int panelWidth, int panelHeight, int clockDigmeter) {
		this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
		this.clockDigmeter = clockDigmeter;
	}
	
	@Override
	public void paint(Graphics g) {
		//表盘
		drawBack(g);
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		double angle = 0;
		//画出时针
		//12进制的小时
		angle = hour * Math.PI / 6 + minute * Math.PI / 360;
		drawHand(g, angle, 4.0f, HOURHAND);
		//画出分针
		angle = minute * Math.PI / 30;
		drawHand(g, angle, 3.0f, MINUTEHAND);
		//画秒针
		angle = second * Math.PI / 30;
		drawHand(g, angle, 2.0f, SECONDHAND);
	}
	
	/**
	 * 画出表盘
	 */
	private void drawBack(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//圆框的横、纵起点
		ovalX = (panelWidth - clockDigmeter - 4) / 2;
		ovalY = (panelHeight - clockDigmeter - TOOLBARHEIGHT) / 2;
		//画出圆框
		g.drawOval(ovalX, ovalY, clockDigmeter, clockDigmeter);
		//画出0、6刻度
		Line2D.Double scale = new Line2D.Double(ovalX + clockDigmeter / 2, ovalY, ovalX + clockDigmeter / 2, ovalY + clockDigmeter);
		g2.draw(scale);
		//画出1、7刻度
		double temp = (1 - Math.sqrt(3) / 2) * clockDigmeter / 2;
		scale = new Line2D.Double(ovalX + clockDigmeter * 0.75, ovalY + temp, ovalX + 0.25 * clockDigmeter, ovalY + clockDigmeter - temp);
		g2.draw(scale);
		//5、11刻度，和上面的对称
		scale = new Line2D.Double(ovalX + clockDigmeter * 0.75, ovalY + clockDigmeter - temp, ovalX + 0.25 * clockDigmeter, ovalY + temp);
		g2.draw(scale);
		//画出2、8刻度
		temp = (Math.sqrt(3) / 4) * clockDigmeter;
		scale = new Line2D.Double(ovalX + temp + 0.5 * clockDigmeter, ovalY + 0.25 * clockDigmeter, 
				ovalX + 0.5 * clockDigmeter - temp, ovalY + clockDigmeter * 0.75);
		g2.draw(scale);
		//4、10刻度，和2、8对称
		scale = new Line2D.Double(ovalX + temp + 0.5 * clockDigmeter, ovalY + 0.75 * clockDigmeter, 
				ovalX + 0.5 * clockDigmeter - temp, ovalY + clockDigmeter * 0.25);
		g2.draw(scale);
		//3、9刻度
		scale = new Line2D.Double(ovalX + clockDigmeter, ovalY + 0.5 * clockDigmeter, ovalX, ovalY + 0.5 * clockDigmeter);
		g2.draw(scale);
		//画一个圆做出刻度效果
		color = g2.getColor();
		g2.setColor(new Color(238, 238, 238));
		g2.fillOval(ovalX + SCALELENGTH,  ovalY + SCALELENGTH, clockDigmeter - 2 * SCALELENGTH, clockDigmeter - 2 * SCALELENGTH);
		g2.setColor(color);
		//画出圆心
		color = g.getColor();
		g.setColor(Color.darkGray);
		g.fillOval(ovalX + (clockDigmeter - OVALDIAMETER) / 2,  ovalY + (clockDigmeter - OVALDIAMETER) / 2, 
				OVALDIAMETER, OVALDIAMETER);
		g.setColor(color);
		//算出表的圆心
		clockCenter = new Point(ovalX + clockDigmeter / 2, ovalY + clockDigmeter / 2);
	}
	
	/**
	 * 画针
	 * @param thick 浮点数画笔的粗细
	 * @param length 针的长度
	 * @param angle 角度
	 */
	private void drawHand(Graphics g, double angle, float thick, int length) {
		Graphics2D g2 = (Graphics2D) g;
		Stroke stroke = g2.getStroke();
		//设置画笔粗细
		g2.setStroke(new BasicStroke(thick));
		double beginX = ovalX + clockDigmeter * 0.5 + length * Math.sin(angle);
		double beginY = ovalY + clockDigmeter * 0.5 - length * Math.cos(angle);
		Line2D.Double hand = new Line2D.Double(beginX, beginY, clockCenter.x, clockCenter.y);
		g2.draw(hand);
		g2.setStroke(stroke);
	}

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);
				repaint();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
