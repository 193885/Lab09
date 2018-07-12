/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import it.polito.tdp.borders.model.Vicino;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;
	
	public void setModel(Model model) {
		
		this.model=model;
		

	}

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader
	
	@FXML
    private ComboBox<Country> listState;

    @FXML
    private Button btnDoFind;


	@FXML
	void doCalcolaConfini(ActionEvent event) {
		
		txtResult.clear();
		
		try {
	
			if(Integer.parseInt(txtAnno.getText()) < 1816 || Integer.parseInt(txtAnno.getText()) > 2016) {
							
				txtResult.setText("inserire un valore numerico compreso tra 1816 e 2016");
				
				return;
			}
			
			model.calcoloConfini(Integer.parseInt(txtAnno.getText()));
			
			
			for(Vicino vicino : model.numeroVicini()) {
				
				txtResult.appendText(vicino.toString());
				
			}
			
			txtResult.appendText(""+model.componentiConnesse());
			
			listState.getItems().addAll(model.getVertici());

		}
		
		catch (NumberFormatException e) {
			
			txtResult.setText("formato numerico errato ");
			
		}
		
	}
	

    @FXML
    void findVicini(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try {
    		
    		for(Country c : model.nodiRaggiungibili(listState.getValue())) {
				
				txtResult.appendText(c+"\n");
				
			}
    	}catch (RuntimeException e) {
			
			txtResult.setText("errore db ");
			
		}
		

    }


	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
		   assert listState != null : "fx:id=\"listState\" was not injected: check your FXML file 'Borders.fxml'.";
	        assert btnDoFind != null : "fx:id=\"btnDoFind\" was not injected: check your FXML file 'Borders.fxml'.";
	}
}
