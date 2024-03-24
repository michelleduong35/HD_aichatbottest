package application.controller;

import application.CommonObjs;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class HomeController {
	
	@FXML
    private VBox categoriesContainer;

    public void updateCategoriesDisplay() {
        List<String> categories = CommonObjs.getInstance().getCategories();
        categoriesContainer.getChildren().clear(); // Clear existing content
        for (String category : categories) {
            categoriesContainer.getChildren().add(new Label(category));
        }
    }

}
