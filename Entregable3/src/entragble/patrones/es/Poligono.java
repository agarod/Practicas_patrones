package entragble.patrones.es;



public class Poligono {
		private Integer dimension1;
		private Integer dimension2;
		private EstadoPoligono estado;
		
		public Poligono(){
			estado= new Rectangulo();
		}
		
		public Integer getDimension1(){
			return dimension1;
		}
		
		public void setDimension1(Integer dimension1){
			this.dimension1= dimension1;
		}
		
		public Integer getDimension2(){
			return dimension2;
		}
		
		public void setDimension2(Integer dimension2){
			this.dimension2= dimension2;
		}
		public void dibuja(Poligono poligono) {
			estado.dibuja(poligono);
		}
				
	}