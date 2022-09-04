import javax.swing.*;
import java.awt.*;

public class BasicJPanel extends JPanel {
    //private ImageIcon backGround;
    private JLabel title;
    private JLabel askToInput;
    private JTextField inputField;
    private JLabel pic1 = new JLabel();

    public BasicJPanel(int x, int y, int w, int h, Color color) {
        this.setBounds(x, y, w, h);
        this.setBackground(color);
        //this.backGround = null;
        this.title = addJLabel("Facebook image editor", Repo.TITLE_X,
                Repo.TITLE_Y, Repo.TITLE_W, Repo.TITLE_H, Repo.TITLE_SIZE, Repo.FACEBOOK_WHITE);
        this.askToInput = addJLabel("Enter a facebook profile and press enter: ",
                Repo.TEXT_X, Repo.TEXT_Y, Repo.TEXT_W, Repo.TEXT_H,
                Repo.TEXT_SIZE, Repo.FACEBOOK_WHITE);
        this.inputField = addTextField(Repo.TEXT_FIELD_X, Repo.TEXT_FIELD_Y,
                Repo.TEXT_FIELD_W, Repo.TEXT_FIELD_H);
        init();
    }

    public void init() {
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }
    public JLabel addJLabel(String title, int x, int y, int w, int h, int size, Color color) {
        JLabel jLabel = new JLabel(title, SwingConstants.CENTER);
        jLabel.setFont(new Font("ariel", Font.BOLD, size));
        jLabel.setForeground(color);
        jLabel.setBounds(x, y, w, h);
        this.add(jLabel);
        return jLabel;
    }

    public JTextField addTextField(int x, int y, int w, int h){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, w, h);
        textField.addActionListener(e -> {
            String inputFromUser = textField.getText();
            textField.setText("");

            Facebook facebook = new Facebook(0,0, Repo.WINDOW_W, Repo.WINDOW_H,
                    Repo.FACEBOOK_BLUE, inputFromUser, pic1);
            this.add(facebook);

        });
        this.add(textField);
        return textField;
    }
}