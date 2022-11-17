import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class WindowRenders extends GameSetup implements ActionListener, WindowListener, KeyListener {
    protected int intPlayersReturn = 0;

    protected volatile boolean playersReturn = false;

    private JButton buttonArray[] = new JButton[MAX_PLAYERS];
    private JFrame frameArray[] = new JFrame[MAX_PLAYERS];


    /**
     * Creates the top center label for the selection screen.
     */
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

    /**
     * Creates a new Button for the selection screen.
     */
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

    /**
     *
     * @param player
     * Creates a jFrame on the screen for a player.
     * Frames are created per player, to play the game.
     */
    public void display(Player player, int location) {
       JFrame jFrame = new JFrame();
       jFrame.setTitle("Player " + player.playerPosition());

       jFrame.setSize(300, 600);
       jFrame.setLocationRelativeTo(null);
       jFrame.setLocation(jFrame.getX()+location, jFrame.getY());
       jFrame.getContentPane().setBackground(SystemColor.BLACK);
       jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       jFrame.addWindowListener(this);
       jFrame.addKeyListener(this);

       jFrame.setFocusable(true);
       jFrame.setVisible(true);

        JLabel jLabel = new JLabel();

        jLabel.setSize(100, 100);
        jLabel.setText("w");
        jLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setForeground(Color.ORANGE);
        jFrame.add(jLabel);
       /*
       String charArray[] = player.charArray;

        for (int i = 0; i < 10; i++) {

            int c = 0;
            while (c < 5) {
                c++;
                try {
                    Thread.sleep(1000);
                }  catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            jLabel.setVisible(false);
        }

        */

    }

    /**
     * Uses the newButton and topCenterLabel methods.
     * @return Returns the selected amount of players.
     */
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


    public void keyTyped(KeyEvent e) {
        System.out.println("pfwdfdfd");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (JFrame frame : frameArray) {
            if (frame.getTitle() == e.getKeyChar()+"") {

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

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
