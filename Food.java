import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Feed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Plant
{
    /**
     * Act - do whatever the Feed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int posx,posy;
    private int nutrition;
    private int prob;
    
    public Food(){
        /*posx = getX();
        posy = getY();*/
        nutrition = 30;
        prob = 120;
    }
    
    public void act() 
    {
        nutrition -= 3;
        //一定の間隔で植物を増やす
        if(Greenfoot.getRandomNumber(1000) <= prob){
            ((atfc_world)this.getWorld()).addObject(new Food(), Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_x),
                      Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_y));
        }
        
        if(nutrition == 0){
            getWorld().removeObject(this);
        }
        

       
    }
    
    public int getNutrition(){
        return nutrition;
    }
}

