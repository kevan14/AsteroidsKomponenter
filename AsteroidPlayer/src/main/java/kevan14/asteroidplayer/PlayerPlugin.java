/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidplayer;

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
public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    @Override
    public void start(GameData gameData, World world) {
        player = createPlayerShip(gameData);
        world.addEntity(player);

    }

    private Entity createPlayerShip(GameData gameData) {
        Entity playerShip = new Entity();
        playerShip.setType(EntityType.PLAYER);
        playerShip.setPosition(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
        playerShip.setMaxSpeed(100);
        playerShip.setAcceleration(100);
        playerShip.setDeacceleration(10);
        playerShip.setColor(EntityColor.BLUE);
        
        playerShip.setDx(0);
        playerShip.setDy(0);
        
        playerShip.setRadians(3.1415f / 2);
        playerShip.setRadius(1.5f);
        playerShip.setRotationSpeed(3);
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity((Entity) player);
    }

}

