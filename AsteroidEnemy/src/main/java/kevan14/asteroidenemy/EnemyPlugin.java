/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidenemy;

import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityColor;
import kevan14.asteroidscommon.data.EntityType;
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

    private Entity enemy;
    
    public Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new Entity();
        enemyShip.setType(EntityType.ENEMY);
        enemyShip.setPosition(gameData.getDisplayWidth()/3, gameData.getDisplayHeight()/3);
        enemyShip.setMaxSpeed(150);
        enemyShip.setAcceleration(50);
        enemyShip.setDeacceleration(10);
        enemyShip.setColor(EntityColor.RED);
        
        enemyShip.setDx(0);
        enemyShip.setDy(0);
        
        enemyShip.setRadians(3.1415f / 2);
        enemyShip.setRadius(1.5f);
        enemyShip.setRotationSpeed(3);
        
        return enemyShip;
    }
    
    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemyShip(gameData);
        world.addEntity( enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity((Entity) enemy);
    }
    
}

