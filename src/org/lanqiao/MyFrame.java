package org.lanqiao;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class MyFrame {
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setSize(500, 500);
		w.add(new Panel() {
			public void paint(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(0, 0, 500, 500);
				g.setColor(Color.WHITE);
				for (int i = 0; i < 300; i++) {
					g.drawString("*", (int) (Math.random() * 1024), (int) (Math.random() * 768));
				}
				// g.fillOval(800, 100, 100, 100);
				// g.setColor(Color.BLACK);
				// g.fillOval(780, 80, 100, 100);
			}
		});
		w.show();
	}
}
