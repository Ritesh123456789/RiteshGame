package ritesh.game1;


import java.util.ArrayList;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public abstract class World extends javafx.scene.layout.Pane{
    private AnimationTimer timer;

   private HashSet<KeyCode> keys = new HashSet<>();
    
    public World() {
        timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				try {
					for(Node i: getChildren()){
						if(i instanceof Actor) {
							
								((Actor)i).act(now);
							
						}
					}
				}catch(Exception e) {
					
				}
				
				
			}
        	
        };
 }

    public abstract void act(long now);

    public void addKeyCode(KeyCode k) {
    	keys.add(k);
    }
    public void removeKeyCode(KeyCode k) {
    	keys.remove(k);
    }
    public boolean isKeyDown(KeyCode e) {
    	return keys.contains(e);
    }
    
    public void clearChildren() {
		getChildren().clear();
	}
    

    public void add(Actor actor) {
        super.getChildren().add(actor);

    }

    public void remove(Actor actor) {
        super.getChildren().remove(actor);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }


    public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls) {
        ArrayList<A> list = new ArrayList<A>();
        for(int i = 0 ; i < super.getChildren().size() ; i++) {
            if(cls.isInstance(super.getChildren().get(i))) {
                list.add(cls.cast(super.getChildren().get(i)));
            }
        }

        return list;

    }

}