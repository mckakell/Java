package application;

import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class OrderSummaryController {
	
	@FXML private Button cancelOrderButton;
	@FXML private Button getCoffeeButton;
	@FXML private Label nameLabel;
	@FXML private Label orderLabel;
	@FXML private AnchorPane mainPane;
	
	//Create private variable
	private PlaceOrderController setController;
	
	public void setCallingController(PlaceOrderController c) {
		setController = c;
	}

	
	
	// Event Listener on Button[#cancelOrderButton].onAction
	@FXML
	public void cancelOrderClick(ActionEvent event) {
		mainPane.getScene().getWindow().hide();
	}
	// Event Listener on Button[#getCoffeeButton].onAction
	@FXML
	public void getCoffeeClick(ActionEvent event) {
		setController.clearOrder();
		mainPane.getScene().getWindow().hide();
	}

	@FXML
	public void setLabel(String text) {
		orderLabel.setText(text);
		
	}
	
	@FXML
	public void setName(String text) {
		nameLabel.setText(text);
		
	}
	
}
