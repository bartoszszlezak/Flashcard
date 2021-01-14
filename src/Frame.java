import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(String title, int width, int height) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
    }

    public void set_icon(String file){
        ImageIcon logo = new ImageIcon(file);
        this.setIconImage(logo.getImage());
    }
}
