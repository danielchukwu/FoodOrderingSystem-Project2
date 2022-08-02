import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    // This method takes a parameter
    void pageOne(String appName) {

        JFrame frame1 = new JFrame(appName);   // create frame1
        frame1.setSize(600, 600);  // set size
        frame1.setLayout(new GridLayout(8, 1));   // set layout

        String[] foods = {"Rice & Stew", "Fried Rice", "Jollof Rice", "Chicken", "Beef", "Meat", "Shawarma", "Pineapple Pizza"}; // array to hold our foods

        for (int i = 0; i < foods.length; i++) { // loop through foods array (in line 18)

            // On each loop create food button
            String food = foods[i]; // retrieve food from foods array (in line 18)
            JButton button = new JButton(food); // create button
            frame1.add(button); // add button to frame

            frame1.setVisible(true);  // frame1 is invisible by default. this line makes it visible

            // whenever a button is clicked -> add food to file
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // write food clicked on to a file
                    try {
                        FileWriter file = new FileWriter("food orders.txt");  // create file
                        file.write("ordered: " + food);   // write food to file
                        file.close();  // close file
                    } catch (Exception w){
                        System.out.println("There is an error");  // if any error. print this
                    }

                    frame1.setVisible(false); // make current frame invisible and open next page
                    pageTwo(); // open next page
                }
            });
        }
    }

    void pageTwo() {

        JFrame frame2 = new JFrame("Order Placed");  // create frame2
        frame2.setSize(600, 600);  // set size
        frame2.setLayout(new GridLayout(1, 1));  // set layout

        JButton closeButton = new JButton("order placed. CLOSE");  // create button
        frame2.add(closeButton);  // add button to frame2

        frame2.setVisible(true);  // frame2 is invisible by default. this line makes it visible

        // objective: once close button is clicked on. close pageTwo()
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false); // close pageTwo()
            }
        });
    }


    // we call the above program here
    public static void main(String [] args) {
        // create object of main class
        Main obj = new Main();
        // call first page method
        obj.pageOne("Order Inaudible Food Today");
    }
}
