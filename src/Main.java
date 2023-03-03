import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        final int[] random = {(int) (Math.random() * 1000)};
        JFrame f = new JFrame("Guess the Number Game.");

        //Setting Label
        JLabel lb1 = new JLabel("<html><center>I have a number between 1 and 1000, can you guess my number?<br>Please enter your first guess.<br></center></html>");
        lb1.setSize(500,50);
        lb1.setVerticalAlignment(JLabel.TOP);
        lb1.setHorizontalAlignment(JLabel.CENTER);

        JLabel lb2 = new JLabel();
        lb2.setBounds(225,75,100,25);

        //Setting text field for input.
        JTextField tf = new JTextField();
        tf.setBounds(225,50,50,20);
        tf.setHorizontalAlignment(SwingConstants.CENTER);

        //Setting buttons
        JButton b1 = new JButton("Submit");
        b1.setBounds(150,100,95,25);
        b1.addActionListener(e -> {
            int input = Integer.parseInt(tf.getText());
            if (random[0] >input){
                lb2.setText("Too low!!!");
                f.getContentPane().setBackground(Color.CYAN);
            }
            else if (random[0] <input){
                lb2.setText("Too high!!!");
                f.getContentPane().setBackground(Color.RED);
            }
            else{
                lb2.setText("Correct!!!");
                f.getContentPane().setBackground(null);
                tf.setEditable(false);
            }
        });

        JButton b2 = new JButton("Play again!");
        b2.setBounds(250,100,95,25);
        b2.addActionListener(e -> {
            random[0] = (int) (Math.random()*1000);
            f.getContentPane().setBackground(null);
            tf.setEditable(true);
            lb2.setText(null);
            tf.setText(null);
        });

        //Adding components to frame
        f.add(lb1);
        f.add(lb2);
        f.add(tf);
        f.add(b1);
        f.add(b2);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
