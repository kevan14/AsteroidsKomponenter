/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.osgicollisionds;

import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;


/**
 *
 * @author Kennet_Gamer
 */
public class CollisionProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
         System.out.println("Collision detection...");

    }

   
  
    
}
