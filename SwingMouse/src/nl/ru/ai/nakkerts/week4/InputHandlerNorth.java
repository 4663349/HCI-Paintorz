package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandlerNorth implements ActionListener {
	private DrawPanel panel;
	private double x1, y1;
	private Color color;

	public InputHandlerNorth(DrawPanel panel) {
		this.panel = panel;
	}

	private void removeListener() {
		MouseMotionListener[] lijst = panel.getMouseMotionListeners();
		for (int b = 0; b < lijst.length; b++) {
			panel.removeMouseMotionListener(lijst[b]);
		}
		MouseListener[] list = panel.getMouseListeners();
		for (int i = 0; i < list.length; i++) {
			panel.removeMouseListener(list[i]);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("black")) {
			color = color.black;
			changeColor();
		} else if (e.getActionCommand().equals("blue")) {
			color = color.blue;
			changeColor();
		} else if (e.getActionCommand().equals("cyan")) {
			color = color.cyan;
			changeColor();
		} else if (e.getActionCommand().equals("darkgray")) {
			color = color.darkGray;
			changeColor();
		} else if (e.getActionCommand().equals("gray")) {
			color = color.gray;
			changeColor();
		} else if (e.getActionCommand().equals("lightgray")) {
			color = color.lightGray;
			changeColor();
		} else if (e.getActionCommand().equals("green")) {
			color = color.green;
			changeColor();
		} else if (e.getActionCommand().equals("magenta")) {
			color = color.magenta;
			changeColor();
		} else if (e.getActionCommand().equals("orange")) {
			color = color.orange;
			changeColor();
		} else if (e.getActionCommand().equals("pink")) {
			color = color.pink;
			changeColor();
		} else if (e.getActionCommand().equals("red")) {
			color = color.red;
			changeColor();
		} else if (e.getActionCommand().equals("yellow")) {
			color = color.yellow;
			changeColor();
		} else if (e.getActionCommand().equals("white")) {
			color = color.white;
			changeColor();
		}

	}

	private void changeColor() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				x1 = evt.getX();
				y1 = evt.getY();
				panel.changeColor(x1, y1, color);
			}
		});
	}

}
