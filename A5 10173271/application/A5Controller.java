package application;
import application.Pizza;
import application.LineItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class A5Controller {
	@FXML
	private Label totalcost = new Label();
	
	
	@FXML
	private TextField displayCost = new TextField();
	@FXML
	private ChoiceBox<String> sizeChoice = new ChoiceBox<String>();
	
	@FXML
	private ChoiceBox<String> cheeseChoice = new ChoiceBox<String>();
	
	@FXML
	private ChoiceBox<String> pepperoniChoice = new ChoiceBox<String>();
	
	@FXML
	private ChoiceBox<String> mushroomChoice = new ChoiceBox<String>();
	
	@FXML
	private TextField numberPizzas = new TextField();	
	
	@FXML
	private Button button = new Button("Save Pizza");
	
	@FXML
	private TextArea display = new TextArea();
	
	@FXML
	private ObservableList<String> sizeList = FXCollections.observableArrayList(
			"Small", "Medium", "Large");
	@FXML
	private ObservableList<String> cheeseList = FXCollections.observableArrayList(
			"Single", "Double", "Triple");
	
	@FXML
	private ObservableList<String> pepperoniList = FXCollections.observableArrayList(
			"Single", "Double", "None");
	
	@FXML
	private ObservableList<String> mushroomList = FXCollections.observableArrayList(
			"Single", "Double", "None");
	
	private Pizza createPizza() {
		String size = sizeChoice.getValue();
		String cheese = cheeseChoice.getValue();
		String pepperoni = pepperoniChoice.getValue();
		String mushroom = mushroomChoice.getValue();
		Pizza pizza = null;
		try {
			pizza = new Pizza(size, cheese, mushroom, pepperoni);
			return pizza;
		} catch (IllegalPizza e) {
			Alert legalAlert = new Alert(AlertType.WARNING, "Erroneous pizza");
	    	legalAlert.showAndWait().ifPresent(response -> {
	    		if (response == ButtonType.OK) {
	    			display.appendText(""); //sets default
	    		}
	    	});
		} 
		return pizza;
	}
	
	private LineItem createLineItem() throws NumberFormatException {
		Pizza pizza = createPizza();
		LineItem order = null;
		try {
			order = new LineItem(Integer.parseInt(numberPizzas.getText()), pizza);
			return order;
		} catch (IllegalPizza e) {
			Alert legalAlert = new Alert(AlertType.WARNING, "Erroneous pizza");
	    	legalAlert.showAndWait().ifPresent(response -> {
	    		if (response == ButtonType.OK) {
	    			displayCost.appendText(""); //sets default
	    		}
	    	});
		} 
		return order;
	}
	
	private int checkNumberofPizzas() {
		int pizzanumber = 1;
		numberPizzas.setText("Please enter an integer here between 0 and 101");
		numberPizzas.textProperty().addListener((observableValue, oldVal, newVal) -> {
			if (!newVal.isEmpty() && newVal != null) {
				try {
					int newpizzanumber = Integer.parseInt(newVal);
					if (newpizzanumber < 1 || newpizzanumber > 100) {
						Alert legalAlert = new Alert(AlertType.WARNING, "Erroneous entry, must be within limits");
						legalAlert.showAndWait().ifPresent(response -> {
							if (response == ButtonType.OK) {
				    			displayCost.appendText(""); //sets default
				    		} //end inner inner if
				    	});//end inner lambda function
					}//end inner if
					//return newpizzanumber;
				} catch (NumberFormatException e) { //end try, begin catch
					Alert legalAlert = new Alert(AlertType.WARNING, "Erroneous entry, please enter an integer");
			    	legalAlert.showAndWait().ifPresent(response -> {
			    		if (response == ButtonType.OK) {
			    			displayCost.appendText(""); //sets default
			    		}
			    	});
				} //end catch
			} //end if 	
		}); // endAddListener lambda function	
		return pizzanumber;
	} //end method
	
	
	public void updatePrice() {
		LineItem order = createLineItem();
		display.appendText("Price of this order is: $" + Double.toString(order.getCost()));
		return;
	}
	
	void displayPizza() {
		String cheese = (String) cheeseChoice.getValue();
		String size = (String) sizeChoice.getValue();
		String mushroom = (String) mushroomChoice.getValue();
		String pepperoni = (String) pepperoniChoice.getValue();
		if (mushroom.equals("None")) {
			mushroom = "No";
		}
		if (pepperoni.equals("None")) {
			pepperoni = "No";
		}
		display.setEditable(false);
        display.prefWidthProperty();
        display.setWrapText(true);     // New line of the text exceeds the text area
		display.appendText(numberPizzas.getText()+" " + size + " pizza, " + cheese + " cheese, " + pepperoni + " pepperoni, "
				+ mushroom + " mushrooms. \n");
		updatePrice(); 
		displaytotalcost();
	}
	

	
	void displaytotalcost( ) {
		displayCost.setEditable(false);
		LineItem order = createLineItem();
		double oldcost = Double.parseDouble(displayCost.getText());
		double newcost = order.getCost();
		displayCost.setText(Double.toString(oldcost + newcost));
		return;
	}
	
	void buttonAction() {
		try { 
		    if (Integer.parseInt(numberPizzas.getText()) < 0 || 
		    		Integer.parseInt(numberPizzas.getText()) > 100 ) {
		    	Alert legalAlert = new Alert(AlertType.WARNING, "Please enter an integer value between 1 and 100");
		    	legalAlert.showAndWait().ifPresent(response -> {
		    		if (response == ButtonType.OK) {
		    			numberPizzas.setText("1"); //sets default arguement
		    		}
		    	});
		    }
		    else {
		    button.setText("Save Pizza");
		    displayPizza(); 
		    }
	    } catch(NumberFormatException e) { 
	    	Alert legalAlert = new Alert(AlertType.WARNING, "Please enter an integer value between 1 and 100");
	    	legalAlert.showAndWait().ifPresent(response -> {
	    		if (response == ButtonType.OK) {
	    			numberPizzas.setText("1"); //sets default arguement
	    		}
	    	});
	    } catch(NullPointerException e) {
	    	Alert legalAlert = new Alert(AlertType.WARNING, "Please enter an integer value between 1 and 100");
	    	legalAlert.showAndWait().ifPresent(response -> {
	    		if (response == ButtonType.OK) {
	    			numberPizzas.setText("1"); //sets default arguement
	    		}
	    	});
	    }
	}
	
	@FXML
	void initialize() {
		totalcost.setText("Total cost of order: ");
		displayCost.setText("0");
		
		sizeChoice.setValue("Small");
		sizeChoice.setItems(sizeList);
		sizeChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
		{
			updatePrice();
		});
		cheeseChoice.setValue("Single");
		cheeseChoice.setItems(cheeseList);
		cheeseChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
		{
			updatePrice();
			});
		
		pepperoniChoice.setValue("None");
		pepperoniChoice.setItems(pepperoniList);
		pepperoniChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
		{
			if (newVal.equals("None")) {
				mushroomChoice.setValue("None");
			}
		});
		
		mushroomChoice.setValue("None");
		mushroomChoice.setItems(mushroomList);
		mushroomChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
		{
			if (!newVal.equals("None") & pepperoniChoice.getSelectionModel().getSelectedItem().equals("None")) {
				mushroomChoice.setValue("None");
			}
		});
	
		button.setText("Save Pizza");
		button.setOnAction(event ->  buttonAction());
		
	}
		  
}
