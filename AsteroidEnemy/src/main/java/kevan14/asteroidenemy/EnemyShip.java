/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevan14.asteroidenemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import kevan14.asteroidscommon.data.Entity;
import kevan14.asteroidscommon.data.EntityType;
import kevan14.asteroidscommon.data.GameData;

/**
 *
 * @author Kennet_Skole
 */
public class EnemyShip extends Entity {
    
    public EnemyShip(GameData gameData) {
        super.setType(EntityType.ENEMY);
        super.setPosition(gameData.getDisplayWidth()/3, gameData.getDisplayHeight()/3);
        super.setMaxSpeed(150);
        super.setAcceleration(50);
        super.setDeacceleration(10);
        
        super.setDx(0);
        super.setDy(0);
        
        super.setRadians(3.1415f / 2);
        super.setRadius(1.5f);
        super.setRotationSpeed(3);
    }
    
    @Override
    public void render(ShapeRenderer sr) {
        sr.setColor(Color.RED);
        sr.begin(ShapeRenderer.ShapeType.Line);
        for(int i = 0, j = super.getShapeX().length -1; i< super.getShapeX().length; j = i++) {
            sr.line(super.getShapeX()[i], super.getShapeY()[i], super.getShapeX()[j], super.getShapeY()[j]);
        }
        sr.end();
    }
}

