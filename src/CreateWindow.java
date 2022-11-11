import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateWindow implements ActionListener {
    private GameCreator activeGame = new GameCreator("");
    private final int MAX_PLAYERS = activeGame.maxPlayers();
    private int players = 0;

    private JButton buttonArray[] = new JButton[MAX_PLAYERS];
    public CreateWindow() {
        startScreen();
    }

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

    private void startScreen() {
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
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : buttonArray) {
            if (e.getSource() == button) {
                players = Integer.parseInt(button.getText().charAt(0)+"");
                notify();
            }
        }
    }

    public static void main(String[] args) {
        CreateWindow nw = new CreateWindow();
    }
}
