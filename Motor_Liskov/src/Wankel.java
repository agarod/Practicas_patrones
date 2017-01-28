class Wankel implements IMotor
{
	private int _diametro;
	private int _cilindrada;
	private double pi = 3.14;
	public void setCarrera(int carrera){
		//_carrera = carrera;
		_diametro = carrera;
	}

	public void setHeight(int diametro){
		//_carrera = diametro;
		 _diametro = diametro;
	}
	public void setCilindrada(int cilindrada){
		_cilindrada = cilindrada;
	}

	@Override
	public double GetVolumen() {
		// TODO Auto-generated method stub
		return ((_diametro/2)*(_diametro/2)*(_diametro/2)*4*pi)/3;
	}

	@Override
	public void setDiametro(int diametro) {
		// TODO Auto-generated method stub
		
	}

}