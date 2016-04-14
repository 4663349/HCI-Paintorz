package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse implements Drawable {

	private double x1, y1, x2, y2;
	private Color color;

	

	public MyEllipse() {
	}

	public MyEllipse(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics2D g) {
		double x = getStartX(x1,x2);
		double y = getStartY(y1,y2);
		double width = getWidth(x1,x2);
		double height = getHeight(y1,y2);
		Ellipse2D e = new Ellipse2D.Double(x, y, width, height);
		g.setColor(color);
		g.fill(e);
		g.draw(e);
	}

	private double getWidth(double x1, double x2) {
		return Math.abs(x1-x2);
	}

	private double getHeight(double y1, double y2) {
		return Math.abs(y1-y2);
	}

	private double getStartX(double x1, double x2) {
		return Math.min(x1, x2);
	}

	private double getStartY(double y1, double y2) {
		return Math.min(y1, y2);
	}
/** 
 * sets ellipse coordinates with the smallest of (x1,x2) and the smallest of (y1,y2) as the top left location.
 * 
 */
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public boolean contains(double x, double y) {
		if (((x1<=x && x<=x2) || (x2<=x && x<=x1))  &&  ((y1<=y && y<=y2) || (y2<=y && y<=y1))) {
			return true;
		} else
			return false;

	}

	@Override
	public boolean amShape(String shapeName) {
		return shapeName == "Ellipse";
	}
}
