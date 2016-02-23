package MandelbrotSet;

import objectdraw.*;

import java.awt.Color;

//import cs1.*;
//import javax.sound.sampled.Line;
//import javax.xml.stream.Location;

/**
   @Author: Brendan Rejevich 
      Date: 24 November 2014
   Teacher: Mr. Howell
       Lab: Mandelbrot Set Exploration
      Misc:
  */

public class Mandelbrot extends WindowController{
 
	private static final long serialVersionUID = 1L;
	private static final int MAX_ITERATIONS = 512;
	private static final double initXMin = -2;
	private static final double initXMax = 1;
	private static final double initYMin = -1.5;
	private static final double initYMax = 1.5;
	private CartesianPlane p;
 
  private void getBoundaries()
  {

  	/*double xMin,xMax,yMin,yMax;
	
  	System.out.print("Enter xMin: ");
  	xMin= Keyboard.readDouble();
  	
  	System.out.print("Enter xMax: ");
  	xMax= Keyboard.readDouble();
  	
  	System.out.print("Enter yMin: ");
  	yMin= Keyboard.readDouble();
  	
  	System.out.print("Enter yMax: ");
  	yMax= Keyboard.readDouble();
  	*/
  	
  	double xMin = initXMin;
  	double xMax = initXMax;
  	double yMin = initYMin;
  	double yMax = initYMax;
  	
  	p = new CartesianPlane(xMin,yMin,xMax,yMax,canvas);
  	
  }
  
  
  
  
  // pass in cx # , z0, 
  public static int dwellMandelbrot(Complex z0)
  { //dwell.  the # of iterations it took to escape
	  	Complex z = new Complex(z0);
	  	int k = 1;
	  	while (k < MAX_ITERATIONS)
	  	{
	  		if(z.squareDistance() > 4){
	  			return k;
	  			}
	  		z = Complex.add(z0,Complex.multiply(z, z));
	  		k++;
	  	}  return k;
  }
  
  
  
 
  public void drawMandelbrotSet()
  {
  	double x;
  	double y;
  	
  	for (int h = 0; h < canvas.getWidth();h++)
  	{
  		
  		for (int v = 0; v < canvas.getHeight();v++)
  		{
  			Location loc = new Location (h,v);
  			Location cartLoc = p.pixelLocationToCartesian(loc);
  			x = cartLoc.getX();
  			y = cartLoc.getY();
  			
  			Complex z = new Complex(x,y);
  	
  			int clr = 5305982*dwellMandelbrot(z);
  			Line l = new Line(h,v,h,v,canvas);
  			
  			l.setColor(new Color(clr));
  			
  		}
  		
  	}
  }
  
  
  public void begin() {
  
  	getBoundaries();
  	canvas.clear();
  	
  	drawMandelbrotSet();
  	
  }
  
  
  
  public void onMouseClick(Location point) {
  		canvas.clear();
  		p.zoom(point.getX(), point.getY());
  		drawMandelbrotSet();
  
  }
  
}
