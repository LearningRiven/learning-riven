package trainer;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
		
		setStageProperties(stage);

		stage.setScene(createMainScene());
		stage.show();
		logger.info("Loaded");
	}

	@Override
	public void stop() throws Exception {
		logger.info("Stopping application");
	}
	
	public Parent createRoot() {
		Parent root;
		try {
			root = FXMLLoader.load(Main.class.getResource("fxml/RawDataEntry.fxml"));
			System.out.println(root);
			return root;
		} catch (IOException e) {
			e.printStackTrace();
			return new Parent() {
			};
		}
	}
	
	public Scene createMainScene() {
		Parent root = createRoot();
		Scene scene = new Scene(root, Color.LIGHTSKYBLUE);
		return scene;
	}
	
	public void setStageProperties(Stage stage) {
		stage.setTitle("Riven Tracker");
		stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/ChannelLogo.png")));
	}
		
}
