package UI;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CashierView {
	protected final ImageView logoView = new ImageView();
	protected final Image logo = new Image(("E&Elogo.png"));
	protected Scene MainScene;
	protected GridPane grid = new GridPane();
	protected Stage mStage = new Stage();
	protected String mtitle = new String();
	protected String currentUser;
	protected boolean isBlack = false;
	
	public CashierView(Stage Stage, String title){
		mStage.setTitle(mtitle);
		initGrid();
		mStage = Stage;
		mtitle = title;
		MainScene = new Scene (grid);
		mStage.setScene(MainScene);
	}
	
	public void startStage(String name){
		currentUser = name;
		mStage.setTitle(mtitle + name);
		mStage.setResizable(false);
		mStage.show();
	}
	
	public void showStage(){
		mStage.setResizable(false);
		mStage.show();
	}
	
	public void closeStage(){
		mStage.close();
	}
	
	public void resetStage(){
		mStage.hide();
		mStage.show();
	}
	
	
	
	public void initLogo() {
		logoView.setImage(logo);
		logoView.setFitHeight(75);
		logoView.setPreserveRatio(true);
		GridPane.setConstraints(logoView, 0, 0);
		grid.getChildren().add(logoView);
		
		logoView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		         if(isBlack){
		        	 grid.setStyle(null);
		        	 isBlack = false;
		         }
		         else {
		        	 grid.setStyle("-fx-base: Black;");
		        	 isBlack = true;
		         }
		     }
		});
	}

	public void initGrid(){
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(12);
		grid.setHgap(10);
	}
	
	public GridPane getGrid(){
		return grid;
	}
}
