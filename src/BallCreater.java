import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BallCreater extends JPanel {
    ArrayList<BouncyBall> balls = new ArrayList<>();
    JPanel panel = this;
    public BallCreater(){
        setSize(new Dimension(700, 700));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == 78){
                    balls.add(new BouncyBall(panel));
                }
            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getButton());
                if(e.getButton() == 1){
                    for(int i = balls.size() - 1; i >= 0; i--){
                       BouncyBall ball = balls.get(i);

                       double x = e.getLocationOnScreen().getX();
                       double y = e.getLocationOnScreen().getY() - 30;
                       boolean xt = x > ball.getLimits()[0] && x < ball.getLimits()[1];
                       boolean yt = y > ball.getLimits()[2] && y < ball.getLimits()[3];
                       System.out.println();
                       System.out.println(x + ", " + y);
                       System.out.println();
                       for(int xs:ball.getLimits()){
                           System.out.println(xs);
                       }
                       if(xt && yt){
                           balls.remove(i);
                       }


                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        setBackground(Color.BLACK);
        for(BouncyBall ball: balls){
            ball.draw(g);

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
