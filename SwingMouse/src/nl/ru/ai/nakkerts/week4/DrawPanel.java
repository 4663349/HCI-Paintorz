package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private Color color;
	private Random rand = new Random();
	private int index = 0;
	ArrayList<Drawable> shapesList = new ArrayList<Drawable>();

	public DrawPanel() {
		super();
		color = Color.BLACK;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Drawable s : shapesList)
			s.draw(g2d);

	}

	public void setRandomColor() {

		int R = rand.nextInt(256);
		int G = rand.nextInt(256);
		int B = rand.nextInt(256);
		Color color = new Color(R, G, B);
		this.color = color;
		repaint();
	}

	public void addRandomShape() {
		this.color = getRandomColor();
		int flip = getRandomInt(13);
		double x1 = rand.nextInt(550) + 50, x2 = rand.nextInt(550) + 50;
		double y1 = rand.nextInt(350) + 50, y2 = rand.nextInt(350) + 50;

		switch (flip) {
		case 0:
			MyRectangle rect = new MyRectangle();
			rect.setCoordinates(x1, x2, y1, y2);
			rect.setColor(color);
			shapesList.add(rect);
			break;
		case 1:
			MyEllipse elipse = new MyEllipse(x1, y1, 30, 70);
			//elipse.setCoordinates(x1, x2, y1, y2);
			elipse.setColor(color);
			shapesList.add(elipse);
			break;
		case 8:
			MyLine diagRight = new MyLine(x1, x1 + 50, y1, y1 + 50);
			diagRight.setColor(color);
			shapesList.add(diagRight);
			break;
		case 9:
			MyLine hor = new MyLine(x1, x1 + 50, y1, y1);
			hor.setColor(color);
			shapesList.add(hor);
			break;
		case 10:
			MyLine vert = new MyLine(x1, x1, y1, y1 + 50);
			vert.setColor(color);
			shapesList.add(vert);
			break;
		case 11:
			MyLine diagLeft = new MyLine(x1, x1 - 50, y1, y1 - 50);
			diagLeft.setColor(color);
			shapesList.add(diagLeft);
			break;
		case 13: //triangle werkt helaas niet meer
			MyTriangle triangle = new MyTriangle();
			triangle.setPanel(this);
			triangle.setColor(color);
			triangle.setCoordinates(x1, y1, x2, y2);
			shapesList.add(triangle);
			break;
		case 12:
			MyEllipse circle = new MyEllipse(x1 - 30, y1 - 30, 40, 40);
			circle.setColor(color);
			shapesList.add(circle);
			break;
		}
		
		repaint();
		this.index = shapesList.size()-1;
	}

	public Color getRandomColor() {
		int R = rand.nextInt(256);
		int G = rand.nextInt(256);
		int B = rand.nextInt(256);
		Color color = new Color(R, G, B);
		return color;
	}

	public int getRandomInt(int bound) {
		int flip = rand.nextInt(bound);
		if (flip < 4) {
			flip = 0;
		} else if ((flip >= 4) && (flip < 8)) {
			flip = 1;
		}
		return flip;
	}

	
	public void removePreviousShape() {
		int index = shapesList.size() - 1;
		if (index >= 0) {
			shapesList.remove(index);
			repaint();
		}
		this.index= index-1;
	}

	public void alterNextShape() {
		if(shapesList.size()>0){
//		int length = shapesList.size();
		int flip = getRandomInt(12);
		this.color = getRandomColor();
		double x1 = rand.nextInt(650) + 50, x2 = rand.nextInt(650) + 50, x3 = rand.nextInt(650) + 50;
		double y1 = rand.nextInt(450) + 50, y2 = rand.nextInt(450) + 50, y3 = rand.nextInt(450) + 50;

		switch (flip) {
		case 0:
			MyRectangle rect = new MyRectangle();
			rect.setCoordinates(x1, x2, y1, y2);
			rect.setColor(color);
			shapesList.set(index, rect);
			break;
		case 1:
			MyEllipse elipse = new MyEllipse(x1, y1, 50, 50);
			elipse.setColor(color);
			shapesList.set(index, elipse);
			break;
		case 8:
			MyLine diagRight = new MyLine(x1, x1 + 50, y1, y1 + 50);
			diagRight.setColor(color);
			shapesList.set(index, diagRight);
			break;
		case 9:
			MyLine hor = new MyLine(x1, x1 + 50, y1, y1);
			hor.setColor(color);
			shapesList.set(index, hor);
			break;
		case 10:
			MyLine vert = new MyLine(x1, x1, y1, y1 + 50);
			vert.setColor(color);
			shapesList.set(index, vert);
			break;
		case 11:
			MyLine diagLeft = new MyLine(x1, x1 - 50, y1, y1 - 50);
			diagLeft.setColor(color);
			shapesList.set(index, diagLeft);
			break;
		case 12: //triangle werkt helaas niet meer
			MyTriangle triangle = new MyTriangle(x1, y1, x2, y2, x3, y3);
			shapesList.set(index, triangle);
			break;
		}//switch end
		} //if check
		repaint();
		index-=1;
		if (index < 0){
			index = shapesList.size()-1;
		}
	}

	public void addRectangle(double x, double y) {
		MyRectangle rect = new MyRectangle();
		rect.setCoordinates(x,y,x+50,y+50);
		rect.setColor(color);
		shapesList.add(rect);
		repaint();
		this.index = shapesList.size()-1;
	}

	public void addEllipse(double x, double y) {
		MyEllipse elipse = new MyEllipse();
		elipse.setCoordinates(x, y, x+50, y+50); 
		elipse.setColor(color);
		shapesList.add(elipse);
		repaint();
		this.index = shapesList.size()-1;
	}

	public void addLine(double x, double y) {
		MyLine line = new MyLine();
		line.setColor(color);
		line.setCoordinates(x, y, x+50, y+20); 
		shapesList.add(line);
		repaint();
		this.index = shapesList.size()-1;
	}

	
	public void removeShapeAt(double x, double y) {
		for (int i=shapesList.size()-1;i>=0;i--){
			if (shapesList.get(i).contains(x,y)){
				shapesList.remove(i);
				index = index-1;
				 i = 0; // comment dit eruit en je delete alles op punt x,y. De for-loop stopt bij i =0
			}
		}
		
		repaint();
	}

	public void changeShape(double x1, double y1, double x2, double y2) { // doesn't alter shapesList in any meaningful way
		for (int i = shapesList.size() - 1; i >= 0; i--) {
			if (shapesList.get(i).contains(x1, y1)) {
				Drawable temp = shapesList.get(i);
				temp.setCoordinates(x1, y1, x2, y2);
				shapesList.set(i, temp);
				 	i = 0;
				}
				
			}
		
		repaint();
	}

	
	public void changeColor(double x1, double y1, Color color2) {
		for (int i=shapesList.size()-1;i>=0;i--){
			if (shapesList.get(i).contains(x1,y1)){
				Drawable temp = shapesList.get(i);
				temp.setColor(color2);
				shapesList.set(i, temp);
			}
		}
		repaint();
	}

	

}