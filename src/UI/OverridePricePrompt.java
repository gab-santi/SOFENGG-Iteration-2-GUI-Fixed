package UI;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OverridePricePrompt extends AlertBox {
	
	private VBox promptBox;
	
	public OverridePricePrompt(String title) {
		super(title);
		initItemSelect();
		initPriceInput();
		initSearchAdder();
		addToReturnSearch("1010101", "gass and stuff", 2, 300, "RETAIL SALE");
		initGridConstraints();
		addToGrid();
	}
	
	public void runWindow() {
		showBox();
	}
	
	protected Label lbl = new Label("Select item to change price:");
	protected TableMaker cartTable = new TableMaker(0);
	protected Label lbl2 = new Label("Current item:");
	protected Label itemInfo = new Label("");
	protected Label newPriceLbl = new Label("New unit price: ");
	protected TextField newPriceInput = new TextField();
	protected Button okButton = new Button("OK");
	protected Button cancelButton = new Button("CANCEL");
	
	private void initItemSelect() {
		promptBox = new VBox(10);
		VBox itemBox = new VBox(10);
		itemBox.getChildren().addAll(lbl, cartTable.getTable(), lbl2, itemInfo);
		promptBox.getChildren().add(itemBox);
	}
	
	private void initPriceInput() {
		HBox inputBox = new HBox(10);
		
		okButton.setOnAction(e -> {
			boolean isValid = isDouble(newPriceInput.getText());
			if (isValid) {
				double newPrice = Double.parseDouble(newPriceInput.getText());
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Done");
				a.setHeaderText("Success");
				// GET ITEM INFO FROM DB
				a.setContentText("Price of <item name> changed to PHP " + newPrice);
				a.showAndWait();
				closeBox();
				// CHANGE PRICE IN CART
			} else {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("Invalid input. Please try again.");
				a.showAndWait();
			}
		});
		
		cancelButton.setOnAction(e -> {
			closeBox();
		});
		
		inputBox.getChildren().addAll(newPriceLbl, newPriceInput, okButton, cancelButton);
		promptBox.getChildren().add(inputBox);
	}
	
	private void initSearchAdder() {
		cartTable.getRawTable().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
		    public void handle(MouseEvent event) {
				
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
		        	itemInfo.setText("This should contain the clicked item's info");
		        }
			}
		});
		
	}
	
	public void addToReturnSearch(String itemCode, String desc, int qty, double price, String type){
		ObservableList<String> selected;
		boolean found = false;
		for(int x = 0; x<cartTable.getRawTable().getItems().size(); x++){
			selected = cartTable.getRawTable().getItems().get(x);
			if(selected.get(0).equals(itemCode)){
				int oldQty = Integer.parseInt(selected.get(2));
				qty += oldQty;
				cartTable.updateSearch(x, itemCode, desc, qty, price);
				found = true;
			}
		}
		if(!found)
			cartTable.addToSearch(itemCode, desc, qty, price, type);
	}

	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void initGridConstraints() {
		GridPane.setConstraints(promptBox, 0, 0);
	}

	private void addToGrid() {
		getGrid().getChildren().addAll(promptBox);
	}
}
