package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
    
	 @FXML
	    private Button clear;

	    @FXML
	    private Button comma;

	    @FXML
	    private TextField display;

	    @FXML
	    private Button divide;

	    @FXML
	    private Button eight;

	    @FXML
	    private Button equal;

	    @FXML
	    private Button five;

	    @FXML
	    private Button four;

	    @FXML
	    private Button minus;

	    @FXML
	    private Button multiply;

	    @FXML
	    private Button nine;

	    @FXML
	    private Button one;

	    @FXML
	    private Button percent;

	    @FXML
	    private Button plus;

	    @FXML
	    private Button plusMinus;

	    @FXML
	    private Button seven;

	    @FXML
	    private Button six;

	    @FXML
	    private Button three;

	    @FXML
	    private Button two;

	    @FXML
	    private Button zero;
	    
	    private double [] temporary = {0,0};
	    Boolean plusBoolean = false, minusBoolean = false, multiplyBoolean = false, divideBoolean = false;
	    DecimalFormat df = new DecimalFormat("#.00");
	    @FXML
	    void numberButtonAction(ActionEvent event) {
	    	Button btn = (Button) event.getSource();
	    	
	    	switch (btn.getId()) {
			case "one":
				display.setText(display.getText()+"1");
				clear.setText("C");
				break;
			case "two":
				display.setText(display.getText()+"2");
				clear.setText("C");
				break;
			case "three":
				display.setText(display.getText()+"3");
				clear.setText("C");
				break;
			case "four":
				display.setText(display.getText()+"4");
				clear.setText("C");
				break;
			case "five":
				display.setText(display.getText()+"5");
				clear.setText("C");
				break;
			case "six":
				display.setText(display.getText()+"6");
				clear.setText("C");
				break;
			case "seven":
				display.setText(display.getText()+"7");
				clear.setText("C");
				break;
			case "eight":
				display.setText(display.getText()+"8");
				clear.setText("C");
				break;
			case "nine":
				display.setText(display.getText()+"9");
				clear.setText("C");
				break;
			case "zero":
				display.setText(display.getText()+"0");
				clear.setText("C");
				break;
			case "comma":
				display.setText(display.getText()+".");
				clear.setText("C");
				break;
			}
			plus.setStyle("-fx-background-color : #FF9500;" + "-fx-text-fill : white;");
			minus.setStyle("-fx-background-color : #FF9500;" + "-fx-text-fill : white;");
			divide.setStyle("-fx-background-color : #FF9500;" + "-fx-text-fill : white;");
			multiply.setStyle("-fx-background-color : #FF9500;" + "-fx-text-fill : white;");
	    }
	    
	    @FXML
	    void operatorAction(ActionEvent event) {
	    	Button btn = (Button)event.getSource();
	    	temporary[0] = Double.parseDouble(display.getText());
	    	
	    	if (btn.equals(plus)) {
				plusBoolean = true;
			}else if (btn.equals(minus)) {
				minusBoolean = true;
			}else if (btn.equals(multiply)) {
				multiplyBoolean = true;
			}else if (btn.equals(divide)) {
				divideBoolean = true;
			}
	    	display.setText("");
	    	if (plusBoolean) {
	    		plus.setStyle("-fx-background-color : white;" + "-fx-text-fill : #FF9500;");
			}else if (minusBoolean) {
				minus.setStyle("-fx-background-color : white;" + "-fx-text-fill : #FF9500;");
			}
			else if (multiplyBoolean) {
				multiply.setStyle("-fx-background-color : white;" + "-fx-text-fill : #FF9500;");
			}else if (divideBoolean) {
				divide.setStyle("-fx-background-color : white;" + "-fx-text-fill : #FF9500;");
			}
	    }


	    
	    @FXML
	    public void result() {
	    	double result = 0;
	    	temporary[1] = Double.parseDouble(display.getText());
	    	if (plusBoolean) {
				result = temporary[0] + temporary[1];
				plusBoolean = false;
			}else if (minusBoolean) {
				result = temporary[0] - temporary[1];
				minusBoolean = false;
			}
			else if (multiplyBoolean) {
				result = temporary[0] * temporary[1];
				multiplyBoolean = false;
			}
			else if (divideBoolean) {
				result = temporary[0] / temporary[1];
				divideBoolean = false;
			}
	    	String formattedValue = df.format(result);
	    	formattedValue = formattedValue.replace(",",".");
	    	display.setText(formattedValue);
	    }
	    
	    @FXML
	    void clear(ActionEvent event) {
	    	clear.setText("AC");
	    	display.setText("");
	    	plusBoolean = false; minusBoolean = false; multiplyBoolean = false; divideBoolean = false;
	    }
	    
	    @FXML
	    void percent(ActionEvent event) {
	    	double newValue = 0.01 * Double.parseDouble(display.getText());
	    	display.setText(String.valueOf(newValue));
	    }

	    @FXML
	    void signConversion(ActionEvent event) {
	    	if (display.getText() != "") {
	    		double newValue = -1 * Double.parseDouble(display.getText());
				display.setText(String.valueOf(newValue));
			}
	    }
    
}
