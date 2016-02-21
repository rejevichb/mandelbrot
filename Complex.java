package MandelbrotSet;

public class Complex {
	
	//private instance variables
	private double re;
	private double im;
	
	
	//default constructor
	public Complex()
	{
		re = 0;
		im = 0;
	}
	
	//constructor with two formal parameters of double type - one for a 
	// real number, re, and one for an imaginary number, im
	public Complex(double a, double b)
	{
		re = a;
		im = b;
	}
	
	//copy constructor - makes a copy of complex c into a new complex number
	public Complex(Complex c)
	{
		this.re = c.getReal();
		this.im = c.getImaginary();
	}
	
	
	// to string method
	public String toString()
	{
		String result = "";
		result += re+ " + "+ im + "i";
		return result;
	}
	
	
	//mutator method - adds this.complex number with 
	//a cx number, c, passed as a parameter 
	public void add(Complex c)
	{
		re += c.getReal();
		im += c.getImaginary();
	}
	
	//static method - adds 2 cx numbers both which have been passed in
	public static Complex add(Complex c1, Complex c2)
	{
		return new Complex(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
	}
	
	public void multiply(Complex c)
	{
		double chuckysteve = re;
		re = this.getReal() * c.getReal() - this.getImaginary() * c.getImaginary();
		im = chuckysteve * c.getImaginary() + this.getImaginary() * c.getReal();
		
	}
	
	//static multiply 
	public static Complex multiply(Complex c1, Complex c2)
	{
		Complex sstrachan = new Complex(c1);
		sstrachan.multiply(c2);;
		return sstrachan;
	}
	
	public double squareDistance()
	{
		return re*re + im*im + (im * re + re * im); 
	}
	
	
	//accessor methods. return real, imaginary
	public double getReal()
	{
		return re;
	}
	public double getImaginary()
	{
		return im;
	}
	
	//main method
	public static void main(String [] args)
	{
		//Complex z1 = new Complex(12, -5);
		
		
		//Complex z2 = new Complex(-3, 10);	
		//z1.multiply(z2);
		//System.out.println(z1);
		
		/*Complex z3 = new Complex(z2);
		z3.add(z2);
		System.out.println("The above number added to the first number equals:  " + z3);
		*/
	}

}
