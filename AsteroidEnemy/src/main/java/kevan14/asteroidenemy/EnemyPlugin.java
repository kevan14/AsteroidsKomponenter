/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidenemy;

import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Kennet_Skole
 */
@ServiceProvider(service = IGamePluginService.class)
public class EnemyPlugin implements IGamePluginService {

    private EnemyShip enemy;
    
    public Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new EnemyShip(gameData);
        
        return enemyShip;
    }
    
    @Override
    public void start(GameData gameData, World world) {
        enemy =(EnemyShip) createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
    
}

