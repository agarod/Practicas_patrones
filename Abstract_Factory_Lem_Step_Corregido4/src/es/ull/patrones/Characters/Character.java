package es.ull.patrones.Characters;





import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import varios.CharacterStats;
import varios.CommonCode;
import Mediator.CanalEmisora;
import es.ull.patrones.Location.Location;
import es.ull.patrones.Map.Direccion;
import es.ull.patrones.Map.Habitacion;
import es.ull.patrones.Map.LugarDelMapa;



public abstract class Character extends Entity{
    Animation animationUp, animationDown, animationLeft, animationRight;
    protected Animation currentRenderable;
    CommonCode.CharacterDirection currentDirection;
    CharacterStats characterStats;
	private String nombre;
	private Location location = new Location();
	
	
	public Character(Animation up, Animation down, Animation left, Animation right,
            float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight,CharacterStats stats) {
        
        super(x, y, colxOffset, colyOffset, colWidth, colHeight);
        animationUp = up;
        animationDown = down;
        animationLeft = left;
        animationRight = right;
        
        characterStats = stats;
        currentRenderable = animationDown;
        currentDirection = CommonCode.CharacterDirection.Down;
    }
	 public Character( String animPathName, int [] duration, float x, float y, float colxOffset, float colyOffset, float colWidth, float colHeight,CharacterStats stats ) throws SlickException {
	        super(x, y, colxOffset, colyOffset, colWidth, colHeight);
	        animationUp = new Animation(new Image[]{new Image(animPathName + "_bk1.gif"), new Image(animPathName + "_bk2.gif")}, duration, false);
	        animationDown = new Animation(new Image[]{new Image(animPathName + "_fr1.gif"), new Image(animPathName + "_fr2.gif")}, duration, false);
	        animationLeft = new Animation(new Image[]{new Image(animPathName + "_lf1.gif"), new Image(animPathName + "_lf2.gif")}, duration, false);
	        animationRight = new Animation(new Image[]{new Image(animPathName + "_rt1.gif"), new Image(animPathName + "_rt2.gif")}, duration, false);
	        
	        currentRenderable = animationDown;
	        currentDirection = CommonCode.CharacterDirection.Down;
	        characterStats = stats;
	    }
	 
	  public void update( long delta ) {
	        currentRenderable.update( delta );
	    }
	  public void ChangeRenderCharacterDirection(CommonCode.CharacterDirection direction) {
	        switch (direction) {
	            case Up:
	                currentRenderable = animationUp;
	                currentDirection = CommonCode.CharacterDirection.Up;
	                break;

	            case Down:
	                currentRenderable = animationDown;
	                currentDirection = CommonCode.CharacterDirection.Down;
	                break;

	            case Left:
	                currentRenderable = animationLeft;
	                currentDirection = CommonCode.CharacterDirection.Left;
	                break;

	            case Right:
	                currentRenderable = animationRight;
	                currentDirection = CommonCode.CharacterDirection.Right;
	                break;
	        }
	    }

	  public CommonCode.CharacterDirection GetCharacterDirection() {
	        return currentDirection;
	    }

	    public Animation GetCharacterRenderableDirection(){
	        return currentRenderable;
	    }
	    
	    public CharacterStats GetCharacterStats(){
	    	return characterStats.Clone();
	    }
	    public void SetSpeed(float speed){
	        characterStats.SetSpeed(speed);
	    }
	    
	    public void MoveUp(){
	        y -= characterStats.GetSpeed();
	        collisionBox.setY(collisionBox.getY() - characterStats.GetSpeed());
	    }

	    public void MoveDown(){
	        y += characterStats.GetSpeed();
	        collisionBox.setY(collisionBox.getY() + characterStats.GetSpeed());
	    }

	    public void MoveLeft(){
	        x -= characterStats.GetSpeed();
	        collisionBox.setX(collisionBox.getX() - characterStats.GetSpeed());
	    }

	    public void MoveRight(){
	        x += characterStats.GetSpeed();
	        collisionBox.setX(collisionBox.getX() + characterStats.GetSpeed());
	    }

	    public void Render() {
	        currentRenderable.draw(x, y);
	    }
	
	public abstract void action();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public void setLocation(Habitacion habitacion) {
//		int num_hab = habitacion.getNumeroHabitacion();
//		this.location.setHabitacion(num_hab);
//	}
	
	public void move(Direccion direccion, Habitacion habitacion){
		System.out.println(this.nombre+" esta entrando en "+habitacion.getNumeroHabitacion());
		LugarDelMapa objet;
		objet = habitacion.obtenerLado(direccion);
		objet.Entrar(this);
	}
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	//Paso un objeto habitación en lugar del identificador de la habitación
	//para dar la posibilidad de que un personaje s mueva entre laberintos 
	//a traves de una habitación que sea un tunel entre ambos mapas
	public void setLocation(Habitacion habitacion) {
		int num_hab = habitacion.getNumeroHabitacion();
		this.location.setHabitacion(num_hab);
	}
	public abstract void recibe(String de, String msg);
	public abstract void envia(CanalEmisora mensaje, String de, String msg);
	
}
