/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidplayer;

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
public class PlayerPlugin implements IGamePluginService {

    private PlayerShip player;

    @Override
    public void start(GameData gameData, World world) {
        player =(PlayerShip) createPlayerShip(gameData);
        world.addEntity((Entity) player);

    }

    private Entity createPlayerShip(GameData gameData) {
        Entity playerShip = new PlayerShip(gameData);
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity((Entity) player);
    }

}

