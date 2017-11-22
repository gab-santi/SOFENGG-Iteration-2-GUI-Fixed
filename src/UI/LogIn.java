package UI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogIn{
	private TextField usernameField = new TextField();
	private PasswordField passwordField = new PasswordField();
	private Label LabelUser = new Label("Username");
	private Label LabelPass = new Label("Password");
	private GridPane grid = new GridPane();
	private Button LogInButton = new Button("Log In");
	private Stage window = new Stage();

	public LogIn(CashierMain cm) throws Exception{
		window.initModality(Modality.APPLICATION_MODAL); //Blocks access to other windows until this is closed
		window.setTitle("Cashier Login");
		window.setMinWidth(250);
		window.setResizable(false);
		//XXX
		usernameField.setText("Gary");
		initGrid();
		initLogInComp(cm);
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.show();
	}
	
	private void initLogInComp(CashierMain cm) {
		LabelUser.setFont(Font.font("Arial", FontWeight.BLACK, 10));
		LabelPass.setFont(Font.font("Arial", FontWeight.BLACK, 10));
		
		LogInButton.setStyle("-fx-focus-color: transparent; "
				+ "-fx-base: Green; -fx-background-radius: 0%; "
				+ "-fx-font-weight: bold");
		
		LogInButton.setOnAction(e ->  {
			String[] user = getUserInput();
			AlertBox ab = null;
			if(user[0].equals("Gary") && user[1].equals("")){
				closeWindow();
				cm.startStage(user[0]);
				//XXX test data
				//cm.setCustomerLabels("Martinez, Jarod", "Makati, Olympia", 15000, 30000);
				cm.moveToCart("114567", "A tire", 3, 200);
				cm.moveToSearch("1010101", "gass and stuff", 2, 300, "RETAIL SALE");
				cm.addToHold("11/04/2017", "5:30:00 PM", 200.00, "Retail");
				//cm.setTotalPrice(100);
			}
			else{
				ab = new AlertBox("Alert");
				ab.initAlertContents("Wrong Password/and or Username");
				ab.showBox();
			}
		});
		
	}
	
	private void initGrid(){
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(8);
		
		
		GridPane.setConstraints(LabelUser, 0, 0);
		GridPane.setConstraints(usernameField, 1, 0);
		
		GridPane.setConstraints(LabelPass, 0, 1);
		GridPane.setConstraints(passwordField, 1, 1);
		GridPane.setConstraints(LogInButton, 2, 1);
		
		grid.getChildren().addAll(LabelUser, LabelPass, usernameField, passwordField, LogInButton);
		
	}
	
	public String[] getUserInput(){
		String[] user = {usernameField.getText(), passwordField.getText()};
		return user;
	}
	
	public void closeWindow(){
		window.close();
	}

}
