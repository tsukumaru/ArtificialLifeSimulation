import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class AntEater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AntEater extends Insects
{
    Ant target;
    
    /**
     * Act - do whatever the AntEater wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(target != null && target.getWorld()!=null){
            turnTowards(target.getX(),target.getY());
            move(speed);
        }
        else{
            List Antlist = getObjectsInRange(600, Ant.class);
            if(Antlist.size() != 0){
                target = (Ant) Antlist.get(0);
                int targetDist =(int)Math.pow(target.getX() - this.getX(),2) + (int)Math.pow(target.getY() - this.getY(),2);
                for(int i = 1;i<Antlist.size();i++){
                    Ant al = (Ant) Antlist.get(i);
                    int dist = (int)Math.pow(al.getX() - this.getX(),2) + (int)Math.pow(al.getY() - this.getY(),2);
                    //System.out.println(targetDist + " " + dist);
                    if(targetDist > dist){
                        target = al;
                        targetDist = dist;
                    }
                }
            }
        } 
        
        if(energy >=300){
            ((atfc_world)this.getWorld()).addObject(new AntEater(), this.getX()+Greenfoot.getRandomNumber(50),this.getY()+Greenfoot.getRandomNumber(50));
            energy /= 2;
        }
       
        List Antlist = getObjectsInRange(600, Ant.class);
       if(Antlist.isEmpty()){
        ((atfc_world)this.getWorld()).addObject(new Ant(), Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_x),
                      Greenfoot.getRandomNumber(((atfc_world)this.getWorld()).worldSize_y));
       }
        
       insectMove();
       lookForAnt();
       bigEnergyUse();
    }  
    
    public void lookForAnt(){
        Ant food = null;
        
        if(canSee(Ant.class))
           food = (Ant) getOneIntersectingObject(Ant.class);
            
        if(food != null) {
            energy += food.energy; // getEnergy() is better;
            getWorld().removeObject(food);
        }
            
    }
    
    public void bigEnergyUse(){
        energy -= 5;
        //power -= 5;
        if(energy <= 0)
            {
                //Greenfoot.stop();
                getWorld().removeObject(this);
            }
   }   
}
