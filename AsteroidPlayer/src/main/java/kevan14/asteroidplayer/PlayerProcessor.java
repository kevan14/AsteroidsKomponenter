/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidplayer;

import com.badlogic.gdx.math.MathUtils;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityType;
import kevan14.asteroidscommon.data.EventType;
import kevan14.asteroidscommon.data.GameData;
import kevan14.asteroidscommon.data.GameKeys;
import kevan14.asteroidscommon.data.World;
import kevan14.asteroidscommon.spi.IEntityProcessingService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Kennet_Skole
 */
@ServiceProvider(service = IEntityProcessingService.class)
public class PlayerProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(EntityType.PLAYER)) {

            if (gameData.getKeys().isPressed(GameKeys.SPACE)) {
                player.doAction(EventType.PLAYER_SHOOT);
            }

            if (gameData.getKeys().isDown(GameKeys.LEFT)) {
                player.setRadians(player.getRadians() + player.getRotationSpeed() * gameData.getDelta());
            }

            if (gameData.getKeys().isDown(GameKeys.RIGHT)) {
                player.setRadians(player.getRadians() - player.getRotationSpeed() * gameData.getDelta());
            }

            if (gameData.getKeys().isDown(GameKeys.UP)) {

                player.setDx(player.getDx() + MathUtils.cos(player.getRadians()) * player.getAcceleration() * gameData.getDelta());
                player.setDy(player.getDy() + MathUtils.sin(player.getRadians()) * player.getAcceleration() * gameData.getDelta());

            }

            float vec = (float) Math.sqrt(player.getDx() * player.getDx() + player.getDy() * player.getDy());
            if (vec > 0) {

                player.setDx(player.getDx() - (player.getDx() / vec) * player.getDeacceleration() * gameData.getDelta());
                player.setDy(player.getDy() - (player.getDy() / vec) * player.getDeacceleration() * gameData.getDelta());
            }
            if (vec > player.getMaxSpeed()) {

                player.setDx((player.getDx() / vec) * player.getMaxSpeed());
                player.setDy((player.getDy() / vec) * player.getMaxSpeed());

            }

            player.setX(player.getX() + player.getDx() * gameData.getDelta());
            player.setY(player.getY() + player.getDy() * gameData.getDelta());
            
            wrap(gameData, player);

            setShape(player);

        }

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

}

