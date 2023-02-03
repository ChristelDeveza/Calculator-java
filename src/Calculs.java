import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


// Class declaration
public class Calculs implements ActionListener {

  // Create frame
  JFrame frame;
  
  // Create text field
  JTextField solution;
  
  // Create button
  JButton[] numberButton = new JButton[10];
  JButton[] functionButton = new JButton[9];
  JButton addButton, subButton, mulButton, divButton, decButton, clrButton, delButton, negButton, equalButton;
  JPanel panel;
  
  Font myFont = new Font("Calibri", Font.BOLD, 30);
  double num1 = 0, num2 = 0, result = 0;
  char operator;
  
  Calculs() {
  frame = new JFrame("Create Calculator Interface");// Create frame object with title
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application
  frame.setSize(420,550); // define size 
  frame.setLayout(null); //layout
  solution = new JTextField();//Create solution object (display number clicked and results)
  solution.setBounds(50, 25, 300,50); // define position and size
  solution.setFont(myFont); // apply my font object
  solution.setEditable(false);// not editable
  
  // Create button objects
  addButton = new JButton("+");
  subButton = new JButton("-");
  mulButton = new JButton("*");
  divButton = new JButton("/");
  decButton = new JButton(".");
  clrButton = new JButton("clr");
  delButton = new JButton("del");
  negButton = new JButton("-");
  equalButton = new JButton("=");
  
  //Index of each action button
  functionButton[0]=addButton;
  functionButton[1]=subButton;
  functionButton[2]=mulButton;
  functionButton[3]=divButton;
  functionButton[4]=decButton;
  functionButton[5]=clrButton;
  functionButton[6]=delButton;
  functionButton[7]= negButton;
  functionButton[8]=equalButton;
  
  // Display action buttons – listener (cf question 3)
  for (int i=0; i<9; i++) {
  functionButton[i].addActionListener(this);
  functionButton[i].setFont(myFont);
  functionButton[i].setFocusable(false);
  }
  // Display number buttons – listener (cf question 3)
  for (int i=0; i<10; i++) {
  numberButton[i] = new JButton(String.valueOf(i));
  numberButton[i].addActionListener(this);
  numberButton[i].setFocusable(false);
  }
  negButton.setBounds(50, 430, 100, 50);
  delButton.setBounds(150, 430, 100, 50);
  clrButton.setBounds(250, 430, 100, 50);
  
  // Create panel (numbers, operators, point)
  panel = new JPanel();
  panel.setBounds(50, 100, 300, 300);
  panel.setLayout(new GridLayout(4,4,10,40));
  panel.add(numberButton[1]);
  panel.add(numberButton[2]);
  panel.add(numberButton[3]);
  panel.add(addButton);
  panel.add(numberButton[4]);
  panel.add(numberButton[5]);
  panel.add(numberButton[6]);
  panel.add(subButton);
  panel.add(numberButton[7]);
  panel.add(numberButton[8]);
  panel.add(numberButton[9]);
  panel.add(mulButton);
  panel.add(decButton);
  panel.add(numberButton[0]);
  panel.add(equalButton);
  panel.add(divButton);
  
  // Add the panel in frame
  frame.add(panel);
  
  // Add negative, delete and clear button in frame, and solution
  frame.add(negButton);
  frame.add(delButton);
  frame.add(clrButton);
  frame.add(solution);
  
  // Frame is now visible
  frame.setVisible(true);
  }

  // Perform actions
public void actionPerformed (ActionEvent e){

  for (int i=0; i<10;i++) {
  
  // If a numberButton is clicked – print in solution the number
  if(e.getSource() == numberButton[i]) {
  solution.setText(solution.getText().concat(String.valueOf(i)));
  }
  }
  
  // If decimal button is clicked – do the action 
  if (e.getSource() == decButton) {
  solution.setText(solution.getText().concat("."));
  }
  
  // If add button is clicked – do the action 
  if (e.getSource() == addButton) {
  num1 = Double.parseDouble(solution.getText());
  operator = '+';
  solution.setText("");
  }
  
  // If substract button is clicked – do the action 
  if (e.getSource() == subButton) {
  num1 = Double.parseDouble(solution.getText());
  operator = '-';
  solution.setText("");
  }
  
  // If multiplication button is clicked – do the action 
  if (e.getSource() == mulButton) {
  num1 = Double.parseDouble(solution.getText());
  operator = '*';
  solution.setText("");
  }
  // If division button is clicked – do the action 
  if (e.getSource() == divButton) {
  num1 = Double.parseDouble(solution.getText());
  operator = '/';
  solution.setText("");
  }
  
  // Calcul
  
  // If equel button is clicked – do the action 
  if (e.getSource() == equalButton) {
  num2 = Double.parseDouble(solution.getText());
  switch(operator) {
  case '+':
  result = num1 + num2;
  break;
  case '-':
  result = num1 - num2;
  break;
  case '*':
  result = num1 * num2;
  break;
  case '/':
  result = num1 / num2;
  break;
  }
  
  //Display the result in solution
  solution.setText(String.valueOf(result));
  num1 = result;
  }
  
  // If clear button is clicked = clear
  if (e.getSource()== clrButton) {
  solution.setText("");
  }
  
  // If Delete button is clicked = delete number one by one number
  if (e.getSource()== delButton) {
  String string = solution.getText();
  solution.setText("");
  for (int i=0; i< string.length()-1; i++ ) {
  solution.setText(solution.getText()+string.charAt(i));
  }
  }
  
  // If negative button is clicked = Add negative
  if (e.getSource()== negButton) {
  double negative = Double.parseDouble(solution.getText());
  negative *= -1;
  solution.setText(String.valueOf(negative));
  }
}
}
  
  