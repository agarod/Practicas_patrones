class Motor implements IMotor
{
	protected int _carrera;
	protected int _diametro;
	protected int _cilindrada;
	private double pi = 3.14;

	@Override
	public void setCilindrada(int cilindrada){
		_cilindrada = cilindrada;
	}
	@Override
	public void setCarrera(int carrera){
		_carrera = carrera;
	}
	@Override
	public void setDiametro(int diametro){
		_diametro = diametro;
	}


	public int getCarrera(){
		return _carrera;
	}

	public int getCilindrada(){
		return _cilindrada;
	}


	@Override
	public double GetVolumen() {
		// TODO Auto-generated method stub
		return _carrera*_carrera * _diametro * pi;
	}
		
}