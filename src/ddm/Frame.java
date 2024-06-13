package ddm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton playButton;
    private JLabel backgroundIm;
    private Panel mainPanel = new Panel();

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeon Dice Monsters");
        setResizable(true);
        setLayout(new BorderLayout());
        init();
    }

    public void init() {
        playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 18));
        backgroundIm = new JLabel(new ImageIcon(getClass().getResource("resources/home.jpg")));
        backgroundIm.setBounds(0, 0, getWidth(), getHeight());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int buttonX = (getWidth() - 100) / 2;
                int buttonY = (getHeight() - 50) / 2;
                playButton.setBounds(buttonX, buttonY, 100, 50);
                backgroundIm.setBounds(0, 0, getWidth(), getHeight());
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        add(backgroundIm);
        add(playButton);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void startGame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getContentPane().remove(playButton);
                getContentPane().remove(backgroundIm);
                getContentPane().add(mainPanel, BorderLayout.CENTER);
				mainPanel.setVisible(true);
                setLocationRelativeTo(null);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setVisible(true);
                getTilesFrame();
                startMsg();
            }
        });
    }

    public void loadIcon() {
        URL imageURL = getClass().getResource("resources/icon.png");
        if (imageURL != null) {
            ImageIcon imageIcon = new ImageIcon(imageURL);
            Image image = imageIcon.getImage();
            if (imageIcon != null) {
                Frame.this.setIconImage(image);
            }
        } else {
            System.out.println("imageURL: " + imageURL);
            JOptionPane.showConfirmDialog(null, "Bad imageURL received from Monster class for resources/icon.png\n"
                            + "Do something about it.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getTilesFrame() {
        mainPanel.getTiles()[2][(mainPanel.getTiles().length - 1) / 2].updatePics();
        mainPanel.getTiles()[mainPanel.getTiles().length - 3][(mainPanel.getTiles().length - 1) / 2].updatePics();
    }

    public void startMsg() {
        JOptionPane.showMessageDialog(null,
                "Welcome to Dungeon Dice Monsters!",
                mainPanel.getTiles()[mainPanel.getTiles().length - 3][(mainPanel.getTiles().length - 1) / 2].monster().owner().name()
                        + "  vs.  "
                        + mainPanel.getTiles()[2][(mainPanel.getTiles().length - 1) / 2].monster().owner().name(),
                JOptionPane.INFORMATION_MESSAGE);

        mainPanel.changePhase("Roll");
    }

    public static void main(String[] args) {
        new Frame();
    }
}
