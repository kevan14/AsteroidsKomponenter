/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidenemy;

import com.badlogic.gdx.math.MathUtils;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityType;
import kevan14.asteroidscommon.data.EventType;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Kennet_Skole
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class EnemyProcessing implements IEntityProcessingService {

    private Entity target;
    private long lastShot = System.currentTimeMillis();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {

            //get target
            if (entity.getType().equals(EntityType.PLAYER)) {
                target = entity;
            }

            if (entity.getType().equals(EntityType.ENEMY)) {

                if (target != null) {
                    seekTarget(target, entity, gameData);
                }

                if (shot()) {
                    entity.doAction(EventType.ENEMY_SHOOT);
                }

                wrap(gameData, entity);
                setShape(entity);
            }
        }
    }

    private void seekTarget(Entity target, Entity source, GameData gameData) {

        source.setRadians((float) Math.atan2(target.getY() - source.getY(), target.getX() - source.getX()));
        float distance = (float) Math.hypot(target.getX() - source.getX(), target.getY() - source.getY());
        if (distance > 10) {
            source.setDx(source.getDx() + MathUtils.cos(source.getRadians()) * source.getAcceleration() * gameData.getDelta());
            source.setDy(source.getDy() + MathUtils.sin(source.getRadians()) * source.getAcceleration() * gameData.getDelta());

        }

        float vec = (float) Math.sqrt(source.getDx() * source.getDx() + source.getDy() * source.getDy());
        if (vec > 0) {

            source.setDx(source.getDx() - (source.getDx() / vec) * source.getDeacceleration() * gameData.getDelta());
            source.setDy(source.getDy() - (source.getDy() / vec) * source.getDeacceleration() * gameData.getDelta());
        }
        if (vec > source.getMaxSpeed()) {

            source.setDx((source.getDx() / vec) * source.getMaxSpeed());
            source.setDy((source.getDy() / vec) * source.getMaxSpeed());

        }

        source.setX(source.getX() + source.getDx() * gameData.getDelta());
        source.setY(source.getY() + source.getDy() * gameData.getDelta());

    }

    private boolean shot() {
        long current = System.currentTimeMillis();
        if (current - lastShot > 1500) {
            lastShot = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }

    }

    private void setShape(Entity player) {

        float[] shapeX = new float[4];
        float[] shapeY = new float[4];
        shapeX[0] = player.getX() + MathUtils.cos(player.getRadians()) * 8;
        shapeY[0] = player.getY() + MathUtils.sin(player.getRadians()) * 8;

        shapeX[1] = player.getX() + MathUtils.cos(player.getRadians() - 4 * 3.1415f / 5) * 8;
        shapeY[1] = player.getY() + MathUtils.sin(player.getRadians() - 4 * 3.1415f / 5) * 8;

        shapeX[2] = player.getX() + MathUtils.cos(player.getRadians() + 3.1415f) * 5;
        shapeY[2] = player.getY() + MathUtils.sin(player.getRadians() + 3.1415f) * 5;

        shapeX[3] = player.getX() + MathUtils.cos(player.getRadians() + 4 * 3.1415f / 5) * 8;
        shapeY[3] = player.getY() + MathUtils.sin(player.getRadians() + 4 * 3.1415f / 5) * 8;

        player.setShapeX(shapeX);
        player.setShapeY(shapeY);

    }

    private void wrap(GameData gameData, Entity entity) {
        if (entity.getY() > gameData.getDisplayHeight()) {
            entity.setY(0);
        }
        if (entity.getY() < 0) {
            entity.setY(gameData.getDisplayHeight());
        }
        if (entity.getX() > gameData.getDisplayWidth()) {
            entity.setX(0);
        }
        if (entity.getX() < 0) {
            entity.setX(gameData.getDisplayWidth());
        }
    }

}

