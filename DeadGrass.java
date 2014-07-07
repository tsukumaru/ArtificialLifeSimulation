import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeadGrass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeadGrass extends Plant
{
    int count;
    public DeadGrass(){
        count = 5;
    }
    
    /**
     * Act - do whatever the DeadGrass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count--;
        if(count == 0){
            getWorld().removeObject(this);
        }
    }    
}
