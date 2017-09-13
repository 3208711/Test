package org.lanqiao;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame("满天星");
		MyPanel panel = new MyPanel();
		frame.add(panel);
		frame.setBackground(Color.BLACK);
		frame.setSize(1024, 768);
		frame.show();// 过时
		frame.setVisible(true);
		System.out.println("change");
		System.out.println("change");
		System.out.println("change");
	}

}

class MyPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i < 300; i++) {
			g.drawString("*", (int) (Math.random() * 1024), (int) (Math.random() * 768));
		}
		//g.fillOval(800, 100, 100, 100);
		//g.setColor(Color.BLACK);
		//g.fillOval(780, 80, 100, 100);
	}
}