package MandelbrotSet;
import objectdraw.*;

//import javax.xml.stream.Location;


public class CartesianPlane {
	
		DrawingCanvas myCanvas;

		// boundaries
		private double xMin,
					   xMax,
					   yMin,
					   yMax;

		// Cartesian distance between adjacent rows of pixels:
		double dx;
		// Cartesian distance between adjacent columns of pixels:
		double dy;

		// Default Constructor
		public CartesianPlane(DrawingCanvas c)
		{	this(-10, -10, 10, 10, c);
			myCanvas = c;
		}

		
		// Constructor
		public CartesianPlane(double xMin,double yMin, double xMax,double yMax, DrawingCanvas c)
		{
			myCanvas = c;
			// complete:
			dx = (xMax - xMin)/myCanvas.getWidth();
			dy = (yMax - yMin)/myCanvas.getHeight();
			this.xMin = xMin; this.xMax = xMax;
			this.yMin = yMin; this.yMax = yMax;
		}
		
		
		
		private double pixelXToCartesianX (double h)
		{
			// complete:
			double x;
			x = xMin + h *dx;
		
			return x;    }
		
		
		
		private double pixelYToCartesianY (double v)
		{
		    // complete:
			double y;
			y = yMax - v *dy;
			
			return y;   }
		
		
		
		public Location pixelLocationToCartesian(Location pixLoc)
		{
			double x = this.pixelXToCartesianX(pixLoc.getX());
			double y = this.pixelYToCartesianY(pixLoc.getY());
			
			return new Location (x,y);   }
		
		
		
		private double cartesianXToPixelX  (double x)
		{
			double h;
			h = (x - xMin)/ dx;

			return h;    }
		
		
		
		private double cartesianYToPixelY  (double y)
		{
			double v;
			v = (y - yMax)/-dy;
			
			return v;  }
		
		
		
		public Location cartesianLocationToPixel(Location cartLoc)
		{
			double x = this.cartesianXToPixelX(cartLoc.getX());
			double y = this.cartesianYToPixelY(cartLoc.getY());
		
			
			return new Location (x,y);    }
		
		
		
		//method that zooms image in, by a factor of 4.
		public void zoom(double x, double y)
		{
			
			double cartWidth = xMax - xMin;
			double cartHeight = yMax - yMin;
			double pntX = this.pixelXToCartesianX(x);
			double pntY = this.pixelYToCartesianY(y);
			
			xMax = pntX + cartWidth/4;
			yMax = pntY + cartHeight/4;
			xMin = pntX - cartWidth/4;
			yMin = pntY - cartHeight/4;
			
			dx = dx/2;
			dy = dy/2;
			
			
		}
		
		
		/*
		 * 
		 * 
		 * zoom screen by a specified amount
		 * h
		 * 
		 * 
		 * 
		public void zoomV2(double a, double b, int h)
		{
			double cartW = xMax- xMin;
			double cartH = yMax- yMin;
			double 

			
					
		}
		
		

		*/
		
		
		
		// accessors
		public double getdx()
		{
			return dx;
		}
		public double getdy()
		{
			return dy;
		}
		public double getxMin()
		{
			return xMin;
		}
		public double getxMax()
		{
			return xMax;
		}
		public double getyMin()
		{
			return yMin;
		}
		public double getyMax()
		{
			return yMax;
		}

		public void drawAxes()
		{
		// complete:
			new Line (cartesianXToPixelX(0), 0, cartesianXToPixelX(0), myCanvas.getHeight(), myCanvas);
			new Line (0, cartesianYToPixelY(0), myCanvas.getWidth(), cartesianYToPixelY(0), myCanvas);
		}

		
	}




