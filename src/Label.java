import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int size;

    public Label(String text, int x, int y, int width, int height, Color color, int size) {

        super(text);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.size = size;

    }

    public void create_label(){
        this.setBounds(this.x,this.y,this.width,this.height);
        this.setFont(new Font("SansSerif",Font.ITALIC,this.size));
        this.setBackground(this.color);
    }
}
