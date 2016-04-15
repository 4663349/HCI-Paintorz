package nl.ru.ai.nakkerts.week4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle implements Drawable {

	private double x1, y1, x2, y2;   // je krijgt meestal een x1 en een y1 mee als startpunt en een x2 en een y2 als eindpunt. Handig is om x1 en y1 niet te updaten, maar x2 en y2 wel.
	private Color color;

	public MyRectangle() {
	}

	public MyRectangle(double x1, double y1, double x2, double y2) {  
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics2D g) {
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		Rectangle2D r = new Rectangle2D.Double(x, y, width, height);  // tekent als volgt x,y als startlocatie en dan width naar rechts en height omlaag
		g.setColor(color);
		g.fill(r);
		g.draw(r);
	}

	private double getWidth() {
		return Math.abs(x1 - x2);  	//verschil tussen x1 en x2 is natuurlijk de breedte
	}

	private double getHeight() {  	// verschil tussen y1 en y2 is natuurlijk de hoogte. Waarom zo aan je width en niet direct meegeven?
									// vooral bij dingen als drag wil je in de min kunnen gaan (dan teken je namelijk vanuit x1 en y1 naar linksboven, anders is alleen naar rechtsbeneden mogelijk)
		return Math.abs(y1 - y2); 
	}

	private double getStartX() {
		return Math.min(x1, x2);
	}

	private double getStartY() {
		return Math.min(y1, y2);
	}

	public void setCoordinates(double x1, double y1, double x2, double y2) { //let op de volgorde. Eerst x1 en y1, dan pas x2 en y2
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
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
		// TODO Auto-generated method stub
		return shapeName == "Rectangle";
	}

}