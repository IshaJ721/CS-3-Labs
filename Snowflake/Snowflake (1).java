import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel {
	public SnowFlakePanel() {
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		Random rd = new Random();
		int R, G, B, size, x, y;
		for (int i = 0; i < 35; i++) {
			size = rd.nextInt(30);
			R = rd.nextInt(256);
			G = rd.nextInt(256);
			B = rd.nextInt(256);
			g.setColor(new Color(R,G,B));
			x = rd.nextInt(width+1);
			y = rd.nextInt(height+1);
			snowflake(g, x, y, size);
			
		}
	}

	public void snowflake(Graphics g, int x, int y, int size) {
		if(size <= 7)
			return;
		else
		{
			for(int i = 0; i<6; i++)
			{
				snowflake(g, (int)(x+size*Math.cos(i*((2*Math.PI)/6))), (int)(y+size*Math.sin(i*((2*Math.PI)/6))), size/3);
				g.drawLine(x, y, (int)(x+size*Math.cos(i*((2*Math.PI)/6))), (int)(y+size*Math.sin(i*((2*Math.PI)/6))));
			}
		}

	}
}

public class Snowflake {
	public static void main(String[] args) {
		/*
		 * A frame is a container for a panel The panel is where the drawing will take
		 * place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}