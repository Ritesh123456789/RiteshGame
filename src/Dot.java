import javafx.scene.image.Image;

public class Dot extends Actor{
	

	public Dot() {
		String path = getClass().getClassLoader().getResource("Resources/dot.png").toString();
		Image img = new Image(path);
		this.setImage(img);

	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
}
