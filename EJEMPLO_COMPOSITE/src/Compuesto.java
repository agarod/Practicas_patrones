import java.util.ArrayList;

class Compuesto extends Componente
{
	private ArrayList<Componente> hijo = new ArrayList<Componente>();
	public Compuesto (String name)
	{
		super(name);
	}
	@Override
	public void agregar(Componente componente)
	{
		hijo.add(componente);
	}
	@Override
	public void eliminar(Componente componente)
	{
		hijo.remove(componente);
	}
	@Override
	public void mostrar(int profundidad)
	{
		System.out.println(nombre + " nivel: " + profundidad);
		for (int i = 0; i < hijo.size(); i++)
			hijo.get(i).mostrar(profundidad + 1);
	}
}