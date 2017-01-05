import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientConsole
{
    private JFrame frame;
    private JPanel loginPanel;
    private MainGUI mainGUI = new MainGUI(this);

    private JButton loginButton;

    private void displayGUI()
    {
        frame = new JFrame("ClientConsole");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        loginPanel.setOpaque(true);
        loginPanel.setBackground(Color.YELLOW);


        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                frame.remove(loginPanel);
                frame.add(mainGUI);
                frame.revalidate(); // For Java 1.7 or above.
               // frame.getContentPane().validate(); // For Java 1.6 or below.
                frame.repaint();
            }
        });


        loginPanel.add(loginButton);

        frame.add(loginPanel);
        frame.setSize(500, 400);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ClientConsole().displayGUI();
            }
        });
    }
    
    public void logOut()
    {
    	frame.remove(mainGUI);
        frame.add(loginPanel);
        frame.revalidate(); // For Java 1.7 or above.
       // frame.getContentPane().validate(); // For Java 1.6 or below.
        frame.repaint();
    }
}