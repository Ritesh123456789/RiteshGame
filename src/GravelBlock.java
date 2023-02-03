import javafx.scene.image.Image;

public class GravelBlock extends Actor{
	
	public GravelBlock(int length, int height) {
		String path = getClass().getClassLoader().getResource("Resources/gravel.png").toString();
		Image img = new Image(path, length, height, false, false);
		this.setImage(img);

	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
}
