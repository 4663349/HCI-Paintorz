package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Drawable {

	public void draw(Graphics2D g);

	public void setCoordinates(double x1, double x2, double y1, double y2);

	public boolean contains(double x, double y);

	public void setColor(Color color2);
	
	public boolean amShape(String shapeName);
	
	
}
