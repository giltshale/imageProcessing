import javax.swing.*;

public class BasicJFrame extends JFrame {
    private BasicJPanel mainPanel;


    public BasicJFrame(int w, int h) {
        this.setSize(w,h);
        this.setResizable(false);
        this.setLayout(null);
        this.setBackground(Repo.FACEBOOK_BLUE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.mainPanel = new BasicJPanel(0, 0, Repo.WINDOW_W, Repo.WINDOW_H, Repo.FACEBOOK_BLUE);
        this.add(mainPanel);
    }
}
