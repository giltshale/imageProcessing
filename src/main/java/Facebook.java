import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.*;


public class Facebook extends BasicJPanel {

    private static final String URL_FACEBOOK = "https://facebook.com/";

    private ImageIcon backGround;
    private JLabel pic1;
    private BufferedImage originalImage;
    private MyFilters images;
    private URL imageURL;
    private int imageWidth;
    private int imageHeight;
    public Facebook(int x, int y, int w, int h, Color color, String userInput, JLabel pic1) {
        super(x, y, w, h, color);
        this.pic1 = pic1;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tasha\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        int currentY = Repo.FIRST_BUTTON_Y;
        for (int i = 0; i < Repo.AMOUNT_OF_BUTTONS; i++) {
            addButton(i, Repo.filterOptions[i], Repo.TEXT_FIELD_X, currentY,
                    Repo.TEXT_FIELD_W, Repo.TEXT_FIELD_H, Repo.FACEBOOK_BLUE, Repo.FACEBOOK_WHITE);
            currentY += Repo.TEXT_FIELD_H;
        }

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String profile = fixSpace(userInput);
            driver.get(URL_FACEBOOK + profile);
            WebElement enterFullPhoto = driver.findElement(By.xpath
                    ("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div/div/div/div[1]/div/a"));
            //מחפש את הקישור באלמנט שנמצא ונכנס לתוכו עם הדריבר
            String link = enterFullPhoto.getAttribute("href");
            driver.get(link);

            int counter=0;
            WebElement photoSource=null;
            do {
                try {
                    //picture element after login
                    photoSource = driver.findElement(By.xpath(
                            "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[2]/div/div/div/img"
                    ));
                } catch (Exception e) {
                    try {
                        counter++;
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    counter++;
                }
            } while (photoSource == null | counter==1000);

            try {
                this.imageURL=new URL(photoSource.getAttribute("src"));
                this.originalImage = ImageIO.read(imageURL);
                this.images = new MyFilters(imageURL);
                repaint();
                driver.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public String fixSpace(String name) {
        return name.replace(" ", "");
    }


    public JButton addButton(int type, String text, int x, int y, int w, int h, Color foregroundColor,
                             Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, w, h);
        button.addActionListener(e -> {
            BufferedImage image = this.originalImage;
            images.setFilter(type, image);
            repaint();
        });
        button.setBackground(color);
        button.setForeground(foregroundColor);
        this.add(button);
        repaint();
        return button;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (this.backGround != null) {
            this.backGround.paintIcon(this, g, 0, 0);
        }
        if (this.originalImage!=null){
            imageWidth=originalImage.getWidth();
            imageHeight=originalImage.getHeight();
            while (imageHeight>500){
                imageHeight/=2;
                imageWidth/=2;
            }
            while (imageWidth>500){
                imageHeight/=2;
                imageWidth/=2;
            }
            g.drawImage(this.originalImage, Repo.IMAGE_X, Repo.IMAGE_Y, imageWidth,imageHeight,this);
            if (this.images!=null) {
                g.drawImage(this.images.getImageForEditing(), Repo.WINDOW_W -
                        Repo.IMAGE_X - Repo.IMAGE_W, Repo.IMAGE_Y,imageWidth,imageHeight, this);
            } else {
                g.drawImage(this.originalImage, Repo.WINDOW_W -
                        Repo.IMAGE_X - Repo.IMAGE_W, Repo.IMAGE_Y, imageWidth,imageHeight,this);
            }
        }
    }
}