/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidasteroids;

import com.badlogic.gdx.math.MathUtils;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityType;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Kennet_Skole
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class AsteroidProcessing implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for(Entity asteroid : world.getEntities(EntityType.ASTEROIDS)) {
            
            asteroid.setX( asteroid.getX() + asteroid.getDx() * gameData.getDelta());
            asteroid.setY( asteroid.getY() + asteroid.getDy() * gameData.getDelta());
            
            asteroid.setRadians( asteroid.getRadians() + asteroid.getRotationSpeed() * gameData.getDelta());
        
            setShape(asteroid);
            wrap(gameData, asteroid);
        }
    }
    
    private void setShape(Entity entity) {
        float[] sx = new float[((Asteroid) entity).getNumPoints()];
        float[] sy = new float[((Asteroid) entity).getNumPoints()];
        float angle = 0;

        for (int i = 0; i < ((Asteroid) entity).getNumPoints(); i++) {
            sx[i] = entity.getX() + MathUtils.cos(angle + entity.getRadians()) * ((Asteroid) entity).getDists()[i];
            sy[i] = entity.getY() + MathUtils.sin(angle + entity.getRadians()) * ((Asteroid) entity).getDists()[i];
            angle += 2 * 3.1415f / ((Asteroid) entity).getNumPoints();
        }
        
        entity.setShapeX(sx);
        entity.setShapeY(sy);

    }
    
    private void wrap(GameData gameData, Entity entity) {
        if (entity.getY() > gameData.getDisplayHeight()) {
            entity.setY(0);
        }
        if(entity.getY() < 0) {
            entity.setY(gameData.getDisplayHeight());
        }
        if(entity.getX() > gameData.getDisplayWidth()) {
            entity.setX(0);
        }
        if(entity.getX() < 0) {
            entity.setX(gameData.getDisplayWidth());
        }
    }
    
}

