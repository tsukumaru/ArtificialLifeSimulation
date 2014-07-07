import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class atfc_world here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class atfc_world extends World
{
     int worldSize_x=600;
     int worldSize_y=600;
     
     int foodnumber = 10;
     int antnumber = 5;
     int anteaternumber = 1;
     
    /**
     * Constructor for objects of class atfc_world.
     * 
     */
    public atfc_world()
    {   
        //superの引数の600を変数にすることは無理？？
        super(600, 600, 1);
        populateWorld();
        addObject(new Plotter(500, 500, 100, this, Ant.class, Food.class,AntEater.class), 0, 0);
    }
    
    public void populateWorld(){
        for(int i=0;i<foodnumber;i++){
            addObject(new Food(), Greenfoot.getRandomNumber(worldSize_x), Greenfoot.getRandomNumber(worldSize_y));
        
        }
        for(int i=0;i<antnumber;i++){
            addObject(new Ant(), Greenfoot.getRandomNumber(worldSize_x), Greenfoot.getRandomNumber(worldSize_y));
        
        }
        for(int i=0;i<anteaternumber;i++){
            addObject(new AntEater(), Greenfoot.getRandomNumber(worldSize_x), Greenfoot.getRandomNumber(worldSize_y));
        
        }
    }
}
