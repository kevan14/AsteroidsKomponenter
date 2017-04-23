/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.osgicollisionds;

import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;


/**
 *
 * @author Kennet_Gamer
 */
public class CollisionProcessor implements IEntityProcessingService {

    Entity source;
    
    
    /**
     * Just a simple collision detection using circles overlapping
     * @param gameData
     * @param world 
     */
    @Override
    public void process(GameData gameData, World world) {
         System.out.println("Collision detection using Declarative Services");
         for(Entity ent : world.getEntities()) {
             source = ent;
             
             for(Entity other : world.getEntities()) {
                 if(!source.equals(other)) {
                     
                     float xDif = source.getX() - other.getX();
                     float yDif = source.getY() - other.getY();
                     float distanceSquared = (xDif * xDif) + (yDif * yDif);
                     
                     if(distanceSquared < (source.getRadius() + other.getRadius()) * (source.getRadius() + other.getRadius())) {
                         System.out.println("Collision between: " + source.getType() + " and " + other.getType());
                     }
                 }
             }
         }

    }

   
    
}
