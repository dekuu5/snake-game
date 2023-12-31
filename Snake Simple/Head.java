import greenfoot.*;
import java.util.Random;
public class Head extends Actor
{
    private boolean ai;
    static private boolean alive;
    private int direction = 0;
    private int length = 3;
    private static final int scale = 3;
    Random r = new Random();
    private Body nextNode = null;
    private Body temp;
    private boolean temp1 = false;
    public void act()
    {
        if(alive)
        {
            if(ai)
            {
                /*if(getOneObjectAtOffset((int)Math.cos(direction*90), (int)Math.sin(direction*90), Body.class)!=null)
                {
                    
                }
                else
                {
                    turnTowards(getOneObject(Food.class).getX(), getOneObject(Food.class).getY());
                }*/
            }
            else
            {
                if(Greenfoot.isKeyDown("right")&&direction!=2)direction = 0;
                else if(Greenfoot.isKeyDown("down")&&direction!=3)direction = 1;
                else if(Greenfoot.isKeyDown("left")&&direction!=0)direction = 2;
                else if(Greenfoot.isKeyDown("up")&&direction!=1)direction = 3;
            }
            setRotation(direction*90);
            nextNode = new Body(length-1, direction*90, nextNode);
            getWorld().addObject(nextNode, getX(), getY());
            move(1);
            if(getOneIntersectingObject(Food.class)!=null)foundFood();
            if(getOneIntersectingObject(Body.class)!=null||isAtEdge())death();
        }
        else
        {
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")){}
            else temp1 = true;
            if((Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right"))&&temp1)Greenfoot.setWorld(new MyWorld());
        }
    }
    private void foundFood()
    {
        length += scale;
        nextNode.increase();
        getWorld().removeObject(getOneIntersectingObject(Food.class));
        getWorld().addObject(new Food(), r.nextInt(MyWorld.getMyWidth()), r.nextInt(MyWorld.getMyHeight()));
    }
    public boolean isAtEdge()
    {
        if(getX()<0||getX()>=MyWorld.getMyWidth()||getY()<0||getY()>=MyWorld.getMyHeight())return true;
        return false;
    }
    public void death()
    {
        Counter counter = new Counter("Score: ");
        getWorld().addObject(counter, MyWorld.getMyWidth() / 2, MyWorld.getMyHeight() / 2);
        counter.setValue(length + 1);
        alive = false;
        //Greenfoot.stop();
    }
    public static int getScale()
    {
        return scale;
    }
    public static boolean getAlive(){
        return alive;
    }
    public Head()
    {
        ai = false;
        alive = true;
    }
    public Head(boolean aiControlled)
    {
        if(ai)ai = true;
        else ai = false;
        alive = true;
    }
}