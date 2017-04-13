/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidweapons;

import com.badlogic.gdx.math.MathUtils;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityColor;
import kevan14.asteroidscommon.data.EntityType;
import static kevan14.asteroidscommon.data.EntityType.BULLET_PLAYER;
import kevan14.asteroidscommon.data.Event;
import static kevan14.asteroidscommon.data.EventType.*;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Kennet_Skole
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class WeaponProcessing implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        //process every entity to search for events
        for (Entity entity : world.getEntities()) {

            //for every event mathing shoot event.
            for (Event event : entity.getEvents(PLAYER_SHOOT)) {

                Entity newBullet = new Entity();

                newBullet.setPosition(entity.getX() + (10f * MathUtils.cos(entity.getRadians())), entity.getY() + (10f * MathUtils.sin(entity.getRadians())));
                newBullet.setAcceleration(1000);
                newBullet.setRadians(entity.getRadians());
                newBullet.setDx(entity.getDx());
                newBullet.setDy(entity.getDy());
                newBullet.setType(BULLET_PLAYER);
                newBullet.setColor(EntityColor.WHITE);
                newBullet.setRadius(0.5f);

                world.addEntity(newBullet);

            }

            for (Event event : entity.getEvents(ENEMY_SHOOT)) {

                Entity newBullet = new Entity();

                newBullet.setPosition(entity.getX() + (10f * MathUtils.cos(entity.getRadians())), entity.getY() + (10f * MathUtils.sin(entity.getRadians())));
                newBullet.setAcceleration(1000);
                newBullet.setRadians(entity.getRadians());
                newBullet.setDx(entity.getDx());
                newBullet.setDy(entity.getDy());
                newBullet.setType(EntityType.BULLET_ENEMY);
                newBullet.setColor(EntityColor.WHITE);
                newBullet.setRadius(0.5f);

                world.addEntity(newBullet);

            }
            //update every bullet
            if (entity.getType().equals(EntityType.BULLET_PLAYER)) {
                update(entity, gameData);
            }

            if (entity.getType().equals(EntityType.BULLET_ENEMY)) {
                update(entity, gameData);
            }
        }
    }

    private void setShape(Entity bullet) {
        float[] shapeX = new float[4];
        float[] shapeY = new float[4];
        shapeX[0] = bullet.getX() + MathUtils.cos(bullet.getRadians()) * 2;
        shapeY[0] = bullet.getY() + MathUtils.sin(bullet.getRadians()) * 2;

        shapeX[1] = bullet.getX() + MathUtils.cos(bullet.getRadians() - 4 * 3.1415f / 5) * 2;
        shapeY[1] = bullet.getY() + MathUtils.sin(bullet.getRadians() - 4 * 3.1415f / 5) * 2;

        shapeX[2] = bullet.getX() + MathUtils.cos(bullet.getRadians() + 3.1415f) * 2;
        shapeY[2] = bullet.getY() + MathUtils.sin(bullet.getRadians() + 3.1415f) * 2;

        shapeX[3] = bullet.getX() + MathUtils.cos(bullet.getRadians() + 4 * 3.1415f / 5) * 2;
        shapeY[3] = bullet.getY() + MathUtils.sin(bullet.getRadians() + 4 * 3.1415f / 5) * 2;

        bullet.setShapeX(shapeX);
        bullet.setShapeY(shapeY);

    }

    private void update(Entity bullet, GameData gameData) {

        bullet.setDx(bullet.getDx() + MathUtils.cos(bullet.getRadians()) * bullet.getAcceleration() * gameData.getDelta());
        bullet.setDy(bullet.getDy() + MathUtils.sin(bullet.getRadians()) * bullet.getAcceleration() * gameData.getDelta());

        bullet.setX(bullet.getX() + bullet.getDx() * gameData.getDelta());
        bullet.setY(bullet.getY() + bullet.getDy() * gameData.getDelta());

        setShape(bullet);
    }

}

