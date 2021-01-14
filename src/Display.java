import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display implements ActionListener, MouseListener {

    private Logic logic;
    private int clicked = 0;
    private Frame frame;
    private Panel panel, panel1, panel2, panel3, panel4;
    private Button button_learn, button_exit, button_revision;
    private Button button_done, button_none, button_save, flashcard, button_save_all;
    private Button button_next;
    private Button button_quit;
    private Button flashcard_rev;
    private Button button_quit_2;

    private Label counter;

    public Display(){

        logic = new Logic();
        frame = new Frame("Fiszki hiszpańskie", 700, 600);
        frame.set_icon("spain.png");

        panel = new Panel(new Color(255, 207, 151));
        panel1 = new Panel(new Color(255, 207, 151));
        panel2 = new Panel(new Color(255, 207, 151));
        panel3 = new Panel(new Color(255, 207, 151));
        panel4 = new Panel(new Color(255, 207, 151));


        button_learn = new Button("Start", 150,100,400, 100, new Color(255, 5, 12), 40);
        button_learn.create_button();

        button_exit = new Button("Wyjście", 150,400,400, 100, new Color(255, 5, 12), 40);
        button_exit.create_button();

        button_revision = new Button("      Powtórka", 150,200,400, 200, new Color(255, 200, 0), 40);
        button_revision.create_button();
        button_revision.set_icon("herb.png");

        button_done = new Button("Umiem", 70,375,245, 50, new Color(255,125,12), 40);
        button_done.create_button();

        button_none = new Button("Nie umiem", 385,375,245, 50, new Color(255,125,12), 40);
        button_none.create_button();

        button_save = new Button("Zapisz i wyjdź", 150,450,400, 50, new Color(255,125,12), 40);
        button_save.create_button();

        flashcard = new Button("Flashcard", 50,25,600, 300, new Color(255,125,12), 40);
        flashcard.create_button();

        button_save_all = new Button("Zapisz i wyjdź", 150,350,400, 100, new Color(255,125,12), 40);
        button_save_all.create_button();

        button_next = new Button("Następne", 70,350, 245, 50, new Color(255,125,12),40);
        button_next.create_button();

        flashcard_rev = new Button("Flashcard", 50,25, 600, 300, new Color(255,125,12),40);
        flashcard_rev.create_button();

        button_quit = new Button("Wyjście", 385,350, 245, 50, new Color(255,125,12),40);
        button_quit.create_button();

        Button image = new Button("", 458, 420, 100, 66, new Color(255, 125, 12), 40);
        image.set_icon("spain1.png");
        image.create_button();

        Button image1 = new Button("", 143, 420, 100, 66, new Color(255, 125, 12), 40);
        image1.set_icon("spain1.png");
        image1.create_button();

        button_quit_2 = new Button("Wyjście", 150,350,400,100,new Color(255,125,12),40);
        button_quit_2.create_button();

        Label title = new Label("Fiszki hiszpańskie", 200, 0, 500, 100, new Color(0, 0, 0), 40);
        title.create_label();

        counter = new Label("", 300,325, 300, 50, new Color(0,0,0), 20);
        counter.create_label();

        Label info = new Label("Umiesz już wszystkie słowa!", 100, 100, 500, 150, new Color(0, 0, 0), 40);
        info.create_label();

        Label info2 = new Label("Jeszcze nic nie umiesz! Nie ma co powtarzać!", 30, 100, 700, 150, new Color(0, 0, 0), 30);
        info2.create_label();

        button_learn.addActionListener(this);
        button_learn.addMouseListener(this);

        button_exit.addActionListener(this);
        button_exit.addMouseListener(this);

        button_revision.addActionListener(this);
        button_revision.addMouseListener(this);

        button_done.addActionListener(this);
        button_done.addMouseListener(this);

        button_none.addActionListener(this);
        button_none.addMouseListener(this);

        button_save.addActionListener(this);
        button_save.addMouseListener(this);

        flashcard.addActionListener(this);
        flashcard.addMouseListener(this);

        button_save_all.addActionListener(this);
        button_save_all.addMouseListener(this);

        button_next.addActionListener(this);
        button_next.addMouseListener(this);

        flashcard_rev.addActionListener(this);
        flashcard_rev.addMouseListener(this);

        button_quit.addActionListener(this);
        button_quit.addMouseListener(this);

        button_quit_2.addActionListener(this);
        button_quit_2.addMouseListener(this);

        panel.add(button_learn);
        panel.add(button_exit);
        panel.add(button_revision);
        panel.add(title);

        panel1.add(counter);
        panel1.add(button_done);
        panel1.add(button_none);
        panel1.add(button_save);
        panel1.add(flashcard);

        panel2.add(info);
        panel2.add(button_save_all);

        panel3.add(button_next);
        panel3.add(button_quit);
        panel3.add(flashcard_rev);
        panel3.add(image);
        panel3.add(image1);

        panel4.add(info2);
        panel4.add(button_quit_2);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        if (button == button_learn) {
            logic.get_from_files("nauka.txt", "tlumaczenia.txt");
            if (logic.map_learn_size() == 0) {
                frame.remove(panel);
                frame.setContentPane(panel2);
            } else {
                frame.remove(panel);
                frame.setContentPane(panel1);
                counter.setText("Pozostało: " + logic.map_learn_size());
            }
        }

        else if (button == button_done)
        {

            if (logic.map_learn_size() == 1){
                frame.remove(panel1);
                frame.setContentPane(panel2);
                logic.map_add();
                logic.map_remove();
            }

            else {

                if (clicked >= 2) {

                    logic.map_add();
                    logic.map_remove();
                    counter.setText("Pozostało: " + logic.map_learn_size());
                    logic.random();
                    logic.setValue(logic.map_get());
                    flashcard.setText(logic.getKey());
                    logic.set_flag(1);

                }
            }
        }
        else if (button == button_none)
        {
            logic.random();
            flashcard.setText(logic.getKey());
            logic.setValue(logic.map_get());
            logic.set_flag(1);
        }
        else if (button == button_save)
        {
            logic.save();
            frame.dispose();
        }
        else if (button == flashcard) {
            clicked += 1;
            if (logic.getRand() == 0) {
                logic.random();
                logic.setValue(logic.map_get());
                logic.set_rand(1);
            }
            if (logic.getFlag() == 0) {
                flashcard.setText(logic.getKey());
                logic.set_flag(1);
            } else {
                flashcard.setText(logic.getValue());
                logic.set_flag(0);
            }
        }
        else if (button == button_exit){
            frame.dispose();
        }

        else if (button == button_save_all)
        {
            logic.save();
            frame.dispose();
        }

        else if (button == button_revision)
        {
            logic.get_from_files("umiem_nauka.txt","umiem_tlumaczenia.txt");
            if (logic.map_learn_size() == 0){
                frame.remove(panel);
                frame.setContentPane(panel4);
            }
            else {
                frame.remove(panel);
                frame.setContentPane(panel3);
            }

        }

        else if (button == button_quit){
            frame.dispose();
        }

        else if (button == button_next){

            if (clicked >= 2) {
                logic.random();

                logic.setValue(logic.map_get());
                flashcard_rev.setText(logic.getKey());
                logic.set_flag(1);
            }
        }

        else if (button == flashcard_rev) {
            //frame.remove(panel1);
            //frame.setContentPane(panel);
            clicked += 1;
            if (logic.getRand() == 0) {
                logic.random();
                logic.setValue(logic.map_get());
                logic.set_rand(1);
            }
            if (logic.getFlag() == 0){
                flashcard_rev.setText(logic.getKey());
                logic.set_flag(1);
            }
            else {
                flashcard_rev.setText(logic.getValue());
                logic.set_flag(0);
            }
        }

        else if (button == button_quit_2){
            frame.dispose();
        }

        frame.validate();
        frame.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        if (button == button_learn) {
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_learn.setBackground(new Color(255, 125, 12));
        }
        else if (button == button_exit){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_exit.setBackground(new Color(255,125,12));
        }

        else if(button == button_done){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_done.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_none){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_none.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_save){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_save.setBackground(new Color(255, 200, 0));
        }

        else if(button == flashcard){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            flashcard.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_save_all){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_save_all.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_revision){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_revision.setBackground(new Color(255, 238, 0));
        }

        else if(button == button_quit){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_quit.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_next){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_next.setBackground(new Color(255, 200, 0));
        }

        else if(button == flashcard_rev){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            flashcard_rev.setBackground(new Color(255, 200, 0));
        }

        else if(button == button_quit_2){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_quit_2.setBackground(new Color(255, 200, 0));
        }

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        if (button == button_learn) {
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_learn.setBackground(new Color(255, 5, 12));
        }
        else if (button == button_exit){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_exit.setBackground(new Color(255,5,12));
        }

        else if (button == button_save){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_save.setBackground(new Color(255,125,12));
        }

        else if (button == button_done){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_done.setBackground(new Color(255,125,12));
        }

        else if (button == button_none){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_none.setBackground(new Color(255,125,12));
        }

        else if (button == flashcard){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            flashcard.setBackground(new Color(255,125,12));
        }

        else if (button == button_revision){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_revision.setBackground(new Color(255,200,0));
        }

        else if (button == button_save_all){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_save_all.setBackground(new Color(255,125,12));
        }

        else if (button == button_quit){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_quit.setBackground(new Color(255,125,12));
        }

        else if (button == button_next){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_next.setBackground(new Color(255,125,12));
        }

        else if (button == flashcard_rev){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            flashcard_rev.setBackground(new Color(255,125,12));
        }

        else if (button == button_quit_2){
            mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            button_quit_2.setBackground(new Color(255,125,12));
        }

    }
}
