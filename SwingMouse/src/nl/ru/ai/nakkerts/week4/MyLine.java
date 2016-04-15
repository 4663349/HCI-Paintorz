package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine implements Drawable {

	private double x1, x2, y1, y2;
	private Color color;

	public MyLine() {
	}

	public MyLine(double x1, double y1, double x2, double y2) {
		this.x1 = x1; 	// coordinates added are x1, y1 and x2 and y2 are in relation to that
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics2D g) {
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g.setColor(color);
		g.draw(line);

	}

	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = y2;
		this.y2 = y2;

	}

	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public boolean contains(double x, double y) {
		if (((x1<=x && x<=x2) || (x2<=x && x<=x1))  &&  ((y1<=y && y<=y2) || (y2<=y && y<=y1))){
			return true;
		} else return false;

	}

	@Override
	public boolean amShape(String shapeName) {
		return shapeName == "line";
	}

}
