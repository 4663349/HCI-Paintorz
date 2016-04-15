package nl.ru.ai.nakkerts.week4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements ActionListener {
	private DrawPanel panel;
	private double x1, x2, y1, y2, diffx, diffy;
	public InputHandler(DrawPanel panel) {
	this.panel = panel;
	}

	private void placeRect() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				double x = evt.getX();
				double y = evt.getY();
				panel.addRectangle(x, y);
			}
		});
	}

	private void placeEllipse() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				double x = evt.getX();
				double y = evt.getY();
				panel.addEllipse(x-25, y-25);
			}
		});
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
	
	private void placeLine() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				double x = evt.getX();
				double y = evt.getY();
				panel.addLine(x, y);
			}
		});
	}

	private void removeClicked() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				double x = evt.getX();
				double y = evt.getY();
				System.out.println("X:" + x + " ,Y:" + y);
				panel.removeShapeAt(x, y);
			}
		});
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Rectangle")) {
			placeRect();
			// panel.addRectangle(x,y);
		} else if (e.getActionCommand().equals("Ellipse")) { //set mode ellipse 
			placeEllipse();
		} else if (e.getActionCommand().equals("Line")) { // set mode line
			placeLine();
		//} else if (e.getActionCommand().equals("add")) { // set mode random
		//	panel.addRandomShape();
		//} else if (e.getActionCommand().equals("mod")) { // set mode modrandom
		//	panel.alterNextShape();
		} else if (e.getActionCommand().equals("Remove")) { // set mode remove 
			removeClicked();
			// panel.removePreviousShape(); //deze haalt simpelweg de laatst
			// geplaatste shape weg
		} else if (e.getActionCommand().equals("Resize")) { // set mode resize
			changeShape();
		} else if (e.getActionCommand().equals("Move")) { // set mode resize
			moveClicked();
		} else if (e.getActionCommand().equals("Borders")) { // set mode resize
			addBorder();
		}

	}

	private void addBorder() { //empty indeed
		// TODO Auto-generated method stub
		
	}

	private void moveClicked() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				x1 = evt.getX();
				y1 = evt.getY();
				diffx = panel.getDiffX(x1,y1);
				diffy = panel.getDiffY(x1,y1);
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						panel.moveShape(diffx,diffy, x2, y2);
					}
				});
			}
			public void mouseReleased(java.awt.event.MouseEvent evt2) {
				x2 = evt2.getX();
				y2 = evt2.getY();
				panel.moveShape(diffx, diffy, x2, y2);
			}
		});
	}

	private void changeShape() {
		if ((panel.getMouseListeners() != null) || (panel.getMouseMotionListeners() != null)) {
			removeListener();
		}
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				x1 = evt.getX();
				y1 = evt.getY();
				panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseDragged(java.awt.event.MouseEvent mrd) {
						x2 = mrd.getX();
						y2 = mrd.getY();
						panel.changeShape(x1, y1, x2, y2);
					}
				});
			}
			public void mouseReleased(java.awt.event.MouseEvent evt2) {
				x2 = evt2.getX();
				y2 = evt2.getY();
				panel.changeShape(x1, y1, x2, y2);
			}
		});
	}
}
