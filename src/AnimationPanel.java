import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    BouncyBall[] balls = new BouncyBall[20];
    public AnimationPanel(){
        setSize(new Dimension(700, 700));
        for(int i = 0; i < balls.length; i++){
            balls[i] = new BouncyBall(this);
        }
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        setBackground(Color.BLACK);
        for(BouncyBall ball: balls){
            ball.draw(g);
            ball.move();
            ball.bounce();
        }
        try
        {
            Thread.sleep(10);

        }
        catch(Exception blah)
        {
            System.out.println(blah.toString());
        }

        repaint();



    }

}
