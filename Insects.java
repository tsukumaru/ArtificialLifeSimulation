import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Insects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Insects extends Animal
{
    /**
     * Act - do whatever the Insects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int posx,posy;
    int speed;//動く速さ
    private int clock;
    
    private int like;//0が肉食、1が草食、2が両方
    private int sex;//0が♂、1が♀
    private int size;//大きさ
    private int power;//力の強さ
    
    public Insects(){
        /*posの取得方法
        posx =getX();
        posy =getY();*/
        speed = 5;
        clock =speed;
        energy = 80;
        like = 0;
        sex=0;
        /*サイズの決め方
        size = */
        power = 20;
    }
    
    public void act() 
    {
        
    }
    
    public void insectMove(){
        move();
        turnAtEdge();
        randomTurn();
    }
    public void turnAtEdge(){
        if(atWorldEdge()){
            turn(15);
        }
    }
    
    public void randomTurn(){
        if(Greenfoot.getRandomNumber(100)<50){
            turn(Greenfoot.getRandomNumber(10)-5);
        }
    }
    
    public void lookForFeed(){
        if(canSee(Food.class)){
            eat();
        }
    }
    
    public void energyUse(){
        energy -= 1;
        power -= 5;
        if(energy <= 0)
            {
                //Greenfoot.stop();
                getWorld().removeObject(this);
            }
    }
}
