import javax.swing.*;
import java.awt.GridLayout; // Imports Gridlayout class which organizes components into rows and columns
import java.awt.BorderLayout; // lets me position components in different areas of the window
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Triangle Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // organizes panel into 3 rows, 2 columns. Two 10s represent horizontal and vertical spacings
        
        JLabel labelX = new JLabel("Side X:");
        JLabel labelY = new JLabel("Side Y:");
        JLabel labelZ = new JLabel("Side Z:");

        JTextField sideX = new JTextField(10);// 10 means the width of the text field is 10 columns
        JTextField sideY = new JTextField(10);
        JTextField sideZ = new JTextField(10);

        panel.add(labelX);// components are added in order, filling the grid from left to right, top to bottom
        panel.add(sideX);
        panel.add(labelY);
        panel.add(sideY);
        panel.add(labelZ);
        panel.add(sideZ);

        frame.add(panel); //places entire panel including labes and text fields into the frame
        frame.setVisible(true); //makes the frame visible

        JButton calculateButton = new JButton ("Calculate");
        calculateButton.addActionListener(event -> { //tels java what to do when the button is clicked
            try {

                double x = Double.parseDouble(sideX.getText());//gets text from input then converts it into a decimal number(double)
                double y = Double.parseDouble(sideY.getText());
                double z= Double.parseDouble(sideZ.getText());

                if (x <= 0 || y <= 0 || z <= 0 || //checks if triangle sides are valid
                    x+y <= z || x + z <= y || y + z <= x) {

                    JOptionPane.showMessageDialog(frame, "ERROR:Please enter valid triangle sides.");// error message for invalid traingles
                    return;//stops the calculation if the sides are invalid
                    }

                    double perimeter = x + y + z;//calculates perimeter
                    double semiperimeter = perimeter / 2;//calculates semiperimeter
                    double area = Math.sqrt(semiperimeter * (semiperimeter-x) * (semiperimeter-y) * (semiperimeter-z));//finds area using niche formula
                    JOptionPane.showMessageDialog(frame, 
                        String.format("Perimeter: %.2f\nSemiperimeter: %.2f\nArea: %.2f", perimeter, semiperimeter, area));//rounds all values to 2 decimal places. .%2f means 2 decimal places and f means floating point number

            } catch (NumberFormatException error) {//cathches error if user inputs something that is not a number
                JOptionPane.showMessageDialog(frame,
                    "Please enter numbers only.");//Displays error message instead of crashing
                   }
            });

            frame.add(panel, BorderLayout.CENTER); // places input panel in centre of the window
            frame.add(calculateButton, BorderLayout.SOUTH);//place calculate button at the bottom of the window

            frame.setVisible(true); //makes frame visible


            
        }
    }

