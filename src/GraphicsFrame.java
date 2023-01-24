import javax.swing.*;
import java.awt.*;

public class GraphicsFrame extends JFrame {

    public GraphicsFrame(){
        setSize(new Dimension(700, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new AnimationPanel());
        setVisible(true);
    }

}
