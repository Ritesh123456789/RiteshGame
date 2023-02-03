
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public abstract class Actor extends javafx.scene.image.ImageView{
	
	public abstract void act(long now);
	
	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
		this.getParent();
	}
	
	public double getWidth() {
		return getBoundsInLocal().getWidth();
	}
	
	public double getHeight() {
		return getBoundsInLocal().getHeight();
	}
	
	public World getWorld(){
		return (World) this.getParent();
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		ArrayList<Actor> intersectingObjects = new ArrayList<>();
		ArrayList<Node> allObjects = new ArrayList<>();
		allObjects.addAll( this.getWorld().getChildren());
		
		
		for(int i = 0; i < allObjects.size(); i++) {
			if(this != allObjects.get(i) && this.intersects(allObjects.get(i).getBoundsInLocal())) {
				
					
				//cls.getClass().cast(allObjects.get(i));
				if(allObjects.get(i).getClass().isAssignableFrom(cls)) {
					intersectingObjects.add(cls.cast(allObjects.get(i)));
					System.out.println("intersect");
				}
					
					
				
				
			}
		}
		
		return (List<A>) intersectingObjects;
		
		
	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
		ArrayList<Node> allObjects = new ArrayList<>();
		allObjects.addAll( this.getParent().getChildrenUnmodifiable());
		
		for(int i = 0; i < allObjects.size(); i++) {
			if(this != allObjects.get(i) && this.intersects(allObjects.get(i).getBoundsInLocal())) {
				try {
					cls.cast(allObjects.get(i));
					return cls.cast(allObjects.get(i));
					
				}catch(Exception e) {
					
				}
				
			}
		}
		return null;
				
	}
}
