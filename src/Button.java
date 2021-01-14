import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Button extends JButton {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int size;

    public Button(String text, int x, int y, int width, int height, Color color, int size) {
        super(text);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.size = size;

    }

    public void create_button(){
        this.setBorder(new EmptyBorder(0,0,0,0));
        this.setBounds(this.x,this.y,this.width,this.height);
        this.setFont(new Font("SansSerif",Font.ITALIC,this.size));
        this.setBackground(this.color);
    }

    public void set_icon(String file){
        ImageIcon icon = new ImageIcon(file);
        this.setIcon(icon);
    }
}
