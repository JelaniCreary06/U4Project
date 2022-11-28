import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRendering extends GameSetup implements ActionListener, WindowListener, KeyListener {
    protected int intPlayersReturn = 0;

    protected volatile boolean playersReturn = false;

    private JButton buttonArray[] = new JButton[MAX_PLAYERS];
    private ArrayList<JLabel> frameArray = new ArrayList<JLabel>();

    private JFrame playerOpen, playerOpen2;

    ArrayList<String> charArray = new ArrayList<>(
            Arrays.asList(
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
            )
    );

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

       jFrame.setSize(300, 400);
       jFrame.setLocationRelativeTo(null);
       jFrame.setLocation(jFrame.getX()-location, jFrame.getY());
       jFrame.getContentPane().setBackground(SystemColor.BLACK);
       jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       jFrame.addKeyListener(this);
       jFrame.setVisible(true);

        JFrame keyFrame = new JFrame("Player Keys");
        keyFrame.setSize(300, 100);
        keyFrame.setLocationRelativeTo(jFrame);
        keyFrame.setLocation(keyFrame.getX(), keyFrame.getY()-250);
        keyFrame.getContentPane().setBackground(SystemColor.BLACK);
        keyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        keyFrame.addKeyListener(this);
        keyFrame.setVisible(true);

        JLabel topLabel = new JLabel(Arrays.toString(player.charArray));
        topLabel.setForeground(Color.BLUE);
        topLabel.setSize(299, 100);
        topLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        topLabel.setBorder(new LineBorder(Color.WHITE, 1));

        ArrayList<String> CA = new ArrayList<>();
        String[] cArray = player.charArray;

        for (String c : cArray) {
            CA.add(c);
        }

        JLabel jLabel = new JLabel();

        jLabel.setSize(100, 100);
        jLabel.setText(CA.get((int) (Math.random() * cArray.length)));
        jLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        jLabel.setForeground(Color.ORANGE);

        keyFrame.add(topLabel);
        jFrame.add(jLabel);

        jLabel.addKeyListener(this);
        jFrame.addKeyListener(this);

        frameArray.add(jLabel);

    }

    /** Displays an example Player Screen, for new players when called.
     */
    public void playerScreenExample() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Player #");

        jFrame.setSize(300, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLocation(jFrame.getX()-400, jFrame.getY());
        jFrame.getContentPane().setBackground(SystemColor.BLACK);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);

        JFrame keyFrame = new JFrame("Player Keys");
        keyFrame.setSize(300, 100);
        keyFrame.setLocationRelativeTo(jFrame);
        keyFrame.setLocation(keyFrame.getX(), keyFrame.getY()-250);
        keyFrame.getContentPane().setBackground(SystemColor.BLACK);
        keyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        keyFrame.setVisible(true);

        JLabel topLabel = new JLabel(" Example: z x c v ");
        topLabel.setForeground(Color.BLUE);
        topLabel.setSize(285, 100);
        topLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        topLabel.setBorder(new LineBorder(Color.WHITE, 5));

        JLabel label = new JLabel("ex ");
        label.setForeground(Color.ORANGE);
        label.setSize(285, 100);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);


        keyFrame.add(topLabel);
        jFrame.add(label);

        this.playerOpen = jFrame; this.playerOpen2 = keyFrame;
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

        playerOpen.dispose();
        playerOpen2.dispose();

        return intPlayersReturn;
    }

    public void change(String c) {
        for (JLabel frame : frameArray) {
            if (frame.getText().equals(c)) {
                System.out.println(c);
                frame.setText(charArray.get((int) (Math.random() * charArray.size())));
            }
        }
    }

    private void playerKey(String c, JFrame label) {
        for (Player player : playerList) {
            for (String ch : player.charArray) {
                if (c.equals(ch)) {
                    player.playerPoints++;
                    player.keysPressed++;
                    System.out.println(ch + " " + c);

                    label.setTitle(player.charArray[(int) (Math.random() * player.charArray.length)]);
                }
            }
        }
    }
    public void keyTyped(KeyEvent e) {
        this.score++;
        for (JLabel l : frameArray) {
            l.setText(charArray.get((int) (Math.random() * charArray.size())));
        }
        System.out.println(e.getKeyChar());

        JFrame label = (JFrame) (e.getSource());

        switch (e.getKeyChar() + "") {
            case "w" -> playerKey(e.getKeyChar() + "", label);
            case "a" -> playerKey(e.getKeyChar() + "", label);
            case "s" -> playerKey(e.getKeyChar() + "", label);
            case "d" -> playerKey(e.getKeyChar() + "", label);
            case "i" -> playerKey(e.getKeyChar() + "", label);
            case "j" -> playerKey(e.getKeyChar() + "", label);
            case "k" -> playerKey(e.getKeyChar() + "", label);
            case "l" -> playerKey(e.getKeyChar() + "", label);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

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
