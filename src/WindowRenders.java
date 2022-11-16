import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowRenders extends GameSetup implements ActionListener, WindowListener {
    protected int intPlayersReturn = 0;

    protected volatile boolean playersReturn = false;

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

    public void display(Player player) {
       JFrame jFrame = new JFrame();
       jFrame.setTitle("");

       jFrame.setSize(500, 600);
       jFrame.setLocationRelativeTo(null);
       jFrame.setLocation(jFrame.getX()-700, jFrame.getY());
       jFrame.getContentPane().setBackground(SystemColor.BLACK);
       jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       jFrame.addWindowListener(this);
       jFrame.setVisible(true);

    }
    public int playerSelectionScreen () {
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

        while (!playersReturn) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        jwindow.dispose();
        sWindow.dispose();

        return intPlayersReturn;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) (e.getSource());
        this.intPlayersReturn = Integer.parseInt(clicked.getText().charAt(0)+"");
        this.playersReturn = true;
    }


    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println(e.getSource());
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println(e.getSource());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
