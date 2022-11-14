import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWindow  implements ActionListener {

    private int MAX_PLAYERS = 4;
    private int players = 0;
    private volatile boolean active = false;

    private JButton buttonArray[] = new JButton[MAX_PLAYERS];


    private JLabel topCenterLabel(String text, Color textColor, int size ) {
        JLabel jLabel = new JLabel(text);
        jLabel.setForeground(textColor);
        jLabel.setSize(size, size);
        jLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        jLabel.setBorder(new LineBorder(Color.WHITE, 10));

        return jLabel;
    }

    private JButton newButton(String text, Color textColor) {
        JButton jButton = new JButton();
        jButton.setText(text);
        jButton.setForeground(textColor);
        jButton.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setBackground(Color.DARK_GRAY);

        jButton.addActionListener(this);
        return jButton;
    }

    public int startScreen() throws InterruptedException {
        JWindow jwindow = new JWindow();
        jwindow.setSize(400, 400);
        jwindow.setLocationRelativeTo(null);
        jwindow.getContentPane().setBackground(SystemColor.BLACK);

        jwindow.add(topCenterLabel("Start Screen", Color.BLUE, 100), BorderLayout.PAGE_START);

        JWindow sWindow = new JWindow();
        sWindow.setSize(400, 330);
        sWindow.setLocationRelativeTo(jwindow);
        sWindow.setLocation(sWindow.getX(), sWindow.getY()+15);
        sWindow.getContentPane().setBackground(SystemColor.BLACK);

        sWindow.setLayout(new GridLayout(0, 2));

        for (int i = 0; i < MAX_PLAYERS; i++) {
            JButton toAdd = newButton((i+1)+" player(s)", Color.YELLOW);
            sWindow.add(toAdd);
            buttonArray[i] = toAdd;
        }

        jwindow.setVisible(true);
        sWindow.setVisible(true);

        while (!active) {
            Thread.sleep(1000);
        }

        jwindow.dispose();
        sWindow.dispose();

        return this.players;
    }

    public void gameScreen() {
        JWindow jWindow = new JWindow();

        jWindow.setSize(600,600);
        jWindow.getContentPane().setBackground(Color.BLACK);
        jWindow.setLocationRelativeTo(null);

        jWindow.setVisible(true);
        jWindow.setLocation(jWindow.getX()+200, jWindow.getY());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)(e.getSource());
        this.players = Integer.parseInt(clicked.getText().charAt(0)+"");
        this.active = true;
    }
}
