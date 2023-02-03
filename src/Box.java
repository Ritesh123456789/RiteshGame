import java.util.List;



import javafx.scene.image.Image;

public class Box extends Actor{

	double moveAmount;
	double goldBoxes;
	boolean increment;
	public Box() {
		String path = getClass().getClassLoader().getResource("Resources/box.png").toString();
		Image img = new Image(path,75, 75, false, false);
		this.setImage(img);
		moveAmount = 75;
		goldBoxes = 0;
		increment = false;
	}
	
	@Override
	public void act(long now) {


		Dot dot = this.getOneIntersectingObject(Dot.class);
		if(dot != null) {
			

			String shadePath = getClass().getClassLoader().getResource("Resources/dot_box.png").toString();
			Image boxImg = new Image(shadePath,75, 75, false, false);
			this.setImage(boxImg);
			
			increment = true;
			
			
		}
		if(dot == null) {
			
			String shadePath = getClass().getClassLoader().getResource("Resources/box.png").toString();
			Image boxImg = new Image(shadePath,75, 75, false, false);
			this.setImage(boxImg);
			
			increment = false;

		}
		System.out.println("increment:  " + increment);

	}
	
	
	public boolean moveLeft(){
		
		List<Box> boxArr = this.getIntersectingObjects(Box.class);
		boolean moveBox = true;
		for(int i = 0; i < boxArr.size(); i++) {
			if(this.getX() == boxArr.get(i).getX() + moveAmount && this.getY() == boxArr.get(i).getY()) {
				moveBox = false;
				break;
			}
		}
		
		List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
		for(GravelBlock gravel: gravelArr) {
			if(this.getX() == gravel.getX() + gravel.getWidth() && this.getY() >= gravel.getY() && this.getY() < gravel.getY() + gravel.getHeight()) {
				moveBox = false;
				break;
			}
		}
		if(this.getX() - moveAmount >= 0 && moveBox) {
			this.move(-moveAmount,0);
			return true;
		}
		return false;
	}
	
	public boolean moveRight(){
		
		List<Box> boxArr = this.getIntersectingObjects(Box.class);
		boolean moveBox = true;
		for(int i = 0; i < boxArr.size(); i++) {
			if(this.getX() + moveAmount == boxArr.get(i).getX() && this.getY() == boxArr.get(i).getY()) {
				moveBox = false;
				break;
			}
		}
		
		List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
		for(GravelBlock gravel: gravelArr) {
			if(this.getX() + moveAmount == gravel.getX() && this.getY() >= gravel.getY() && this.getY() < gravel.getY() + gravel.getHeight()) {
				moveBox = false;
				break;
			}
		}
		if(this.getX() + moveAmount*2 <= this.getWorld().getWidth() && moveBox) {
			this.move(moveAmount,0);
			return true;
		}
		return false;
	}
	public boolean moveUp(){
		
		List<Box> boxArr = this.getIntersectingObjects(Box.class);
		boolean moveBox = true;
		for(int i = 0; i < boxArr.size(); i++) {
			if(this.getY() == boxArr.get(i).getY() + moveAmount && this.getX() == boxArr.get(i).getX()) {
				moveBox = false;
				break;
			}
		}
		
		List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
		for(GravelBlock gravel: gravelArr) {
			if(this.getY() == gravel.getY() + gravel.getHeight() && this.getX() >= gravel.getX() && this.getX() < gravel.getX() + gravel.getWidth()) {
				moveBox = false;
				break;
			}
		}
		if(this.getY() - moveAmount >= 0 && moveBox) {
			this.move(0, -moveAmount);
			return true;
		}
		return false;
	}
	public boolean moveDown(){
		
		List<Box> boxArr = this.getIntersectingObjects(Box.class);
		boolean moveBox = true;
		for(int i = 0; i < boxArr.size(); i++) {
			if(this.getY() + moveAmount == boxArr.get(i).getY() && this.getX() == boxArr.get(i).getX()) {
				moveBox = false;
				break;
			}
		}
		
		List<GravelBlock> gravelArr = this.getIntersectingObjects(GravelBlock.class);
		for(GravelBlock gravel: gravelArr) {
			if(this.getY() + moveAmount == gravel.getY() && this.getX() >= gravel.getX() && this.getX() < gravel.getX() + gravel.getWidth()) {
				moveBox = false;
				break;
			}
		}
		if(this.getY() + moveAmount*2 <= this.getWorld().getHeight() && moveBox) {
			this.move(0,moveAmount);
			return true;
		}
		return false;
	}

}
