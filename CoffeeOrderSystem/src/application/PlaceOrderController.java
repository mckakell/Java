package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class PlaceOrderController {
	@FXML private TextField nameField;
	@FXML private RadioButton cappucinoRB;
	@FXML private ToggleGroup coffeeType;
	@FXML private RadioButton mochaRB;
	@FXML private RadioButton espressoRB;
	@FXML private RadioButton latteRB;
	@FXML private RadioButton smallRB;
	@FXML private ToggleGroup coffeeSize;
	@FXML private RadioButton mediumRB;
	@FXML private RadioButton largeRB;
	@FXML private RadioButton decafRB;
	@FXML private ToggleGroup coffeeCaffeine;
	@FXML private RadioButton regularRB;
	@FXML private Button clearButton;
	@FXML private Button orderButton;
	
	//OrderSummary stage and controller, start with null
	private Stage orderSummaryStage;
	private OrderSummaryController orderController;
	
	// accessor method to set the label on PlaceOrder window
	public void setLabel(String s) {
		nameField.setText(s);
	}
	
	// handler for order button click event
	@FXML
	public void orderClick(ActionEvent event) {
		
		String order = "";
		if (smallRB.isSelected()) {
			order += "Small";
		} else if (mediumRB.isSelected()) {
			order+= "Medium";
		} else if (largeRB.isSelected()) {
			order+= "Large";
		}
		
		if (decafRB.isSelected()) {
			order += " decaf";
		} else if (regularRB.isSelected()) {
			order+= " regular";
		}
		
		if (cappucinoRB.isSelected()) {
			order += " capucino";
		} else if (mochaRB.isSelected()) {
			order+= " Mocha";
		} else if (latteRB.isSelected()) {
			order+= " Latte";
		} else if (espressoRB.isSelected()) {
			order+= " Espresso";
		}
		
		// If first time in the button click, load Order Summary
		
			//get an FXML Loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderSummary.fxml"));
			AnchorPane orderSummaryPane;
			
			try {
				orderSummaryPane = (AnchorPane) loader.load();
				Scene orderSummaryScene = new Scene(orderSummaryPane);
				orderSummaryStage = new Stage();
				orderSummaryStage.setScene(orderSummaryScene);
				orderController = (OrderSummaryController) loader.getController();
				orderController.setCallingController(this);
				orderController.setLabel(order);
				orderController.setName(nameField.getText());
				orderSummaryStage.show();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
		
		// set the label(s) on Order Summary, then show it
		

/*		orderController.setLabel(orderLabel.getText());
		orderSummaryStage.show();*/
	}
	
	// handler for clear click event
	@FXML
	public void clearClick(ActionEvent event) {
		clearOrder();
	}
	public void clearOrder() {
		nameField.setText("");
		((RadioButton) coffeeType.getSelectedToggle()).setSelected(false);
		((RadioButton) coffeeSize.getSelectedToggle()).setSelected(false);
		((RadioButton) coffeeCaffeine.getSelectedToggle()).setSelected(false);
	}
	
}
