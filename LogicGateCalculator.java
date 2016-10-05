package logicGateCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LogicGateCalculator extends Application{
	
	Font f = new Font("Californian FB", 14);
	
	public static void main(String[] args){
		Application.launch(args);
	}//main
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Logic Gate Calculator");

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));//top, left, bottom, right
		grid.setAlignment(Pos.TOP_CENTER);
		//grid.setGridLinesVisible(true);
		
		Scene mainGrid = new Scene(grid);
		
		Label sceneTitle = new Label("Logic Gate Calculator");
		sceneTitle.setFont(Font.font("tahoma", FontWeight.NORMAL, 20));
		sceneTitle.setTextAlignment(TextAlignment.CENTER);
		grid.add(sceneTitle, 0, 0);
		GridPane.setHalignment(sceneTitle, HPos.CENTER);
		
		TextField display = new TextField();
		//display.setEditable(false);
		display.setPrefSize(254, 40);
		display.setFont(f);
		grid.add(display, 0, 1);
		
		display.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
            	if(ke.getCode().equals(KeyCode.ENTER)){
            		display.setText(calculate(display.getText()));
            	}
            }
        });
		
		//1, 0, (, ), ,
		HBox oneZeroOpenCloseComma = new HBox();
		Button one = new Button("1");
		Button zero = new Button("0");
		Button open = new Button("(");
		Button close = new Button(")");
		Button comma = new Button(",");
		one.setPrefSize(56, 40);
		zero.setPrefSize(56, 40);
		open.setPrefSize(56, 40);
		close.setPrefSize(56, 40);
		comma.setPrefSize(56, 40);
		oneZeroOpenCloseComma.getChildren().addAll(one, zero, open, close, comma);
		oneZeroOpenCloseComma.setSpacing(10);
		grid.add(oneZeroOpenCloseComma, 0, 2);
		GridPane.setHalignment(oneZeroOpenCloseComma, HPos.CENTER);
		
		one.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("1");
				}else{
					display.setText(display.getText() + "1");
				}
			}//handle
		}//EventHandler Class
		);
		zero.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("0");
				}else{
					display.setText(display.getText() + "0");
				}
			}//handle
		}//EventHandler Class
		);
		open.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("(");
				}else{
					display.setText(display.getText() + "(");
				}
			}//handle
		}//EventHandler Class
		);
		close.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText(")");
				}else{
					display.setText(display.getText() + ")");
				}
			}//handle
		}//EventHandler Class
		);
		comma.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText(",");
				}else{
					display.setText(display.getText() + ",");
				}
			}//handle
	    }//EventHandler Class
		);
		
		//AND, OR, NOT, clear, back
		HBox andOrNotClear = new HBox();
		Button AND = new Button("AND");
		Button OR = new Button("OR");
		Button NOT = new Button("NOT");
		Button clear = new Button("Clear");
		Button back = new Button("<--");
		AND.setPrefSize(56, 40);
		OR.setPrefSize(56, 40);
		NOT.setPrefSize(56, 40);
		clear.setPrefSize(56, 40);
		back.setPrefSize(56, 40);
		andOrNotClear.getChildren().addAll(AND, OR, NOT, clear, back);
		andOrNotClear.setSpacing(10);
		grid.add(andOrNotClear, 0, 3);
		GridPane.setHalignment(andOrNotClear, HPos.CENTER);
		
		AND.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("AND(");
				}else{
					display.setText(display.getText() + "AND(");
				}
			}//handle
	    }//EventHandler Class
		);
		OR.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("OR(");
				}else{
					display.setText(display.getText() + "OR(");
				}
			}//handle
		}//EventHandler Class
		);
		NOT.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("NOT(");
				}else{
					display.setText(display.getText() + "NOT(");
				}
			}//handle
		}//EventHandler Class
		);
		clear.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				display.setText("");
			}//handle
		}//EventHandler Class
		);
		back.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				if(display.getText().length() > 0){
					display.setText(display.getText().substring(0, display.getText().length() - 1));
				}
			}//handle
		}//EventHandler Class
		);
		
		//NAND, NOR, XOR, XNOR, equal
		HBox nandNorXorXnor = new HBox();
		Button NAND = new Button("NAND");
		Button NOR = new Button("NOR");
		Button XOR = new Button("XOR");
		Button XNOR = new Button("XNOR");
		Button equal = new Button("=");
		NAND.setPrefSize(56, 40);
		NOR.setPrefSize(56, 40);
		XOR.setPrefSize(56, 40);
		XNOR.setPrefSize(56, 40);
		equal.setPrefSize(56, 40);
		nandNorXorXnor.getChildren().addAll(NAND, NOR, XOR, XNOR, equal);
		nandNorXorXnor.setSpacing(10);
		grid.add(nandNorXorXnor, 0, 4);
		GridPane.setHalignment(nandNorXorXnor, HPos.CENTER);
		
		NAND.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("NAND(");
				}else{
					display.setText(display.getText() + "NAND(");
				}
			}//handle
		}//EventHandler Class
		);
		NOR.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("NOR(");
				}else{
					display.setText(display.getText() + "NOR(");
				}
			}//handle
		}//EventHandler Class
		);
		XOR.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("XOR(");
				}else{
					display.setText(display.getText() + "XOR(");
				}
			}//handle
		}//EventHandler Class
		);
		XNOR.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(((display.getText().equals("1")) || (display.getText().equals("0")) || (display.getText().equals("Error")))){
					display.setText("XNOR(");
				}else{
					display.setText(display.getText() + "XNOR(");
				}
			}//handle
		}//EventHandler Class
		);
		equal.setOnAction(
		new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				display.setText(calculate(display.getText()));
			}//handle
		}//EventHandler Class
		);
		
		primaryStage.setScene(mainGrid);
		primaryStage.show();
	}//start

	private String calculate(String dispText){
		if(dispText.startsWith("AND(")){
			if(dispText.length() == 8){
				return "" + AND(intOfChar(dispText.charAt(4)), intOfChar(dispText.charAt(6)));
			}else{
				String sub = dispText.substring(4, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + AND(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + AND(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//AND
		if(dispText.startsWith("OR(")){
			if(dispText.length() == 7){
				return "" + OR(intOfChar(dispText.charAt(3)), intOfChar(dispText.charAt(5)));
			}else{
				String sub = dispText.substring(3, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + OR(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + OR(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//OR
		if(dispText.startsWith("NOT(")){//unbreakable
			if(dispText.length() == 6){
				if((dispText.charAt(4) == '1') || (dispText.charAt(4) == '0')){
					return "" + NOT(intOfChar(dispText.charAt(4)));
				}else{
					return  "Error";
				}
			}else{
				if((Integer.parseInt(calculate(dispText.substring(4, dispText.length() - 1))) == 1) || (Integer.parseInt(calculate(dispText.substring(4, dispText.length() - 1))) == 0)){//add this error fix, it's hopeless though, can't fix all
					return "" + NOT(Integer.parseInt(calculate(dispText.substring(4, dispText.length() - 1))));
				}else{
					return "Error";
				}
			}
		}//NOT
		if(dispText.startsWith("NAND(")){
			if(dispText.length() == 9){
				return "" + NAND(intOfChar(dispText.charAt(5)), intOfChar(dispText.charAt(7)));
			}else{
				String sub = dispText.substring(5, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + NAND(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + NAND(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//NAND
		if(dispText.startsWith("NOR(")){
			if(dispText.length() == 8){
				return "" + NOR(intOfChar(dispText.charAt(4)), intOfChar(dispText.charAt(6)));
			}else{
				String sub = dispText.substring(4, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + NOR(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + NOR(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//NOR
		if(dispText.startsWith("XOR(")){
			if(dispText.length() == 8){
				return "" + XOR(intOfChar(dispText.charAt(4)), intOfChar(dispText.charAt(6)));
			}else{
				String sub = dispText.substring(4, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + XOR(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + XOR(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//XOR
		if(dispText.startsWith("XNOR(")){
			if(dispText.length() == 9){
				return "" + XNOR(intOfChar(dispText.charAt(5)), intOfChar(dispText.charAt(7)));
			}else{
				String sub = dispText.substring(5, dispText.length() - 1);
				if((intOfChar(sub.charAt(0)) == 1) || (intOfChar(sub.charAt(0)) == 0)){
					if(calculate(sub.substring(2, sub.length())).equals("Error")) return "Error";
					return "" + XNOR(intOfChar(sub.charAt(0)), Integer.parseInt(calculate(sub.substring(2, sub.length()))));
				}//if the second argument isn't 0 or 1, but the first one is 0 or 1
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0; i < sub.length(); i ++){
					if((sub.charAt(i) == ',') && (openCount - closeCount == 0)){//based on the amount of closed/open parenthesis, break up the string into first and second argument and calc em
						if(calculate(sub.substring(0, i)).equals("Error")) return "Error";
						if(calculate(sub.substring(i + 1, sub.length())).equals("Error")) return "Error";
						return "" + XNOR(Integer.parseInt(calculate(sub.substring(0, i))), Integer.parseInt(calculate(sub.substring(i + 1, sub.length()))));//apply gate to before comma and after comma
					}
					if(sub.charAt(i) == '(') openCount = openCount + 1;
					if(sub.charAt(i) == ')') closeCount = closeCount + 1;//paren counters
				}//for
			}
		}//XNOR
		if((dispText.equals("1")) || (dispText.equals("0")) || (dispText.equals(""))){
			return dispText;
		}
		return "Error";
	}//calculate
	
	private int intOfChar(char x){ return x - 48; }
	
	public int AND(int a, int b) { return ((a == b) && (a == 1)) ? 1 : 0; }
	public int OR(int a, int b)  { return ((a == b) && (a == 0)) ? 0 : 1; }
	public int NOT(int a)        { return (a == 1)               ? 0 : 1; }
	public int NAND(int a, int b){ return ((a == b) && (a == 1)) ? 0 : 1; }
	public int NOR(int a, int b) { return ((a == b) && (a == 0)) ? 1 : 0; }
	public int XOR(int a, int b) { return (a == b)               ? 0 : 1; }
	public int XNOR(int a, int b){ return (a == b)               ? 1 : 0; }
}//class
