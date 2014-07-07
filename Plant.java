import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List Foodlist = getObjectsInRange(600,Food.class);
        if(Foodlist.isEmpty()) {
        ((atfc_world)this.getWorld()).addObject(new Food(), Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_x),
                      Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_y));
        }
    }    
}
