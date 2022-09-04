import java.awt.*;

public class Repo {
    public static final int WINDOW_W = 1230;
    public static final int WINDOW_H = 700;
    public static final String [] filterOptions = {"Negative filter", "Black and white filter", "Sepia filter", "Mirror filter",
    "Color shift left filter", "Color shift right filter"};
    public static final int TITLE_W = 610;
    public static final int TITLE_X = (WINDOW_W - TITLE_W)/2;
    public static final int TITLE_Y = 30;
    public static final int TITLE_H = 100;
    public static final int TITLE_SIZE= 50;

    public static final int TEXT_SIZE= 15;
    public static final int TEXT_W= 400;
    public static final int TEXT_X= (WINDOW_W - TEXT_W)/2;
    public static final int TEXT_H= 40;
    public static final int TEXT_Y= TITLE_Y + TITLE_H;

    public static final int TEXT_FIELD_W= 200;
    public static final int TEXT_FIELD_H= 50;
    public static final int TEXT_FIELD_X= (WINDOW_W - TEXT_FIELD_W)/2;
    public static final int TEXT_FIELD_Y= TEXT_Y + 50;

    public static final int FIRST_BUTTON_Y = TEXT_FIELD_Y + TEXT_FIELD_H + 20;

    public static final int AMOUNT_OF_BUTTONS = 6;

    public static final int IMAGE_Y = 200;
    public static final int IMAGE_X = 170;
    public static final int IMAGE_W = 270;
    public static final int IMAGE_H = 320;

    final static Color FACEBOOK_BLUE=new Color(66,103,178);
    final static Color FACEBOOK_WHITE=new Color(255,255,255);

}
