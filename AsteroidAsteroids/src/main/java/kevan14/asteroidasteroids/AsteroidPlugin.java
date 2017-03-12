/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidasteroids;

import java.util.ArrayList;
import java.util.List;
import kevan14.asteroidscommon.data.Entity;
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
public class AsteroidPlugin implements IGamePluginService {
    
    private List<Asteroid> asteroids = new ArrayList<Asteroid>();
    
    private void addAsteroid(int amount, GameData gameData) {
        for(int i = 0; i < amount; i++) {
            asteroids.add(new Asteroid(gameData.getDisplayWidth() / (i+1), gameData.getDisplayHeight() / (i+1), EntityType.ASTEROIDS));
        }
    }

    @Override
    public void start(GameData gameData, World world) {
        addAsteroid(5, gameData);
        
        for(Asteroid a : asteroids) {
            world.addEntity((Entity) a);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        for(Asteroid a : asteroids) {
            world.removeEntity((Entity) a);
        }
    }
    
}

