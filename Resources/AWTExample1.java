package Resources;
import java.awt.*;

public class AWTExample1 extends Frame {
    AWTExample1() {
        Button b = new Button("Click Me!");
        b.setBounds(30, 100, 80, 30);
        add(b);

        setSize(800, 800);
        setTitle("title");
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        AWTExample1 f = new AWTExample1();
    }
}
