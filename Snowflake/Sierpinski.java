import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SierpinskiPanel extends JPanel {
	public SierpinskiPanel() {
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
		g.setColor(Color.BLUE);
		triangle(g, 400, 0, 0);
		
	}

	public void triangle(Graphics g, int size, int x, int y) {
		// TODO Auto-generated method stub
		if(size==1)
			return;
		triangle(g, size/2, x, y + size/2);
		triangle(g, size/2, x, y);
		triangle(g, size/2, x + size/2,  y);
		g.drawLine(x, y, x, y+size);
		g.drawLine(x, y, x+size, y);
		g.drawLine(x, y+size, x+size, y);
	}

	
}

public class Sierpinski {
	public static void main(String[] args) {
		/*
		 * A frame is a container for a panel The panel is where the drawing will take
		 * place
		 */
		JFrame frame = new JFrame("Sierpinski");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SierpinskiPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
