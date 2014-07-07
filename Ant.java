import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Insects
{
    Food target;
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Ant(){
        super();
        target = null;
    }
    
    public void act() 
    {
        if(target != null && target.getWorld()!=null){
            turnTowards(target.getX(),target.getY());
            move(speed);
        }
        else{
            List Foodlist = getObjectsInRange(600, Food.class);
            if(Foodlist.size() != 0){
                target = (Food) Foodlist.get(0);
                int targetDist =(int)Math.pow(target.getX() - this.getX(),2) + (int)Math.pow(target.getY() - this.getY(),2);
                for(int i = 1;i<Foodlist.size();i++){
                    Food fl = (Food) Foodlist.get(i);
                    int dist = (int)Math.pow(fl.getX() - this.getX(),2) + (int)Math.pow(fl.getY() - this.getY(),2);
                    //System.out.println(targetDist + " " + dist);
                    if(targetDist > dist){
                        target = fl;
                        targetDist = dist;
                    }
                }
            }
        }
        
        if(energy >=100){
            ((atfc_world)this.getWorld()).addObject(new Ant(), this.getX()+Greenfoot.getRandomNumber(50),this.getY()+Greenfoot.getRandomNumber(50));
            energy /= 2;
        }
       
        
        List Foodlist = getObjectsInRange(600,Food.class);
        if(Foodlist.isEmpty()) {
            ((atfc_world)this.getWorld()).addObject(new Food(), Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_x),
                      Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_y));
       
                   }
                   
        List AntEaterlist = getObjectsInRange(600,AntEater.class);
        if(AntEaterlist.isEmpty()) {
        ((atfc_world)this.getWorld()).addObject(new AntEater(), Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_x),
                      Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_y));
        
                    }
        
        insectMove();
        lookForFeed();
        energyUse();
    }    
}
