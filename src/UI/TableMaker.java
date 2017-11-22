package UI;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableMaker {
	private TableView<ObservableList<String>> Table = new TableView<>();; 
	private TableColumn<ObservableList<String>, String> column;
	private ScrollPane TableHolder = new ScrollPane();
	
	public TableMaker(int cart){
		if(cart == 1){
			TableHolder.setMaxHeight(200);
			initColumnCart();
		}
		else if(cart == 2){
			TableHolder.setMaxHeight(460);
			initColumnHold();
		}
		else if(cart == 0){
			TableHolder.setMaxHeight(140);
			initColumnSearch();
		}
		
		TableHolder.setContent(Table);
	}
	
	private AlertBox ab;
	
	public void clearCart(boolean logOut){
		if(!Table.getItems().isEmpty()){
			Table.getItems().clear();
		}
		else {
			if(!logOut){
				ab = new AlertBox("Alert");
				ab.initAlertContents("Cart Is Already Empty");
				ab.showBox();
			}
			
		}
	}
	

	private void initColumnHold() {
		column = new TableColumn<>("#");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(0)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.07));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("DATE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(1)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.20));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("TIME");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(2)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.20));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("TOTAL AMOUNT");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(3)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.26));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("TYPE OF SALE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(4)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.26));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
	}

	private void initColumnCart(){
		column = new TableColumn<>("#");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(0)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.07));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("ITEM CODE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(1)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.17));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("DESC");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(2)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.31));
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("QTY");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(3)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.07));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("PRICE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(4)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.17));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("Ex Price");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(5)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.17));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
	}
	
	private void initColumnSearch(){
		column = new TableColumn<>("ITEM CODE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(0)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.20));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("DESC");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(1)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.26));
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("QTY");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(2)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.10));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("PRICE");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(3)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.20));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
		
		column = new TableColumn<>("Ex Price");
		column.setCellValueFactory(param ->new ReadOnlyObjectWrapper<>(param.getValue().get(4)));
		column.prefWidthProperty().bind(TableHolder.widthProperty().multiply(0.20));
		column.setStyle("-fx-alignment: CENTER;");
		column.setResizable(false);
		Table.getColumns().add(column);
	}
	
	public void addToCart(String itemCode, String desc, int qty, double price){
		int id = Table.getItems().size() + 1;
		ObservableList<String> row = FXCollections.observableArrayList(); 
		row.addAll(Integer.toString(id), itemCode, desc, Integer.toString(qty), "P" + Double.toString(price), "P" + Double.toString(price * qty));
		Table.getItems().add(FXCollections.observableArrayList(row));
	}
	
	public void updateCart(int index, int id, String itemCode, String desc, int qty, double price){
		ObservableList<String> row = FXCollections.observableArrayList(); 
		row.addAll(Integer.toString(id), itemCode, desc, Integer.toString(qty), "P" + Double.toString(price), "P" + Double.toString(price * qty));
		Table.getItems().set(index,FXCollections.observableArrayList(row));
	}
	
	public void addToSearch(String itemCode, String desc, int qty, double price, String type){
		ObservableList<String> row = FXCollections.observableArrayList(); 
		row.addAll(itemCode, desc, Integer.toString(qty), "P" + Double.toString(price), "P" + Double.toString(price * qty));
		Table.getItems().add(FXCollections.observableArrayList(row));
	}
	
	public void updateSearch(int index, String itemCode, String desc, int qty, double price){
		ObservableList<String> row = FXCollections.observableArrayList(); 
		row.addAll(itemCode, desc, Integer.toString(qty), "P" + Double.toString(price), "P" + Double.toString(price * qty));
		Table.getItems().set(index,FXCollections.observableArrayList(row));
	}
	
	public void switchSearchPriceData(String status){
		if(status.equals("WHOLE SALE")){
			
		}
		else{
			
		}
	}
	
	public void addToHold(String date, String time, double total, String type){
		int id = Table.getItems().size() + 1;
		ObservableList<String> row = FXCollections.observableArrayList(); 
		row.addAll(Integer.toString(id), date, time, "P" + Double.toString(total), type);
		Table.getItems().add(FXCollections.observableArrayList(row));
	}

	public ScrollPane getTable(){	
		TableHolder.setMinWidth(Control.USE_PREF_SIZE);
		return TableHolder;
	}
	
	public TableView<ObservableList<String>> getRawTable(){
		return Table;
	}
}
