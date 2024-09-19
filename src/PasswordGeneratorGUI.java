import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneratorGUI extends JFrame{
    PasswordGeneratorGUI(){
        setContentPane(panel1);
        ImageIcon img = new ImageIcon("d:\\key2.png");
        setIconImage(img.getImage());
        getContentPane().setBackground(new Color(20,25,30));
        // textField1.setPreferredSize(new Dimension(10, 10));
        // textField1.setFont(new Font("Cambria", Font.PLAIN, 16));
        label.setForeground(new Color(255,255,255));
        //generateButton.setBackground(new Color(0x475459));
        generateButton.setBackground(new Color(0x2b3336));
        generateButton.setForeground(new Color(255,255,255));
        a8CharactersRadioButton.setBackground(new Color(0x2b3336));
        a8CharactersRadioButton.setForeground(new Color(255,255,255));
        a12CharactersRadioButton.setBackground(new Color(0x2b3336));
        a12CharactersRadioButton.setForeground(new Color(255,255,255));
        a15CharactersRadioButton.setBackground(new Color(0x2b3336));
        a15CharactersRadioButton.setForeground(new Color(255,255,255));
        textField1.setEditable(false);
        textField1.setForeground(Color.GREEN);
        textField1.setBackground(Color.BLACK);
        textField1.setCaretColor(Color.white);
        ButtonGroup group = new ButtonGroup();
        group.add(a8CharactersRadioButton);
        group.add(a12CharactersRadioButton);
        group.add(a15CharactersRadioButton);
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(425, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        final String[] pass = new String[1];
        a8CharactersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pass[0] = passwordGenerator(8);
            }

        });
        a12CharactersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pass[0] = passwordGenerator(12);
            }
        });
        a15CharactersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pass[0] = passwordGenerator(15);
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(pass[0]);
            }
        });
    }

    public String passwordGenerator(int len){
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String numbers = "0123456789";
        String specialChars = "~!@#$%^&*()_+{}|:<>?`-=[]';/.,";
        String combination = lower + upper + numbers + specialChars;

        char[] password = new char[len];
        Random r = new Random();
        for(int i = 0; i < password.length; i++){
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }

    private JButton generateButton;
    private JPanel panel1;
    private JTextField textField1;
    private JRadioButton a8CharactersRadioButton;
    private JRadioButton a12CharactersRadioButton;
    private JRadioButton a15CharactersRadioButton;
    private JLabel label;
    private JLabel label1;
    private JButton b1;
}
