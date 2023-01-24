import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventListener;

public class ContolAnimation extends JPanel {
    private int x,y;
    public ArrayList<Integer> key = new ArrayList<Integer>();
    private BouncyBall ball = new BouncyBall(this);
    private BouncyBall ball2;
    private BouncyBall ball3;

    private boolean left = false;
    private boolean right = false;
    public ContolAnimation(){
        setBackground(Color.BLACK);
        setSize(new Dimension(700, 700));
        this.setFocusable(true);
        this.addKeyListener(new KeyListener());
        ball.setxAdd();
        ball2 = new BouncyBall(this, ball.getSize(), ball.getColor(), ball.getxAdd(), ball.getyAdd(), ball.getX(), ball.getY(), true);
        ball3 = new BouncyBall(this, ball.getSize(), ball.getColor(), ball.getxAdd(), ball.getyAdd(), ball.getX(), ball.getY(), false);
    }

    @Override
    protected void  paintComponent(Graphics g){
        check();
        start();
        super.paintComponent(g);
        ball.draw(g);
        if(right){
            ball2.draw(g);
        } else if(left){
            ball3.draw(g);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
        right = false;
        left = false;
    }
    public void check(){
        int x = ball.getX() + ball.getSize() * 2;
        int y = ball.getY();
        if(x - ball.getSize()*2 < 0)
            right = true;
        else if(x > this.getWidth())
            left = true;
    }
    public void start(){
        if(key.contains(1)){
            ball.moveRight();
            ball2.moveRight();
            ball3.moveRight();
        }
        if(key.contains(2)){
            ball.moveLeft();
            ball2.moveLeft();
            ball3.moveLeft();
        }
        if(key.contains(3)){
            ball.moveUp();
            ball2.moveUp();
            ball3.moveUp();
        }
        if(key.contains(4)){
            ball.moveDown();
            ball2.moveDown();
            ball3.moveDown();
        }
    }
    public class KeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
            keys[e.getKeyCode()] = true;

            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                key.add(1);
            }
            if(keys[KeyEvent.VK_LEFT]){
                key.add(2);
            }
            if(keys[KeyEvent.VK_UP]){
                key.add(3);
            }
            if(keys[KeyEvent.VK_DOWN]){
                key.add(4);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            key.clear();
        }
    }
}
