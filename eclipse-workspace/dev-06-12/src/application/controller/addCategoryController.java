package application.controller;
import java.io.IOException;
import java.net.URL;

import application.CommonObjs;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;


public class addCategoryController {
	
	private CommonObjs commonObjs = CommonObjs.getInstance();
	
	@FXML
	private TextField categoryNameInput;
	
	@FXML public void showHomeOp(){

		URL url = getClass().getClassLoader().getResource("view/homePage.fxml");
		
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(url);
			HBox mainBox = commonObjs.getMainBox();
			
			if (mainBox.getChildren().size() > 1) {
				mainBox.getChildren().remove(1);
			}
			
			mainBox.getChildren().add(pane);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@FXML public void addCategoryOp(){
		
		String categoryName = categoryNameInput.getText();
		
		if (!categoryName.isEmpty()) {
            commonObjs.addCategory(categoryName);

            URL url = getClass().getClassLoader().getResource("view/homePage.fxml");
		
            try {
            	FXMLLoader loader = new FXMLLoader(url);
                AnchorPane pane2 = loader.load();
            	HBox mainBox = commonObjs.getMainBox();
			
            	if (mainBox.getChildren().size() > 1) {
            		mainBox.getChildren().remove(1);
            	}
			
            	mainBox.getChildren().add(pane2);
            	
            	HomeController homeController = loader.getController();
                homeController.updateCategoriesDisplay();
			
            } catch (IOException e) {
            	e.printStackTrace();
            }
		}
    }
	
}
