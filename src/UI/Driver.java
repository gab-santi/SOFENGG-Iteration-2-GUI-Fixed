package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
	
	LogIn login;
	CashierMain cm;

	@Override
	public void start(Stage main) throws Exception {
		// TODO Auto-generated method stub
		cm = new CashierMain(main, "Cashier: ");
		login = new LogIn(cm);
		initButtons();
	}

	public void initButtons() {
		cm.getLogOutbutton().setOnAction(e ->  {
			cm.closeStage();
			try {
				cm.clearAllTables(true);
				login = new LogIn(cm);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
}