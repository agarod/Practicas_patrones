class LspTest
{
	private static Motor getMotor()
	{
		// it can be an object returned by some factory ... 
		return new Wankel();
	}

	public static void main (String args[])
	{
		Motor r = LspTest.getMotor();
        
		r.setCarrera(86);
		r.setDiametro(86);
		r.setCilindrada(1300);
		// user knows that r it's a rectangle. 
		// It assumes that he's able to set the width and height as for the base class

		System.out.println(r.getArea());
		System.out.println((r.getCilindrada()));
		// now he's surprised to see that the area is 100 instead of 50.
	}
}