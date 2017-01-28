class Hoja extends Componente
{
	public Hoja (String nombre)
	{
		super(nombre);
	}
	public void agregar(Componente c)
	{
		System.out.println("no se puede agregar la hoja");
	}
	public void eliminar(Componente c)
	{
		System.out.println("no se puede quitar la hoja");
	}
	public void mostrar(int depth)
	{
		System.out.println('-' + "" + nombre);
	}
}