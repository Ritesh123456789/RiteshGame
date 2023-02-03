

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Game extends Application{
	
    Stage primaryStage;
    PlayerWorld world = new PlayerWorld(this);
	static int level = 1;
	static double upperBoundX;
	static double lowerBoundX;
	static double lowerBoundY;
	static double upperBoundY;
	final int size = 75;
	

	
	public static void main(String args[]) {
		launch(args);
		/*
		 --module-path /Users/ritesh/workspace/school/lib/javafx/lib --add-modules=javafx.controls --add-opens=javafx.graphics/javafx.scene=ALL-UNNAMED --add-exports javafx.base/com.sun.javafx.event=ALL-UNNAMED
		 
		 */
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sokoban");
		
		
		this.primaryStage = primaryStage;
		
		BorderPane titleScreen = new BorderPane();
		Scene title = new Scene(titleScreen,600,675);
		Label start = new Label("Welcome");
		titleScreen.setTop(start);
		Button play = new Button("Play");
		Label vol = new Label("Volume");
		Slider slider = new Slider();
		titleScreen.setBottom(vol);
		titleScreen.setBottom(slider);
		titleScreen.setCenter(play);
		play.setOnAction(new EventHandler() {

			@Override
			public void handle(Event event) {
				startWorld();
				
			}});
		
		
		
		
		
		primaryStage.setScene(title);
		primaryStage.show();
		
		
	}

		public void startWorld() {
			world.clearChildren();
			if(level == 1) {
				level1();
			}
			if(level == 2) {
				level2();
			}
			if(level == 3) {
				level3();
			}
			if(level == 4) {
				primaryStage.setTitle("Sokoban");
				
				
				this.primaryStage = primaryStage;
				
				BorderPane titleScreen = new BorderPane();
				Scene title = new Scene(titleScreen,600,675);
				Label label = new Label("Game Over");
				titleScreen.setTop(label);
				Button restart = new Button("Restart");
				Label vol = new Label("Volume");
				Slider slider = new Slider();
				titleScreen.setCenter(restart);
				restart.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {
						level = 1;
						startWorld();
						
					}});
				
				
				
				
				
				primaryStage.setScene(title);
				primaryStage.show();
			}
		}
		
		public void level4() {
			
		}
		
		public void level3() {
			world.clearChildren();
			BorderPane rootNode = new BorderPane();
			rootNode.setCenter(world);
			Scene scene = new Scene(rootNode,14*size, 10*size);
			
			GravelBlock gravel = new GravelBlock(size*12, size);
			world.add(gravel);
			
			GravelBlock gravel1 = new GravelBlock(size, size*7);
			world.add(gravel1);
			
			GravelBlock gravel2 = new GravelBlock(size, size*9);
			gravel2.setX(size*13);
			gravel2.setY(size);
			world.add(gravel2);
			
			GravelBlock gravel3 = new GravelBlock(size*12, size);
			gravel3.setX(size*2);
			gravel3.setY(size*9);
			world.add(gravel3);
			
			GravelBlock gravel4 = new GravelBlock(size*5, size);
			gravel4.setX(size);
			gravel4.setY(size*6);
			world.add(gravel4);
			
			GravelBlock gravel5 = new GravelBlock(size, size*2);
			gravel5.setX(size*2);
			gravel5.setY(size*7);
			world.add(gravel5);
			
			GravelBlock gravel6 = new GravelBlock(size, size*3);
			gravel6.setX(size*5);
			gravel6.setY(size);
			world.add(gravel6);
			

			GravelBlock gravel7 = new GravelBlock(size*4, size);
			gravel7.setX(size*7);
			gravel7.setY(size*3);
			world.add(gravel7);
			
			GravelBlock gravel8 = new GravelBlock(size*2, size);
			gravel8.setX(size*9);
			gravel8.setY(size*4);
			world.add(gravel8);
			
			GravelBlock gravel9 = new GravelBlock(size, size*2);
			gravel9.setX(size*7);
			gravel9.setY(size*5);
			world.add(gravel9);
			
			GravelBlock gravel10 = new GravelBlock(size, size);
			gravel10.setX(size*8);
			gravel10.setY(size*6);
			world.add(gravel10);
			
			GravelBlock gravel11 = new GravelBlock(size, size);
			gravel11.setX(size*7);
			gravel11.setY(size*8);
			world.add(gravel11);
			
			GravelBlock gravel12 = new GravelBlock(size, size);
			gravel12.setX(size*12);
			gravel12.setY(size*5);
			world.add(gravel12);
			
			GravelBlock gravel13 = new GravelBlock(size*3, size);
			gravel13.setX(size*11);
			gravel13.setY(size);
			world.add(gravel13);
			
			
			GravelBlock gravel14 = new GravelBlock(size, size);
			gravel14.setX(size*5);
			gravel14.setY(size*5);
			world.add(gravel14);
			
			Box box = new Box();
			box.setX(size*6);
			box.setY(size*3);
			world.add(box);
			
			Box box1 = new Box();
			box1.setX(size*7);
			box1.setY(size*2);
			world.add(box1);
			
			Box box2 = new Box();
			box2.setX(size*10);
			box2.setY(size*2);
			world.add(box2);
			
			Box box3 = new Box();
			box3.setX(size*10);
			box3.setY(size*5);
			world.add(box3);
			
			Box box4 = new Box();
			box4.setX(size*11);
			box4.setY(size*6);
			world.add(box4);
			
			Box box5 = new Box();
			box5.setX(size*11);
			box5.setY(size*7);
			world.add(box5);
			
			Box box6 = new Box();
			box6.setX(size*9);
			box6.setY(size*6);
			world.add(box6);
			
			Box box7 = new Box();
			box7.setX(size*9);
			box7.setY(size*7);
			world.add(box7);
			
			Box box8 = new Box();
			box8.setX(size*7);
			box8.setY(size*7);
			world.add(box8);
			
			Box box9 = new Box();
			box9.setX(size*4);
			box9.setY(size*7);
			world.add(box9);
			
			Dot dot = new Dot();
			dot.setX(size + size/2 - dot.getWidth()/2);
			dot.setY(size + size/2 - dot.getHeight()/2);
			world.add(dot);
			
			Dot dot1 = new Dot();
			dot1.setX(size + size/2 - dot1.getWidth()/2);
			dot1.setY(size*2 + size/2 - dot1.getHeight()/2);
			world.add(dot1);
			
			Dot dot2 = new Dot();
			dot2.setX(size + size/2 - dot2.getWidth()/2);
			dot2.setY(size*3 + size/2 - dot2.getHeight()/2);
			world.add(dot2);
			
			Dot dot3 = new Dot();
			dot3.setX(size + size/2 - dot3.getWidth()/2);
			dot3.setY(size*4 + size/2 - dot3.getHeight()/2);
			world.add(dot3);
			
			Dot dot4 = new Dot();
			dot4.setX(size + size/2 - dot4.getWidth()/2);
			dot4.setY(size*5 + size/2 - dot4.getHeight()/2);
			world.add(dot4);
			
			Dot dot5 = new Dot();
			dot5.setX(size*2 + size/2 - dot5.getWidth()/2);
			dot5.setY(size + size/2 - dot5.getHeight()/2);
			world.add(dot5);
			
			Dot dot6 = new Dot();
			dot6.setX(size*2 + size/2 - dot6.getWidth()/2);
			dot6.setY(size*2 + size/2 - dot6.getHeight()/2);
			world.add(dot6);
			
			Dot dot7 = new Dot();
			dot7.setX(size*2 + size/2 - dot7.getWidth()/2);
			dot7.setY(size*3 + size/2 - dot7.getHeight()/2);
			world.add(dot7);
			
			Dot dot8 = new Dot();
			dot8.setX(size*2 + size/2 - dot8.getWidth()/2);
			dot8.setY(size*4 + size/2 - dot8.getHeight()/2);
			world.add(dot8);
			
			Dot dot9 = new Dot();
			dot9.setX(size*2 + size/2 - dot9.getWidth()/2);
			dot9.setY(size*5 + size/2 - dot9.getHeight()/2);
			world.add(dot9);
			
			
			Person person = new Person();
			person.setX(size*3);
			person.setY(size*2);
			world.add(person);
			
			
			
			
			
			
			world.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.addKeyCode(event.getCode());
					
					}});
			
			world.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.removeKeyCode(event.getCode());
					upperBoundX = person.getX() + 75;
					lowerBoundX = person.getX() - 75;
					upperBoundY = person.getY() + 75;
					lowerBoundY = person.getY() - 75;
					}});
			
			primaryStage.setScene(scene);
			world.requestFocus();
			world.start();
			primaryStage.show();
			
		}

		private void level2() {
			BorderPane rootNode = new BorderPane();
			rootNode.setCenter(world);
			Scene scene = new Scene(rootNode, 600, 675);
			
			GravelBlock gravel = new GravelBlock(size * 5, size);
			gravel.setX(size * 2);
			world.add(gravel);
			
			GravelBlock gravel1 = new GravelBlock(size, size*8);
			gravel1.setY(size);
			world.add(gravel1);
			
			GravelBlock gravel2 = new GravelBlock(size*8, size);
			gravel2.setY(size*8);
			world.add(gravel2);
			
			GravelBlock gravel3 = new GravelBlock(size, size*6);
			gravel3.setX(size*6);
			world.add(gravel3);
			
			GravelBlock gravel4 = new GravelBlock(size*2, size);
			gravel4.setX(size);
			gravel4.setY(size);
			world.add(gravel4);
			
			GravelBlock gravel5 = new GravelBlock(size, size*3);
			gravel5.setX(size*7);
			gravel5.setY(size*5);
			world.add(gravel5);
			
			GravelBlock gravel6 = new GravelBlock(size*2, size);
			gravel6.setX(size);
			gravel6.setY(size*3);
			world.add(gravel6);
			
			GravelBlock gravel7 = new GravelBlock(size, size);
			gravel7.setX(size*3);
			gravel7.setY(size*4);
			world.add(gravel7);
			
			GravelBlock gravel8 = new GravelBlock(size, size*3);
			gravel8.setX(size*2);
			gravel8.setY(size*3);
			world.add(gravel8);
			
			GravelBlock gravel9 = new GravelBlock(size, size);
			gravel9.setX(size*5);
			gravel9.setY(size*7);
			world.add(gravel9);
			
			GravelBlock gravel10 = new GravelBlock(size, size);
			gravel10.setX(size*3);
			gravel10.setY(size*5);
			world.add(gravel10);
			
			Person person = new Person();
			person.setX(size*2);
			person.setY(size*2);
			world.add(person);
			
			Box box = new Box();
			box.setX(size*3);
			box.setY(size*2);
			world.add(box);
			
			Box box1 = new Box();
			box1.setX(size*4);
			box1.setY(size*3);
			world.add(box1);
			
			Box box2 = new Box();
			box2.setX(size*4);
			box2.setY(size*4);
			world.add(box2);
			
			Box box3 = new Box();
			box3.setX(size);
			box3.setY(size*6);
			world.add(box3);
			
			Box box4 = new Box();
			box4.setX(size*3);
			box4.setY(size*6);
			world.add(box4);

			Box box5 = new Box();
			box5.setX(size*4);
			box5.setY(size*6);
			world.add(box5);
			
			Box box6 = new Box();
			box6.setX(size*5);
			box6.setY(size*6);
			world.add(box6);
			
			
			Dot dot = new Dot();
			dot.setX(size + size/2 - dot.getWidth()/2);
			dot.setY(size * 2 + size/2 - dot.getHeight()/2);
			world.add(dot);
			
			Dot dot1 = new Dot();
			dot1.setX(size*5 + size/2 - dot1.getWidth()/2);
			dot1.setY(size*3 + size/2 - dot1.getHeight()/2);
			world.add(dot1);
			
			Dot dot2 = new Dot();
			dot2.setX(size + size/2 - dot2.getWidth()/2);
			dot2.setY(size * 4 + size/2 - dot2.getHeight()/2);
			world.add(dot2);
			
			Dot dot3 = new Dot();
			dot3.setX(size*4 + size/2 - dot3.getWidth()/2);
			dot3.setY(size*5 + size/2 - dot3.getHeight()/2);
			world.add(dot3);
			
			Dot dot4 = new Dot();
			dot4.setX(size*4 + size/2 - dot4.getWidth()/2);
			dot4.setY(size*7 + size/2 - dot4.getHeight()/2);
			world.add(dot4);
			
			Dot dot5 = new Dot();
			dot5.setX(size*6 + size/2 - dot5.getWidth()/2);
			dot5.setY(size*6 + size/2 - dot5.getHeight()/2);
			world.add(dot5);
			
			Dot dot6 = new Dot();
			dot6.setX(size*3 + size/2 - dot6.getWidth()/2);
			dot6.setY(size*6 + size/2 - dot6.getHeight()/2);
			world.add(dot6);
			
			world.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.addKeyCode(event.getCode());
					
					}});
			
			world.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.removeKeyCode(event.getCode());
					upperBoundX = person.getX() + 75;
					lowerBoundX = person.getX() - 75;
					upperBoundY = person.getY() + 75;
					lowerBoundY = person.getY() - 75;
					}});
			

			primaryStage.setScene(scene);
			world.requestFocus();
			world.start();
			primaryStage.show();
		}

		public void level1() {
			BorderPane rootNode = new BorderPane();
			rootNode.setCenter(world);
			Scene scene = new Scene(rootNode, 600, 675);
			
			GravelBlock gravel = new GravelBlock(size * 5, size);
			gravel.setX(size * 2);
			world.add(gravel);
			
			GravelBlock gravel1 = new GravelBlock(size, size*8);
			gravel1.setY(size);
			world.add(gravel1);
			
			GravelBlock gravel2 = new GravelBlock(size*8, size);
			gravel2.setY(size*8);
			world.add(gravel2);
			
			GravelBlock gravel3 = new GravelBlock(size, size*6);
			gravel3.setX(size*6);
			world.add(gravel3);
			
			GravelBlock gravel4 = new GravelBlock(size*2, size);
			gravel4.setX(size);
			gravel4.setY(size);
			world.add(gravel4);
			
			GravelBlock gravel5 = new GravelBlock(size, size*3);
			gravel5.setX(size*7);
			gravel5.setY(size*5);
			world.add(gravel5);
			
			GravelBlock gravel6 = new GravelBlock(size*2, size);
			gravel6.setX(size);
			gravel6.setY(size*3);
			world.add(gravel6);
			
			GravelBlock gravel7 = new GravelBlock(size, size);
			gravel7.setX(size*3);
			gravel7.setY(size*4);
			world.add(gravel7);
			
			GravelBlock gravel8 = new GravelBlock(size, size*3);
			gravel8.setX(size*2);
			gravel8.setY(size*3);
			world.add(gravel8);
			
			
			Person person = new Person();
			person.setX(size*2);
			person.setY(size*2);
			world.add(person);
			
			Box box = new Box();
			box.setX(size*3);
			box.setY(size*2);
			world.add(box);
			
			Box box1 = new Box();
			box1.setX(size*4);
			box1.setY(size*3);
			world.add(box1);
			
			Box box2 = new Box();
			box2.setX(size*4);
			box2.setY(size*4);
			world.add(box2);
			
			Box box3 = new Box();
			box3.setX(size);
			box3.setY(size*6);
			world.add(box3);
			
			Box box4 = new Box();
			box4.setX(size*3);
			box4.setY(size*6);
			world.add(box4);

			Box box5 = new Box();
			box5.setX(size*4);
			box5.setY(size*6);
			world.add(box5);
			
			Box box6 = new Box();
			box6.setX(size*5);
			box6.setY(size*6);
			world.add(box6);
			
			
			Dot dot = new Dot();
			dot.setX(size + size/2 - dot.getWidth()/2);
			dot.setY(size * 2 + size/2 - dot.getHeight()/2);
			world.add(dot);
			
			Dot dot1 = new Dot();
			dot1.setX(size*5 + size/2 - dot1.getWidth()/2);
			dot1.setY(size*3 + size/2 - dot1.getHeight()/2);
			world.add(dot1);
			
			Dot dot2 = new Dot();
			dot2.setX(size + size/2 - dot2.getWidth()/2);
			dot2.setY(size * 4 + size/2 - dot2.getHeight()/2);
			world.add(dot2);
			
			Dot dot3 = new Dot();
			dot3.setX(size*4 + size/2 - dot3.getWidth()/2);
			dot3.setY(size*5 + size/2 - dot3.getHeight()/2);
			world.add(dot3);
			
			Dot dot4 = new Dot();
			dot4.setX(size*4 + size/2 - dot4.getWidth()/2);
			dot4.setY(size*7 + size/2 - dot4.getHeight()/2);
			world.add(dot4);
			
			Dot dot5 = new Dot();
			dot5.setX(size*6 + size/2 - dot5.getWidth()/2);
			dot5.setY(size*6 + size/2 - dot5.getHeight()/2);
			world.add(dot5);
			
			Dot dot6 = new Dot();
			dot6.setX(size*3 + size/2 - dot6.getWidth()/2);
			dot6.setY(size*6 + size/2 - dot6.getHeight()/2);
			world.add(dot6);
			
			world.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.addKeyCode(event.getCode());
					
					}});
			
			world.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					world.removeKeyCode(event.getCode());
					upperBoundX = person.getX() + 75;
					lowerBoundX = person.getX() - 75;
					upperBoundY = person.getY() + 75;
					lowerBoundY = person.getY() - 75;
					}});
			

			primaryStage.setScene(scene);
			world.requestFocus();
			world.start();
			primaryStage.show();
			
			
		}

		public static void gameOver() {
			
			
		}
	
}