package ritesh.game1;

import javafx.scene.Node;


public class PlayerWorld extends World{


	private Game game;
	
	public PlayerWorld( Game game) {
		this.game = game;
		
	}
	@Override
	public void act(long now) {
		
		
	}

	public Game getGame() {
		return this.game;
	}
	
	public void clearChildren() {
		getChildren().clear();
	}
	public boolean isGameOver() {
		return false;
	}
	

}
