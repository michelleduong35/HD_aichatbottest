package application.controller;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainController {
	@FXML HBox mainBox;
	
	@FXML 
	public void initialize() {
		showHomeOp();
	}
	
	@FXML public void showHomeOp(){

		URL url = getClass().getClassLoader().getResource("view/homePage.fxml");
		
		try {
			FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            HomeController homeController = loader.getController();
            homeController.updateCategoriesDisplay();
			
			if (mainBox.getChildren().size() > 1) {
				mainBox.getChildren().remove(1);
			}
			
			mainBox.getChildren().add(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML public void showNewCategoryOp() {

    	URL url = getClass().getClassLoader().getResource("view/addCategory.fxml");
		
		try {
			AnchorPane pane2 = (AnchorPane) FXMLLoader.load(url);
			
			if (mainBox.getChildren().size() > 1) {
				mainBox.getChildren().remove(1);
			}
			
			mainBox.getChildren().add(pane2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
