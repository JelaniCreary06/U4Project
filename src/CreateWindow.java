import javax.swing.*;
import java.awt.*;

public class CreateWindow {

    public CreateWindow() {}

    private void create() {
        JWindow jwindow = new JWindow();
        JButton jButton = new JButton();

        jButton.setSize(150, 45);
        jButton.setBackground(Color.YELLOW);
        jButton.setText("Button");


        jwindow.setSize(400, 400);
        jwindow.setLocationRelativeTo(null);
        jwindow.getContentPane().setBackground(SystemColor.BLACK);
        jwindow.setVisible(true);

        jwindow.add(jButton);
        jButton.setLocation(jwindow.getHeight() / 2, jwindow.getWidth() / 2 );








    }

    public static void main(String[] args) {
        CreateWindow nw = new CreateWindow();

        nw.create();
    }
}
