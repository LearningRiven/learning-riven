package learning.riven;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void init() throws Exception {
		logger.info("Preparing for launch");
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		logger.info("Initializing...");
		//Set title
		stage.setTitle("Riven Tracker");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/ChannelLogo.png")));
		
		BorderPane root = new BorderPane();
		fillPane(root);
		
		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.show();
		logger.info("Loaded");
	}

	@Override
	public void stop() throws Exception {
		logger.info("Stopping application");
	}

	public void fillPane(BorderPane root) {
		
	}
		
}
