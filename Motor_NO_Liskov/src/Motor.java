class Motor
{
	protected int _carrera;
	protected int _diametro;
	protected int _cilindrada;
	private double pi = 3.14;

	public void setCilindrada(int cilindrada){
		_cilindrada = cilindrada;
	}
	public void setCarrera(int carrera){
		_carrera = carrera;
	}

	public void setDiametro(int diametro){
		_diametro = diametro;
	}


	public int getCarrera(){
		return _carrera;
	}

	public int getCilindrada(){
		return _cilindrada;
	}

	public double getArea(){
		return _carrera*_carrera * _diametro * pi;
	}	
}