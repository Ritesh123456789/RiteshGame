package ritesh.game1;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;



public class Person extends Actor{
	
	int moveAmount;
	
	public Person() {
		String path = getClass().getClassLoader().getResource("Resources/human.png").toString();
		Image img = new Image(path,75, 75, false, false);
		this.setImage(img);
		moveAmount = 75;
	
	}
	


	@Override
	public void act(long now) {
		boolean moveBox = false;
		List<Box> arr =  this.getWorld().getObjects(Box.class);
		
		if(Game.level == 1) {
			int counter = 0;
			for(Box box : arr) {
				if(box.increment == true) {
					counter++;
				}
			}

			if(counter == 7) {
				Game.level++;
				((PlayerWorld)getWorld()).getGame().startWorld();
				
			}
		}else if(Game.level == 2) {
			int counter = 0;
			for(Box box : arr) {
				if(box.increment == true) {
					counter++;
				}
			}

			if(counter == 7) {
				Game.level++;
				((PlayerWorld)getWorld()).getGame().startWorld();
				
			}
		}else if(Game.level == 3) {
			int counter = 0;
			for(Box box : arr) {
				if(box.increment == true) {
					counter++;
				}
			}

			if(counter == 10) {
				Game.level++;
				((PlayerWorld)getWorld()).getGame().startWorld();
				
			}
		}
		
				
		if( getWorld().isKeyDown(KeyCode.LEFT)) {
			moveLeft();
						
		}
		if( getWorld().isKeyDown(KeyCode.RIGHT)) {
			moveRight();
			
		}
		if( getWorld().isKeyDown(KeyCode.UP)) {
			moveUp();
		}
		if( getWorld().isKeyDown(KeyCode.DOWN)) {
			moveDown();
		}
		if(getWorld().isKeyDown(KeyCode.SPACE)) {
			int counter = 0;
			if(counter == 0) {
				((PlayerWorld)getWorld()).getGame().startWorld();
			}
			counter++;
		}
		
		
	}
	
	public void moveRight() {
		if(!(this.getX() + moveAmount > Game.upperBoundX)) {
			List<Box> boxArr = this.getIntersectingObjects(Box.class);
			Box moveBox = null;
			for(int i = 0; i < boxArr.size(); i++) {
				if(this.getX() + moveAmount == boxArr.get(i).getX() && this.getY() == boxArr.get(i).getY()) {
					moveBox = boxArr.get(i);
				}
			}
			if(moveBox != null) {
				boolean movePerson = moveBox.moveRight();
				if(movePerson) {
					this.move(moveAmount, 0);
				}
			}else if(moveBox == null && this.getX() + moveAmount < this.getWorld().getWidth()) {
				boolean movePerson = true;
				List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
				for(GravelBlock gravel: gravelArr) {
					if(this.getX() + moveAmount == gravel.getX() && this.getY() >= gravel.getY() && this.getY() < gravel.getY() + gravel.getHeight()) {
						movePerson = false;
						break;
					}
				}
				if(movePerson) {
					this.move(moveAmount, 0);
				}
			}
		}
	}
	
	public void moveLeft() {
		if(!(this.getX() - moveAmount < Game.lowerBoundX)) {
			List<Box> boxArr = this.getIntersectingObjects(Box.class);
			Box moveBox = null;
			for(int i = 0; i < boxArr.size(); i++) {
				if(this.getX() == boxArr.get(i).getX() + moveAmount && this.getY() == boxArr.get(i).getY()) {
					moveBox = boxArr.get(i);
				}
			}
			if(moveBox != null) {
				boolean movePerson = moveBox.moveLeft();
				if(movePerson) {
					this.move(-moveAmount, 0);
				}
			}else if(moveBox == null && this.getX() - moveAmount >= 0) {
				boolean movePerson = true;
				List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
				for(GravelBlock gravel: gravelArr) {
					if(this.getX() == gravel.getX() + gravel.getWidth() && this.getY() >= gravel.getY() && this.getY() < gravel.getY() + gravel.getHeight()) {
						movePerson = false;
						break;
					}
				}
				if(movePerson) {
					this.move(-moveAmount, 0);
				}
			}
		}
	}
	
	public void moveUp() {
		if(!(this.getY() - moveAmount < Game.lowerBoundY)) {
			List<Box> boxArr = this.getIntersectingObjects(Box.class);
			Box moveBox = null;
			for(int i = 0; i < boxArr.size(); i++) {
				if(this.getY() == boxArr.get(i).getY() + moveAmount && this.getX() == boxArr.get(i).getX()) {
					moveBox = boxArr.get(i);
				}
			}
			if(moveBox != null) {
				boolean movePerson = moveBox.moveUp();
				if(movePerson) {
					this.move(0, -moveAmount);
				}
			}else if(moveBox == null && this.getY() - moveAmount >= 0) {
				boolean movePerson = true;
				List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
				for(GravelBlock gravel: gravelArr) {
					if(this.getY() == gravel.getY() + gravel.getHeight() && this.getX() >= gravel.getX() && this.getX() < gravel.getX() + gravel.getWidth()) {
						movePerson = false;
						break;
					}
				}
				if(movePerson) {
					this.move(0, -moveAmount);
				}
			}
		}
	}
	
	public void moveDown() {
		if(!(this.getY() + moveAmount > Game.upperBoundY)) {
			List<Box> boxArr = this.getIntersectingObjects(Box.class);
			Box moveBox = null;
			for(int i = 0; i < boxArr.size(); i++) {
				if(this.getY() + moveAmount == boxArr.get(i).getY() && this.getX() == boxArr.get(i).getX()) {
					moveBox = boxArr.get(i);
				}
			}
			if(moveBox != null) {
				boolean movePerson = moveBox.moveDown();
				if(movePerson) {
					this.move(0, moveAmount);
				}
			}else if(moveBox == null && this.getY() + moveAmount < this.getWorld().getHeight()) {
				boolean movePerson = true;
				List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
				for(GravelBlock gravel: gravelArr) {
					if(this.getY() + moveAmount == gravel.getY() && this.getX() >= gravel.getX() && this.getX() < gravel.getX() + gravel.getWidth()) {
						movePerson = false;
						break;
					}
				}
				if(movePerson) {
					this.move(0, moveAmount);
				}
			}
		}
	}

	
}
