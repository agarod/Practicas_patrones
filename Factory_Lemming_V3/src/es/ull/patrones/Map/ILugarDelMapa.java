package es.ull.patrones.Map;

import es.ull.patrones.Characters.Character;


public interface ILugarDelMapa {

		public void Entrar();

		void Entrar(Character character);

		void Entrar(Direccion direccion);
}
