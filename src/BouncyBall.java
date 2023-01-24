import javax.swing.*;
import java.awt.*;

public class BouncyBall {
    private int x,y,xAdd,yAdd,size, diameter;
    private Color color;
    private JPanel panel;
    private boolean mirror = false;
    private boolean check;
    public BouncyBall(JPanel panel)
    {
        randomSize();
        diameter = 2 * size;
        x = (int)(Math.random()*panel.getWidth()/1.2);
        y = (int)(Math.random()*panel.getHeight()/1.2);
        color = randomColor();
        xAdd = (int)(Math.random() * 5)+ 1;
        yAdd = (int)(Math.random() * 5)+ 1;
        this.panel = panel;
        mirror = false;

    }
    public BouncyBall(JPanel panel, int size, Color color, int xAdd, int yAdd, int x, int y, boolean check)
    {
        this.size = size;
        diameter = 2 * size;
        this.color = color;
        this.xAdd = xAdd;
        this.yAdd = yAdd;
        this.panel = panel;
        this.check = check;
        if(check){
            this.x = x + panel.getWidth();
        } else{
            this.x =  x - panel.getWidth();
        }
        this.y = y;
        mirror = true;

    }

    public void bounce()
    {

        if(x >= panel.getWidth() - diameter || x <= 0) {
            xAdd = xAdd*(-1);
        }
        if(y>= panel.getHeight() - diameter || y<=0){
            yAdd = yAdd *(-1);
        }
    }


    public void move(){
        x+=xAdd;
        y+=yAdd;
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y,diameter,diameter);
        //g.drawRect(x, y, diameter, diameter);
    }

    private void randomSize(){
        size = (int)(Math.random() * 41) + 20;
    }
    private Color randomColor(){
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        return new Color(r, g, b);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setxAdd() {
        xAdd = (int)(Math.random() * 4)+ 3;
        yAdd = (int)(Math.random() * 4)+ 3;
    }
    public int[] getLimits(){
        int[] temp = new int[4];
        int xt = x;
        int yt = y;
        temp[0] = xt;
        temp[2] = yt;
        temp[1] = xt+diameter;
        temp[3] = yt+diameter;
        return temp;
    }
    public void moveRight(){
        x+= xAdd;

        if(x >= panel.getWidth() && !mirror){
            x = 0;
        }else if(mirror && check && x >= panel.getWidth() *2)
            x = panel.getWidth();
        else if(mirror && !check && x >= 0)
            x = -panel.getWidth();
    }
    public void moveLeft(){
        x-= xAdd;
        if(x <= -diameter && !mirror)
            x = panel.getWidth() - diameter;
        else if(mirror && check && x <= panel.getWidth() - diameter)
            x = panel.getWidth()* 2 - diameter;
        else if(mirror && !check && x <= -diameter - panel.getWidth())
            x = -diameter;
    }
    public void moveUp(){
        if(y>0)
            y-=yAdd;
    }
    public void moveDown(){
        if(!(y>panel.getHeight() - diameter))
            y+=yAdd;
    }
    public Color getColor(){
        return color;
    }
    public int getxAdd(){
        return xAdd;
    }
    public int getyAdd(){
        return yAdd;
    }
    public int getSize(){
        return size;
    }

}
