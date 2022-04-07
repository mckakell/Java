package application;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class PetRegistryController {
	@FXML
	private Label petidLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private RadioButton catRadioButton;
	@FXML
	private ToggleGroup toggleGroup1;
	@FXML
	private RadioButton dogRadioButton;
	@FXML
	private RadioButton otherRadioButton;
	@FXML
	private RadioButton femaleRadioButton;
	@FXML
	private ToggleGroup toggleGroup2;
	@FXML
	private RadioButton maleRadioButton;
	@FXML
	private Label dateLabel;
	@FXML
	private Button saveButton;
	@FXML
	private Button writeButton;

	private ArrayList<PetEntry> pets = new ArrayList<>();
	
	@FXML
	private void saveClick(ActionEvent event) {
		String species = "";
		species = ((RadioButton)toggleGroup1.getSelectedToggle()).getText(); //easier than writing ifs, but more to remember.
		String sex = ((RadioButton)toggleGroup2.getSelectedToggle()).getText();
		
		/*if(catRadioButton.isSelected()) {
			species = "cat"; //totally valid way
		}
		*/
		PetEntry newPet = new PetEntry(Integer.parseInt(petidLabel.getText()), nameTextField.getText(), species, sex, new Date());
		
		pets.add(newPet);
		
		System.out.println(newPet);
		
		nameTextField.setText("");
		((RadioButton) toggleGroup1.getSelectedToggle()).setSelected(false);
		((RadioButton) toggleGroup2.getSelectedToggle()).setSelected(false);
		petidLabel.setText("" + pets.size());
	}
	
	@FXML
	private void writeClick(ActionEvent event) {
		try {
			FileWriter fileWriter = new FileWriter("PetRegistrationList.txt"); // file writer opens file to be written to
			
			for(PetEntry p : pets) {
				fileWriter.write(p + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			System.out.print("File not found");
		}
	}
}
