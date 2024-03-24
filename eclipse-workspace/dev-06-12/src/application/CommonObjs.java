package application;

import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;

public class CommonObjs {
	
	private static CommonObjs commonObjs = new CommonObjs();
	private HBox mainBox;
	private List<String> categories = new ArrayList<>();
	
	private CommonObjs() {}
	
	public static CommonObjs getInstance() {
		return commonObjs;
	}
	
	public HBox getMainBox() {
		return mainBox;
	}
	
	public void setMainBox(HBox mainBox) {
		this.mainBox = mainBox;
	}

	public void addCategory(String category) {
		if (category != null && !category.trim().isEmpty()) {
			categories.add(category);
		}
	}

	public List<String> getCategories() {
		return new ArrayList<>(categories); 
	}
}
